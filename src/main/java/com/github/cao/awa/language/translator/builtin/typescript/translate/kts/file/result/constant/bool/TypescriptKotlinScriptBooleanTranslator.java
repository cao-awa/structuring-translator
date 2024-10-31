package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.result.constant.bool;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.result.constant.bool.TypescriptBooleanTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.bool.TypescriptBoolean;

public class TypescriptKotlinScriptBooleanTranslator extends TypescriptKotlinScriptTranslator<TypescriptBoolean> implements TypescriptBooleanTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptBoolean ast) {
        builder.append(ast.literal());
    }
}
