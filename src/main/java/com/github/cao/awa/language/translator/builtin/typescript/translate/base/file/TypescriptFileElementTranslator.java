package com.github.cao.awa.language.translator.builtin.typescript.translate.base.file;

import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.TypescriptFile;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.translate.LanguageTranslator;
import com.github.cao.awa.language.translator.translate.base.LanguageElementTranslator;

public interface TypescriptFileElementTranslator extends LanguageElementTranslator<TypescriptFile> {
    default void translateEach(LanguageTranslator<TypescriptFile> translator) {
        TypescriptFile ast = translator.ast();
        StringBuilder builder = translator.builder();

        translator.translator(TypescriptTranslateElement.STATEMENT, next -> {
            for (TypescriptStatement importAst : ast.statements()) {
                next.postTranslate(builder, importAst);
            }
        });
    }
}
