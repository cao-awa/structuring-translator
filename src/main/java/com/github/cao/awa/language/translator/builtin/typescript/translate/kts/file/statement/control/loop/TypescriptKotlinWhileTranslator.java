package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control.loop;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.loop.TypescriptForTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.loop.TypescriptWhileTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.loop.TypescriptFor;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.loop.TypescriptWhile;

public class TypescriptKotlinWhileTranslator extends TypescriptKotlinScriptTranslator<TypescriptWhile> implements TypescriptWhileTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptWhile ast) {
        builder.append("while(");
        postTranslate(TypescriptTranslateElement.STATEMENT, ast.condition());
        builder.append("){");

        translateLineWrap(this);

        pushIdent();
        for (TypescriptStatement statement : ast.statements()) {
            postTranslate(TypescriptTranslateElement.STATEMENT, statement);
            if (!statement.isEnding()) {
                translateEnding(this);
            }
        }
        popIdent();

        builder.append("}");

        translateEnding(this);
    }
}
