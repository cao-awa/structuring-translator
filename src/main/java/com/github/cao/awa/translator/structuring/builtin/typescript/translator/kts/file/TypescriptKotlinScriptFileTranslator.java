package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.TypescriptFileElementTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.TypescriptFile;

public class TypescriptKotlinScriptFileTranslator extends TypescriptKotlinScriptTranslator<TypescriptFile> implements TypescriptFileElementTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptFile ast) {
        translateEach(this);
    }
}
