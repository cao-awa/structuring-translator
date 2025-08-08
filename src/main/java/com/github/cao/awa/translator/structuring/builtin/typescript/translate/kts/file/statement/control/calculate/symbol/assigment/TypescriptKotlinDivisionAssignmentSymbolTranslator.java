package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.assigment;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.control.calculate.symbol.assigment.TypescriptDivisionAssignmentSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.assignment.TypescriptDivisionAssignmentSymbol;

public class TypescriptKotlinDivisionAssignmentSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptDivisionAssignmentSymbol> implements TypescriptDivisionAssignmentSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptDivisionAssignmentSymbol ast) {
        builder.append(ast.symbol());
    }
}
