package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.control.calculate.symbol.assigment;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.control.calculate.symbol.assigment.TypescriptDivisionAssignmentSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.assignment.TypescriptDivisionAssignmentSymbol;

public class TypescriptKotlinDivisionAssignmentSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptDivisionAssignmentSymbol> implements TypescriptDivisionAssignmentSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptDivisionAssignmentSymbol ast) {
        builder.append(ast.symbol());
    }
}
