package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.comparing.TypescriptMoreThanSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.comparing.TypescriptMoreThanSymbol;

public class TypescriptKotlinMoreThanSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptMoreThanSymbol> implements TypescriptMoreThanSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptMoreThanSymbol ast) {
        builder.append(ast.symbol());
    }
}
