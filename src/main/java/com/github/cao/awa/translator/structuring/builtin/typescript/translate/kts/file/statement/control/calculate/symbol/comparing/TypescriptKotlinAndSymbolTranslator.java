package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.control.calculate.symbol.comparing.TypescriptAndSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.comparing.TypescriptAndSymbol;

public class TypescriptKotlinAndSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptAndSymbol> implements TypescriptAndSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptAndSymbol ast) {
        builder.append(ast.symbol());
    }
}
