package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.arithmetic;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.control.calculate.symbol.arithmetic.TypescriptMinusSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic.TypescriptMinusSymbol;

public class TypescriptKotlinMinusSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptMinusSymbol> implements TypescriptMinusSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptMinusSymbol ast) {
        builder.append(ast.symbol());
    }
}
