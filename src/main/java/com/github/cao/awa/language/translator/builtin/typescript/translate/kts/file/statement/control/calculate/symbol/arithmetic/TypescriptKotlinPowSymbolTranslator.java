package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.arithmetic;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.arithmetic.TypescriptMinusSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.arithmetic.TypescriptPowSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic.TypescriptMinusSymbol;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic.TypescriptPowSymbol;

public class TypescriptKotlinPowSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptPowSymbol> implements TypescriptPowSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptPowSymbol ast) {
        builder.append(ast.symbol());
    }
}
