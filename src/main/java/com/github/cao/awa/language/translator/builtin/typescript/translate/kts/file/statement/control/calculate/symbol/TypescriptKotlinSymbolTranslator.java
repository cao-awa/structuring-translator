package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control.calculate.symbol;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.TypescriptCalculateTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.TypescriptSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.TypescriptCalculate;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;

public class TypescriptKotlinSymbolTranslator<S extends TypescriptSymbol> extends TypescriptKotlinScriptTranslator<S> implements TypescriptSymbolTranslator<S> {
    @Override
    public void translate(StringBuilder builder, S ast) {
        translateSymbol(this);
    }
}
