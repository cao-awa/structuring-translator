package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.TypescriptFileElementTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.TypescriptFile;

public class TypescriptKotlinScriptFileTranslator extends TypescriptKotlinScriptTranslator<TypescriptFile> implements TypescriptFileElementTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptFile ast) {
        translateEach(this);
    }
}
