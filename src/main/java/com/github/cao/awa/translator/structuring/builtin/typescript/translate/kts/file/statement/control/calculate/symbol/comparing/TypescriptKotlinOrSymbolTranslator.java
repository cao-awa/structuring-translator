package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.control.calculate.symbol.comparing.TypescriptOrSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.comparing.TypescriptOrSymbol;

public class TypescriptKotlinOrSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptOrSymbol> implements TypescriptOrSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptOrSymbol ast) {
        builder.append(ast.symbol());
    }
}
