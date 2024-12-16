package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.result.constant.bool;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.result.constant.bool.TypescriptBooleanTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.result.constant.TypescriptKotlinScriptConstantTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result.constant.bool.TypescriptBoolean;

public class TypescriptKotlinScriptBooleanTranslator extends TypescriptKotlinScriptConstantTranslator<TypescriptBoolean> implements TypescriptBooleanTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptBoolean ast) {
        builder.append(ast.literal());
    }
}
