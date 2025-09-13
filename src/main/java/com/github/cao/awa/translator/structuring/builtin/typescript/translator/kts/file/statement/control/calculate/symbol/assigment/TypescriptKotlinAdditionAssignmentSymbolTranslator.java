package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.control.calculate.symbol.assigment;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.control.calculate.symbol.assigment.TypescriptAdditionAssignmentSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.assignment.TypescriptAdditionAssignmentSymbol;

public class TypescriptKotlinAdditionAssignmentSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptAdditionAssignmentSymbol> implements TypescriptAdditionAssignmentSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptAdditionAssignmentSymbol ast) {
        builder.append(ast.symbol());
    }
}
