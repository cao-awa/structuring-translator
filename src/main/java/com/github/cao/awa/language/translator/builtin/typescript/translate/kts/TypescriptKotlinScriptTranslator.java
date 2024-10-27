package com.github.cao.awa.language.translator.builtin.typescript.translate.kts;

import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.TypescriptKotlinScriptFileTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.constant.TypescriptKotlinScriptConstantTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.constant.bool.TypescriptKotlinScriptBooleanTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.constant.number.TypescriptKotlinScriptNumberTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.constant.string.TypescriptKotlinScriptStringTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.constant.undefined.TypescriptKotlinScriptNullTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.constant.undefined.TypescriptKotlinScriptUndefinedTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.object.anonymous.TypescriptKotlinAnonymousObjectParamListTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.object.anonymous.TypescriptKotlinAnonymousObjectTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.object.callback.TypescriptKotlinCallbackFunctionTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.TypescriptKotlinScriptStatementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.action.TypescriptKotlinSelfActionTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.action.TypescriptKotlinSelfDecrementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.action.TypescriptKotlinSelfIncrementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control.TypescriptKotlinIfTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control.calculate.TypescriptKotlinCalculateTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.function.TypescriptKotlinFunctionTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.function.param.TypescriptKotlinParamListTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.function.param.TypescriptKotlinParamTypeTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.importing.TypescriptKotlinImportTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.invoke.TypescriptKotlinInvokeObjectTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.invoke.TypescriptKotlinInvokeTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.invoke.access.TypescriptKotlinInvokeAccessArrayTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.invoke.access.TypescriptKotlinInvokeAccessElementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.invoke.access.TypescriptKotlinInvokeAccessTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.invoke.param.TypescriptKotlinInvokeParamListTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.invoke.param.TypescriptKotlinInvokeParamTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.referecen.TypescriptKotlinReferenceTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.vararg.TypescriptKotlinScriptArgTypeTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.variable.TypescriptKotlinScriptDefineVariableTranslator;
import com.github.cao.awa.language.translator.translate.LanguageTranslator;
import com.github.cao.awa.language.translator.translate.lang.TranslateTarget;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public abstract class TypescriptKotlinScriptTranslator<T extends LanguageAst> extends LanguageTranslator<T> {
    public static void postRegister() {
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.FILE, new TypescriptKotlinScriptFileTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.STATEMENT, new TypescriptKotlinScriptStatementTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.DEFINE_VARIABLE, new TypescriptKotlinScriptDefineVariableTranslator());

        registerKotlinScript(defaultProvider, TypescriptTranslateElement.CONSTANT, new TypescriptKotlinScriptConstantTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.NUMBER, new TypescriptKotlinScriptNumberTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.STRING, new TypescriptKotlinScriptStringTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.BOOLEAN, new TypescriptKotlinScriptBooleanTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.NULL, new TypescriptKotlinScriptNullTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.UNDEFINED, new TypescriptKotlinScriptUndefinedTranslator());

        registerKotlinScript(defaultProvider, TypescriptTranslateElement.ARG_TYPE, new TypescriptKotlinScriptArgTypeTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.REFERENCE, new TypescriptKotlinReferenceTranslator());

        registerKotlinScript(defaultProvider, TypescriptTranslateElement.IMPORT, new TypescriptKotlinImportTranslator());

        registerKotlinScript(defaultProvider, TypescriptTranslateElement.FUNCTION, new TypescriptKotlinFunctionTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.PARAM_LIST, new TypescriptKotlinParamListTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.PARAM_TYPE, new TypescriptKotlinParamTypeTranslator());

        registerKotlinScript(defaultProvider, TypescriptTranslateElement.CALLBACK_FUNCTION, new TypescriptKotlinCallbackFunctionTranslator());

        registerKotlinScript(defaultProvider, TypescriptTranslateElement.INVOKE, new TypescriptKotlinInvokeTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.INVOKE_OBJECT, new TypescriptKotlinInvokeObjectTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.INVOKE_ACCESS, new TypescriptKotlinInvokeAccessTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.INVOKE_ACCESS_ELEMENT, new TypescriptKotlinInvokeAccessElementTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.INVOKE_ACCESS_ARRAY, new TypescriptKotlinInvokeAccessArrayTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.INVOKE_PARAM, new TypescriptKotlinInvokeParamTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.INVOKE_PARAM_LIST, new TypescriptKotlinInvokeParamListTranslator());

        registerKotlinScript(defaultProvider, TypescriptTranslateElement.ANONYMOUS_OBJECT, new TypescriptKotlinAnonymousObjectTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.ANONYMOUS_OBJECT_PARAM_LIST, new TypescriptKotlinAnonymousObjectParamListTranslator());

        registerKotlinScript(defaultProvider, TypescriptTranslateElement.SELF_ACTION, new TypescriptKotlinSelfActionTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.SELF_DECREMENT, new TypescriptKotlinSelfDecrementTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.SELF_INCREMENT, new TypescriptKotlinSelfIncrementTranslator());

        registerKotlinScript(defaultProvider, TypescriptTranslateElement.IF, new TypescriptKotlinIfTranslator());
        registerKotlinScript(defaultProvider, TypescriptTranslateElement.CALCULATE, new TypescriptKotlinCalculateTranslator());


    }

    @Override
    public TranslateTarget target() {
        return TranslateTarget.KOTLIN_SCRIPT;
    }
}
