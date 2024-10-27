package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.invoke;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.importing.TypescriptImportingTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.invoke.TypescriptInvokeTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.importing.TypescriptImportStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.TypescriptInvoke;

public class TypescriptKotlinInvokeTranslator extends TypescriptKotlinScriptTranslator<TypescriptInvoke> implements TypescriptInvokeTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptInvoke ast) {
        postTranslate(TypescriptTranslateElement.INVOKE_OBJECT, ast.invokeTarget());
                builder.append("(");

        postTranslate(TypescriptTranslateElement.INVOKE_PARAM_LIST, ast.params());

        builder.append(")");

        if (ast.isEnding()) {
            translateEnding(this);
        }
    }
}
