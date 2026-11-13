package com.github.kusa233.translator.structuring.parser

import com.github.kusa233.translator.structuring.api.LanguageType
import com.github.kusa233.translator.structuring.api.SyntaxException
import com.github.kusa233.translator.structuring.typescript.ast.ArrowFunction
import com.github.kusa233.translator.structuring.typescript.ast.BinaryExpression
import com.github.kusa233.translator.structuring.typescript.ast.BlockBody
import com.github.kusa233.translator.structuring.typescript.ast.BlockStatement
import com.github.kusa233.translator.structuring.typescript.ast.ClassDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.CommentStatement
import com.github.kusa233.translator.structuring.typescript.ast.EnumDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.ExpressionBody
import com.github.kusa233.translator.structuring.typescript.ast.ExpressionStatement
import com.github.kusa233.translator.structuring.typescript.ast.FieldMemberNode
import com.github.kusa233.translator.structuring.typescript.ast.ForOfStatement
import com.github.kusa233.translator.structuring.typescript.ast.FunctionDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.Identifier
import com.github.kusa233.translator.structuring.typescript.ast.IfStatement
import com.github.kusa233.translator.structuring.typescript.ast.InterfaceDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.KeywordTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.MemberExpression
import com.github.kusa233.translator.structuring.typescript.ast.MethodKind
import com.github.kusa233.translator.structuring.typescript.ast.MethodMemberNode
import com.github.kusa233.translator.structuring.typescript.ast.NumericLiteral
import com.github.kusa233.translator.structuring.typescript.ast.ObjectLiteral
import com.github.kusa233.translator.structuring.typescript.ast.SourceFile
import com.github.kusa233.translator.structuring.typescript.ast.SwitchStatement
import com.github.kusa233.translator.structuring.typescript.ast.TypeAliasDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.TypeReferenceNode
import com.github.kusa233.translator.structuring.typescript.ast.VariableKind
import com.github.kusa233.translator.structuring.typescript.ast.VariableStatement
import com.github.kusa233.translator.structuring.typescript.ast.YieldExpression
import com.github.kusa233.translator.structuring.typescript.parser.TypeScriptParser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.collections.get

/**
 * Parser behaviour: the shape of the produced tree, automatic semicolon insertion and the error report.
 */
class TypeScriptParserTest {
    private fun parse(source: String): SourceFile =
        TypeScriptParser().parse(source, "test.ts") as SourceFile

    @Test
    fun `the unit remembers its language and name`() {
        val file = parse("let a = 1;")
        assertEquals("test.ts", file.fileName)
        assertSame(LanguageType.TYPESCRIPT, file.sourceType)
        assertEquals(1, file.statements.size)
    }

    @Test
    fun `a declaration keeps its kind and initializer`() {
        val statement = parse("const a = 1;").statements.single() as VariableStatement
        assertSame(VariableKind.CONST, statement.kind)
        val declarator = statement.declarations.single()
        assertEquals("a", declarator.name)
        assertNull(declarator.type)
        assertEquals(1.0, (declarator.initializer as NumericLiteral).value)
    }

    @Test
    fun `a missing semicolon is inserted at a line break`() {
        val file = parse("let a = 1\nlet b = 2")
        assertEquals(2, file.statements.size)
        assertTrue(file.statements.all { it is VariableStatement })
    }

    @Test
    fun `a function keeps its parameters, type and body`() {
        val statement = parse("function add(a: number, b: number): number { return a + b; }")
            .statements.single() as FunctionDeclaration
        assertEquals("add", statement.name)
        assertEquals(2, statement.parameters.size)
        assertEquals("a", statement.parameters[0].name)
        assertEquals("number", (statement.parameters[0].type as KeywordTypeNode).name)
        assertEquals("number", (statement.returnType as KeywordTypeNode).name)
        assertEquals(1, statement.body!!.statements.size)
    }

    @Test
    fun `a class type reference keeps its type arguments`() {
        val statement = parse("let a: Box<number> = b;").statements.single() as VariableStatement
        val type = statement.declarations.single().type as TypeReferenceNode
        assertEquals("Box", type.name)
        assertEquals(1, type.typeArguments.size)
    }

    @Test
    fun `a generic function keeps its type parameters`() {
        val statement = parse("function id<T>(value: T): T { return value; }")
            .statements.single() as FunctionDeclaration
        assertEquals(listOf("T"), statement.typeParameters)
    }

