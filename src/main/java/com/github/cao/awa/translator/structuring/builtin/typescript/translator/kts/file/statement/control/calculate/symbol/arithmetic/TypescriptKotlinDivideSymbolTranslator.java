package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.control.calculate.symbol.arithmetic;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.control.calculate.symbol.arithmetic.TypescriptDivideSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic.TypescriptDivideSymbol;

public class TypescriptKotlinDivideSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptDivideSymbol> implements TypescriptDivideSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptDivideSymbol ast) {
        builder.append(ast.symbol());
    }
}
