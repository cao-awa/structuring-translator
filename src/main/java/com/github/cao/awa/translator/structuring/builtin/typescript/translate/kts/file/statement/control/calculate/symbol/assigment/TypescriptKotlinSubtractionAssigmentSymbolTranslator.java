package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.assigment;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.control.calculate.symbol.assigment.TypescriptSubtractionAssignmentSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.assignment.TypescriptSubtractionAssignmentSymbol;

public class TypescriptKotlinSubtractionAssigmentSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptSubtractionAssignmentSymbol> implements TypescriptSubtractionAssignmentSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptSubtractionAssignmentSymbol ast) {
        builder.append(ast.symbol());
    }
}
