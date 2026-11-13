package com.github.kusa233.translator.structuring.typescript.ast

import com.github.kusa233.translator.structuring.api.SourceSpan
import com.github.kusa233.translator.structuring.api.ast.AstNode

/**
 * Every statement and declaration form the parser can produce.
 */
sealed interface Statement : AstNode

/** A module's statements plus its block-scoped body. Used for functions and blocks. */
data class FunctionBody(
    val statements: List<Statement>,
    override val span: SourceSpan = SourceSpan.NONE,
) : AstNode

/** A bare block `{ ... }`. */
data class BlockStatement(
    val body: FunctionBody,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** An expression used as a statement, e.g. `run();`. */
data class ExpressionStatement(
    val expression: Expression,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `;` and empty statements. */
data class EmptyStatement(
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** A line or block comment retained as a statement so emitters can keep it. */
data class CommentStatement(
    val comment: Comment,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `var`, `let` and `const` declarations, with one or more declarators. */
data class VariableStatement(
    val kind: VariableKind,
    val declarations: List<VariableDeclarator>,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

enum class VariableKind(val text: String) {
    VAR("var"),
    LET("let"),
    CONST("const"),
}

/** A single `name = init` inside a declaration. */
data class VariableDeclarator(
    val name: String,
    val type: TypeNode? = null,
    val initializer: Expression? = null,
    val definite: Boolean = false,
    override val span: SourceSpan = SourceSpan.NONE,
) : AstNode

/** `function name(a) {...}` and `async function ...`. */
data class FunctionDeclaration(
    val name: String,
    val parameters: List<ParameterNode>,
    val body: FunctionBody?,
    val isAsync: Boolean = false,
    val isGenerator: Boolean = false,
    val returnType: TypeNode? = null,
    val typeParameters: List<String> = emptyList(),
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** One `case`/`default` label with its statements. */
data class SwitchCase(
    val test: Expression?,
    val statements: List<Statement>,
    override val span: SourceSpan = SourceSpan.NONE,
) : AstNode

/** `switch (discriminant) { ... }`. */
data class SwitchStatement(
    val discriminant: Expression,
    val cases: List<SwitchCase>,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `if (cond) then else other`. */
data class IfStatement(
    val condition: Expression,
    val thenBranch: Statement,
    val elseBranch: Statement? = null,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `for (init; test; update) body`. [init] is either a [VariableStatement] or an [Expression]. */
data class ForStatement(
    val init: Statement?,
    val test: Expression?,
    val update: Expression?,
    val body: BlockStatement,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `for (const item of items) body`. */
data class ForOfStatement(
    val declares: Boolean,
    val declarationKind: VariableKind,
    val left: Statement?,
    val right: Expression?,
    val body: BlockStatement,
    val isAwait: Boolean = false,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `for (const key in object) body`. */
data class ForInStatement(
    val declares: Boolean,
    val declarationKind: VariableKind,
    val left: Statement?,
    val right: Expression?,
    val body: BlockStatement,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `while (cond) body`. */
data class WhileStatement(
    val condition: Expression,
    val body: BlockStatement,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `do body while (cond)`. */
data class DoWhileStatement(
    val body: BlockStatement,
    val condition: Expression,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `break label?` / `continue label?`. */
data class JumpStatement(
    val keyword: String,
    val label: String? = null,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `return expr?`. */
data class ReturnStatement(
    val argument: Expression?,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `throw expr`. */
data class ThrowStatement(
    val argument: Expression?,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `label: statement`. */
data class LabeledStatement(
    val label: String,
    val statement: Statement,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `try { } catch (e) { } finally { }`. */
data class TryStatement(
    val block: BlockStatement,
    val handler: CatchClause?,
    val finalizer: BlockStatement?,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** The `catch` part of a [TryStatement]. */
data class CatchClause(
    val parameterName: String?,
    val parameterType: TypeNode?,
    val body: BlockStatement,
    override val span: SourceSpan = SourceSpan.NONE,
) : AstNode

/** A single named/default/namespace specifier. */
data class ImportSpecifier(
    val imported: String,
    val local: String = imported,
    val typeOnly: Boolean = false,
    override val span: SourceSpan = SourceSpan.NONE,
) : AstNode

/** `import`, `import ... from '...'`, `import '...'`, `import type ...`. */
data class ImportDeclaration(
    val source: String,
    val defaultBinding: String? = null,
    val namespaceBinding: String? = null,
    val namedImports: List<ImportSpecifier> = emptyList(),
    val sideEffectOnly: Boolean = false,
    val typeOnly: Boolean = false,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `export { a as b }`, `export * from`, `export default ...`, `export const ...`. */
data class ExportDeclaration(
    val declaration: Statement? = null,
    val specifiers: List<ExportSpecifier> = emptyList(),
    val source: String? = null,
    val isDefault: Boolean = false,
    val isStar: Boolean = false,
    val namespaceExport: String? = null,
    val typeOnly: Boolean = false,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `a as b` inside an export list. */
data class ExportSpecifier(
    val local: String,
    val exported: String = local,
    override val span: SourceSpan = SourceSpan.NONE,
) : AstNode

/** `class A extends B { }`. */
data class ClassDeclaration(
    val name: String,
    val superClass: Expression? = null,
    val members: List<ClassMemberNode> = emptyList(),
    val isAbstract: Boolean = false,
    val typeParameters: List<String> = emptyList(),
    val implementsTypes: List<TypeNode> = emptyList(),
    val decorators: List<Expression> = emptyList(),
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** Members allowed inside a class body. */
sealed interface ClassMemberNode : AstNode

/** A field declaration `name: Type = init`. */
data class FieldMemberNode(
    val name: String,
    val type: TypeNode? = null,
    val initializer: Expression? = null,
    val isStatic: Boolean = false,
    val readonly: Boolean = false,
    val accessibility: String? = null,
    val optional: Boolean = false,
    val definite: Boolean = false,
    override val span: SourceSpan = SourceSpan.NONE,
) : ClassMemberNode

/** A method / constructor / accessor declaration. */
data class MethodMemberNode(
    val name: String,
    val parameters: List<ParameterNode>,
    val body: FunctionBody?,
    val kind: MethodKind = MethodKind.METHOD,
    val isStatic: Boolean = false,
    val isAsync: Boolean = false,
    val isGenerator: Boolean = false,
    val isAbstract: Boolean = false,
    val accessibility: String? = null,
    val returnType: TypeNode? = null,
    val typeParameters: List<String> = emptyList(),
    override val span: SourceSpan = SourceSpan.NONE,
) : ClassMemberNode

/** `interface Name { ... }` - parsed so real-world TypeScript files do not fail. */
data class InterfaceDeclaration(
    val name: String,
    val members: List<TypeMemberNode>,
    val extendsNames: List<String> = emptyList(),
    val typeParameters: List<String> = emptyList(),
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `type Name = ...`. */
data class TypeAliasDeclaration(
    val name: String,
    val type: TypeNode,
    val typeParameters: List<String> = emptyList(),
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `enum Name { A, B = 2 }`. */
data class EnumDeclaration(
    val name: String,
    val members: List<EnumMemberNode>,
    val isConst: Boolean = false,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** One enum member. */
data class EnumMemberNode(
    val name: String,
    val initializer: Expression? = null,
    override val span: SourceSpan = SourceSpan.NONE,
) : AstNode

/** A top level `declare ...` statement; parsed and kept for fidelity. */
data class NamespaceDeclaration(
    val name: String,
    val statements: List<Statement>,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement

/** `declare function f(): void;`. */
data class AmbientDeclaration(
    val statement: Statement,
    override val span: SourceSpan = SourceSpan.NONE,
) : Statement
