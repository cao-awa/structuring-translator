package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.control.loop;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.control.loop.TypescriptLoopControlTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.loop.TypescriptLoopControl;

public class TypescriptKotlinLoopControlTranslator extends TypescriptKotlinScriptTranslator<TypescriptLoopControl> implements TypescriptLoopControlTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptLoopControl ast) {
        switch (ast.controlType()) {
            case BREAK -> builder.append("break");
            case CONTINUE -> builder.append("continue");
        }

        translateEnding(this);
    }
}
