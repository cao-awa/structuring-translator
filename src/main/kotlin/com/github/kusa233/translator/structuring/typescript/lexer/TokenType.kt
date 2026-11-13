package com.github.kusa233.translator.structuring.typescript.lexer

/**
 * Every token kind the TypeScript lexer can produce.
 */
enum class TokenType {
    // Literals and names
    IDENTIFIER,
    KEYWORD,
    NUMERIC_LITERAL,
    STRING_LITERAL,
    REGEX_LITERAL,
    TEMPLATE_HEAD,      // `text${
    TEMPLATE_MIDDLE,    // }text${
    TEMPLATE_TAIL,      // }text`
    TEMPLATE_NO_SUBST,  // `text`

    // Punctuation
    OPEN_BRACE,         // {
    CLOSE_BRACE,        // }
    OPEN_PAREN,         // (
    CLOSE_PAREN,        // )
    OPEN_BRACKET,       // [
    CLOSE_BRACKET,      // ]
    SEMICOLON,          // ;
    COMMA,              // ,
    DOT,                // .
    DOT_DOT_DOT,        // ...
    QUESTION_DOT,       // ?.
    COLON,              // :
    QUESTION,           // ?
    ARROW,              // =>
    AT,                 // @
    BACKTICK,           // ` (only produced on unterminated templates)
    HASH,               // #

    // Operators
    PLUS,               // +
    MINUS,              // -
    STAR,               // *
    SLASH,              // /
    PERCENT,            // %
    STAR_STAR,          // **
    PLUS_PLUS,          // ++
    MINUS_MINUS,        // --
    AMPERSAND,          // &
    PIPE,               // |
    CARET,              // ^
    TILDE,              // ~
    BANG,               // !
    AMPERSAND_AMPERSAND,            // &&
    PIPE_PIPE,                      // ||
    QUESTION_QUESTION,              // ??
    LESS,                           // <
    GREATER,                        // >
    LESS_EQUALS,                    // <=
    GREATER_EQUALS,                 // >=
    EQUALS_EQUALS,                  // ==
    EXCLAMATION_EQUALS,             // !=
    EQUALS_EQUALS_EQUALS,           // ===
    EXCLAMATION_EQUALS_EQUALS,      // !==
    EQUALS,                         // =
    PLUS_EQUALS,                    // +=
    MINUS_EQUALS,                   // -=
    STAR_EQUALS,                    // *=
    SLASH_EQUALS,                   // /=
    PERCENT_EQUALS,                 // %=
    STAR_STAR_EQUALS,               // **=
    AMPERSAND_EQUALS,               // &=
    PIPE_EQUALS,                    // |=
    CARET_EQUALS,                   // ^=
    LESS_LESS,                      // <<
    GREATER_GREATER,                // >>
    GREATER_GREATER_GREATER,        // >>>
    LESS_LESS_EQUALS,               // <<=
    GREATER_GREATER_EQUALS,         // >>=
    GREATER_GREATER_GREATER_EQUALS, // >>>=
    AMPERSAND_AMPERSAND_EQUALS,     // &&=
    PIPE_PIPE_EQUALS,               // ||=
    QUESTION_QUESTION_EQUALS,       // ??=

    // Trivia and stream control
    COMMENT,
    NEWLINE,
    WHITESPACE,
    EOF,
    ;

    /** True for tokens that may appear at the start of an expression. */
    val isExpressionStart: Boolean
        get() = when (this) {
            IDENTIFIER, KEYWORD, NUMERIC_LITERAL, STRING_LITERAL, REGEX_LITERAL,
            TEMPLATE_HEAD, TEMPLATE_NO_SUBST,
            OPEN_PAREN, OPEN_BRACKET, OPEN_BRACE,
            PLUS, MINUS, BANG, TILDE, PLUS_PLUS, MINUS_MINUS,
            -> true

            else -> false
        }
}
