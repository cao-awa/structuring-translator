package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.assigment;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.control.calculate.symbol.assigment.TypescriptAdditionAssignmentSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.assignment.TypescriptAdditionAssignmentSymbol;

public class TypescriptKotlinAdditionAssigmentSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptAdditionAssignmentSymbol> implements TypescriptAdditionAssignmentSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptAdditionAssignmentSymbol ast) {
        builder.append(ast.symbol());
    }
}
