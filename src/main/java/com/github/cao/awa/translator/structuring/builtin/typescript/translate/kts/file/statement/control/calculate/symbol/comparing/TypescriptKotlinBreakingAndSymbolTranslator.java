package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.control.calculate.symbol.comparing.TypescriptBreakingAndSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.comparing.TypescriptBreakingAndSymbol;

public class TypescriptKotlinBreakingAndSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptBreakingAndSymbol> implements TypescriptBreakingAndSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptBreakingAndSymbol ast) {
        builder.append(ast.symbol());
    }
}
