package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.arithmetic;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.control.calculate.symbol.arithmetic.TypescriptMultiplySymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic.TypescriptMultiplySymbol;

public class TypescriptKotlinMultiplySymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptMultiplySymbol> implements TypescriptMultiplySymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptMultiplySymbol ast) {
        builder.append(ast.symbol());
    }
}
