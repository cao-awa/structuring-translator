package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.invoke.param;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.invoke.param.TypescriptInvokeParamTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.param.TypescriptInvokeParam;
import com.github.cao.awa.translator.structuring.translate.StructuringTranslator;
import org.jetbrains.annotations.NotNull;

public class TypescriptKotlinInvokeParamTranslator extends TypescriptKotlinScriptTranslator<TypescriptInvokeParam> implements TypescriptInvokeParamTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptInvokeParam ast, @NotNull StructuringTranslator<?> source) {
        inheritIndent(source);
        translate(builder, ast);
    }

    @Override
    public void translate(StringBuilder builder, TypescriptInvokeParam ast) {
        if (ast.reference() != null) {
            translateIndent();
            builder.append(ast.reference());
        } else if (ast.result() != null) {
            postTranslate(TypescriptTranslateElement.STATEMENT, ast.result());
        }
    }
}
