package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.control.calculate.symbol.comparing.TypescriptMoreThanSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.comparing.TypescriptMoreThanSymbol;

public class TypescriptKotlinMoreThanSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptMoreThanSymbol> implements TypescriptMoreThanSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptMoreThanSymbol ast) {
        builder.append(ast.symbol());
    }
}
