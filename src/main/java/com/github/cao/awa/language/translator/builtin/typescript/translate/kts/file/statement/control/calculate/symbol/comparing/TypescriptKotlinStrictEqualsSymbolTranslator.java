package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.comparing.TypescriptEqualsSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.comparing.TypescriptStrictEqualsSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptOperators;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.comparing.TypescriptEqualsSymbol;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.comparing.TypescriptStrictEqualsSymbol;

public class TypescriptKotlinStrictEqualsSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptStrictEqualsSymbol> implements TypescriptStrictEqualsSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptStrictEqualsSymbol ast) {
        builder.append(TypescriptOperators.EQUALS.symbol());
    }
}
