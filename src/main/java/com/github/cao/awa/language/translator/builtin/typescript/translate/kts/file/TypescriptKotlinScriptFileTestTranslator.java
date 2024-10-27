package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.TypescriptFileElementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.TypescriptFile;

public class TypescriptKotlinScriptFileTestTranslator extends TypescriptKotlinScriptTranslator<TypescriptFile> implements TypescriptFileElementTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptFile ast) {
        translateEach(this);

        builder.append("\n\nWITH_TEST");
    }
}
