package com.github.cao.awa.language.translator.translate;

import com.github.cao.awa.language.translator.translate.base.LanguageElementTranslator;
import com.github.cao.awa.language.translator.translate.lang.TranslateTarget;
import com.github.cao.awa.language.translator.translate.lang.element.TranslateElementData;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;
import com.github.cao.awa.sinuatum.manipulate.Manipulate;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class LanguageTranslator<T extends LanguageAst> implements LanguageElementTranslator<T> {
    private static final Map<TranslateTarget, Map<TranslateElementData<?>, LanguageTranslator<?>>> translators = CollectionFactor.hashMap();
    private StringBuilder builder;
    private T ast;

    public StringBuilder builder() {
        return this.builder;
    }

    public void builder(StringBuilder builder) {
        this.builder = builder;
    }

    public T ast() {
        return this.ast;
    }

    public void ast(T ast) {
        this.ast = ast;
    }

    public static <X extends LanguageAst> void registerJava(TranslateElementData<X> element, LanguageTranslator<?> translator) {
        register(TranslateTarget.JAVA, element, translator);
    }

    public static <X extends LanguageAst> void register(TranslateTarget target, TranslateElementData<X> element, LanguageTranslator<?> translator) {
        translators.compute(target, (key, map) -> {
            if (map == null) {
                map = CollectionFactor.hashMap();
            }

            map.put(element, translator);

            return map;
        });
    }

    public static <X extends LanguageAst> String translate(TranslateTarget target, TranslateElementData<X> element, X ast) {
        StringBuilder builder = new StringBuilder();
        translators.get(target).get(element).postTranslate(builder, Manipulate.cast(ast));
        return builder.toString();
    }

    public abstract TranslateTarget target();

    public void append(String str) {
        this.builder.append(str);
    }

    @Override
    public void postTranslate(StringBuilder builder, T ast) {
        if (ast == null || builder == null) {
            return;
        }
        this.builder = builder;
        this.ast = ast;
        translate(builder, ast);
    }

    public String postTranslateToString(T ast) {
        StringBuilder builder = new StringBuilder();
        postTranslate(builder, ast);
        return builder.toString();
    }

    public <X extends LanguageAst> void postTranslate(TranslateElementData<X> element, X ast) {
        T recovery = this.ast;
        translator(element).postTranslate(this.builder, ast);
        this.ast = recovery;
    }

    public <X extends LanguageAst> void postNextTranslate(TranslateElementData<X> element, Function<T, X> nextAst) {
        postTranslate(element, nextAst.apply(this.ast));
    }

    public static <X extends LanguageAst> LanguageTranslator<X> translator(TranslateTarget target, TranslateElementData<X> element) {
        return Manipulate.cast(translators.get(target).get(element));
    }

    public <X extends LanguageAst> LanguageTranslator<X> translator(TranslateElementData<X> element) {
        return Manipulate.cast(translators.get(target()).get(element));
    }

    public <X extends LanguageAst> void translator(TranslateElementData<X> element, Consumer<LanguageTranslator<X>> action) {
        if (element == null) {
            return;
        }
        T recovery = this.ast;
        LanguageTranslator<X> ast = Manipulate.cast(translators.get(target()).get(element));
        if (ast == null) {
            return;
        }
        action.accept(ast);
        this.ast = recovery;
    }
}
