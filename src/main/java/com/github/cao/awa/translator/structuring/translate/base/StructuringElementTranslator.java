package com.github.cao.awa.translator.structuring.translate.base;

import com.github.cao.awa.translator.structuring.translate.StructuringTranslator;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;
import com.github.cao.awa.translator.structuring.translate.tree.modifier.ElementModifier;
import com.github.cao.awa.translator.structuring.translate.tree.modifier.ModifierRequiredAst;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface StructuringElementTranslator<T extends StructuringAst> {
    // Do not impl it at translating instance.
    void postTranslate(StringBuilder builder, T ast, @NotNull StructuringTranslator<?> source);

    // Do not call this at translating instance, call 'postTranslate'.
    default void translate(StringBuilder builder, T ast, @NotNull StructuringTranslator<?> source) {
        translate(builder, ast);
    }

    // Do not call this at translating instance, call 'postTranslate'.
    void translate(StringBuilder builder, T ast);

    default byte[] translateBin(T ast) {
        return new byte[0];
    }

    default void braces(StructuringTranslator<T> translator, Consumer<StructuringTranslator<T>> body) {
        StringBuilder builder = translator.builder();

        builder.append("{");
        body.accept(translator);
        builder.append("}");
    }

    default void braceOr(StructuringTranslator<T> translator, Predicate<T> predicate, Consumer<StructuringTranslator<T>> body) {
        braceOr(translator, predicate, body, body);
    }

    default void braceOr(StructuringTranslator<T> translator, Predicate<T> predicate, Consumer<StructuringTranslator<T>> bodyWhenBrace, Consumer<StructuringTranslator<T>> bodyWhenNotBrace) {
        if (predicate.test(translator.ast())) {
            braces(translator, bodyWhenBrace);
        } else {
            bodyWhenNotBrace.accept(translator);
        }
    }

    default void paren(StructuringTranslator<T> translator, Consumer<StructuringTranslator<T>> body) {
        StringBuilder builder = translator.builder();

        builder.append("(");
        body.accept(translator);
        builder.append(")");
    }

    default void or(StructuringTranslator<T> translator, Predicate<T> predicate, Consumer<StructuringTranslator<T>> body) {
        or(translator, predicate, body, body);
    }

    default void or(StructuringTranslator<T> translator, Predicate<T> predicate, Consumer<StructuringTranslator<T>> bodyWhenTrue, Consumer<StructuringTranslator<T>> bodyWhenFalse) {
        if (predicate.test(translator.ast())) {
            bodyWhenTrue.accept(translator);
        } else {
            bodyWhenFalse.accept(translator);
        }
    }

    default void parenOr(StructuringTranslator<T> translator, Predicate<T> predicate, Consumer<StructuringTranslator<T>> body) {
        parenOr(translator, predicate, body, body);
    }

    default void parenOr(StructuringTranslator<T> translator, Predicate<T> predicate, Consumer<StructuringTranslator<T>> bodyWhenParen, Consumer<StructuringTranslator<T>> bodyWhenNotParen) {
        if (predicate.test(translator.ast())) {
            paren(translator, bodyWhenParen);
        } else {
            bodyWhenNotParen.accept(translator);
        }
    }

    default void translateAccessible(StructuringTranslator<T> translator) {
        if (translator.ast() instanceof ModifierRequiredAst<?> modifierRequired) {
            translator.append(modifierRequired.accessible().getAccessibleType().literal());
            translator.append(" ");
        }
    }

    default void splitModifiersBySpace(StructuringTranslator<T> translator) {
        if (translator.ast() instanceof ModifierRequiredAst<?> modifierRequired) {
            splitModifiersBy(translator, modifierRequired.modifierValues(), " ");
        }
    }

    default void splitModifiersBy(StructuringTranslator<T> translator, Collection<? extends ElementModifier<?>> modifiers, String split) {
        for (ElementModifier<?> modifier : modifiers) {
            if (modifier.isLiteral()) {
                translator.append(modifier.literal());
                translator.append(split);
            }
        }
    }

    default void translateLineWrap(StructuringTranslator<T> translator) {
        if (StructuringTranslator.isEnableLineWrap()) {
            translator.builder().append("\n");
        }
    }
}
