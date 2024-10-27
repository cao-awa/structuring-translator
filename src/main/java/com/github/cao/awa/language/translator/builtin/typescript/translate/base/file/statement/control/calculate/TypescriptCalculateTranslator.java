package com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.TypescriptStatementElementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.TypescriptCalculate;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.language.translator.translate.LanguageTranslator;

public interface TypescriptCalculateTranslator extends TypescriptStatementElementTranslator<TypescriptCalculate> {
    default void translateTotal(LanguageTranslator<TypescriptCalculate> translator) {
        parenOr(
                translator,
                TypescriptCalculate::totalWithParen,
                this::translateContext
        );
    }

    default void translateContext(LanguageTranslator<TypescriptCalculate> translator) {
        try {
            parenOr(
                    translator,
                    TypescriptCalculate::leftWithParen,
                    this::translateLeft
            );

            parenOr(
                    translator,
                    TypescriptCalculate::rightWithParen,
                    this::translateRight
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void translateLeft(LanguageTranslator<TypescriptCalculate> translator) {
        translator.postNextTranslate(
                TypescriptTranslateElement.STATEMENT,
                TypescriptCalculate::left
        );
    }

    default void translateRight(LanguageTranslator<TypescriptCalculate> translator) {
        if (translator.ast().right() != null) {
            translateSymbol(translator);
        }

        translator.postTranslate(TypescriptTranslateElement.STATEMENT, translator.ast().right());

        translator.translator(TypescriptTranslateElement.CALCULATE, next -> {
            if (translator.ast().rights() != null) {
                for (TypescriptCalculate right : translator.ast().rights()) {
                    next.postTranslate(translator.builder(), right);
                }
            }
        });
    }

    default void translateSymbol(LanguageTranslator<TypescriptCalculate> translator) {
        TypescriptSymbol symbol = translator.ast().symbol();
        if (symbol != null) {
            translator.builder().append(symbol.symbol());
        }
    }
}
