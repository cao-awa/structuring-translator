package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.result.instance;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.result.instance.TypescriptNewInstanceStatementTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.instance.TypescriptNewInstanceStatement;

public class TypescriptKotlinNewInstanceStatementTranslator extends TypescriptKotlinScriptTranslator<TypescriptNewInstanceStatement> implements TypescriptNewInstanceStatementTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptNewInstanceStatement ast) {
        postTranslate(TypescriptTranslateElement.ARG_TYPE, ast.type());

        builder.append("(");
        if (ast.paramList() != null) {
            postTranslate(TypescriptTranslateElement.INVOKE_PARAM_LIST, ast.paramList());
        }
        builder.append(")");
    }
}
