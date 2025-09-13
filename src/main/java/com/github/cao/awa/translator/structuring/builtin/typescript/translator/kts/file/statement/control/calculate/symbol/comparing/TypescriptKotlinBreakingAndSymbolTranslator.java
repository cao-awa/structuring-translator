package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.control.calculate.symbol.comparing.TypescriptBreakingAndSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.comparing.TypescriptBreakingAndSymbol;

public class TypescriptKotlinBreakingAndSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptBreakingAndSymbol> implements TypescriptBreakingAndSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptBreakingAndSymbol ast) {
        builder.append(ast.symbol());
    }
}
