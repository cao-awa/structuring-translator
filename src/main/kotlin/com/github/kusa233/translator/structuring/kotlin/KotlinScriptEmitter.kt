package com.github.kusa233.translator.structuring.kotlin

import com.github.kusa233.translator.structuring.api.LanguageEmitter
import com.github.kusa233.translator.structuring.api.LanguageType
import com.github.kusa233.translator.structuring.api.TranslationOptions
import com.github.kusa233.translator.structuring.api.UnsupportedNodeException
import com.github.kusa233.translator.structuring.api.ast.TranslationUnit
import com.github.kusa233.translator.structuring.typescript.ast.AmbientDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.ArrayLiteral
import com.github.kusa233.translator.structuring.typescript.ast.ArrowFunction
import com.github.kusa233.translator.structuring.typescript.ast.AsExpression
import com.github.kusa233.translator.structuring.typescript.ast.AssignmentExpression
import com.github.kusa233.translator.structuring.typescript.ast.BinaryExpression
import com.github.kusa233.translator.structuring.typescript.ast.BlockBody
import com.github.kusa233.translator.structuring.typescript.ast.BlockStatement
import com.github.kusa233.translator.structuring.typescript.ast.BooleanLiteral
import com.github.kusa233.translator.structuring.typescript.ast.CallExpression
import com.github.kusa233.translator.structuring.typescript.ast.ClassDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.ClassExpression
import com.github.kusa233.translator.structuring.typescript.ast.ClassMemberNode
import com.github.kusa233.translator.structuring.typescript.ast.Comment
import com.github.kusa233.translator.structuring.typescript.ast.CommentStatement
import com.github.kusa233.translator.structuring.typescript.ast.ConditionalExpression
import com.github.kusa233.translator.structuring.typescript.ast.DoWhileStatement
import com.github.kusa233.translator.structuring.typescript.ast.EmptyStatement
import com.github.kusa233.translator.structuring.typescript.ast.EnumDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.ExportDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.Expression
import com.github.kusa233.translator.structuring.typescript.ast.ExpressionBody
import com.github.kusa233.translator.structuring.typescript.ast.ExpressionStatement
import com.github.kusa233.translator.structuring.typescript.ast.FieldMemberNode
import com.github.kusa233.translator.structuring.typescript.ast.ForInStatement
import com.github.kusa233.translator.structuring.typescript.ast.ForOfStatement
import com.github.kusa233.translator.structuring.typescript.ast.ForStatement
import com.github.kusa233.translator.structuring.typescript.ast.FunctionBody
import com.github.kusa233.translator.structuring.typescript.ast.FunctionDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.FunctionExpression
import com.github.kusa233.translator.structuring.typescript.ast.Identifier
import com.github.kusa233.translator.structuring.typescript.ast.IfStatement
import com.github.kusa233.translator.structuring.typescript.ast.InstantiationExpression
import com.github.kusa233.translator.structuring.typescript.ast.ImportDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.InterfaceDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.JumpStatement
import com.github.kusa233.translator.structuring.typescript.ast.KeywordTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.LabeledStatement
import com.github.kusa233.translator.structuring.typescript.ast.LogicalExpression
import com.github.kusa233.translator.structuring.typescript.ast.MemberExpression
import com.github.kusa233.translator.structuring.typescript.ast.MethodKind
import com.github.kusa233.translator.structuring.typescript.ast.MethodMember
import com.github.kusa233.translator.structuring.typescript.ast.MethodMemberNode
import com.github.kusa233.translator.structuring.typescript.ast.NamespaceDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.NewExpression
import com.github.kusa233.translator.structuring.typescript.ast.NonNullExpression
import com.github.kusa233.translator.structuring.typescript.ast.NullLiteral
import com.github.kusa233.translator.structuring.typescript.ast.NumericLiteral
import com.github.kusa233.translator.structuring.typescript.ast.ObjectLiteral
import com.github.kusa233.translator.structuring.typescript.ast.ObjectMember
import com.github.kusa233.translator.structuring.typescript.ast.ParenthesizedExpression
import com.github.kusa233.translator.structuring.typescript.ast.ParameterNode
import com.github.kusa233.translator.structuring.typescript.ast.PropertyMember
import com.github.kusa233.translator.structuring.typescript.ast.RegexLiteral
import com.github.kusa233.translator.structuring.typescript.ast.ReturnStatement
import com.github.kusa233.translator.structuring.typescript.ast.SatisfiesExpression
import com.github.kusa233.translator.structuring.typescript.ast.SequenceExpression
import com.github.kusa233.translator.structuring.typescript.ast.ShorthandPropertyMember
import com.github.kusa233.translator.structuring.typescript.ast.SourceFile
import com.github.kusa233.translator.structuring.typescript.ast.SpecialExpression
import com.github.kusa233.translator.structuring.typescript.ast.SpreadElement
import com.github.kusa233.translator.structuring.typescript.ast.SpreadPropertyMember
import com.github.kusa233.translator.structuring.typescript.ast.Statement
import com.github.kusa233.translator.structuring.typescript.ast.StringLiteral
import com.github.kusa233.translator.structuring.typescript.ast.SwitchCase
import com.github.kusa233.translator.structuring.typescript.ast.SwitchStatement
import com.github.kusa233.translator.structuring.typescript.ast.TaggedTemplateExpression
import com.github.kusa233.translator.structuring.typescript.ast.TemplateLiteral
import com.github.kusa233.translator.structuring.typescript.ast.ThrowStatement
import com.github.kusa233.translator.structuring.typescript.ast.TryStatement
import com.github.kusa233.translator.structuring.typescript.ast.TypeAliasDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.TypeAssertionExpression
import com.github.kusa233.translator.structuring.typescript.ast.TypeMemberNode
import com.github.kusa233.translator.structuring.typescript.ast.TypeNode
import com.github.kusa233.translator.structuring.typescript.ast.UndefinedLiteral
import com.github.kusa233.translator.structuring.typescript.ast.UnaryExpression
import com.github.kusa233.translator.structuring.typescript.ast.UpdateExpression
import com.github.kusa233.translator.structuring.typescript.ast.VariableDeclarator
import com.github.kusa233.translator.structuring.typescript.ast.VariableKind
import com.github.kusa233.translator.structuring.typescript.ast.VariableStatement
import com.github.kusa233.translator.structuring.typescript.ast.WhileStatement
import com.github.kusa233.translator.structuring.typescript.ast.YieldExpression

/**
 * Renders a TypeScript [SourceFile] as Kotlin script source.
 *
 * The emitter is a back end for exactly one language pair: [LanguageType.TYPESCRIPT] in,
 * [LanguageType.KOTLIN_SCRIPT] out. Requesting another pair never reaches this class, because the
 * registry reports the missing translation first; a unit that is not a TypeScript source file raises
 * [UnsupportedNodeException] instead of being silently skipped.
 *
 * Translation choices, all of them documented in the TypeScript README:
 * - `let` and `var` become `var`, `const` becomes `val`.
 * - Annotations are mapped by [KotlinTypeMapper]; `as`, `satisfies` and angle bracket assertions are erased.
 * - Array literals become `mutableListOf`, plain object literals become `mutableMapOf`, and object literals that
 *   declare methods become anonymous objects so the methods stay callable.
 * - Arrow functions with an expression body stay lambdas; block bodies become anonymous functions so a JavaScript
 *   `return` keeps working.
 * - C style `for` loops are rewritten as an initialiser followed by a `while` loop that also runs the update
 *   expression, because Kotlin has no three clause loop.
 * - `switch` becomes `when`, `===` becomes `==`, `**` becomes a `Math.pow` call and the bitwise operators become
 *   their named Kotlin infix counterparts.
 * - Modules do not exist in a script, so `import` and bare `export` statements are kept as comments while an
 *   exported declaration is emitted as an ordinary declaration.
 */
