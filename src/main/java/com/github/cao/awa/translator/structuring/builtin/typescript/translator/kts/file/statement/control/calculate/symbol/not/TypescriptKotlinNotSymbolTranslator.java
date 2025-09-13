package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.control.calculate.symbol.not;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.control.calculate.symbol.not.TypescriptNotSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.not.TypescriptNotSymbol;

public class TypescriptKotlinNotSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptNotSymbol> implements TypescriptNotSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptNotSymbol ast) {
        builder.append(ast.symbol());
    }
}
