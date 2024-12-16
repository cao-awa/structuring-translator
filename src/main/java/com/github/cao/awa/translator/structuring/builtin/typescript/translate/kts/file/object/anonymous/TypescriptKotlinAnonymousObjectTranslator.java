package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.object.anonymous;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.object.anonymous.TypescriptAnonymousObjectTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.object.anonymous.TypescriptAnonymousObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.translator.structuring.translate.StructuringTranslator;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class TypescriptKotlinAnonymousObjectTranslator extends TypescriptKotlinScriptTranslator<TypescriptAnonymousObject> implements TypescriptAnonymousObjectTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptAnonymousObject ast, @NotNull StructuringTranslator<?> source) {
        inheritIdent(source);
        translate(builder, ast);
    }

    @Override
    public void translate(StringBuilder builder, TypescriptAnonymousObject ast) {
        translateIdent();
        builder.append("Any() ");
        translateLineWrap(this);

        pushIdent();
        translateIdent();
        builder.append("/* NOT IMPLIED: anonymous object ");
        translateLineWrap(this);

        Map<String, TypescriptResultStatement> statements = ast.params().values();
        int size = 1;
        pushIdent();
        for (Map.Entry<String, TypescriptResultStatement> entry : statements.entrySet()) {
            String key = entry.getKey();
            TypescriptResultStatement value = entry.getValue();
            translateIdent();
            builder.append(key).append(":");
            postTranslate(TypescriptTranslateElement.STATEMENT, value, false);
            if (size != statements.size()) {
                builder.append(",");
            }
            translateLineWrap(this);
            size++;
        }
        popIdent();

        translateIdent();
        popIdent();

        builder.append(" */ ");
    }
}