class KotlinScriptEmitter(
    override val sourceType: LanguageType = LanguageType.TYPESCRIPT,
    override val targetType: LanguageType = LanguageType.KOTLIN_SCRIPT,
) : LanguageEmitter {

    override fun emit(file: TranslationUnit, options: TranslationOptions): String {
        if (file !is SourceFile) {
            throw UnsupportedNodeException(
                targetType,
                file::class.simpleName ?: "TranslationUnit",
                "this emitter only understands a TypeScript source unit, so the input cannot be rendered as Kotlin script",
            )
        }
        return Session(file, options, targetType).render()
    }

    /** One emission run: holds the options and builds the text. */
    private class Session(
        private val file: SourceFile,
        private val options: TranslationOptions,
        private val targetType: LanguageType,
    ) {
        private val newline: String = options.lineSeparator

        /**
         * The Kotlin type of every name declared so far, keyed by the source name. A few translations need to know
         * what a member is attached to, because JavaScript spells the same member differently per receiver: a list
         * and a string both have `length`, but only the list becomes `size` in Kotlin.
         */
        private val declaredTypes = HashMap<String, String>()

        /** The Kotlin name of the class being rendered, used for a `this` return type. */
        private var selfType: String? = null

        /** The update a C style loop has to run before a `continue` jumps back to its condition. */
        private var continueUpdate: String? = null

        /**
         * The labels of the lambdas that stand in for enclosing `switch` statements. Kotlin has no statement that
         * leaves a `when`, so a case whose body breaks out early becomes a labelled `run` block and its `break`
         * is redirected at that label.
         */
        private val breakTargets = ArrayList<BreakTarget>(2)

        /** Source of unique names for the labels above, so nested switches cannot shadow one another. */
        private var breakLabelCount = 0

        /** How many loops surround the statement being rendered, so a break can tell which construct it leaves. */
        private var loopDepth = 0

        /**
         * A labelled block standing in for a switch, together with the loop depth it was opened at: a break whose
         * loop depth is deeper than this came from a loop inside the case and must not return from the block.
         */
        private class BreakTarget(val label: String, val loopDepth: Int)

        fun render(): String {
            val builder = StringBuilder()
            if (options.emitHeaderComment) {
                builder.append("// Generated by structuring-translator: ")
                builder.append(file.sourceType?.id ?: LanguageType.TYPESCRIPT.id)
                builder.append(" -> ")
                builder.append(LanguageType.KOTLIN_SCRIPT.id)
                val name = file.fileName
                if (name != null) {
                    builder.append(" (from ").append(name).append(')')
                }
                builder.append(newline).append(newline)
            }

            var previous: Statement? = null
            for (statement in file.statements) {
                val text = statementText(statement, 0)
                if (text.isEmpty()) {
                    continue
                }
                if (previous != null && needsBlankLine(previous, statement)) {
                    builder.append(newline)
                }
                builder.append(text).append(newline)
                previous = statement
            }
            return builder.toString()
        }

        // ---------------------------------------------------------------- layout helpers

        private fun ind(level: Int): String = options.indent(level)

        /** Runs [block] with [update] as the expression a bare `continue` has to run first, then restores it. */
        private fun <T> withContinueUpdate(update: String?, block: () -> T): T {
            val previous = continueUpdate
            continueUpdate = update
            try {
                return block()
            } finally {
                continueUpdate = previous
            }
        }

        /** Runs [block] knowing that a bare `break` has to return from the labelled block [label]. */
        private fun <T> withBreakTarget(label: String, block: () -> T): T {
            breakTargets.add(BreakTarget(label, loopDepth))
            try {
                return block()
            } finally {
                breakTargets.removeAt(breakTargets.size - 1)
            }
        }

        /** Runs [block] as the body of a loop, so a break inside it belongs to that loop rather than to a switch. */
        private fun <T> withLoop(block: () -> T): T {
            loopDepth++
            try {
                return block()
            } finally {
                loopDepth--
            }
        }

        /** Runs [block] knowing that `this` stands for [type], then restores the enclosing one. */
        private fun <T> withSelfType(type: String?, block: () -> T): T {
            val previous = selfType
            selfType = type
            try {
                return block()
            } finally {
                selfType = previous
            }
        }

        private fun recordType(name: String, type: String) {
            declaredTypes[name] = type
        }

        /**
         * Maps an annotation, resolving the `this` type against the class being rendered. Kotlin has no type that
         * means the enclosing class the way the TypeScript `this` type does, so it is spelled out as that class.
         */
        private fun mapType(type: TypeNode?): String {
            if (type is KeywordTypeNode && type.name == "this") {
                return selfType ?: KotlinTypeMapper.ANY_NULLABLE
            }
            return KotlinTypeMapper.map(type)
        }

        /** The Kotlin type recorded for the value [expression] evaluates to, when it is a plain name. */
        private fun typeOf(expression: Expression): String? = when (expression) {
            is Identifier -> declaredTypes[expression.name]
            is MemberExpression -> if (expression.computed) null else memberName(expression)?.let { declaredTypes[it] }
            else -> null
        }

        /** The Kotlin type of a value whose shape is obvious from the literal that builds it. */
        private fun inferValueType(expression: Expression): String? = when (expression) {
            is ArrayLiteral -> "MutableList<Any?>"
            is NewExpression -> inferredNewType(expression)
            is StringLiteral, is TemplateLiteral -> "String"
            is NumericLiteral -> "Double"
            is BooleanLiteral -> "Boolean"
            else -> null
        }

        private fun isListLike(type: String?): Boolean {
            if (type == null) {
                return false
            }
            return type.startsWith("MutableList") || type.startsWith("MutableSet") || type.startsWith("List") ||
                type.startsWith("Set") || type.startsWith("MutableMap") || type.startsWith("Map")
        }

        private fun isMapLike(type: String?): Boolean {
            if (type == null) {
                return false
            }
            return type.startsWith("MutableMap") || type.startsWith("Map")
        }

        private fun needsBlankLine(previous: Statement, current: Statement): Boolean =
            isSection(previous) || isSection(current)

        private fun isSection(statement: Statement): Boolean = when (statement) {
            is FunctionDeclaration, is ClassDeclaration, is InterfaceDeclaration, is EnumDeclaration,
            is NamespaceDeclaration, is TypeAliasDeclaration, is TryStatement, is SwitchStatement -> true
            else -> false
        }

        /** The text of a brace block whose header sits at [headerLevel]. */
        private fun blockText(body: FunctionBody, headerLevel: Int): String =
            bodyText(body.statements, headerLevel + 1)

        /** The text of a brace block whose contents sit at [innerLevel]. */
        private fun bodyText(statements: List<Statement>, innerLevel: Int): String {
            val rendered = statements.map { statementText(it, innerLevel) }.filter { it.isNotEmpty() }
            if (rendered.isEmpty()) {
                return "{ }"
            }
            val builder = StringBuilder("{")
            builder.append(newline)
            for (text in rendered) {
                builder.append(text).append(newline)
            }
            builder.append(ind(innerLevel - 1)).append('}')
            return builder.toString()
        }

        /** Renders [statement] as a block, wrapping it when the source form is a single statement. */
        private fun statementAsBlock(statement: Statement, level: Int): String {
            if (statement is BlockStatement) {
                return blockText(statement.body, level)
            }
            val text = statementText(statement, level + 1)
            if (text.isEmpty()) {
                return "{ }"
            }
            return "{" + newline + text + newline + ind(level) + "}"
        }

        // ---------------------------------------------------------------- statements

        private fun statementText(statement: Statement, level: Int): String = when (statement) {
            is EmptyStatement -> ""
            is CommentStatement -> commentText(statement.comment, level)
            is BlockStatement -> ind(level) + blockText(statement.body, level)
            is ExpressionStatement -> expressionStatementText(statement.expression, level)
            is VariableStatement -> variableStatementText(statement, level)
            is FunctionDeclaration -> functionDeclarationText(statement, level)
            is ClassDeclaration -> classDeclarationText(statement, level)
            is InterfaceDeclaration -> interfaceText(statement, level)
            is TypeAliasDeclaration -> ind(level) + "typealias " + statement.name +
                typeParameters(statement.typeParameters) + " = " + KotlinTypeMapper.map(statement.type)
            is EnumDeclaration -> enumText(statement, level)
            is NamespaceDeclaration -> namespaceText(statement, level)
            is IfStatement -> ifText(statement, level)
            is ForStatement -> withLoop { forText(statement, level) }
            is ForOfStatement -> withLoop {
                forEachText(
                    level,
                    loopVariable(statement.left),
                    statement.right,
                    statement,
                    statement.body,
                )
            }
            is ForInStatement -> withLoop {
                forEachText(
                    level,
                    loopVariable(statement.left),
                    statement.right,
                    statement,
                    statement.body,
                )
            }
            is WhileStatement -> withLoop {
                ind(level) + "while (" + expressionText(statement.condition, level) + ") " +
                    blockText(statement.body.body, level)
            }
            is DoWhileStatement -> withLoop {
                ind(level) + "do " + blockText(statement.body.body, level) +
                    " while (" + expressionText(statement.condition, level) + ")"
            }
            is JumpStatement -> jumpText(statement, level)
            is ReturnStatement -> returnText(statement.argument, level)
            is ThrowStatement -> throwText(statement.argument, level)
            is LabeledStatement -> ind(level) + identifierText(statement.label) + "@ " +
                statementText(statement.statement, level).removePrefix(ind(level))
            is TryStatement -> tryText(statement, level)
            is SwitchStatement -> switchText(statement, level)
            is ImportDeclaration -> importText(statement, level)
            is ExportDeclaration -> exportText(statement, level)
            is AmbientDeclaration -> ambientText(statement, level)
        }

        private fun expressionStatementText(expression: Expression, level: Int): String {
            val text = expressionText(expression, level)
            if (text.isEmpty()) {
                return ""
            }
            return ind(level) + text + options.terminator()
        }

        /**
         * A `break` or `continue`. A label becomes a Kotlin jump label, and a `continue` inside a rewritten
         * C style loop first runs the update the original loop performed at the end of its body, because
         * Kotlin jumps straight back to the condition.
         */
        private fun jumpText(statement: JumpStatement, level: Int): String {
            val keyword = statement.keyword
            val label = statement.label
            if (label != null) {
                return ind(level) + keyword + "@" + identifierText(label) + options.terminator()
            }
            val wrapper = breakTargets.lastOrNull()
            if (keyword == "break" && wrapper != null && wrapper.loopDepth == loopDepth) {
                // The switch this break leaves became a `run` block, so leaving it is leaving that lambda.
                return ind(level) + "return@" + wrapper.label + options.terminator()
            }
            val update = continueUpdate
            if (keyword == "continue" && update != null) {
                return StringBuilder(ind(level)).append(update).append(options.terminator()).append(newline)
                    .append(ind(level)).append("continue").append(options.terminator()).toString()
            }
            return ind(level) + keyword + options.terminator()
        }

        private fun returnText(argument: Expression?, level: Int): String {
            if (argument == null) {
                return ind(level) + "return" + options.terminator()
            }
            return ind(level) + "return " + expressionText(argument, level) + options.terminator()
        }

        /**
         * A thrown value is a Kotlin exception. JavaScript lets any value travel through `throw`, so a value that is
         * not already an exception is wrapped in a [RuntimeException] carrying it.
         */
        private fun throwText(argument: Expression?, level: Int): String {
            if (argument == null) {
                return ind(level) + "throw RuntimeException()" + options.terminator()
            }
            val text = expressionText(argument, level)
            if (isExceptionConstruction(argument)) {
                return ind(level) + "throw " + text + options.terminator()
            }
            return ind(level) + "throw RuntimeException(" + text + ".toString())" + options.terminator()
        }

        private fun isExceptionConstruction(expression: Expression): Boolean {
            if (expression !is NewExpression) {
                return false
            }
            val callee = unwrapParentheses(expression.callee)
            if (callee !is Identifier) {
                return false
            }
            return callee.name in JS_ERROR_CLASSES
        }

        private fun commentText(comment: Comment, level: Int): String {
            val lines = comment.text.split(newline)
            val builder = StringBuilder(ind(level)).append(lines.first().trimEnd())
            for (index in 1 until lines.size) {
                builder.append(newline).append(lines[index].trimEnd())
            }
            return builder.toString()
        }

        private fun variableStatementText(statement: VariableStatement, level: Int): String {
            val parts = statement.declarations.map { declaratorText(statement.kind, it, level) }
            return parts.joinToString(newline)
        }

        private fun declaratorText(kind: VariableKind, declarator: VariableDeclarator, level: Int): String {
            val keyword = if (kind == VariableKind.CONST) "val" else "var"
            val name = identifierText(declarator.name)
            val builder = StringBuilder(ind(level)).append(keyword).append(' ').append(name)
            val declaredType = declarator.type
            val initializer = declarator.initializer
            if (declaredType != null && initializer != null) {
                val mapped = mapType(declaredType)
                recordType(declarator.name, mapped)
                builder.append(": ").append(mapped)
                builder.append(" = ").append(expressionText(initializer, level))
            } else if (declaredType != null) {
                val mapped = mapType(declaredType)
                recordType(declarator.name, mapped)
                builder.append(": ").append(KotlinTypeMapper.nullable(mapped))
                builder.append(" = null")
            } else if (initializer != null) {
                inferValueType(initializer)?.let { recordType(declarator.name, it) }
                builder.append(" = ").append(expressionText(initializer, level))
            } else {
                builder.append(": ").append(KotlinTypeMapper.ANY_NULLABLE).append(" = null")
            }
            builder.append(options.terminator())
            return builder.toString()
        }

        private fun functionDeclarationText(declaration: FunctionDeclaration, level: Int): String {
            val body = declaration.body
            // A generator is a Kotlin sequence builder: the declared return type becomes the element type.
            val signature = StringBuilder("fun ").append(identifierText(declaration.name))
                .append(typeParameters(declaration.typeParameters))
                .append('(').append(parameterList(declaration.parameters, level)).append(')')
                .append(
                    if (declaration.isGenerator) {
                        ": Sequence<Any?>"
                    } else {
                        returnSuffix(declaration.returnType, body)
                    },
                )
                .toString()
            if (body == null) {
                // A declaration without a body is an overload signature. Kotlin only allows a bodiless function as
                // an abstract member, so the signature is preserved verbatim as a comment rather than as a stub
                // that would quietly return nothing.
                return StringBuilder(ind(level)).append("// overload ").append(signature).toString()
            }
            val builder = StringBuilder(ind(level)).append(signature)
            if (declaration.isGenerator) {
                return builder.append(" = ").append(sequenceBodyText(body, level)).toString()
            }
            return builder.append(' ').append(blockText(body, level)).toString()
        }

        /** Renders a generator body wrapped in a `sequence` builder at [level]. */
        private fun sequenceBodyText(body: FunctionBody, level: Int): String {
            val builder = StringBuilder("sequence {").append(newline)
            for (statement in body.statements) {
                val text = statementText(statement, level + 1)
                if (text.isNotEmpty()) {
                    builder.append(text).append(newline)
                }
            }
            builder.append(ind(level)).append("}")
            return builder.toString()
        }

        private fun classDeclarationText(declaration: ClassDeclaration, level: Int): String {
            val builder = StringBuilder(ind(level))
            if (declaration.isAbstract) {
                builder.append("abstract ")
            }
            builder.append("class ").append(identifierText(declaration.name))
            builder.append(typeParameters(declaration.typeParameters))
            val supertypes = ArrayList<String>(1 + declaration.implementsTypes.size)
            val superClass = declaration.superClass
            if (superClass != null) {
                supertypes.add(expressionText(superClass, level) + "()")
            }
            for (implemented in declaration.implementsTypes) {
                supertypes.add(KotlinTypeMapper.map(implemented))
            }
            if (supertypes.isNotEmpty()) {
                builder.append(" : ").append(supertypes.joinToString(", "))
            }
            if (declaration.members.isEmpty()) {
                builder.append(" { }")
                return builder.toString()
            }

            builder.append(" {").append(newline)
            val statics = declaration.members.filter { isStatic(it) }
            val instance = declaration.members.filterNot { isStatic(it) }
            // A member that returns `this` returns an instance of the class being written, so the members are
            // rendered knowing which type that is.
            withSelfType(declaration.name) {
                for (text in classMemberTexts(instance, level + 1)) {
                    builder.append(text).append(newline)
                }
                if (statics.isNotEmpty()) {
                    builder.append(ind(level + 1)).append("companion object {").append(newline)
                    for (text in classMemberTexts(statics, level + 2)) {
                        builder.append(text).append(newline)
                    }
                    builder.append(ind(level + 1)).append('}').append(newline)
                }
            }
            builder.append(ind(level)).append('}')
            return builder.toString()
        }

        private fun isStatic(member: ClassMemberNode): Boolean = when (member) {
            is FieldMemberNode -> member.isStatic
            is MethodMemberNode -> member.isStatic
        }

        private fun classMemberText(member: ClassMemberNode, level: Int): String = when (member) {
            is FieldMemberNode -> fieldMemberText(member, level)
            is MethodMemberNode -> methodMemberText(member, level)
        }

        private fun fieldMemberText(member: FieldMemberNode, level: Int): String {
            val keyword = if (member.readonly) "val" else "var"
            val builder = StringBuilder(ind(level)).append(keyword).append(' ')
                .append(identifierText(member.name))
            val initializer = member.initializer
            val declaredType = member.type
            if (declaredType != null) {
                val mapped = mapType(declaredType)
                recordType(member.name, mapped)
                builder.append(": ").append(KotlinTypeMapper.nullable(mapped))
            } else {
                // A field holding a function keeps a callable type, so a later `this.callback()` still resolves.
                val inferred = inferFieldType(initializer)
                recordType(member.name, inferred ?: KotlinTypeMapper.ANY_NULLABLE)
                builder.append(": ").append(inferred ?: KotlinTypeMapper.ANY_NULLABLE)
            }
            builder.append(
                if (initializer == null) {
                    " = null"
                } else {
                    " = " + expressionText(initializer, level)
                },
            )
            builder.append(options.terminator())
            return builder.toString()
        }

        /** The Kotlin type of a field with no annotation, taken from an initialiser that has an obvious shape. */
        private fun inferFieldType(initializer: Expression?): String? = when (initializer) {
            null -> null
            is ArrowFunction -> "(" + initializer.parameters.joinToString(", ") {
                KotlinTypeMapper.nullable(KotlinTypeMapper.map(it.type))
            } + ") -> " + anonymousReturnType(initializer)
            is FunctionExpression -> "(" + initializer.parameters.joinToString(", ") {
                KotlinTypeMapper.nullable(KotlinTypeMapper.map(it.type))
            } + ") -> " + anonymousReturnType(initializer)
            is NewExpression -> inferredNewType(initializer)
            else -> null
        }

        /**
         * The container type of a collection factory call, so a field filled by `new Map<string, unknown>()` keeps
         * both a usable element type and a mutable container instead of collapsing to a nullable `Any`.
         */
        private fun inferredNewType(expression: NewExpression): String? {
            val callee = unwrapParentheses(expression.callee)
            if (callee !is Identifier) {
                return null
            }
            val arguments = expression.typeArguments
            return when (callee.name) {
                "Map", "WeakMap" -> containerType("MutableMap", arguments, "String, Any?")
                "Set", "WeakSet" -> containerType("MutableSet", arguments, "Any?")
                "Array" -> containerType("MutableList", arguments, "Any?")
                else -> null
            }
        }

        private fun containerType(name: String, arguments: List<TypeNode>, fallback: String): String =
            if (arguments.isEmpty()) {
                "$name<$fallback>"
            } else {
                name + arguments.joinToString(", ", "<", ">") { KotlinTypeMapper.map(it) }
            }

        private fun anonymousReturnType(expression: Expression): String {
            val declared = when (expression) {
                is ArrowFunction -> expression.returnType
                is FunctionExpression -> expression.returnType
                else -> null
            }
            if (declared != null) {
                return KotlinTypeMapper.map(declared)
            }
            val body = when (expression) {
                is ArrowFunction -> when (val arrow = expression.body) {
                    is BlockBody -> arrow.block
                    is ExpressionBody -> return "Any?"
                }
                is FunctionExpression -> expression.body
                else -> return "Any?"
            }
            return if (body.statements.any { it is ReturnStatement }) "Any?" else "Unit"
        }

        private fun methodMemberText(member: MethodMemberNode, level: Int): String {
            val builder = StringBuilder(ind(level))
            if (member.kind == MethodKind.CONSTRUCTOR) {
                builder.append("constructor(").append(parameterList(member.parameters, level)).append(')')
                val body = member.body
                builder.append(' ').append(if (body == null) "{ }" else blockText(body, level))
                return builder.toString()
            }
            val signature = StringBuilder("fun ").append(identifierText(member.name))
                .append(typeParameters(member.typeParameters))
                .append('(').append(parameterList(member.parameters, level)).append(')')
                .append(returnSuffix(member.returnType, member.body))
                .toString()
            if (member.isAbstract) {
                // An abstract member is a signature only: Kotlin rejects a body on it.
                return builder.append("abstract ").append(signature).toString()
            }
            val body = member.body
            if (body == null) {
                // A member without a body overloads another one; Kotlin cannot express that as a stub.
                return builder.append("// overload ").append(signature).toString()
            }
            return builder.append(signature).append(' ').append(blockText(body, level)).toString()
        }

        /**
         * A get and set pair becomes one Kotlin property with custom accessors, because two members of the same
         * name cannot both be properties. A lone accessor keeps the same shape with only the half it declares.
         */
        private fun accessorText(getter: MethodMemberNode?, setter: MethodMemberNode?, level: Int): String {
            val source = getter ?: setter ?: return ""
            val builder = StringBuilder(ind(level))
            builder.append(if (setter == null) "val " else "var ")
            builder.append(identifierText(source.name))
            builder.append(": ").append(KotlinTypeMapper.ANY_NULLABLE)
            val getterBody = getter?.body
            builder.append(newline).append(ind(level + 1)).append("get() ")
            builder.append(if (getterBody == null) "{ }" else blockText(getterBody, level + 1))
            if (setter != null) {
                val parameter = setter.parameters.firstOrNull()
                val parameterName = if (parameter == null) "value" else identifierText(parameter.name)
                val setterBody = setter.body
                builder.append(newline).append(ind(level + 1)).append("set(").append(parameterName).append(") ")
                builder.append(if (setterBody == null) "{ }" else blockText(setterBody, level + 1))
            }
            return builder.toString()
        }

        /** Renders class members, folding each get and set pair into a single property. */
        private fun classMemberTexts(members: List<ClassMemberNode>, level: Int): List<String> {
            val texts = ArrayList<String>(members.size)
            val folded = HashSet<String>(4)
            for (member in members) {
                if (member is MethodMemberNode && (member.kind == MethodKind.GET || member.kind == MethodKind.SET)) {
                    if (member.name in folded) {
                        continue
                    }
                    folded.add(member.name)
                    val getter = members.firstOrNull {
                        it is MethodMemberNode && it.kind == MethodKind.GET && it.name == member.name
                    } as MethodMemberNode?
                    val setter = members.firstOrNull {
                        it is MethodMemberNode && it.kind == MethodKind.SET && it.name == member.name
                    } as MethodMemberNode?
                    texts.add(accessorText(getter, setter, level))
                    continue
                }
                texts.add(classMemberText(member, level))
            }
            return texts
        }

        private fun interfaceText(declaration: InterfaceDeclaration, level: Int): String {
            val builder = StringBuilder(ind(level)).append("interface ").append(identifierText(declaration.name))
            builder.append(typeParameters(declaration.typeParameters))
            if (declaration.extendsNames.isNotEmpty()) {
                builder.append(" : ").append(declaration.extendsNames.joinToString(", "))
            }
            if (declaration.members.isEmpty()) {
                builder.append(" { }")
                return builder.toString()
            }
            builder.append(" {").append(newline)
            for (member in declaration.members) {
                builder.append(typeMemberText(member, level + 1)).append(newline)
            }
            builder.append(ind(level)).append('}')
            return builder.toString()
        }

        private fun typeMemberText(member: TypeMemberNode, level: Int): String {
            if (member.parameters.isNotEmpty() || member.returnType != null) {
                val builder = StringBuilder(ind(level)).append("fun ").append(identifierText(member.name))
                builder.append('(').append(parameterList(member.parameters, level)).append(')')
                builder.append(": ").append(KotlinTypeMapper.map(member.returnType))
                return builder.toString()
            }
            val type = member.type
            if (type == null) {
                return ind(level) + "val " + identifierText(member.name) + ": " + KotlinTypeMapper.ANY_NULLABLE
            }
            val mapped = KotlinTypeMapper.map(type)
            return ind(level) + "val " + identifierText(member.name) + ": " +
                (if (member.optional) KotlinTypeMapper.nullable(mapped) else mapped)
        }

        private fun enumText(declaration: EnumDeclaration, level: Int): String {
            val withValues = declaration.members.any { it.initializer != null }
            val builder = StringBuilder(ind(level)).append("enum class ").append(identifierText(declaration.name))
            if (withValues) {
                builder.append("(val value: ").append(KotlinTypeMapper.ANY_NULLABLE).append(')')
            }
            if (declaration.members.isEmpty()) {
                builder.append(" { }")
                return builder.toString()
            }
            builder.append(" {").append(newline)
            for (member in declaration.members) {
                builder.append(ind(level + 1)).append(identifierText(member.name))
                if (withValues) {
                    val initializer = member.initializer
                    builder.append('(')
                    builder.append(if (initializer == null) "null" else expressionText(initializer, level + 1))
                    builder.append(')')
                }
                builder.append(',').append(newline)
            }
            builder.append(ind(level)).append('}')
            return builder.toString()
        }

        private fun namespaceText(declaration: NamespaceDeclaration, level: Int): String {
            val builder = StringBuilder(ind(level)).append("object ").append(identifierText(declaration.name))
                .append(" {")
            if (declaration.statements.isEmpty()) {
                builder.append(" }")
                return builder.toString()
            }
            builder.append(newline)
            for (statement in declaration.statements) {
                val text = statementText(statement, level + 1)
                if (text.isNotEmpty()) {
                    builder.append(text).append(newline)
                }
            }
            builder.append(ind(level)).append('}')
            return builder.toString()
        }

        private fun ambientText(declaration: AmbientDeclaration, level: Int): String {
            val inner = statementText(declaration.statement, level)
            return ind(level) + "// declare" + newline + inner
        }

        private fun ifText(statement: IfStatement, level: Int): String {
            val builder = StringBuilder(ind(level))
            builder.append("if (").append(expressionText(statement.condition, level)).append(") ")
            builder.append(statementAsBlock(statement.thenBranch, level))
            val elseBranch = statement.elseBranch
            if (elseBranch != null) {
                builder.append(" else ")
                if (elseBranch is IfStatement) {
                    builder.append(statementText(elseBranch, level).removePrefix(ind(level)))
                } else {
                    builder.append(statementAsBlock(elseBranch, level))
                }
            }
            return builder.toString()
        }

        private fun loopVariable(left: Statement?): String = when (left) {
            is VariableStatement -> left.declarations.firstOrNull()?.let { identifierText(it.name) } ?: "item"
            is ExpressionStatement -> expressionText(left.expression, 0)
            null -> "item"
            else -> "item"
        }

        private fun forEachText(
            level: Int,
            variable: String,
            iterable: Expression?,
            statement: Statement,
            body: BlockStatement,
        ): String {
            val target = if (iterable == null) {
                "emptyList<Any?>()"
            } else {
                expressionText(iterable, level)
            }
            val suffix = if (statement is ForOfStatement && statement.isAwait) "" else ""
            return ind(level) + "for (" + variable + " in " + target + ")" + suffix + " " +
                blockText(body.body, level)
        }

        private fun forText(statement: ForStatement, level: Int): String {
            val builder = StringBuilder()
            val init = statement.init
            if (init != null) {
                val text = statementText(init, level)
                if (text.isNotEmpty()) {
                    builder.append(text).append(newline)
                }
            }
            builder.append(ind(level)).append("while (")
            builder.append(statement.test?.let { expressionText(it, level) } ?: "true")
            builder.append(") {")

            val bodyStatements = statement.body.body.statements
            if (bodyStatements.isEmpty() && statement.update == null) {
                builder.append(" }")
                return builder.toString()
            }

            builder.append(newline)
            for (inner in bodyStatements) {
                val text = statementText(inner, level + 1)
                if (text.isNotEmpty()) {
                    builder.append(text).append(newline)
                }
            }
            val update = statement.update
            if (update != null) {
                builder.append(ind(level + 1)).append(expressionText(update, level)).append(options.terminator())
                builder.append(newline)
            }
            builder.append(ind(level)).append('}')
            return builder.toString()
        }

        private fun tryText(statement: TryStatement, level: Int): String {
            val builder = StringBuilder(ind(level))
            builder.append("try ").append(blockText(statement.block.body, level))
            val handler = statement.handler
            if (handler != null) {
                val name = handler.parameterName ?: "e"
                val type = handler.parameterType?.let { KotlinTypeMapper.map(it) } ?: "Throwable"
                builder.append(" catch (").append(name).append(": ").append(type).append(") ")
                builder.append(blockText(handler.body.body, level))
            }
            val finalizer = statement.finalizer
            if (finalizer != null) {
                builder.append(" finally ").append(blockText(finalizer.body, level))
            }
            return builder.toString()
        }

        private fun switchText(statement: SwitchStatement, level: Int): String {
            val builder = StringBuilder(ind(level))
            builder.append("when (").append(expressionText(statement.discriminant, level)).append(") {")
            if (statement.cases.isEmpty()) {
                builder.append(" }")
                return builder.toString()
            }
            for (case in statement.cases) {
                builder.append(newline).append(ind(level + 1))
                val test = case.test
                builder.append(if (test == null) "else" else expressionText(test, level))
                builder.append(" -> ").append(caseBody(case, level + 2))
            }
            builder.append(newline).append(ind(level)).append('}')
            return builder.toString()
        }

        /**
         * One branch of the `when` that replaced the switch. A case body that breaks out of the switch cannot keep
         * a bare `break`, because Kotlin only allows that inside a loop, so such a body becomes a labelled block
         * and every break of the case turns into a return from it.
         */
        private fun caseBody(case: SwitchCase, level: Int): String {
            val statements = flattenedCase(case.statements)
            if (!breaksOut(statements)) {
                return bodyText(statements, level)
            }
            val label = "case" + breakLabelCount++
            val text = withBreakTarget(label) { bodyText(statements, level) }
            return "run " + label + "@ " + text
        }

        /**
         * The statements of a case body. A case written as one brace block, which is how a switch in TypeScript is
         * usually formatted, is unwrapped so its branch does not gain a second, redundant pair of braces.
         */
        private fun flattenedCase(statements: List<Statement>): List<Statement> {
            val only = statements.singleOrNull()
            return if (only is BlockStatement) only.body.statements else statements
        }

        /** True when [statements] contain a break that leaves the enclosing switch, rather than an inner loop. */
        private fun breaksOut(statements: List<Statement>): Boolean = statements.any { breaksOut(it) }

        private fun breaksOut(statement: Statement): Boolean = when (statement) {
            is JumpStatement -> statement.keyword == "break" && statement.label == null
            is BlockStatement -> breaksOut(statement.body.statements)
            is IfStatement -> breaksOut(statement.thenBranch) ||
                (statement.elseBranch?.let { breaksOut(it) } ?: false)
            is LabeledStatement -> breaksOut(statement.statement)
            is TryStatement -> breaksOut(statement.block.body.statements) ||
                (statement.handler?.let { breaksOut(it.body.body.statements) } ?: false) ||
                (statement.finalizer?.let { breaksOut(it.body.statements) } ?: false)
            // A loop and a nested switch both capture their own breaks, so neither reaches the outer switch.
            else -> false
        }

        private fun importText(declaration: ImportDeclaration, level: Int): String {
            val builder = StringBuilder(ind(level)).append("// import ")
            if (declaration.typeOnly) {
                builder.append("type ")
            }
            val parts = ArrayList<String>()
            val defaultBinding = declaration.defaultBinding
            if (defaultBinding != null) {
                parts.add(defaultBinding)
            }
            val namespaceBinding = declaration.namespaceBinding
            if (namespaceBinding != null) {
                parts.add("* as " + namespaceBinding)
            }
            if (declaration.namedImports.isNotEmpty()) {
                parts.add(
                    declaration.namedImports.joinToString(", ", "{ ", " }") { specifier ->
                        if (specifier.local == specifier.imported) {
                            specifier.imported
                        } else {
                            specifier.imported + " as " + specifier.local
                        }
                    },
                )
            }
            val quoteSource = '"' + declaration.source + '"'
            if (parts.isEmpty()) {
                return builder.append(quoteSource).append(' ').append("// side effect only").toString()
            }
            return builder.append(parts.joinToString(", ")).append(" from ").append(quoteSource).toString()
        }

        private fun exportText(declaration: ExportDeclaration, level: Int): String {
            val inner = declaration.declaration
            if (inner != null) {
                val text = statementText(inner, level)
                if (!declaration.isDefault) {
                    return text
                }
                return ind(level) + "// export default" + newline + text
            }
            val builder = StringBuilder(ind(level)).append("// export ")
            if (declaration.isDefault) {
                builder.append("default ")
            }
            if (declaration.isStar) {
                builder.append('*')
                val namespaceExport = declaration.namespaceExport
                if (namespaceExport != null) {
                    builder.append(" as ").append(namespaceExport)
                }
            } else {
                builder.append(
                    declaration.specifiers.joinToString(", ", "{ ", " }") { specifier ->
                        if (specifier.local == specifier.exported) {
                            specifier.local
                        } else {
                            specifier.local + " as " + specifier.exported
                        }
                    },
                )
            }
            val source = declaration.source
            if (source != null) {
                builder.append(" from ").append('"').append(source).append('"')
            }
            return builder.toString()
        }

        // ---------------------------------------------------------------- declarations shared by both layers

        private fun typeParameters(parameters: List<String>): String =
            if (parameters.isEmpty()) "" else parameters.joinToString(", ", "<", ">")

        private fun parameterList(parameters: List<ParameterNode>, level: Int): String =
            parameters.joinToString(", ") { parameterText(it, level) }

        private fun parameterText(parameter: ParameterNode, level: Int): String {
            val builder = StringBuilder()
            if (parameter.rest) {
                builder.append("vararg ")
            }
            builder.append(identifierText(parameter.name)).append(": ")
            val type = parameter.type
            val mapped = if (type == null) KotlinTypeMapper.ANY_NULLABLE else mapType(type)
            recordType(parameter.name, mapped)
            builder.append(mapped)
            val defaultValue = parameter.defaultValue
            if (defaultValue != null) {
                builder.append(" = ").append(expressionText(defaultValue, level))
            }
            return builder.toString()
        }

        /**
         * The return type suffix for a function like node: the declared type when present, otherwise an inferred one
         * so that a Kotlin anonymous function keeps the value its JavaScript counterpart returns.
         */
        private fun returnSuffix(declared: TypeNode?, body: FunctionBody?): String {
            if (declared != null) {
                return ": " + mapType(declared)
            }
            val inferred = inferReturnType(body)
            return if (inferred == null) "" else ": $inferred"
        }

        private fun inferReturnType(body: FunctionBody?): String? {
            if (body == null) {
                return null
            }
            val returns = ArrayList<ReturnStatement>(4)
            collectReturns(body.statements, returns)
            if (returns.isEmpty()) {
                return null
            }
            return if (returns.any { it.argument != null }) "Any?" else "Unit"
        }

        private fun collectReturns(statements: List<Statement>, out: MutableList<ReturnStatement>) {
            for (statement in statements) {
                when (statement) {
                    is ReturnStatement -> out.add(statement)
                    is BlockStatement -> collectReturns(statement.body.statements, out)
                    is IfStatement -> {
                        collectReturns(listOf(statement.thenBranch), out)
                        statement.elseBranch?.let { collectReturns(listOf(it), out) }
                    }
                    is TryStatement -> {
                        collectReturns(statement.block.body.statements, out)
                        statement.handler?.let { collectReturns(it.body.body.statements, out) }
                        statement.finalizer?.let { collectReturns(it.body.statements, out) }
                    }
                    is SwitchStatement -> {
                        for (case in statement.cases) {
                            collectReturns(case.statements, out)
                        }
                    }
                    is WhileStatement -> collectReturns(statement.body.body.statements, out)
                    is DoWhileStatement -> collectReturns(statement.body.body.statements, out)
                    is ForStatement -> collectReturns(statement.body.body.statements, out)
                    is ForOfStatement -> collectReturns(statement.body.body.statements, out)
                    is ForInStatement -> collectReturns(statement.body.body.statements, out)
                    is LabeledStatement -> collectReturns(listOf(statement.statement), out)
                    else -> Unit
                }
            }
        }

        // ---------------------------------------------------------------- expressions

        private fun expressionText(expression: Expression, level: Int): String = when (expression) {
            is Identifier -> identifierText(expression.name)
            is SpecialExpression -> expression.kind.text
            is NumericLiteral -> numericText(expression)
            is StringLiteral -> quote(expression.value)
            is BooleanLiteral -> expression.value.toString()
            is NullLiteral -> "null"
            is UndefinedLiteral -> "null"
            is RegexLiteral -> regexText(expression)
            is TemplateLiteral -> templateText(expression, level)
            is ArrayLiteral -> arrayText(expression, level)
            is ObjectLiteral -> objectText(expression, level)
            is SpreadElement -> "*" + expressionText(expression.argument, level)
            is UnaryExpression -> unaryText(expression, level)
            is UpdateExpression -> updateText(expression, level)
            is BinaryExpression -> binaryText(expression.left, expression.operator, expression.right, level)
            is LogicalExpression -> logicalText(expression, level)
            is AssignmentExpression -> assignmentText(expression, level)
            is ConditionalExpression -> "if (" + expressionText(expression.test, level) + ") " +
                expressionText(expression.consequent, level) + " else " +
                expressionText(expression.alternate, level)
            is SequenceExpression -> "run { " + expression.expressions.joinToString("; ") {
                expressionText(it, level)
            } + " }"
            is CallExpression -> callText(expression, level)
            is NewExpression -> newText(expression, level)
            is MemberExpression -> memberText(expression, level)
            is ArrowFunction -> arrowText(expression, level)
            is FunctionExpression -> functionExpressionText(expression, level)
            is ClassExpression -> classExpressionText(expression, level)
            is InstantiationExpression ->
                expressionText(expression.expression, level) + typeArguments(expression.typeArguments)
            is AsExpression -> expressionText(expression.expression, level)
            is SatisfiesExpression -> expressionText(expression.expression, level)
            is TypeAssertionExpression -> expressionText(expression.expression, level)
            is NonNullExpression -> expressionText(expression.expression, level) + "!!"
            is ParenthesizedExpression -> "(" + expressionText(expression.expression, level) + ")"
            is TaggedTemplateExpression -> expressionText(expression.tag, level) + "(" +
                templateText(expression.template, level) + ")"
            is YieldExpression -> yieldText(expression, level)
        }

        /** A generator step: `yield x` becomes a `yield` call inside the surrounding `sequence` builder. */
        private fun yieldText(expression: YieldExpression, level: Int): String {
            val argument = expression.argument
            if (argument == null) {
                return "yield(Unit)"
            }
            val text = expressionText(argument, level)
            return if (expression.delegate) "yieldAll($text)" else "yield($text)"
        }

        private fun numericText(literal: NumericLiteral): String {
            var raw = literal.raw
            if (literal.isBigInt) {
                raw = raw.removeSuffix("n")
            }
            if (raw.startsWith("0o") || raw.startsWith("0O")) {
                return raw.substring(2).toLongOrNull(8)?.toString() ?: "0"
            }
            if (raw.startsWith('.')) {
                raw = "0$raw"
            }
            if (raw.endsWith('.')) {
                raw = raw + "0"
            }
            return raw
        }

        private fun quote(value: String): String = '"' + escape(value) + '"'

        /**
         * A Kotlin identifier for a JavaScript or TypeScript name. A private `#name` member loses its marker
         * because Kotlin class members are private already, and a name that collides with a Kotlin keyword or
         * contains a character a plain identifier cannot hold is wrapped in backticks so the script compiles.
         */
        private fun identifierText(name: String): String {
            val plain = if (name.startsWith("#")) name.substring(1) else name
            if (plain.isEmpty()) {
                return "`_`"
            }
            if (plain in KOTLIN_KEYWORDS || !isPlainIdentifier(plain)) {
                return "`" + plain + "`"
            }
            return plain
        }

        private fun isPlainIdentifier(name: String): Boolean {
            val first = name.first()
            if (!first.isLetter() && first != '_') {
                return false
            }
            return name.all { it.isLetterOrDigit() || it == '_' }
        }

        private fun propertyName(name: String): String = identifierText(name)

        private fun escape(value: String): String {
            val builder = StringBuilder(value.length + 8)
            for (character in value) {
                when (character) {
                    '\\' -> builder.append('\\').append('\\')
                    '"' -> builder.append('\\').append('"')
                    '$' -> builder.append('\\').append('$')
                    '\n' -> builder.append('\\').append('n')
                    '\r' -> builder.append('\\').append('r')
                    '\t' -> builder.append('\\').append('t')
                    '\b' -> builder.append('\\').append('b')
                    else -> if (character < ' ') {
                        builder.append("\\u").append(character.code.toString(16).padStart(4, '0'))
                    } else {
                        builder.append(character)
                    }
                }
            }
            return builder.toString()
        }

        private fun regexText(literal: RegexLiteral): String {
            var flags = literal.flags
            val options = ArrayList<String>(3)
            if (flags.contains('i')) {
                options.add("RegexOption.IGNORE_CASE")
                flags = flags.replace("i", "")
            }
            if (flags.contains('m')) {
                options.add("RegexOption.MULTILINE")
                flags = flags.replace("m", "")
            }
            if (flags.contains('s')) {
                options.add("RegexOption.DOT_MATCHES_ALL")
                flags = flags.replace("s", "")
            }
            val pattern = quote(literal.pattern)
            if (options.isEmpty()) {
                return "Regex($pattern)"
            }
            return "Regex($pattern, setOf(" + options.joinToString(", ") + "))"
        }

        private fun templateText(literal: TemplateLiteral, level: Int): String {
            val builder = StringBuilder("\"")
            for (index in literal.quasis.indices) {
                builder.append(escape(literal.quasis[index].cooked))
                if (index < literal.expressions.size) {
                    builder.append("\${").append(expressionText(literal.expressions[index], level)).append('}')
                }
            }
            builder.append('"')
            return builder.toString()
        }

        private fun arrayText(literal: ArrayLiteral, level: Int): String {
            val elements = literal.elements.joinToString(", ") {
                if (it == null) "null" else expressionText(it, level)
            }
            return "mutableListOf($elements)"
        }

        private fun objectText(literal: ObjectLiteral, level: Int): String {
            val hasMethods = literal.properties.any { it is MethodMember }
            if (hasMethods) {
                return anonymousObjectText(literal, level)
            }

            val spreads = literal.properties.filterIsInstance<SpreadPropertyMember>()
            val entries = literal.properties.filterNot { it is SpreadPropertyMember }.map { entryText(it, level) }
            val mapText = when {
                entries.isEmpty() && spreads.isEmpty() -> "mutableMapOf<String, Any?>()"
                entries.isEmpty() -> "mutableMapOf<String, Any?>()"
                else -> "mutableMapOf(" + entries.joinToString(", ") + ")"
            }
            if (spreads.isEmpty()) {
                return mapText
            }
            val builder = StringBuilder("(").append(mapText)
            for (spread in spreads) {
                builder.append(" + ").append(expressionText(spread.argument, level))
            }
            builder.append(')')
            return builder.toString()
        }

        /**
         * The key side of a map entry. A computed JavaScript key such as `["k" + 1]` is an ordinary expression in
         * Kotlin because a map lookup has no restriction on how the key was formed, so it is emitted unquoted.
         */
        private fun entryKeyText(member: ObjectMember, level: Int): String = when (member) {
            is PropertyMember -> if (member.computed) {
                member.keyExpression?.let { expressionText(it, level) } ?: quote(member.key)
            } else {
                quote(member.key)
            }
            is MethodMember -> if (member.computed) {
                member.keyExpression?.let { expressionText(it, level) } ?: quote(member.name)
            } else {
                quote(member.name)
            }
            is ShorthandPropertyMember -> quote(member.name)
            is SpreadPropertyMember -> quote("...")
        }

        private fun entryText(member: ObjectMember, level: Int): String =
            when (member) {
                is PropertyMember -> entryKeyText(member, level) + " to " + expressionText(member.value, level)
                is ShorthandPropertyMember -> {
                    val outer = quote(member.name) + " to " + identifierText(member.name)
                    val defaultValue = member.defaultValue
                    if (defaultValue == null) outer else "($outer ?: " + expressionText(defaultValue, level) + ")"
                }
                is SpreadPropertyMember -> quote("...") + " to " + expressionText(member.argument, level)
                is MethodMember -> entryKeyText(member, level) + " to " + objectMethodText(member, level)
            }

        private fun anonymousObjectText(literal: ObjectLiteral, level: Int): String {
            val members = literal.properties
            val builder = StringBuilder("object {")
            val folded = HashSet<String>(4)
            for (member in members) {
                if (member is MethodMember && (member.kind == MethodKind.GET || member.kind == MethodKind.SET)) {
                    if (member.name in folded) {
                        continue
                    }
                    folded.add(member.name)
                    val getter = members.firstOrNull {
                        it is MethodMember && it.kind == MethodKind.GET && it.name == member.name
                    } as MethodMember?
                    val setter = members.firstOrNull {
                        it is MethodMember && it.kind == MethodKind.SET && it.name == member.name
                    } as MethodMember?
                    builder.append(newline).append(objectAccessorText(getter, setter, level + 1))
                    continue
                }
                builder.append(newline)
                when (member) {
                    is MethodMember -> builder.append(objectMethodText(member, level + 1))
                    is PropertyMember -> builder.append(ind(level + 1)).append("var ")
                        .append(propertyName(member.key)).append(" = ")
                        .append(expressionText(member.value, level + 1))
                    is ShorthandPropertyMember -> builder.append(ind(level + 1)).append("var ")
                        .append(propertyName(member.name)).append(" = ").append(identifierText(member.name))
                    is SpreadPropertyMember -> builder.append(ind(level + 1)).append("// spread ")
                        .append(expressionText(member.argument, level + 1))
                }
            }
            builder.append(newline).append(ind(level)).append('}')
            return builder.toString()
        }

        /**
         * A get and set pair inside an object literal becomes one Kotlin property with custom accessors, mirroring
         * what a class body does: two members of the same name cannot both be properties of the same object.
         */
        private fun objectAccessorText(getter: MethodMember?, setter: MethodMember?, level: Int): String {
            val source = getter ?: setter ?: return ""
            val builder = StringBuilder(ind(level))
            builder.append(if (setter == null) "val " else "var ")
            builder.append(identifierText(source.name))
            builder.append(": ").append(KotlinTypeMapper.ANY_NULLABLE)
            val getterBody = getter?.body
            builder.append(newline).append(ind(level + 1)).append("get() ")
            builder.append(if (getterBody == null) "{ }" else blockText(getterBody, level + 1))
            if (setter != null) {
                val parameter = setter.parameters.firstOrNull()
                val parameterName = if (parameter == null) "value" else identifierText(parameter.name)
                builder.append(newline).append(ind(level + 1)).append("set(").append(parameterName).append(") ")
                builder.append(blockText(setter.body, level + 1))
            }
            return builder.toString()
        }

        private fun objectMethodText(method: MethodMember, level: Int): String {
            val builder = StringBuilder(ind(level)).append("fun ").append(identifierText(method.name))
            builder.append('(').append(parameterList(method.parameters, level)).append(')')
            builder.append(returnSuffix(null, method.body))
            builder.append(' ').append(blockText(method.body, level))
            return builder.toString()
        }

        private fun unaryText(expression: UnaryExpression, level: Int): String {
            val operand = expressionText(expression.operand, level)
            return when (expression.operator) {
                "~" -> "$operand.inv()"
                "typeof" -> "($operand)::class.simpleName"
                "void" -> "Unit"
                "delete" -> "Unit"
                // There is no `await` keyword outside a coroutine, so an awaited value is read through the
                // coroutine `await` extension instead. `await Promise.all(...)` is already awaited by the
                // `awaitAll` call the argument became, so the outer await is dropped.
                "await" -> if (isPromiseAll(expression.operand)) operand else "$operand.await()"
                else -> expression.operator + operand
            }
        }

        /** True when [expression] is a call of the static `Promise.all` helper. */
        private fun isPromiseAll(expression: Expression): Boolean {
            var callee = expression
            while (callee is ParenthesizedExpression) {
                callee = callee.expression
            }
            if (callee !is CallExpression) {
                return false
            }
            val member = callee.callee
            if (member !is MemberExpression) {
                return false
            }
            val receiver = member.obj
            return receiver is Identifier && receiver.name == "Promise" && memberName(member) == "all"
        }

        private fun updateText(expression: UpdateExpression, level: Int): String {
            val operand = expressionText(expression.operand, level)
            return if (expression.prefix) {
                expression.operator + operand
            } else {
                operand + expression.operator
            }
        }

        private fun binaryText(left: Expression, operator: String, right: Expression, level: Int): String {
            val leftText = expressionText(left, level)
            val rightText = expressionText(right, level)
            return when (operator) {
                "===" , "==" -> "$leftText == $rightText"
                "!==" , "!=" -> "$leftText != $rightText"
                "**" -> "Math.pow($leftText, $rightText)"
                ">>>" -> "$leftText ushr $rightText"
                ">>" -> "$leftText shr $rightText"
                "<<" -> "$leftText shl $rightText"
                "&" -> "$leftText and $rightText"
                "|" -> "$leftText or $rightText"
                "^" -> "$leftText xor $rightText"
                "instanceof" -> "$leftText is $rightText"
                else -> "$leftText $operator $rightText"
            }
        }

        private fun logicalText(expression: LogicalExpression, level: Int): String {
            val operator = if (expression.operator == "??") "?:" else expression.operator
            return binaryText(expression.left, operator, expression.right, level)
        }

        private fun assignmentText(expression: AssignmentExpression, level: Int): String {
            val left = expressionText(expression.left, level)
            val right = expressionText(expression.right, level)
            return when (expression.operator) {
                "=" -> "$left = $right"
                "+=", "-=", "*=", "/=", "%=" -> "$left ${expression.operator} $right"
                "**=" -> "$left = Math.pow($left, $right)"
                ">>>=" -> "$left = $left ushr $right"
                ">>=" -> "$left = $left shr $right"
                "<<=" -> "$left = $left shl $right"
                "&=" -> "$left = $left and $right"
                "|=" -> "$left = $left or $right"
                "^=" -> "$left = $left xor $right"
                "&&=" -> "$left = $left && $right"
                "||=" -> "$left = $left || $right"
                "??=" -> "$left = $left ?: $right"
                else -> "$left ${expression.operator} $right"
            }
        }

        private fun memberName(expression: MemberExpression): String? {
            if (expression.computed) {
                return null
            }
            val property = expression.property
            return if (property is Identifier) property.name else null
        }

        private fun callText(expression: CallExpression, level: Int): String {
            val arguments = expression.arguments.joinToString(", ") { expressionText(it, level) }
            val callee = expression.callee
            if (callee is MemberExpression) {
                val receiver = callee.obj
                val member = memberName(callee)
                if (receiver is Identifier && receiver.name == "console" && member != null) {
                    when (member) {
                        "log", "info", "debug", "warn" -> return "println(" + consoleArguments(expression, level) + ")"
                        "error" -> return "System.err.println(" + consoleArguments(expression, level) + ")"
                        else -> Unit
                    }
                }
                // Kotlin spells a map write as an indexed assignment, so a two argument `set` call becomes one.
                if (member == "set" && expression.arguments.size == 2 && isMapLike(typeOf(receiver))) {
                    val key = expressionText(expression.arguments[0], level)
                    val value = expressionText(expression.arguments[1], level)
                    return expressionText(receiver, level) + "[" + key + "] = " + value
                }
                // `Promise.all` waits for every promise of a collection, which is what the coroutine `awaitAll`
                // extension does, so the call becomes a call on the awaited collection itself.
                if (receiver is Identifier && receiver.name == "Promise" && member == "all" &&
                    expression.arguments.size == 1
                ) {
                    return expressionText(expression.arguments[0], level) + ".awaitAll()"
                }
            }
            val calleeText = expressionText(callee, level)
            val typeArguments = typeArguments(expression.typeArguments)
            val text = if (expression.optional) {
                "$calleeText$typeArguments?.invoke($arguments)"
            } else {
                "$calleeText$typeArguments($arguments)"
            }
            // A host API has no Kotlin counterpart at all, so the call is marked rather than silently emitted as
            // if it were translatable.
            if (callee is Identifier && callee.name in HOST_ONLY_APIS) {
                return markedUnsupported("call to '${callee.name}'", text)
            }
            return text
        }

        /**
         * Marks a node that cannot be expressed in Kotlin, either with a leading comment (so the surrounding code
         * still reads as Kotlin) or, when [TranslationOptions.failOnUnsupportedNode] is set, as a hard failure.
         */
        private fun markedUnsupported(node: String, text: String): String {
            if (options.failOnUnsupportedNode) {
                throw UnsupportedNodeException(
                    targetType,
                    node,
                    "Kotlin has no runtime equivalent, so the call has to be replaced by hand",
                )
            }
            return "/* not translatable: $node */ " + text
        }

        /**
         * The arguments of a console call. A Kotlin print takes one value, so several arguments are joined with a
         * space the way the JavaScript console prints them.
         */
        private fun consoleArguments(expression: CallExpression, level: Int): String {
            if (expression.arguments.size <= 1) {
                return expression.arguments.joinToString(", ") { expressionText(it, level) }
            }
            val parts = expression.arguments.joinToString(", ") { expressionText(it, level) }
            return "listOf($parts).joinToString(\" \")"
        }

        private fun typeArguments(types: List<TypeNode>): String =
            if (types.isEmpty()) "" else types.joinToString(", ", "<", ">") { KotlinTypeMapper.map(it) }

        private fun newText(expression: NewExpression, level: Int): String {
            val arguments = expression.arguments.joinToString(", ") { expressionText(it, level) }
            // `new (class extends Base { ... })(...)` builds an anonymous subclass, which Kotlin spells by naming
            // the superclass constructor call in the object header.
            val inline = unwrapParentheses(expression.callee)
            if (inline is ClassExpression) {
                return classExpressionText(inline, level, "($arguments)")
            }
            val calleeText = expressionText(expression.callee, level)
            val typeArguments = typeArguments(expression.typeArguments)
            // A JavaScript error type has no Kotlin counterpart, so the nearest exception type is used instead and
            // the argument is kept as the message.
            val exception = JS_ERROR_CLASSES[calleeText]
            if (exception != null) {
                return exception + "($arguments)"
            }
            val factory = COLLECTION_CONSTRUCTORS[calleeText]
            if (factory != null) {
                return factory + typeArguments + "($arguments)"
            }
            return "$calleeText$typeArguments($arguments)"
        }

        private fun unwrapParentheses(expression: Expression): Expression {
            var current = expression
            while (current is ParenthesizedExpression) {
                current = current.expression
            }
            return current
        }

        private fun memberText(expression: MemberExpression, level: Int): String {
            val receiver = expressionText(expression.obj, level)
            if (expression.computed) {
                val index = expressionText(expression.property, level)
                return if (expression.optional) "$receiver?.get($index)" else "$receiver[$index]"
            }
            val property = expressionText(expression.property, level)
            val name = renamedMember(expression, property)
            val accessor = if (expression.optional) "?." else "."
            return "$receiver$accessor$name"
        }

        /**
         * The Kotlin name of a member. JavaScript spells a length the same way on a list and on a string, while
         * Kotlin calls a list length `size`, so the recorded receiver type decides between the two.
         */
        private fun renamedMember(expression: MemberExpression, property: String): String {
            if (property == "length") {
                val receiverType = typeOf(expression.obj)
                if (isListLike(receiverType)) {
                    return "size"
                }
            }
            return LIST_METHOD_RENAMES[property] ?: property
        }

        private fun arrowText(expression: ArrowFunction, level: Int): String {
            val parameters = parameterList(expression.parameters, level)
            return when (val body = expression.body) {
                is ExpressionBody -> {
                    val text = expressionText(body.expression, level)
                    // The arrow is dropped when there is nothing to bind; a leading space would then be stray.
                    if (parameters.isEmpty()) "{ $text }" else "{ $parameters -> $text }"
                }
                is BlockBody -> anonymousFunctionText(parameters, expression.returnType, body.block, level)
            }
        }

        private fun functionExpressionText(expression: FunctionExpression, level: Int): String {
            val parameters = parameterList(expression.parameters, level)
            return anonymousFunctionText(parameters, expression.returnType, expression.body, level)
        }

        /**
         * Anonymous functions instead of lambdas for block bodies: a JavaScript return statement keeps its meaning
         * because Kotlin only allows a bare return inside a named or anonymous function.
         */
        private fun anonymousFunctionText(
            parameters: String,
            returnType: TypeNode?,
            body: FunctionBody,
            level: Int,
        ): String {
            val builder = StringBuilder("fun(").append(parameters).append(')')
            builder.append(returnSuffix(returnType, body))
            builder.append(' ').append(blockText(body, level))
            return builder.toString()
        }

        private fun classExpressionText(expression: ClassExpression, level: Int, superCall: String = "()"): String {
            val builder = StringBuilder("object")
            val supertypes = ArrayList<String>(2)
            val superClass = expression.superClass
            if (superClass != null) {
                supertypes.add(expressionText(superClass, level) + superCall)
            }
            for (implemented in expression.implementsTypes) {
                supertypes.add(KotlinTypeMapper.map(implemented))
            }
            if (supertypes.isNotEmpty()) {
                builder.append(" : ").append(supertypes.joinToString(", "))
            }
            if (expression.members.isEmpty()) {
                builder.append(" { }")
                return builder.toString()
            }
            builder.append(" {").append(newline)
            for (text in classMemberTexts(expression.members, level + 1)) {
                builder.append(text).append(newline)
            }
            builder.append(ind(level)).append('}')
            return builder.toString()
        }

        private companion object {
            /** Reserved words of Kotlin, which have to be escaped to stand for a JavaScript name. */
            private val KOTLIN_KEYWORDS = setOf(
                "as", "break", "class", "continue", "do", "else", "false", "for", "fun", "if", "in",
                "interface", "is", "null", "object", "package", "return", "super", "this", "throw",
                "true", "try", "typealias", "typeof", "val", "var", "when", "while",
            )

            /** Constructor calls whose Kotlin counterpart is a factory function rather than a class name. */
            private val COLLECTION_CONSTRUCTORS = mapOf(
                "Array" to "mutableListOf",
                "Map" to "mutableMapOf",
                "Set" to "mutableSetOf",
                "WeakMap" to "mutableMapOf",
                "WeakSet" to "mutableSetOf",
            )

            /** JavaScript error constructors, each of which maps onto a Kotlin exception type. */
            private val JS_ERROR_CLASSES = mapOf(
                "Error" to "RuntimeException",
                "EvalError" to "RuntimeException",
                "RangeError" to "IndexOutOfBoundsException",
                "ReferenceError" to "NoSuchElementException",
                "SyntaxError" to "IllegalStateException",
                "TypeError" to "ClassCastException",
                "URIError" to "IllegalArgumentException",
                "AggregateError" to "RuntimeException",
            )

            /** Collection members whose JavaScript name differs from the Kotlin one. */
            private val LIST_METHOD_RENAMES = mapOf(
                "push" to "add",
                "unshift" to "add",
                "pop" to "removeLast",
                "shift" to "removeFirst",
                "splice" to "removeAt",
                "includes" to "contains",
                "indexOf" to "indexOf",
            )

            /**
             * Host APIs of a browser or of Node, which have no Kotlin runtime counterpart. A call to one of these
             * is kept but marked, because guessing a replacement would change what the program does.
             */
            private val HOST_ONLY_APIS = setOf(
                "fetch",
                "require",
                "setTimeout",
                "setInterval",
                "clearTimeout",
                "clearInterval",
                "addEventListener",
                "removeEventListener",
                "alert",
                "prompt",
                "confirm",
                "localStorage",
                "sessionStorage",
                "process",
                "Buffer",
            )
        }
    }
}