    @Test
    fun `a class keeps its heritage, members and modifiers`() {
        val statement = parse(
            """
            abstract class Base<T> implements Shape<T> {
                static count: number = 0;
                readonly name: string;
                abstract area(): number;
                constructor(x: number) { }
            }
            """.trimIndent(),
        ).statements.single() as ClassDeclaration
        assertEquals("Base", statement.name)
        assertTrue(statement.isAbstract)
        assertEquals(listOf("T"), statement.typeParameters)
        assertEquals(1, statement.implementsTypes.size)
        assertEquals(4, statement.members.size)
        assertTrue((statement.members[0] as FieldMemberNode).isStatic)
        assertTrue((statement.members[1] as FieldMemberNode).readonly)
        assertTrue((statement.members[2] as MethodMemberNode).isAbstract)
        assertSame(MethodKind.CONSTRUCTOR, (statement.members[3] as MethodMemberNode).kind)
    }

    @Test
    fun `an interface and a type alias are parsed`() {
        val statements = parse("interface A { x: number } type B = A;").statements
        assertEquals(1, (statements[0] as InterfaceDeclaration).members.size)
        assertEquals("B", (statements[1] as TypeAliasDeclaration).name)
    }

    @Test
    fun `an enum keeps its members and initializers`() {
        val statement = parse("enum Color { Red, Green = 2 }").statements.single() as EnumDeclaration
        assertEquals("Color", statement.name)
        assertEquals(2, statement.members.size)
        assertNull(statement.members[0].initializer)
        assertEquals(2.0, (statement.members[1].initializer as NumericLiteral).value)
    }

    @Test
    fun `a switch keeps its cases`() {
        val statement = parse("switch (a) { case 1: break; default: a = 2; }")
            .statements.single() as SwitchStatement
        assertEquals(2, statement.cases.size)
        assertNotNull(statement.cases[0].test)
        assertNull(statement.cases[1].test)
    }

    @Test
    fun `a for of loop keeps its declaration`() {
        val statement = parse("for (const item of items) { use(item); }")
            .statements.single() as ForOfStatement
        assertTrue(statement.declares)
        assertSame(VariableKind.CONST, statement.declarationKind)
    }

    @Test
    fun `an object literal keeps methods and shorthand properties`() {
        val initializer = (parse("const o = { a, b: 1, run() { } };").statements.single() as VariableStatement)
            .declarations.single().initializer as ObjectLiteral
        assertEquals(3, initializer.properties.size)
    }

    @Test
    fun `an arrow function keeps its body kind`() {
        val expression = (parse("const f = (x) => x + 1;").statements.single() as VariableStatement)
            .declarations.single().initializer as ArrowFunction
        assertEquals(1, expression.parameters.size)
        assertTrue(expression.body is ExpressionBody)

        val block = (parse("const g = (x) => { return x; };").statements.single() as VariableStatement)
            .declarations.single().initializer as ArrowFunction
        assertTrue(block.body is BlockBody)
    }

    @Test
    fun `a generator keeps its yield expression`() {
        val statement = parse("function* gen() { yield 1; }").statements.single() as FunctionDeclaration
        assertTrue(statement.isGenerator)
        val body = statement.body!!.statements.single() as ExpressionStatement
        assertTrue(body.expression is YieldExpression)
    }

    @Test
    fun `a comment inside a body is kept as a statement`() {
        val file = parse("// leading\nlet a = 1;")
        val first = file.statements.first()
        assertTrue(first is CommentStatement)
    }

    @Test
    fun `an if else chain keeps both branches`() {
        val statement = parse("if (a) { b(); } else if (c) { d(); } else { e(); }")
            .statements.single() as IfStatement
        assertNotNull(statement.elseBranch)
        assertTrue(statement.elseBranch is IfStatement)
    }

    @Test
    fun `a precedence rule binds a product tighter than a sum`() {
        val expression = (parse("const a = 1 + 2 * 3;").statements.single() as VariableStatement)
            .declarations.single().initializer as BinaryExpression
        assertEquals("+", expression.operator)
        assertEquals("*", (expression.right as BinaryExpression).operator)
    }

    @Test
    fun `a member chain and a call are nested`() {
        val expression = (parse("a.b(1).c;").statements.single() as ExpressionStatement).expression
        assertTrue(expression is MemberExpression)
    }

    @Test
    fun `a block keeps its statements`() {
        val block = parse("{ let a = 1; }").statements.single() as BlockStatement
        assertEquals(1, block.body.statements.size)
    }

    @Test
    fun `an unexpected token is reported with its position`() {
        val failure = assertThrows<SyntaxException> { parse("let a = ;") }
        assertEquals("parser", failure.stage)
        assertTrue(failure.message!!.contains("expected an expression"))
        assertEquals(1, failure.span.start.line)
    }

    @Test
    fun `an unclosed block is reported`() {
        val failure = assertThrows<SyntaxException> { parse("function f() {") }
        assertNotNull(failure.span)
    }

    @Test
    fun `a name is parsed as an identifier expression`() {
        val expression = (parse("value;").statements.single() as ExpressionStatement).expression
        assertEquals("value", (expression as Identifier).name)
    }
}
