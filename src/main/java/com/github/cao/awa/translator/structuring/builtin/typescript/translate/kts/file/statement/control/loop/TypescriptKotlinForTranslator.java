package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.loop;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.control.loop.TypescriptForTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.loop.TypescriptFor;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.variable.TypescriptDefineVariable;

public class TypescriptKotlinForTranslator extends TypescriptKotlinScriptTranslator<TypescriptFor> implements TypescriptForTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptFor ast) {
        if (ast.initStatement() instanceof TypescriptDefineVariable variable) {
            builder.append("var ");
            builder.append(variable.name());
            builder.append("=");
            postTranslate(TypescriptTranslateElement.STATEMENT, variable.assignment());
            builder.append(";");
            translateLineWrap(this);

            builder.append("while(");
            postTranslate(TypescriptTranslateElement.STATEMENT, ast.condition());
            builder.append("){");

            translateLineWrap(this);
            pushIndent();

            postTranslate(TypescriptTranslateElement.STATEMENT, ast.operationStatement());
            if (!ast.operationStatement().isEnding()) {
                translateEnding(this);
            }

            for (TypescriptStatement statement : ast.statements()) {
                postTranslate(TypescriptTranslateElement.STATEMENT, statement);
                if (!statement.isEnding()) {
                    translateEnding(this);
                }
            }

            popIndent();

            builder.append("}");

            translateEnding(this);
        } else {
            builder.append("/**\n");
            builder.append(" NOT SUPPORTED INITIALIZE STYLE:\n ");
            postTranslate(TypescriptTranslateElement.STATEMENT, ast.initStatement());
            builder.append(" */\n");
        }
    }
}
