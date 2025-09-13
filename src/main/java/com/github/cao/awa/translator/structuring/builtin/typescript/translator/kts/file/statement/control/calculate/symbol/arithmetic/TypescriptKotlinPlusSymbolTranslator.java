package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.control.calculate.symbol.arithmetic;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.control.calculate.symbol.arithmetic.TypescriptPlusSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic.TypescriptPlusSymbol;

public class TypescriptKotlinPlusSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptPlusSymbol> implements TypescriptPlusSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptPlusSymbol ast) {
        builder.append(ast.symbol());
    }
}
