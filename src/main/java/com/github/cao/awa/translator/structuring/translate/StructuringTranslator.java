package com.github.cao.awa.translator.structuring.translate;

import com.github.cao.awa.translator.structuring.translate.base.StructuringElementTranslator;
import com.github.cao.awa.translator.structuring.translate.language.LanguageTranslateTarget;
import com.github.cao.awa.translator.structuring.translate.element.TranslateElementData;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;
import com.github.cao.awa.sinuatum.manipulate.Manipulate;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class StructuringTranslator<T extends StructuringAst> implements StructuringElementTranslator<T> {
    public static final String DEFAULT_PROVIDER = "generic";
    public static final String VERSION = "1.1.4-fix5";
    private static final Map<String, Map<LanguageTranslateTarget, Map<TranslateElementData<?>, StructuringTranslator<?>>>> translators = CollectionFactor.hashMap();
    private static boolean enableLineWrap = true;
    private static boolean enableIndent = true;
    private String requiredProvider = DEFAULT_PROVIDER;
    private StringBuilder builder;
    private T ast;
    @Range(from = 0, to = Integer.MAX_VALUE)
    private int currentIndent = 0;
    @Range(from = 0, to = Integer.MAX_VALUE)
    private int indent = 0;
    private String indentStyle = "    ";

    @Contract(pure = true)
    public static String getVersion() {
        return VERSION;
    }

    public static void enableIndent(boolean enableIndent) {
        StructuringTranslator.enableIndent = enableIndent;
        enableLineWrap(true);
    }

    @Contract(pure = true)
    public static boolean isEnableIndent() {
        return enableIndent;
    }

    public static void enableLineWrap(boolean enableLineWrap) {
        StructuringTranslator.enableLineWrap = enableLineWrap;
    }

    @Contract(pure = true)
    public static boolean isEnableLineWrap() {
        return enableLineWrap;
    }

    public void pushIndent() {
        this.currentIndent++;

        this.indent = this.currentIndent;
    }

    public void popIndent() {
        if (this.currentIndent > 0) {
            this.currentIndent--;
        }

        this.indent = this.currentIndent;
    }

    public StructuringTranslator<T> indentStyle(String indentStyle) {
        this.indentStyle = indentStyle;
        return this;
    }

    public StructuringTranslator<T> requestProvider(final String provider) {
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

    public static <X extends StructuringAst> void registerJava(String provider, TranslateElementData<X> element, StructuringTranslator<?> translator) {
        register(provider, LanguageTranslateTarget.JAVA, element, translator);
    }

    public static <X extends StructuringAst> void registerKotlinScript(String provider, TranslateElementData<X> element, StructuringTranslator<?> translator) {
        register(provider, LanguageTranslateTarget.KOTLIN_SCRIPT, element, translator);
    }

    public static <X extends StructuringAst> void register(String provider, LanguageTranslateTarget target, TranslateElementData<X> element, StructuringTranslator<?> translator) {
        translators.compute(provider, (key, map) -> {
            if (map == null) {
                map = CollectionFactor.hashMap();
            }

            map.computeIfAbsent(target, k -> CollectionFactor.hashMap());

            map.get(target).put(element, translator);

            return map;
        });
    }

    public static Map<LanguageTranslateTarget, Map<TranslateElementData<?>, StructuringTranslator<?>>> getTranslators(String provider) {
        Map<LanguageTranslateTarget, Map<TranslateElementData<?>, StructuringTranslator<?>>> ts = translators.get(provider);
        if (ts == null) {
            ts = translators.get(DEFAULT_PROVIDER);
        }
        return ts;
    }

    public static StructuringTranslator<?> getTranslator(String provider, LanguageTranslateTarget target, TranslateElementData<?> element) {
        StructuringTranslator<?> translator = getTranslators(provider).get(target).get(element);
        if (translator == null && !DEFAULT_PROVIDER.equals(provider)) {
            translator = getTranslator(DEFAULT_PROVIDER, target, element);
        }
        if (translator != null) {
            translator.requestProvider(provider);
        }
        return translator;
    }

    public static StructuringTranslator<?> getTranslator(LanguageTranslateTarget target, TranslateElementData<?> element) {
        StructuringTranslator<?> translator = getTranslators(DEFAULT_PROVIDER).get(target).get(element);
        if (translator == null) {
            return getTranslator(DEFAULT_PROVIDER, target, element);
        }
        return translator;
    }

    public static <X extends StructuringAst> String translate(String provider, LanguageTranslateTarget target, TranslateElementData<X> element, X ast) {
        StringBuilder builder = new StringBuilder();
        StructuringTranslator<?> translator = getTranslator(provider, target, element);
        translator.requestProvider(provider).postTranslate(builder, Manipulate.cast(ast), translator);
        return builder.toString();
    }

    public static <X extends StructuringAst> String translate(LanguageTranslateTarget target, TranslateElementData<X> element, X ast) {
        StringBuilder builder = new StringBuilder();
        StructuringTranslator<?> translator = getTranslator(DEFAULT_PROVIDER, target, element);
        translator.requestProvider(DEFAULT_PROVIDER).postTranslate(builder, Manipulate.cast(ast), translator);
        return builder.toString();
    }

    public abstract LanguageTranslateTarget target();

    public void append(String str) {
        this.builder.append(str);
    }

    @Override
    public void postTranslate(StringBuilder builder, T ast, @NotNull StructuringTranslator<?> source) {
        if (ast == null || builder == null) {
            return;
        }
        this.builder = builder;
        this.ast = ast;
        translate(builder, ast, source);
        if (source.indent != source.currentIndent) {
            source.currentIndent = source.indent;
        }
    }

    public void postTranslate(StringBuilder builder, T ast, @NotNull StructuringTranslator<?> source, boolean indent) {
        int currentIndent = source.currentIndent;
        if (!indent) {
            source.currentIndent = 0;
        }
        postTranslate(builder, ast, source);
        source.currentIndent = currentIndent;
    }

    public String postTranslateToString(T ast) {
        StringBuilder builder = new StringBuilder();
        postTranslate(builder, ast, this);
        return builder.toString();
    }

    public <X extends StructuringAst> void postTranslate(String provider, TranslateElementData<X> element, X ast) {
        T recovery = this.ast;
        translator(provider, element).postTranslate(this.builder, ast, this);
        this.ast = recovery;
    }

    public <X extends StructuringAst> void postTranslate(TranslateElementData<X> element, X ast) {
        T recovery = this.ast;
        translator(this.requiredProvider, element).postTranslate(this.builder, ast, this);
        this.ast = recovery;
    }

    public <X extends StructuringAst> void postTranslate(String provider, TranslateElementData<X> element, X ast, boolean indent) {
        T recovery = this.ast;
        translator(provider, element).postTranslate(this.builder, ast, this, indent);
        this.ast = recovery;
    }

    public <X extends StructuringAst> void postTranslate(TranslateElementData<X> element, X ast, boolean indent) {
        T recovery = this.ast;
        translator(this.requiredProvider, element).postTranslate(this.builder, ast, this, indent);
        this.ast = recovery;
    }

    public <X extends StructuringAst> void postNextTranslate(TranslateElementData<X> element, Function<T, X> nextAst) {
        postTranslate(element, nextAst.apply(this.ast));
    }

    public <X extends StructuringAst> void postNextTranslate(TranslateElementData<X> element, Function<T, X> nextAst, boolean indent) {
        postTranslate(element, nextAst.apply(this.ast), indent);
    }

    public static <X extends StructuringAst> StructuringTranslator<X> translator(String provider, LanguageTranslateTarget target, TranslateElementData<X> element) {
        return Manipulate.cast(getTranslator(provider, target, element));
    }

    public static <X extends StructuringAst> StructuringTranslator<X> translator(LanguageTranslateTarget target, TranslateElementData<X> element) {
        return Manipulate.cast(getTranslator(DEFAULT_PROVIDER, target, element));
    }

    public <X extends StructuringAst> StructuringTranslator<X> translator(String provider, TranslateElementData<X> element) {
        return Manipulate.cast(getTranslator(provider, target(), element));
    }

    public <X extends StructuringAst> StructuringTranslator<X> translator(TranslateElementData<X> element) {
        return Manipulate.cast(getTranslator(this.requiredProvider, target(), element));
    }

    public <X extends StructuringAst> void translator(TranslateElementData<X> element, Consumer<StructuringTranslator<X>> action) {
        if (element == null) {
            return;
        }
        T recovery = this.ast;
        StructuringTranslator<X> translator = Manipulate.cast(getTranslator(this.requiredProvider, target(), element));
        if (translator == null) {
            return;
        }
        action.accept(translator);
        this.ast = recovery;
    }

    public void translateIndent() {
        if (enableIndent) {
            this.builder.append(String.valueOf(this.indentStyle).repeat(this.currentIndent));
        }
    }

    public void inheritIndent(@NotNull StructuringTranslator<?> source) {
        this.currentIndent = source.currentIndent;
        this.indent = source.indent;
        this.indentStyle = source.indentStyle;
    }
}
