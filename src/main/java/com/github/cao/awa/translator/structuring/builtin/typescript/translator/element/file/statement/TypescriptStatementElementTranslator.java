package com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.translate.StructuringTranslator;
import com.github.cao.awa.translator.structuring.translate.base.StructuringElementTranslator;
import com.github.cao.awa.sinuatum.manipulate.Manipulate;

public interface TypescriptStatementElementTranslator<T extends TypescriptStatement> extends StructuringElementTranslator<T> {
    default void translateStatement(StructuringTranslator<T> translator) {
        TypescriptStatement ast = translator.ast();
        StringBuilder builder = translator.builder();

        translator.translator(TypescriptTranslateElement.byType(ast.getClass()), next -> {
            next.postTranslate(builder, Manipulate.cast(ast), translator);
        });
    }

    default void translateEnding(StructuringTranslator<T> translator) {
        translator.builder().append(";");

        translateLineWrap(translator);
    }
}
