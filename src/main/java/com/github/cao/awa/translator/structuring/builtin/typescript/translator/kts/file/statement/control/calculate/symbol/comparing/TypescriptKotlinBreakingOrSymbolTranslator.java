package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.control.calculate.symbol.comparing.TypescriptBreakingOrSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.comparing.TypescriptBreakingOrSymbol;

public class TypescriptKotlinBreakingOrSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptBreakingOrSymbol> implements TypescriptBreakingOrSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptBreakingOrSymbol ast) {
        builder.append(ast.symbol());
    }
}
