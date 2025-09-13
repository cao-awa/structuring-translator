package com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.TypescriptFile;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.translate.StructuringTranslator;
import com.github.cao.awa.translator.structuring.translate.base.StructuringElementTranslator;

public interface TypescriptFileElementTranslator extends StructuringElementTranslator<TypescriptFile> {
    default void translateEach(StructuringTranslator<TypescriptFile> translator) {
        TypescriptFile ast = translator.ast();
        StringBuilder builder = translator.builder();

        translator.translator(TypescriptTranslateElement.STATEMENT, next -> {
            for (TypescriptStatement importAst : ast.statements()) {
                next.postTranslate(builder, importAst, translator);
                translateLineWrap(translator);
            }
        });
    }
}
