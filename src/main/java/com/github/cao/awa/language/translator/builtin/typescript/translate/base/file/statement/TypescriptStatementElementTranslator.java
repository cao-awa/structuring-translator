package com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement;

import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.translate.LanguageTranslator;
import com.github.cao.awa.language.translator.translate.base.LanguageElementTranslator;
import com.github.cao.awa.sinuatum.manipulate.Manipulate;

public interface TypescriptStatementElementTranslator<T extends TypescriptStatement> extends LanguageElementTranslator<T> {
    default void translateStatement(LanguageTranslator<T> translator) {
        TypescriptStatement ast = translator.ast();
        StringBuilder builder = translator.builder();

        translator.translator(TypescriptTranslateElement.byType(ast.getClass()), next -> {
            next.postTranslate(builder, Manipulate.cast(ast));
        });
    }

    default void translateEnding(LanguageTranslator<T> translator) {
        translator.builder().append(";\n");
    }
}
