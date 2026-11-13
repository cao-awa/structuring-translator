package com.github.kusa233.translator.structuring.typescript.ast

import com.github.kusa233.translator.structuring.api.SourceSpan
import com.github.kusa233.translator.structuring.api.ast.AstNode

/**
 * Every expression form of ECMAScript 2015 plus the TypeScript extensions.
 */
sealed interface Expression : AstNode

/** An identifier reference. */
data class Identifier(
    val name: String,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** The `this` and `super` keywords. */
data class SpecialExpression(
    val kind: Kind,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression {
    enum class Kind(val text: String) {
        THIS("this"),
        SUPER("super"),
    }
}

/**
 * Numeric literal. [value] is a [Double] for every numeric form, [raw] keeps the exact source text.
 */
data class NumericLiteral(
    val raw: String,
    val value: Double,
    val isBigInt: Boolean = false,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** Single quoted or double quoted text. [value] is the unescaped content, [quote] the delimiter. */
data class StringLiteral(
    val value: String,
    val quote: Char = '"',
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** The `true` and `false` literals. */
data class BooleanLiteral(
    val value: Boolean,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** The `null` literal. */
data class NullLiteral(
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** The `undefined` literal. */
data class UndefinedLiteral(
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** A regular expression literal. */
data class RegexLiteral(
    val pattern: String,
    val flags: String,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** One literal chunk of a template string. */
data class TemplateElement(
    val raw: String,
    val cooked: String,
) : AstNode {
    override val span: SourceSpan = SourceSpan.NONE
}

/**
 * A template literal. [expressions] is one shorter than [quasis] when the template has substitutions.
 */
data class TemplateLiteral(
    val quasis: List<TemplateElement>,
    val expressions: List<Expression>,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** An array literal, possibly with holes (a hole is a `null` entry). */
data class ArrayLiteral(
    val elements: List<Expression?>,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** An object literal. */
data class ObjectLiteral(
    val properties: List<ObjectMember>,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** A member of an object literal. */
sealed interface ObjectMember : AstNode

/** A `key: value` property. */
data class PropertyMember(
    val key: String,
    val value: Expression,
    val computed: Boolean = false,
    /** The key expression of a computed member such as `[name]: value`; null for a plain key. */
    val keyExpression: Expression? = null,
    override val span: SourceSpan = SourceSpan.NONE,
) : ObjectMember

/** A shorthand property, optionally with a default value (the latter only in patterns). */
data class ShorthandPropertyMember(
    val name: String,
    val defaultValue: Expression? = null,
    override val span: SourceSpan = SourceSpan.NONE,
) : ObjectMember

/** A spread member of an object literal. */
data class SpreadPropertyMember(
    val argument: Expression,
    override val span: SourceSpan = SourceSpan.NONE,
) : ObjectMember

/** A method, accessor or constructor inside an object literal. */
data class MethodMember(
    val name: String,
    val parameters: List<ParameterNode>,
    val body: FunctionBody,
    val kind: MethodKind = MethodKind.METHOD,
    val isAsync: Boolean = false,
    val computed: Boolean = false,
    /** The key expression of a computed member such as `[name]() { }`; null for a plain key. */
    val keyExpression: Expression? = null,
    override val span: SourceSpan = SourceSpan.NONE,
) : ObjectMember

enum class MethodKind { METHOD, GET, SET, CONSTRUCTOR }

/** A spread element inside a call or an array literal. */
data class SpreadElement(
    val argument: Expression,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** Prefix unary operators such as `+x`, `-x`, `!x`, `~x`, `typeof x`, `void x`, `delete x`, `await x`. */
data class UnaryExpression(
    val operator: String,
    val operand: Expression,
    val prefix: Boolean = true,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** Postfix or prefix increment and decrement. */
data class UpdateExpression(
    val operator: String,
    val operand: Expression,
    val prefix: Boolean,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** Every binary operator, including the bitwise and exponentiation forms. */
data class BinaryExpression(
    val left: Expression,
    val operator: String,
    val right: Expression,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** Short circuit operators: `&&`, `||` and `??`. */
data class LogicalExpression(
    val left: Expression,
    val operator: String,
    val right: Expression,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** Assignment forms, including the compound and logical assignments. */
data class AssignmentExpression(
    val left: Expression,
    val operator: String,
    val right: Expression,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** Conditional (ternary) expression. */
data class ConditionalExpression(
    val test: Expression,
    val consequent: Expression,
    val alternate: Expression,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** Comma expression. */
data class SequenceExpression(
    val expressions: List<Expression>,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** A call, with optional type arguments and optional chaining. */
data class CallExpression(
    val callee: Expression,
    val arguments: List<Expression>,
    val typeArguments: List<TypeNode> = emptyList(),
    val optional: Boolean = false,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** A `new` expression with optional type arguments. */
data class NewExpression(
    val callee: Expression,
    val arguments: List<Expression>,
    val typeArguments: List<TypeNode> = emptyList(),
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** Property access, index access and optional chaining. */
data class MemberExpression(
    val obj: Expression,
    val property: Expression,
    val computed: Boolean,
    val optional: Boolean = false,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** An arrow function with either an expression body or a block body. */
data class ArrowFunction(
    val parameters: List<ParameterNode>,
    val body: ArrowBody,
    val isAsync: Boolean = false,
    val returnType: TypeNode? = null,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** The body of an arrow function: either an expression or a block. */
sealed interface ArrowBody : AstNode

/** An arrow function body that is a single expression. */
data class ExpressionBody(
    val expression: Expression,
    override val span: SourceSpan = SourceSpan.NONE,
) : ArrowBody

/** An arrow function body that is a block. */
data class BlockBody(
    val block: FunctionBody,
    override val span: SourceSpan = SourceSpan.NONE,
) : ArrowBody

/** A `function` expression used as a value. */
data class FunctionExpression(
    val name: String?,
    val parameters: List<ParameterNode>,
    val body: FunctionBody,
    val isAsync: Boolean = false,
    val returnType: TypeNode? = null,
    val typeParameters: List<String> = emptyList(),
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** A `class` expression used as a value. */
data class ClassExpression(
    val name: String?,
    val superClass: Expression?,
    val members: List<ClassMemberNode>,
    val implementsTypes: List<TypeNode> = emptyList(),
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/**
 * An expression that only supplies type arguments, as in the superclass of `class C extends Base<T>`.
 *
 * The value itself is unchanged, so a consumer either reads the arguments or ignores them, and the
 * expression keeps working wherever the bare callee would.
 */
data class InstantiationExpression(
    val expression: Expression,
    val typeArguments: List<TypeNode>,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** A type assertion written with the `as` keyword. */
data class AsExpression(
    val expression: Expression,
    val type: TypeNode,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** A type check written with the `satisfies` keyword. */
data class SatisfiesExpression(
    val expression: Expression,
    val type: TypeNode,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** Non null assertion, written as a postfix exclamation mark. */
data class NonNullExpression(
    val expression: Expression,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** Angle bracket type assertion. */
data class TypeAssertionExpression(
    val expression: Expression,
    val type: TypeNode,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** A parenthesised expression, kept so printing reproduces the original parentheses. */
data class ParenthesizedExpression(
    val expression: Expression,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/** A tagged template, e.g. ``tag`a${b}` ``. */
data class TaggedTemplateExpression(
    val tag: Expression,
    val template: TemplateLiteral,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression

/**
 * The `yield` operator of a generator function.
 *
 * [argument] is null for a bare `yield`, and [delegate] marks the `yield*` form that forwards a whole
 * iterable.
 */
data class YieldExpression(
    val argument: Expression?,
    val delegate: Boolean = false,
    override val span: SourceSpan = SourceSpan.NONE,
) : Expression
