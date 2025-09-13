package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.control.calculate.symbol.assigment;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.control.calculate.symbol.assigment.TypescriptMultiplicationAssignmentSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.assignment.TypescriptMultiplicationAssignmentSymbol;

public class TypescriptKotlinMultiplicationAssignmentSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptMultiplicationAssignmentSymbol> implements TypescriptMultiplicationAssignmentSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptMultiplicationAssignmentSymbol ast) {
        builder.append(ast.symbol());
    }
}
