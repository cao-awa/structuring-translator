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
    public static final String defaultProvider = "generic";
    private static final Map<String, Map<TranslateTarget, Map<TranslateElementData<?>, LanguageTranslator<?>>>> translators = CollectionFactor.hashMap();
    private StringBuilder builder;
    private T ast;
    private String requiredProvider = defaultProvider;

    public LanguageTranslator<T> requestProvider(final String provider) {
        this.requiredProvider = provider;
        return this;
    }

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

    public static <X extends LanguageAst> void registerJava(String provider, TranslateElementData<X> element, LanguageTranslator<?> translator) {
        register(provider, TranslateTarget.JAVA, element, translator);
    }

    public static <X extends LanguageAst> void registerKotlinScript(String provider, TranslateElementData<X> element, LanguageTranslator<?> translator) {
        register(provider, TranslateTarget.KOTLIN_SCRIPT, element, translator);
    }

    public static <X extends LanguageAst> void register(String provider, TranslateTarget target, TranslateElementData<X> element, LanguageTranslator<?> translator) {
        translators.compute(provider, (key, map) -> {
            if (map == null) {
                map = CollectionFactor.hashMap();
            }

            map.computeIfAbsent(target, k -> CollectionFactor.hashMap());

            map.get(target).put(element, translator);

            return map;
        });
    }

    public static Map<TranslateTarget, Map<TranslateElementData<?>, LanguageTranslator<?>>> getTranslators(String provider) {
        Map<TranslateTarget, Map<TranslateElementData<?>, LanguageTranslator<?>>> ts = translators.get(provider);
        if (ts == null) {
            ts = translators.get(defaultProvider);
        }
        return ts;
    }

    public static LanguageTranslator<?> getLanguageTranslator(String provider, TranslateTarget target, TranslateElementData<?> element) {
        LanguageTranslator<?> translator = getTranslators(provider).get(target).get(element);
        if (translator == null && !defaultProvider.equals(provider)) {
            translator = getLanguageTranslator(defaultProvider, target, element);
        }
        if (translator != null) {
            translator.requestProvider(provider);
        }
        return translator;
    }

    public static LanguageTranslator<?> getLanguageTranslator(TranslateTarget target, TranslateElementData<?> element) {
        LanguageTranslator<?> translator = getTranslators(defaultProvider).get(target).get(element);
        if (translator == null) {
            return getLanguageTranslator(defaultProvider, target, element);
        }
        return translator;
    }

    public static <X extends LanguageAst> String translate(String provider, TranslateTarget target, TranslateElementData<X> element, X ast) {
        StringBuilder builder = new StringBuilder();
        getLanguageTranslator(provider, target, element).requestProvider(provider).postTranslate(builder, Manipulate.cast(ast));
        return builder.toString();
    }

    public static <X extends LanguageAst> String translate(TranslateTarget target, TranslateElementData<X> element, X ast) {
        StringBuilder builder = new StringBuilder();
        getLanguageTranslator(defaultProvider, target, element).requestProvider(defaultProvider).postTranslate(builder, Manipulate.cast(ast));
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

    public <X extends LanguageAst> void postTranslate(String provider, TranslateElementData<X> element, X ast) {
        T recovery = this.ast;
        translator(provider, element).postTranslate(this.builder, ast);
        this.ast = recovery;
    }

    public <X extends LanguageAst> void postTranslate(TranslateElementData<X> element, X ast) {
        T recovery = this.ast;
        translator(this.requiredProvider, element).postTranslate(this.builder, ast);
        this.ast = recovery;
    }

    public <X extends LanguageAst> void postNextTranslate(TranslateElementData<X> element, Function<T, X> nextAst) {
        postTranslate(element, nextAst.apply(this.ast));
    }

    public static <X extends LanguageAst> LanguageTranslator<X> translator(String provider, TranslateTarget target, TranslateElementData<X> element) {
        return Manipulate.cast(getLanguageTranslator(provider, target, element));
    }

    public static <X extends LanguageAst> LanguageTranslator<X> translator(TranslateTarget target, TranslateElementData<X> element) {
        return Manipulate.cast(getLanguageTranslator(defaultProvider, target, element));
    }

    public <X extends LanguageAst> LanguageTranslator<X> translator(String provider, TranslateElementData<X> element) {
        return Manipulate.cast(getLanguageTranslator(provider, target(), element));
    }

    public <X extends LanguageAst> LanguageTranslator<X> translator(TranslateElementData<X> element) {
        return Manipulate.cast(getLanguageTranslator(this.requiredProvider, target(), element));
    }

    public <X extends LanguageAst> void translator(TranslateElementData<X> element, Consumer<LanguageTranslator<X>> action) {
        if (element == null) {
            return;
        }
        T recovery = this.ast;
        LanguageTranslator<X> translator = Manipulate.cast(getLanguageTranslator(this.requiredProvider, target(), element));
        if (translator == null) {
            return;
        }
        action.accept(translator);
        this.ast = recovery;
    }
}
