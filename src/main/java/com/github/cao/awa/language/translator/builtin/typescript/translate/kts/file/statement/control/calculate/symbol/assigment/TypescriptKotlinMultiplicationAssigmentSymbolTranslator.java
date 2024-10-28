package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.assigment;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.assigment.TypescriptMultiplicationAssignmentSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.assigment.TypescriptSubtractionAssignmentSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.assignment.TypescriptMultiplicationAssignmentSymbol;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.assignment.TypescriptSubtractionAssignmentSymbol;

public class TypescriptKotlinMultiplicationAssigmentSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptMultiplicationAssignmentSymbol> implements TypescriptMultiplicationAssignmentSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptMultiplicationAssignmentSymbol ast) {
        builder.append(ast.symbol());
    }
}
