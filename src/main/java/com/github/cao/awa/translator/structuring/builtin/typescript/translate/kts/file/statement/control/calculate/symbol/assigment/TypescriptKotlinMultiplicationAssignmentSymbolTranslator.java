package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.assigment;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.control.calculate.symbol.assigment.TypescriptMultiplicationAssignmentSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.assignment.TypescriptMultiplicationAssignmentSymbol;

public class TypescriptKotlinMultiplicationAssignmentSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptMultiplicationAssignmentSymbol> implements TypescriptMultiplicationAssignmentSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptMultiplicationAssignmentSymbol ast) {
        builder.append(ast.symbol());
    }
}
