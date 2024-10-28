package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.assigment;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.assigment.TypescriptAdditionAssignmentSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.assigment.TypescriptSubtractionAssignmentSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.assignment.TypescriptAdditionAssignmentSymbol;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.assignment.TypescriptSubtractionAssignmentSymbol;

public class TypescriptKotlinSubtractionAssigmentSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptSubtractionAssignmentSymbol> implements TypescriptSubtractionAssignmentSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptSubtractionAssignmentSymbol ast) {
        builder.append(ast.symbol());
    }
}
