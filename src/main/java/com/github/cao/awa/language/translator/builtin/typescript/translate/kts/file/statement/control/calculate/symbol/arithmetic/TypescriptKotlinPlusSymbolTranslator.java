package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.arithmetic;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.arithmetic.TypescriptPlusSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.assigment.TypescriptAdditionAssignmentSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic.TypescriptPlusSymbol;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.assignment.TypescriptAdditionAssignmentSymbol;

public class TypescriptKotlinPlusSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptPlusSymbol> implements TypescriptPlusSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptPlusSymbol ast) {
        builder.append(ast.symbol());
    }
}
