package com.github.cao.awa.language.translator.builtin.typescript.translate.java;

import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.TypescriptKotlinScriptFileTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.constant.TypescriptKotlinScriptConstantTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.constant.bool.TypescriptKotlinScriptBooleanTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.constant.number.TypescriptKotlinScriptNumberTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.constant.string.TypescriptKotlinScriptStringTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.constant.undefined.TypescriptKotlinScriptNullTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.constant.undefined.TypescriptKotlinScriptUndefinedTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.object.anonymous.TypescriptKotlinAnonymousObjectParamListTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.object.anonymous.TypescriptKotlinAnonymousObjectTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.object.callback.TypescriptKotlinCallbackFunctionTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.TypescriptKotlinScriptStatementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.action.TypescriptKotlinSelfActionTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.action.TypescriptKotlinSelfDecrementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.action.TypescriptKotlinSelfIncrementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.control.TypescriptKotlinIfTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.control.calculate.TypescriptKotlinCalculateTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.function.TypescriptKotlinFunctionTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.function.param.TypescriptKotlinParamListTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.function.param.TypescriptKotlinParamTypeTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.importing.TypescriptKotlinImportTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.invoke.TypescriptKotlinInvokeObjectTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.invoke.TypescriptKotlinInvokeTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.invoke.access.TypescriptKotlinInvokeAccessArrayTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.invoke.access.TypescriptKotlinInvokeAccessElementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.invoke.access.TypescriptKotlinInvokeAccessTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.invoke.param.TypescriptKotlinInvokeParamListTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.invoke.param.TypescriptKotlinInvokeParamTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.referecen.TypescriptKotlinReferenceTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.vararg.TypescriptKotlinScriptArgTypeTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.variable.TypescriptKotlinScriptDefineVariableTranslator;
import com.github.cao.awa.language.translator.translate.LanguageTranslator;
import com.github.cao.awa.language.translator.translate.lang.TranslateTarget;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public abstract class TypescriptKotlinScriptTranslator<T extends LanguageAst> extends LanguageTranslator<T> {
    public static void postRegister() {
        registerKotlinScript(TypescriptTranslateElement.FILE, new TypescriptKotlinScriptFileTranslator());
        registerKotlinScript(TypescriptTranslateElement.STATEMENT, new TypescriptKotlinScriptStatementTranslator());
        registerKotlinScript(TypescriptTranslateElement.DEFINE_VARIABLE, new TypescriptKotlinScriptDefineVariableTranslator());

        registerKotlinScript(TypescriptTranslateElement.CONSTANT, new TypescriptKotlinScriptConstantTranslator());
        registerKotlinScript(TypescriptTranslateElement.NUMBER, new TypescriptKotlinScriptNumberTranslator());
        registerKotlinScript(TypescriptTranslateElement.STRING, new TypescriptKotlinScriptStringTranslator());
        registerKotlinScript(TypescriptTranslateElement.BOOLEAN, new TypescriptKotlinScriptBooleanTranslator());
        registerKotlinScript(TypescriptTranslateElement.NULL, new TypescriptKotlinScriptNullTranslator());
        registerKotlinScript(TypescriptTranslateElement.UNDEFINED, new TypescriptKotlinScriptUndefinedTranslator());

        registerKotlinScript(TypescriptTranslateElement.ARG_TYPE, new TypescriptKotlinScriptArgTypeTranslator());
        registerKotlinScript(TypescriptTranslateElement.REFERENCE, new TypescriptKotlinReferenceTranslator());

        registerKotlinScript(TypescriptTranslateElement.IMPORT, new TypescriptKotlinImportTranslator());

        registerKotlinScript(TypescriptTranslateElement.FUNCTION, new TypescriptKotlinFunctionTranslator());
        registerKotlinScript(TypescriptTranslateElement.PARAM_LIST, new TypescriptKotlinParamListTranslator());
        registerKotlinScript(TypescriptTranslateElement.PARAM_TYPE, new TypescriptKotlinParamTypeTranslator());

        registerKotlinScript(TypescriptTranslateElement.CALLBACK_FUNCTION, new TypescriptKotlinCallbackFunctionTranslator());

        registerKotlinScript(TypescriptTranslateElement.INVOKE, new TypescriptKotlinInvokeTranslator());
        registerKotlinScript(TypescriptTranslateElement.INVOKE_OBJECT, new TypescriptKotlinInvokeObjectTranslator());
        registerKotlinScript(TypescriptTranslateElement.INVOKE_ACCESS, new TypescriptKotlinInvokeAccessTranslator());
        registerKotlinScript(TypescriptTranslateElement.INVOKE_ACCESS_ELEMENT, new TypescriptKotlinInvokeAccessElementTranslator());
        registerKotlinScript(TypescriptTranslateElement.INVOKE_ACCESS_ARRAY, new TypescriptKotlinInvokeAccessArrayTranslator());
        registerKotlinScript(TypescriptTranslateElement.INVOKE_PARAM, new TypescriptKotlinInvokeParamTranslator());
        registerKotlinScript(TypescriptTranslateElement.INVOKE_PARAM_LIST, new TypescriptKotlinInvokeParamListTranslator());

        registerKotlinScript(TypescriptTranslateElement.ANONYMOUS_OBJECT, new TypescriptKotlinAnonymousObjectTranslator());
        registerKotlinScript(TypescriptTranslateElement.ANONYMOUS_OBJECT_PARAM_LIST, new TypescriptKotlinAnonymousObjectParamListTranslator());

        registerKotlinScript(TypescriptTranslateElement.SELF_ACTION, new TypescriptKotlinSelfActionTranslator());
        registerKotlinScript(TypescriptTranslateElement.SELF_DECREMENT, new TypescriptKotlinSelfDecrementTranslator());
        registerKotlinScript(TypescriptTranslateElement.SELF_INCREMENT, new TypescriptKotlinSelfIncrementTranslator());

        registerKotlinScript(TypescriptTranslateElement.IF, new TypescriptKotlinIfTranslator());
        registerKotlinScript(TypescriptTranslateElement.CALCULATE, new TypescriptKotlinCalculateTranslator());
    }

    @Override
    public TranslateTarget target() {
        return TranslateTarget.KOTLIN_SCRIPT;
    }
}
