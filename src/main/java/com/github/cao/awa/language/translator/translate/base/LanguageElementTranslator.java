package com.github.cao.awa.language.translator.translate.base;

import com.github.cao.awa.language.translator.translate.LanguageTranslator;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;
import com.github.cao.awa.language.translator.translate.tree.modifier.ElementModifier;
import com.github.cao.awa.language.translator.translate.tree.modifier.ModifierRequiredAst;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface LanguageElementTranslator<T extends LanguageAst> {
    // Do not impl it at translating instance.
    void postTranslate(StringBuilder builder, T ast);

    // Do not call this at translating instance, call 'postTranslate'.
    void translate(StringBuilder builder, T ast);

    default byte[] translateBin(T ast) {
        return new byte[0];
    }

    default void braces(LanguageTranslator<T> translator, Consumer<LanguageTranslator<T>> body) {
        StringBuilder builder = translator.builder();

        builder.append("{");
        body.accept(translator);
        builder.append("}");
    }

    default void braceOr(LanguageTranslator<T> translator, Predicate<T> predicate, Consumer<LanguageTranslator<T>> body) {
        braceOr(translator, predicate, body, body);
    }

    default void braceOr(LanguageTranslator<T> translator, Predicate<T> predicate, Consumer<LanguageTranslator<T>> bodyWhenBrace, Consumer<LanguageTranslator<T>> bodyWhenNotBrace) {
        if (predicate.test(translator.ast())) {
            braces(translator, bodyWhenBrace);
        } else {
            bodyWhenNotBrace.accept(translator);
        }
    }

    default void paren(LanguageTranslator<T> translator, Consumer<LanguageTranslator<T>> body) {
        StringBuilder builder = translator.builder();

        builder.append("(");
        body.accept(translator);
        builder.append(")");
    }

    default void or(LanguageTranslator<T> translator, Predicate<T> predicate, Consumer<LanguageTranslator<T>> body) {
        or(translator, predicate, body, body);
    }

    default void or(LanguageTranslator<T> translator, Predicate<T> predicate, Consumer<LanguageTranslator<T>> bodyWhenTrue, Consumer<LanguageTranslator<T>> bodyWhenFalse) {
        if (predicate.test(translator.ast())) {
            bodyWhenTrue.accept(translator);
        } else {
            bodyWhenFalse.accept(translator);
        }
    }

    default void parenOr(LanguageTranslator<T> translator, Predicate<T> predicate, Consumer<LanguageTranslator<T>> body) {
        parenOr(translator, predicate, body, body);
    }

    default void parenOr(LanguageTranslator<T> translator, Predicate<T> predicate, Consumer<LanguageTranslator<T>> bodyWhenParen, Consumer<LanguageTranslator<T>> bodyWhenNotParen) {
        if (predicate.test(translator.ast())) {
            paren(translator, bodyWhenParen);
        } else {
            bodyWhenNotParen.accept(translator);
        }
    }

    default void translateAccessible(LanguageTranslator<T> translator) {
        if (translator.ast() instanceof ModifierRequiredAst<?> modifierRequired) {
            translator.append(modifierRequired.accessible().getAccessibleType().literal());
            translator.append(" ");
        }
    }

    default void splitModifiersBySpace(LanguageTranslator<T> translator) {
        if (translator.ast() instanceof ModifierRequiredAst<?> modifierRequired) {
            splitModifiersBy(translator, modifierRequired.modifierValues(), " ");
        }
    }

    default void splitModifiersBy(LanguageTranslator<T> translator, Collection<? extends ElementModifier<?>> modifiers, String split) {
        for (ElementModifier<?> modifier : modifiers) {
            if (modifier.isLiteral()) {
                translator.append(modifier.literal());
                translator.append(split);
            }
        }
    }
}
