package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.control.calculate.symbol.comparing.TypescriptEqualsSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.comparing.TypescriptEqualsSymbol;

public class TypescriptKotlinEqualsSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptEqualsSymbol> implements TypescriptEqualsSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptEqualsSymbol ast) {
        builder.append(ast.symbol());
    }
}
