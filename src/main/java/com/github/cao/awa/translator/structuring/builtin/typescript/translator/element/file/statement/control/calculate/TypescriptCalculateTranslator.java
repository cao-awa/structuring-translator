package com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.control.calculate;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.TypescriptStatementElementTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.TypescriptCalculate;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.translator.structuring.translate.StructuringTranslator;

public interface TypescriptCalculateTranslator extends TypescriptStatementElementTranslator<TypescriptCalculate> {
    default void translateTotal(StructuringTranslator<TypescriptCalculate> translator) {
        parenOr(
                translator,
                TypescriptCalculate::totalWithParen,
                this::translateContext
        );
    }

    default void translateContext(StructuringTranslator<TypescriptCalculate> translator) {
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

    default void translateLeft(StructuringTranslator<TypescriptCalculate> translator) {
        translator.postNextTranslate(
                TypescriptTranslateElement.STATEMENT,
                TypescriptCalculate::left
        );
    }

    default void translateRight(StructuringTranslator<TypescriptCalculate> translator) {
        if (translator.ast().right() != null) {
            translateSymbol(translator);
        }

        translator.postTranslate(TypescriptTranslateElement.STATEMENT, translator.ast().right());

        translator.translator(TypescriptTranslateElement.CALCULATE, next -> {
            if (translator.ast().rights() != null) {
                for (TypescriptCalculate right : translator.ast().rights()) {
                    next.postTranslate(translator.builder(), right, translator);
                }
            }
        });
    }

    default void translateSymbol(StructuringTranslator<TypescriptCalculate> translator) {
        TypescriptSymbol symbol = translator.ast().symbol();
        if (symbol != null) {
            translator.postTranslate(TypescriptTranslateElement.SYMBOL, symbol);
        }
    }
}
