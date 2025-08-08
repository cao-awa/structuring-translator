package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.invoke.param;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.invoke.param.TypescriptInvokeParamListTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.param.TypescriptInvokeParam;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.param.TypescriptInvokeParamList;
import com.github.cao.awa.translator.structuring.translate.StructuringTranslator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class TypescriptKotlinInvokeParamListTranslator extends TypescriptKotlinScriptTranslator<TypescriptInvokeParamList> implements TypescriptInvokeParamListTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptInvokeParamList ast, @NotNull StructuringTranslator<?> source) {
        inheritIndent(source);
        translate(builder, ast);
    }

    @Override
    public void translate(StringBuilder builder, TypescriptInvokeParamList ast) {
        Iterator<TypescriptInvokeParam> iterator = ast.params().iterator();
        boolean hasNext = iterator.hasNext();
        while (hasNext) {
            postTranslate(TypescriptTranslateElement.INVOKE_PARAM, iterator.next());
            hasNext = iterator.hasNext();
            if (hasNext) {
                builder.append(",");
                translateLineWrap(this);
            }
        }
    }
}
