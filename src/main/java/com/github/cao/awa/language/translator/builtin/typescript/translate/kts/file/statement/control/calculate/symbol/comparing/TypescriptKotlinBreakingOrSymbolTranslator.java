package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.comparing.TypescriptBreakingOrSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.comparing.TypescriptBreakingOrSymbol;

public class TypescriptKotlinBreakingOrSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptBreakingOrSymbol> implements TypescriptBreakingOrSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptBreakingOrSymbol ast) {
        builder.append(ast.symbol());
    }
}
