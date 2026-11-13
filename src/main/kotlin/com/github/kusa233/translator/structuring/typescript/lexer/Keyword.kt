package com.github.kusa233.translator.structuring.typescript.lexer

/**
 * Reserved words and contextual keywords.
 */
enum class Keyword(val text: String) {
    BREAK("break"),
    CASE("case"),
    CATCH("catch"),
    CLASS("class"),
    CONST("const"),
    CONTINUE("continue"),
    DEBUGGER("debugger"),
    DEFAULT("default"),
    DELETE("delete"),
    DO("do"),
    ELSE("else"),
    ENUM("enum"),
    EXPORT("export"),
    EXTENDS("extends"),
    FALSE("false"),
    FINALLY("finally"),
    FOR("for"),
    FUNCTION("function"),
    IF("if"),
    IMPORT("import"),
    IN("in"),
    INSTANCEOF("instanceof"),
    LET("let"),
    NEW("new"),
    NULL("null"),
    RETURN("return"),
    SUPER("super"),
    SWITCH("switch"),
    THIS("this"),
    THROW("throw"),
    TRUE("true"),
    TRY("try"),
    TYPEOF("typeof"),
    VAR("var"),
    VOID("void"),
    WHILE("while"),
    WITH("with"),
    YIELD("yield"),

    // TypeScript
    ABSTRACT("abstract"),
    ANY("any"),
    AS("as"),
    ASSERTS("asserts"),
    ASYNC("async"),
    AWAIT("await"),
    BIGINT("bigint"),
    BOOLEAN("boolean"),
    DECLARE("declare"),
    INFER("infer"),
    INTERFACE("interface"),
    IS("is"),
    KEYOF("keyof"),
    MODULE("module"),
    NAMESPACE("namespace"),
    NEVER("never"),
    NUMBER("number"),
    OBJECT("object"),
    OVERRIDE("override"),
    PRIVATE("private"),
    PROTECTED("protected"),
    PUBLIC("public"),
    READONLY("readonly"),
    REQUIRED("required"),
    SATISFIES("satisfies"),
    STATIC("static"),
    STRING("string"),
    SYMBOL("symbol"),
    TYPE("type"),
    UNDEFINED("undefined"),
    UNIQUE("unique"),
    UNKNOWN("unknown"),
    ;

    companion object {
        private val byText: Map<String, Keyword> = entries.associateBy { it.text }

        fun of(text: String): Keyword? = byText[text]

        /** Words that can never be used as an identifier. */
        fun isReserved(text: String): Boolean = byText[text]?.isReservedWord == true
    }

    /** True for keywords that can never be an identifier in ECMAScript. */
    val isReservedWord: Boolean
        get() = when (this) {
            BREAK, CASE, CATCH, CLASS, CONST, CONTINUE, DEBUGGER, DEFAULT, DELETE, DO, ELSE, ENUM,
            EXPORT, EXTENDS, FALSE, FINALLY, FOR, FUNCTION, IF, IMPORT, IN, INSTANCEOF, NEW, NULL,
            RETURN, SUPER, SWITCH, THIS, THROW, TRUE, TRY, TYPEOF, VAR, VOID, WHILE, WITH,
            -> true

            else -> false
        }

    /** True for keywords that denote a primitive type. */
    val isPrimitiveType: Boolean
        get() = when (this) {
            ANY, BIGINT, BOOLEAN, NEVER, NUMBER, OBJECT, STRING, SYMBOL, UNKNOWN, UNDEFINED, VOID, NULL -> true
            else -> false
        }
}
