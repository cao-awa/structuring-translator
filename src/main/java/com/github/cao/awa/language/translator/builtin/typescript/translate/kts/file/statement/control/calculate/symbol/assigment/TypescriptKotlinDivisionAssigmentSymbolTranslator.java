package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.assigment;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.assigment.TypescriptDivisionAssignmentSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.assigment.TypescriptMultiplicationAssignmentSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.assignment.TypescriptDivisionAssignmentSymbol;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.assignment.TypescriptMultiplicationAssignmentSymbol;

public class TypescriptKotlinDivisionAssigmentSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptDivisionAssignmentSymbol> implements TypescriptDivisionAssignmentSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptDivisionAssignmentSymbol ast) {
        builder.append(ast.symbol());
    }
}
