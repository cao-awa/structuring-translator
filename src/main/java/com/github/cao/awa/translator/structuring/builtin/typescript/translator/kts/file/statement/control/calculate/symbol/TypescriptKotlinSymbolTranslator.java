package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.control.calculate.symbol;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.control.calculate.symbol.TypescriptSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;

public class TypescriptKotlinSymbolTranslator<S extends TypescriptSymbol> extends TypescriptKotlinScriptTranslator<S> implements TypescriptSymbolTranslator<S> {
    @Override
    public void translate(StringBuilder builder, S ast) {
        translateSymbol(this);
    }
}
