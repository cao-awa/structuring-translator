package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.arithmetic;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.arithmetic.TypescriptMinusSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.arithmetic.TypescriptPlusSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic.TypescriptMinusSymbol;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic.TypescriptPlusSymbol;

public class TypescriptKotlinMinusSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptMinusSymbol> implements TypescriptMinusSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptMinusSymbol ast) {
        builder.append(ast.symbol());
    }
}
