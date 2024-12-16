package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.arithmetic;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.control.calculate.symbol.arithmetic.TypescriptDivideSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic.TypescriptDivideSymbol;

public class TypescriptKotlinDivideSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptDivideSymbol> implements TypescriptDivideSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptDivideSymbol ast) {
        builder.append(ast.symbol());
    }
}
