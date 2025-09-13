package com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.result.constant;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.TypescriptStatementElementTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.constant.TypescriptConstant;
import com.github.cao.awa.translator.structuring.translate.StructuringTranslator;
import com.github.cao.awa.sinuatum.manipulate.Manipulate;

public interface TypescriptConstantTranslator<T extends TypescriptConstant<?>> extends TypescriptStatementElementTranslator<T> {
    default void translateConstant(StructuringTranslator<T> translator) {
        TypescriptConstant<?> ast = translator.ast();
        StringBuilder builder = translator.builder();

        translator.translator(TypescriptTranslateElement.byType(ast.getClass()), next -> {
            next.postTranslate(builder, Manipulate.cast(ast), translator);
        });
    }
}
