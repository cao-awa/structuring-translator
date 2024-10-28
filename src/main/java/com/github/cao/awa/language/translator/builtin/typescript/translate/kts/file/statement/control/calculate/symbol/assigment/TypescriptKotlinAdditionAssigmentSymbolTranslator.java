package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.assigment;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.assigment.TypescriptAdditionAssignmentSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.symbol.comparing.TypescriptAndSymbolTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.assignment.TypescriptAdditionAssignmentSymbol;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.comparing.TypescriptAndSymbol;

public class TypescriptKotlinAdditionAssigmentSymbolTranslator extends TypescriptKotlinScriptTranslator<TypescriptAdditionAssignmentSymbol> implements TypescriptAdditionAssignmentSymbolTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptAdditionAssignmentSymbol ast) {
        builder.append(ast.symbol());
    }
}
