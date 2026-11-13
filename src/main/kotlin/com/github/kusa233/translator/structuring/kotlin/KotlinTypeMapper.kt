package com.github.kusa233.translator.structuring.kotlin

import com.github.kusa233.translator.structuring.typescript.ast.ArrayTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.ConditionalTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.FunctionTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.IndexedAccessTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.IntersectionTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.KeywordTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.LiteralTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.NullLiteral
import com.github.kusa233.translator.structuring.typescript.ast.NumericLiteral
import com.github.kusa233.translator.structuring.typescript.ast.ObjectTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.ParenthesizedTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.StringLiteral
import com.github.kusa233.translator.structuring.typescript.ast.TupleTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.TypeNode
import com.github.kusa233.translator.structuring.typescript.ast.TypeOperatorNode
import com.github.kusa233.translator.structuring.typescript.ast.TypeQueryNode
import com.github.kusa233.translator.structuring.typescript.ast.TypeReferenceNode
import com.github.kusa233.translator.structuring.typescript.ast.UndefinedLiteral
import com.github.kusa233.translator.structuring.typescript.ast.UnionTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.BooleanLiteral

/**
 * Maps TypeScript type syntax onto Kotlin type syntax.
 *
 * The mapping is deliberately lossy: TypeScript types are erased in Kotlin script output, so a type that
 * has no direct counterpart falls back to [ANY] instead of inventing a class. Renamed or structural
 * types are normalised instead of being reported, because a type annotation never changes behaviour.
 */
object KotlinTypeMapper {
    /** Substituted whenever a type is absent or cannot be expressed. */
    const val ANY: String = "Any"

    /** The nullable form of [ANY], used for untyped parameters and lambda arguments. */
    const val ANY_NULLABLE: String = "Any?"

    /** Adds `?` unless [type] is already nullable. */
    fun nullable(type: String): String = if (type.endsWith("?")) type else "$type?"

    /** Maps [type]; a missing type becomes [ANY]. */
    fun map(type: TypeNode?): String {
        if (type == null) {
            return ANY
        }

        return when (type) {
            is KeywordTypeNode -> keyword(type.name)
            is TypeReferenceNode -> reference(type)
            is ArrayTypeNode -> "MutableList<${map(type.elementType)}>"
            is UnionTypeNode -> union(type)
            is IntersectionTypeNode -> map(type.types.firstOrNull())
            is TupleTypeNode -> "MutableList<Any?>"
            is FunctionTypeNode -> functionType(type)
            is LiteralTypeNode -> literalType(type)
            is ParenthesizedTypeNode -> map(type.inner)
            is ObjectTypeNode -> "MutableMap<String, Any?>"
            is TypeQueryNode -> ANY_NULLABLE
            is TypeOperatorNode -> operatorType(type)
            is IndexedAccessTypeNode -> ANY_NULLABLE
            is ConditionalTypeNode -> ANY_NULLABLE
        }
    }

    /** Maps a primitive keyword type name. */
    fun keyword(name: String): String = when (name) {
        "string" -> "String"
        "number" -> "Double"
        "boolean" -> "Boolean"
        "void" -> "Unit"
        "never" -> "Nothing"
        "undefined", "null", "any", "unknown", "object", "this" -> ANY_NULLABLE
        "symbol", "bigint" -> ANY
        else -> name
    }

    /**
     * A promise never reaches the output: awaiting it already produced the value, so the awaited type stands in for
     * the promise itself and `Promise<void>` becomes [keyword] of `void`.
     *
     * The built in collection interfaces are named the way Kotlin names them, and they are mutable, because the
     * translator turns every literal into a mutable collection so that the script can still change it.
     */
    private fun reference(type: TypeReferenceNode): String {
        val arguments = type.typeArguments
        if (type.name == "Promise") {
            return if (arguments.isEmpty()) keyword("void") else map(arguments.first())
        }
        val mapped = when (type.name) {
            "Array", "ReadonlyArray" -> collection("MutableList", arguments, "Any?")
            "Map", "ReadonlyMap", "WeakMap" -> collection("MutableMap", arguments, "String, Any?")
            "Set", "ReadonlySet", "WeakSet" -> collection("MutableSet", arguments, "Any?")
            else -> null
        }
        if (mapped != null) {
            return mapped
        }
        if (arguments.isEmpty()) {
            return type.name
        }
        return type.name + arguments.joinToString(", ", "<", ">") { map(it) }
    }

    /** A renamed collection reference, keeping the type arguments it was given. */
    private fun collection(name: String, arguments: List<TypeNode>, fallback: String): String =
        if (arguments.isEmpty()) "$name<$fallback>" else name + arguments.joinToString(", ", "<", ">") { map(it) }

    /**
     * A union collapses to a single Kotlin type when one member is nullable and the rest agree;
     * anything wider becomes [ANY].
     */
    private fun union(type: UnionTypeNode): String {
        val nullableMember = type.types.any { isNullish(it) }
        val concrete = type.types.filterNot { isNullish(it) }.map { map(it) }.distinct()
        return when {
            concrete.isEmpty() -> ANY_NULLABLE
            concrete.size == 1 -> if (nullableMember) nullable(concrete[0]) else concrete[0]
            else -> if (nullableMember) ANY_NULLABLE else ANY
        }
    }

    private fun isNullish(type: TypeNode): Boolean = when (type) {
        is KeywordTypeNode -> type.name == "null" || type.name == "undefined" || type.name == "void"
        is LiteralTypeNode -> type.literal is NullLiteral || type.literal is UndefinedLiteral
        else -> false
    }

    private fun functionType(type: FunctionTypeNode): String {
        val parameters = type.parameters.joinToString(", ") {
            if (it.rest) {
                "vararg ${nullable(map(it.type))}"
            } else {
                nullable(map(it.type))
            }
        }
        return "($parameters) -> ${map(type.returnType)}"
    }

    private fun literalType(type: LiteralTypeNode): String = when (type.literal) {
        is StringLiteral -> "String"
        is NumericLiteral -> "Double"
        is BooleanLiteral -> "Boolean"
        is NullLiteral -> "Nothing?"
        else -> ANY_NULLABLE
    }

    private fun operatorType(type: TypeOperatorNode): String = when (type.operator) {
        "readonly" -> map(type.type)
        "keyof" -> ANY
        else -> ANY_NULLABLE
    }
}
