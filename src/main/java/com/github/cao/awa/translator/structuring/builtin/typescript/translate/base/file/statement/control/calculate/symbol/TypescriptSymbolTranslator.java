package com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.control.calculate.symbol;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.TypescriptStatementElementTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.translator.structuring.translate.StructuringTranslator;
import com.github.cao.awa.sinuatum.manipulate.Manipulate;

public interface TypescriptSymbolTranslator<S extends TypescriptSymbol> extends TypescriptStatementElementTranslator<S> {
    default void translateSymbol(StructuringTranslator<S> translator) {
        TypescriptStatement ast = translator.ast();
        StringBuilder builder = translator.builder();

        translator.translator(TypescriptTranslateElement.byType(ast.getClass()), next -> {
            next.postTranslate(builder, Manipulate.cast(ast), translator);
        });
    }
}
