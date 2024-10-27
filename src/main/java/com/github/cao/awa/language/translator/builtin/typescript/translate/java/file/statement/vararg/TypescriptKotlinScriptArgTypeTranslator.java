package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.vararg;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.TypescriptStatementElementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.vararg.TypescriptArgTypeTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.vararg.TypescriptArgType;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.variable.TypescriptDefineVariable;

import java.math.BigDecimal;
import java.util.LinkedList;

public class TypescriptKotlinScriptArgTypeTranslator extends TypescriptKotlinScriptTranslator<TypescriptArgType> implements TypescriptArgTypeTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptArgType ast) {
        builder.append(ast.name());
        if (!ast.args().isEmpty()) {
            builder.append("<");
            translator(TypescriptTranslateElement.ARG_TYPE, next -> {
                LinkedList<TypescriptArgType> args = ast.args();
                int size = args.size();
                int edge = size - 1;
                for (int i = 0; i < size; i++) {
                    TypescriptArgType arg = args.get(i);
                    next.postTranslate(builder, arg);
                    if (i != edge) {
                        builder.append(",");
                    }
                }
            });
            builder.append(">");
        }
        if (ast.arrayArgType()) {
            int depth = ast.arrayDepth();
            while (depth-- > 0) {
                builder.append("[");
                builder.append("]");
            }
        }
    }
}
