# TypeScript to Kotlin script

This document describes the TypeScript front end and the Kotlin script back end that ship with
`structuring-translator`: what the lexer and parser accept, and how the AST is rendered.

## Pipeline

```
source text
  -> TypeScriptLexer      (tokens, including trivia)
  -> TypeScriptParser     (a SourceFile, the TypeScript translation unit)
  -> KotlinScriptEmitter  (Kotlin script text)
```

Every stage is hand written Kotlin; there is no grammar file and no generated code.

## Layout

| Package | Responsibility |
| --- | --- |
| `...structuring.api` | Language agnostic contracts: `LanguageType`, `LanguageRegistry`, `LanguageParser`, `LanguageEmitter`, `LanguageProvider`, `Translator`, `TranslationOptions`, the exception types and the `AstNode` / `TranslationUnit` roots. Nothing here names TypeScript. |
| `...structuring.typescript.lexer` | `TypeScriptLexer`, `Token`, `TokenType`, `Keyword`, literal value records. |
| `...structuring.typescript.ast` | The TypeScript node catalogue: statements, expressions, types, comments. |
| `...structuring.typescript.parser` | `TypeScriptParser`, a recursive descent parser over the significant tokens. |
| `...structuring.kotlin` | `KotlinScriptEmitter` and `KotlinTypeMapper`. |
| `...structuring.builtin` | `BuiltinLanguageProvider`, the only class that names both a front end and a back end. |

## Using the api

The api always takes the source type and the target type explicitly, so further language pairs can be
added without changing any call site. Nothing has to be initialised first: the first call loads the
languages announced on the classpath.

```kotlin
import com.github.kusa233.translator.structuring.api.LanguageType
import com.github.kusa233.translator.structuring.api.TranslationOptions
import com.github.kusa233.translator.structuring.api.Translator

// Explicit types.
val text = Translator.translate(
    sourceType = LanguageType.TYPESCRIPT,
    targetType = LanguageType.KOTLIN_SCRIPT,
    source = "const a = 1;",
)

// Types derived from the file names.
val fromFiles = Translator.translateFile(
    fileName = "input.ts",
    source = "const a = 1;",
    targetFileName = "output.kts",
)

// Parse once, translate many times.
val ast = Translator.parse(LanguageType.TYPESCRIPT, "let a = 1;", "a.ts")
val again = Translator.translate(ast, LanguageType.KOTLIN_SCRIPT)

// Formatting knobs.
val pretty = Translator.translate(
    LanguageType.TYPESCRIPT,
    LanguageType.KOTLIN_SCRIPT,
    "function f() { return 1; }",
    options = TranslationOptions(indent = "  ", useSemicolons = true, emitHeaderComment = true),
)
```

`TranslationOptions` fields:

| Field | Default | Meaning |
| --- | --- | --- |
| `indent` | four spaces | One indentation level. |
| `baseIndentLevel` | `0` | Levels every line starts at. |
| `useSemicolons` | `false` | Append `;` to statements that accept one. |
| `emitHeaderComment` | `false` | Prefix a comment naming both languages and the file. |
| `lineSeparator` | `"\n"` | Separator written between lines. |
| `failOnUnsupportedNode` | `false` | Throw instead of writing a placeholder comment. |

### Error semantics

A language type that has no parser, or a pair that has no emitter, is never guessed and never silently
replaced:

- `LanguageType.JAVASCRIPT` as the source raises `UnsupportedSourceLanguageException`, whose message names
  `javascript` and lists the parsable source languages.
- `LanguageType.KOTLIN` as the target raises `UnsupportedTargetLanguageException`, whose message names both
  types and lists the registered translations.
- The registry resolves the parser before the emitter and both before the source is read, so a missing
  language is reported instead of a syntax error from a language that was never parsed.
- Lexer and parser problems raise `SyntaxException` with the stage and the span.
- A node with no Kotlin counterpart raises `UnsupportedNodeException` when `failOnUnsupportedNode` is set,
  and is otherwise emitted behind a `not translatable` marker comment.

At this time `typescript` is the only parsable source language and `typescript -> kotlin-script` the only
registered translation.

## Adding a language

Implement `LanguageProvider` and list it in the service descriptor
`META-INF/services/com.github.kusa233.translator.structuring.api.LanguageProvider`; `Translator` picks it up
through `ServiceLoader`. A provider registers parsers and emitters into the `LanguageRegistry` it is given.
Nothing in `api` has to change, and `api` never names a concrete language.

No setup call is needed. The registry fills itself the first time a language is asked for, so
`Translator.translate(...)` works on a fresh process. Discovery happens once and is guarded, so repeated
calls do not register a provider twice, and a `registerParser` / `registerEmitter` call always wins over the
discovered set because it runs afterwards. `Translator.loadProviders(registry, vararg extra)` stays public
for a registry of your own, which is what a test does to register a fake front end.

