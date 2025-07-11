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

        Map<String, TypescriptResultStatement> elements = ast.params().values();

        builder.append("com.github.cao.awa.translator.structuring.standard.anonymous.AnonymousObject(");
        // Fixed size.
        builder.append(elements.size());
        builder.append(")");
        builder.append(".run {");

        translateLineWrap(this);

        pushIdent();
        pushIdent();
        int count = 0;
        for (Map.Entry<String, TypescriptResultStatement> entry : elements.entrySet()) {
            String key = entry.getKey();
            TypescriptResultStatement value = entry.getValue();
            translateIdent();
            builder.append("set(\"");
            builder.append(key);
            builder.append("\", ");
            postTranslate(TypescriptTranslateElement.STATEMENT, value, false);
            builder.append(")");
            translateEnding(this);
        }
        popIdent();
//        translateLineWrap(this);
        translateIdent();
        popIdent();

        builder.append("}");

        translateIdent();
        popIdent();
    }
}
