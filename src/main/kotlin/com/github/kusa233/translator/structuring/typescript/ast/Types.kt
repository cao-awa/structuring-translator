package com.github.kusa233.translator.structuring.typescript.ast

import com.github.kusa233.translator.structuring.api.SourceSpan
import com.github.kusa233.translator.structuring.api.ast.AstNode

/**
 * TypeScript / ECMAScript type syntax.
 *
 * Type nodes are only used for annotations; the Kotlin emitter maps them in `KotlinTypeMapper`.
 */
sealed interface TypeNode : AstNode

/** `string`, `number`, `boolean`, `any`, `void`, `unknown`, `never`, `symbol`, `bigint`, `object`, `this`. */
data class KeywordTypeNode(
    val name: String,
    override val span: SourceSpan = SourceSpan.NONE,
) : TypeNode

/** `Foo`, `ns.Foo<T, U>`. */
data class TypeReferenceNode(
    val name: String,
    val typeArguments: List<TypeNode> = emptyList(),
    override val span: SourceSpan = SourceSpan.NONE,
) : TypeNode

/** `T[]`. */
data class ArrayTypeNode(
    val elementType: TypeNode,
    override val span: SourceSpan = SourceSpan.NONE,
) : TypeNode

/** `A | B`. */
data class UnionTypeNode(
    val types: List<TypeNode>,
    override val span: SourceSpan = SourceSpan.NONE,
) : TypeNode

/** `A & B`. */
data class IntersectionTypeNode(
    val types: List<TypeNode>,
    override val span: SourceSpan = SourceSpan.NONE,
) : TypeNode

/** `[A, B]`. */
data class TupleTypeNode(
    val elements: List<TypeNode>,
    override val span: SourceSpan = SourceSpan.NONE,
) : TypeNode

/** `(a: A, b: B) => C`. */
data class FunctionTypeNode(
    val parameters: List<ParameterNode>,
    val returnType: TypeNode,
    override val span: SourceSpan = SourceSpan.NONE,
) : TypeNode

/** `"literal"`, `42`, `true`. */
data class LiteralTypeNode(
    val literal: Expression,
    override val span: SourceSpan = SourceSpan.NONE,
) : TypeNode

/** `(T)`. */
data class ParenthesizedTypeNode(
    val inner: TypeNode,
    override val span: SourceSpan = SourceSpan.NONE,
) : TypeNode

/** `{ a: A }`. */
data class ObjectTypeNode(
    val members: List<TypeMemberNode>,
    override val span: SourceSpan = SourceSpan.NONE,
) : TypeNode

/** `typeof x`. */
data class TypeQueryNode(
    val entityName: String,
    override val span: SourceSpan = SourceSpan.NONE,
) : TypeNode

/** `keyof T`, `readonly T[]`, `infer U`. */
data class TypeOperatorNode(
    val operator: String,
    val type: TypeNode,
    override val span: SourceSpan = SourceSpan.NONE,
) : TypeNode

/** `T[K]`. */
data class IndexedAccessTypeNode(
    val objectType: TypeNode,
    val indexType: TypeNode,
    override val span: SourceSpan = SourceSpan.NONE,
) : TypeNode

/** `T extends U ? X : Y`. */
data class ConditionalTypeNode(
    val checkType: TypeNode,
    val extendsType: TypeNode,
    val trueType: TypeNode,
    val falseType: TypeNode,
    override val span: SourceSpan = SourceSpan.NONE,
) : TypeNode

/** A member of an inline object type, e.g. `a: A` or `run(x: number): void`. */
data class TypeMemberNode(
    val name: String,
    val type: TypeNode?,
    val optional: Boolean = false,
    val parameters: List<ParameterNode> = emptyList(),
    val returnType: TypeNode? = null,
    override val span: SourceSpan = SourceSpan.NONE,
) : AstNode

/** A declared function / method / lambda parameter. */
data class ParameterNode(
    val name: String,
    val type: TypeNode? = null,
    val defaultValue: Expression? = null,
    val optional: Boolean = false,
    val rest: Boolean = false,
    val readonly: Boolean = false,
    val accessibility: String? = null,
    override val span: SourceSpan = SourceSpan.NONE,
) : AstNode