```kotlin
import com.github.kusa233.translator.structuring.api.LanguageProvider
import com.github.kusa233.translator.structuring.api.LanguageRegistry

class MyLanguageProvider : LanguageProvider {
    override val id: String = "my-languages"

    override fun registerLanguages(registry: LanguageRegistry) {
        registry.registerParser(MyParser())
        registry.registerEmitter(MyEmitter())
    }
}
```

## Command line

```
structuring-translator <input> [output] [options]

  --list                  list the known languages and translations
  --from, --source <id>   source language, otherwise inferred from the input name
  --to, --target <id>     target language, otherwise inferred from the output name
  --indent <text>         one indentation level
  --base-indent <n>       levels every line starts at
  --semicolons            terminate statements with semicolons
  --header                prefix a comment naming both languages
  --strict                throw on a node that has no Kotlin counterpart
```

The output is printed to standard output when no output file is given. Regenerating the samples:

```
build/install/structuring-translator/bin/structuring-translator samples/micro.ts samples/micro.out.kts
build/install/structuring-translator/bin/structuring-translator samples/stress.ts samples/stress.out.kts
```

## Lexer

The lexer keeps trivia, because the parser needs it for automatic semicolon insertion.

- Line terminators become `NEWLINE` tokens and set `precededByLineBreak` on the next significant token.
- Comments become `COMMENT` tokens and are attached to the statements they precede.
- Numbers cover decimal, hex, binary, octal, digit separators, exponents and BigInt suffixes.
- Strings cover both quote styles and every escape form, including code point escapes.
- Templates are `TEMPLATE_NO_SUBST` when they hold no substitution, and otherwise split into
  `TEMPLATE_HEAD`, `TEMPLATE_MIDDLE` and `TEMPLATE_TAIL` around the substituted expressions.
- A slash is a regular expression only where an expression may start; elsewhere it is division. The
  decision uses the previous significant token.
- Punctuators are matched longest first, so `>>>=` never arrives as three tokens.

## Parser

The parser is a recursive descent parser over the significant tokens. Notable behaviour:

- Automatic semicolon insertion is honoured, so semicolons are optional in ordinary code.
- TypeScript syntax is fully parsed: annotations, interfaces, type aliases, generics, enums, namespaces,
  `declare`, `abstract`, `readonly`, optional and rest parameters, `as`, `satisfies` and angle bracket
  assertions, `?.`, `??` and the rest of the modern operator set.
- `speculate` is used where the grammar is ambiguous, for example to decide whether `<` opens type
  arguments or is a comparison; it rewinds the cursor on failure.

## Translation rules

### Declarations

```typescript
var noAssigment;
var a = 123;
let b = 456;
const c = 789;
```

```kotlin
var noAssigment: Any? = null
var a = 123
var b = 456
val c = 789
```

`var` and `let` become `var`, `const` becomes `val`. A declaration without an initializer gains a `null`
initializer, because Kotlin requires one outside a class body.

### Functions

```typescript
function test(a, b: String): String {
    return "awa";
}
```

```kotlin
fun test(a: Any?, b: String): String {
    return "awa"
}
```

An untyped parameter becomes `Any?`. A function without a return annotation gets one inferred from its
`return` statements: `Any?` when some `return` carries a value, `Unit` when they all return nothing, and no
annotation at all when the body never returns.

Kotlin cannot express a bodiless function, so an overload signature becomes a comment; a real
implementation keeps a real signature. An abstract member stays a real `abstract` signature, because Kotlin
allows that.

### Classes

```typescript
abstract class Base<T> implements Shape<T> {
    static count: number = 0;
    readonly name: string;
    abstract area(): number;
    constructor(x: number) { this.name = "b"; }
}
```

```kotlin
abstract class Base<T> : Shape<T> {
    val name: String? = null
    abstract fun area(): Double
    constructor(x: Double) {
        this.name = "b"
    }
    companion object {
        var count: Double? = 0
    }
}
```

Heritage becomes a `:` clause, `implements` becomes further supertypes, and static members move into a
`companion object`. Accessibility modifiers are preserved and `readonly` becomes `val`. Members keep the
order the source gave them, except that statics are collected into the companion object.

### Arrays and object literals

```typescript
var list = [1, 2, 3];
var holes = [, 1];
var obj = { a: "v", b: 2 };
```

```kotlin
var list = mutableListOf(1, 2, 3)
var holes = mutableListOf(null, 1)
var obj = mutableMapOf("a" to "v", "b" to 2)
```

An array literal becomes `mutableListOf`. An object literal without methods becomes `mutableMapOf`, with
every member written as a `key to value` pair. An object literal that declares methods becomes an
anonymous `object { }`, because the methods have to stay callable.

Known constructor names are mapped as well: `Array`, `Map`, `Set`, `WeakMap` and `WeakSet` become the
matching `mutable*Of` factories, with type arguments preserved.

### Functions as values

```typescript
var cb0 = () => { };
var cb1 = (p1) => { return p1; };
var cb2 = (p1) => p1;
```

