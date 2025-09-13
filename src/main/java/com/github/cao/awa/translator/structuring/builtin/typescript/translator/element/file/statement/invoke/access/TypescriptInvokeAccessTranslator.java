package com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.invoke.access;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.TypescriptStatementElementTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.access.TypescriptInvokeAccess;
import com.github.cao.awa.translator.structuring.translate.StructuringTranslator;
import com.github.cao.awa.sinuatum.manipulate.Manipulate;

public interface TypescriptInvokeAccessTranslator<T extends TypescriptInvokeAccess> extends TypescriptStatementElementTranslator<T> {
    default void translateAccess(StructuringTranslator<T> translator) {
        T ast = translator.ast();
        StringBuilder builder = translator.builder();

        translator.translator(TypescriptTranslateElement.byType(ast.getClass()), next -> {
            next.postTranslate(builder, Manipulate.cast(ast), translator);
        });
    }
}
