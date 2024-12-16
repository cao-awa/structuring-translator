package com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.result.constant;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.TypescriptStatementElementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result.constant.TypescriptConstant;
import com.github.cao.awa.language.translator.translate.LanguageTranslator;
import com.github.cao.awa.sinuatum.manipulate.Manipulate;

public interface TypescriptConstantTranslator<T extends TypescriptConstant<?>> extends TypescriptStatementElementTranslator<T> {
    default void translateConstant(LanguageTranslator<T> translator) {
        TypescriptConstant<?> ast = translator.ast();
        StringBuilder builder = translator.builder();

        translator.translator(TypescriptTranslateElement.byType(ast.getClass()), next -> {
            next.postTranslate(builder, Manipulate.cast(ast), translator);
        });
    }
}