```kotlin
var cb0 = fun() { }
var cb1 = fun(p1: Any?): Any? {
    return p1
}
var cb2 = { p1: Any? -> p1 }
```

An arrow with an expression body stays a lambda. An arrow with a block body becomes an anonymous
function, because a JavaScript `return` inside a lambda would return from the enclosing function.

### Control flow

- `if` and the ternary operator become Kotlin `if` expressions.
- `for (init; test; update)` becomes an initializer followed by a `while` loop that also runs the update
  expression at the end of its body and before a `continue`. Kotlin has no three clause loop.
- `for (x of items)` and `for (x in items)` become `for (x in items)`.
- `switch` becomes `when`. A bare `break` inside a `when` branch does not compile, so a branch that breaks
  out becomes a labelled `run` block and each break becomes a `return@label`.
- `try` / `catch` / `finally` are preserved; the catch binding is typed `Throwable`.
- Labels are preserved as Kotlin jump labels.

### Operators

| TypeScript | Kotlin |
| --- | --- |
| `===`, `==` | `==` |
| `!==`, `!=` | `!=` |
| `**` | `Math.pow(a, b)` |
| `&`, `|`, `^` | `and`, `or`, `xor` |
| `<<`, `>>`, `>>>` | `shl`, `shr`, `ushr` |
| `~a` | `a.inv()` |
| `a ?? b` | `a ?: b` |
| `a instanceof B` | `a is B` |
| `typeof a` | `(a)::class.simpleName` |
| `void a`, `delete a` | `Unit` |
| `await a` | `a.await()`, omitted for an awaited `Promise.all` |

`as`, `satisfies` and angle bracket assertions are erased; the annotation, when there is one, already
carries the type.

### Standard library

- `console.log`, `console.info`, `console.debug` and `console.warn` become `println`; `console.error`
  becomes `System.err.println`. Several
  arguments are joined with a space: `console.log("a", b)` becomes `println(listOf("a", b).joinToString(" "))`.
- `Promise.all(x)` becomes `x.awaitAll()`.
- `new Error(...)` and its subclasses become Kotlin exceptions, for example `RuntimeException` and
  `ClassCastException`.
- A thrown value that is not an exception is wrapped: `throw "bad"` becomes
  `throw RuntimeException("bad".toString())`.
- Host-only apis have no Kotlin counterpart and are marked, or reported under `--strict`. The set covers
  `fetch`, `require`, the timer functions, the event listener functions, `alert`, `prompt`, `confirm`, the
  storage objects, `process` and `Buffer`. Only a call whose callee is one of those bare names is checked:
  a call such as `response.text()` is left alone, because any object may declare a method of that name.
- A member rename only fires when the receiver is known to be a collection, because `length` is `size` on
  a list but not on every object.

### Types

`KotlinTypeMapper` maps annotations:

| TypeScript | Kotlin |
| --- | --- |
| `number` | `Double` |
| `string` | `String` |
| `boolean` | `Boolean` |
| `any`, `unknown`, `object`, `symbol`, `bigint` | `Any` |
| `void` | `Unit` |
| `never` | `Nothing` |
| `T[]`, `Array<T>`, `ReadonlyArray<T>` | `MutableList<T>` |
| `Map<K, V>`, `ReadonlyMap`, `WeakMap` | `MutableMap<K, V>` |
| `Set<T>`, `ReadonlySet`, `WeakSet` | `MutableSet<T>` |
| `Promise<T>` | `T` |
| `A \| B` | `Any`, or `T?` when one member is nullish |
| `[A, B]` | `MutableList<Any?>` |
| `(a: A) => B` | `(A?) -> B` |
| `{ x: number }` | `MutableMap<String, Any?>` |
| `'a' \| 'b'` | `String` |
| `T & U` | the type of the first member |

An annotation on a declaration that has no initializer gains `?`, because Kotlin needs a value and the
emitter writes `null`. The collection names are mutable on purpose: the translator turns every literal into
a mutable collection, so a read only TypeScript type would reject the assignment it produces.

### Modules

A script has no module system, so `import` statements and a bare `export` are kept as comments, while an
exported declaration is emitted as an ordinary declaration. `declare ...` is kept as a comment.

### Generators

```typescript
function* counter(n: number) {
    for (let i = 0; i < n; i++) {
        yield i;
    }
}
```

```kotlin
fun counter(n: Double): Sequence<Any?> = sequence {
    var i = 0
    while (i < n) {
        yield(i)
        i++
    }
}
```

A generator returns `Sequence<Any?>` and its body is wrapped in `sequence { }`; `yield*` becomes
`yieldAll`.

## Tests

```
./gradlew test
```

The suites are `TypeScriptLexerTest`, `TypeScriptParserTest`, `TranslatorApiTest` and
`KotlinScriptEmitterTest`. The last one also compares the emitter output against `samples/micro.out.kts`
and `samples/stress.out.kts`, so those files are goldens and have to be regenerated when a translation
changes on purpose.
