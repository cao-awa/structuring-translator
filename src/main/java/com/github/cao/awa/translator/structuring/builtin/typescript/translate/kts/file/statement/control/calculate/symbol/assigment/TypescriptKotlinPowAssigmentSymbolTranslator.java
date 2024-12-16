package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.assigment;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.control.calculate.symbol.assigment.TypescriptPowAssignmentSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.assignment.TypescriptPowAssignmentSymbol;

public class TypescriptKotlinPowAssigmentSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptPowAssignmentSymbol> implements TypescriptPowAssignmentSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptPowAssignmentSymbol ast) {
        builder.append(ast.symbol());
    }
}
