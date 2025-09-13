package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.control.calculate.symbol.arithmetic;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.control.calculate.symbol.arithmetic.TypescriptMultiplySymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic.TypescriptMultiplySymbol;

public class TypescriptKotlinMultiplySymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptMultiplySymbol> implements TypescriptMultiplySymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptMultiplySymbol ast) {
        builder.append(ast.symbol());
    }
}
