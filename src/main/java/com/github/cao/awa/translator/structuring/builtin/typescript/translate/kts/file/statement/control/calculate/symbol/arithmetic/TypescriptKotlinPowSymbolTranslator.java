package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.arithmetic;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.control.calculate.symbol.arithmetic.TypescriptPowSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic.TypescriptPowSymbol;

public class TypescriptKotlinPowSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptPowSymbol> implements TypescriptPowSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptPowSymbol ast) {
        builder.append(ast.symbol());
    }
}
