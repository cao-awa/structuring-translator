package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.arithmetic;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.arithmetic.TypescriptDivideSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.arithmetic.TypescriptPowSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic.TypescriptDivideSymbol;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic.TypescriptPowSymbol;

public class TypescriptKotlinDivideSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptDivideSymbol> implements TypescriptDivideSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptDivideSymbol ast) {
        builder.append(ast.symbol());
    }
}
