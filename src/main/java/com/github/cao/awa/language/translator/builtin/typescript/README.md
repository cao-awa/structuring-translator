# Typescript

## Grammars
```
Due to technical limitations, each line of code must end with a semicolon
```

Typescript grammars supported:

### define variable
```typescript
// <var|let|const> <name> (= <assigment>)? ;
var noAssigment;
var a = 123;
let b = 456;
const c = 789;
```

Translate by 'generic' provide:

```kotlin
var noAssigment: Any? = null
var a = 123
var b = 456
val c = 789
```

### define function
```typescript
// function <name>(<params>?) {
//     <codes>?
// }

// function <name>(<params>?): <result type> {
//     <codes>?
// }

function test() {
    
}

function testWithParams(a, b: String) {
    
}

function testWithParamsAndResultType(a, b: String): String {
    return "awa";
}
```

Translate by 'generic' provide:

```kotlin
fun test() {
    
}

fun testWithParams(a: Any, b: String) {
    
}

fun testWithParamsAndResultType(a: Any, b: String): String {
    return "awa";
}
```
## list of (array)

```typescript
// <var|let|const> <name> = [<elements>] ;

var a = [1];
var b = [1, 2];
var c = [,1];
var d = [,1,];
var e = [,1,2];
var f = [,1,2,];
```

Translate by 'generic' provide:

```kotlin
var a = mutableListOf(1) ;
var b = mutableListOf(1, 2) ;
var c = mutableListOf(1) ;
var d = mutableListOf(1) ;
var e = mutableListOf(1, 2) ;
var f = mutableListOf(1, 2) ;
```