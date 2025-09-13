package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.control.calculate.symbol.comparing.TypescriptLessThanSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.comparing.TypescriptLessThanSymbol;

public class TypescriptKotlinLessThanSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptLessThanSymbol> implements TypescriptLessThanSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptLessThanSymbol ast) {
        builder.append(ast.symbol());
    }
}
