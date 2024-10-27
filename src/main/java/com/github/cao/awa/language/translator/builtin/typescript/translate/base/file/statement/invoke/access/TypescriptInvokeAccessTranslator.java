package com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.invoke.access;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.TypescriptStatementElementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.TypescriptConstant;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.access.TypescriptInvokeAccess;
import com.github.cao.awa.language.translator.translate.LanguageTranslator;
import com.github.cao.awa.sinuatum.manipulate.Manipulate;

public interface TypescriptInvokeAccessTranslator<T extends TypescriptInvokeAccess> extends TypescriptStatementElementTranslator<T> {
    default void translateAccess(LanguageTranslator<T> translator) {
        T ast = translator.ast();
        StringBuilder builder = translator.builder();

        translator.translator(TypescriptTranslateElement.byType(ast.getClass()), next -> {
            next.postTranslate(builder, Manipulate.cast(ast));
        });
    }
}
