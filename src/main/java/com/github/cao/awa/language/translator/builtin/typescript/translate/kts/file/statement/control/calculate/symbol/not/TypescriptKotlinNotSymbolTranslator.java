package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.not;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.TypescriptSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.not.TypescriptNotSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.not.TypescriptNotSymbol;

public class TypescriptKotlinNotSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptNotSymbol> implements TypescriptNotSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptNotSymbol ast) {
        builder.append(ast.symbol());
    }
}
