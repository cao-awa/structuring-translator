package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.TypescriptKotlinScriptFileTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.loop.TypescriptKotlinForTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.loop.TypescriptKotlinLoopControlTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.loop.TypescriptKotlinWhileTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.result.constant.TypescriptKotlinScriptConstantTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.result.constant.bool.TypescriptKotlinScriptBooleanTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.result.constant.number.TypescriptKotlinScriptNumberTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.result.constant.string.TypescriptKotlinScriptStringTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.result.constant.undefined.TypescriptKotlinScriptNullTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.result.constant.undefined.TypescriptKotlinScriptUndefinedTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.object.anonymous.TypescriptKotlinAnonymousObjectParamListTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.object.anonymous.TypescriptKotlinAnonymousObjectTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.object.callback.TypescriptKotlinCallbackFunctionTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.result.instance.TypescriptKotlinNewInstanceStatementTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.result.list.TypescriptKotlinOfListTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.TypescriptKotlinScriptStatementTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.action.TypescriptKotlinSelfActionTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.action.TypescriptKotlinSelfDecrementTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.action.TypescriptKotlinSelfIncrementTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.TypescriptKotlinIfTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.TypescriptKotlinCalculateTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.TypescriptKotlinSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.arithmetic.*;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.assigment.*;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.comparing.*;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.control.calculate.symbol.not.TypescriptKotlinNotSymbolTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.function.TypescriptKotlinFunctionTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.function.param.TypescriptKotlinParamListTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.function.param.TypescriptKotlinParamTypeTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.importing.TypescriptKotlinImportTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.invoke.TypescriptKotlinInvokeObjectTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.invoke.TypescriptKotlinInvokeTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.invoke.access.TypescriptKotlinInvokeAccessArrayTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.invoke.access.TypescriptKotlinInvokeAccessElementTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.invoke.access.TypescriptKotlinInvokeAccessTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.invoke.param.TypescriptKotlinInvokeParamListTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.invoke.param.TypescriptKotlinInvokeParamTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.result.referecen.TypescriptKotlinReferenceTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.vararg.TypescriptKotlinScriptArgTypeTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.variable.TypescriptKotlinScriptDefineVariableTranslator;
import com.github.cao.awa.translator.structuring.translate.StructuringTranslator;
import com.github.cao.awa.translator.structuring.translate.language.LanguageTranslateTarget;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public abstract class TypescriptKotlinScriptTranslator<T extends StructuringAst> extends StructuringTranslator<T> {
    public static void postRegister() {
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.FILE, new TypescriptKotlinScriptFileTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.STATEMENT, new TypescriptKotlinScriptStatementTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.DEFINE_VARIABLE, new TypescriptKotlinScriptDefineVariableTranslator());

        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.CONSTANT, new TypescriptKotlinScriptConstantTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.NUMBER, new TypescriptKotlinScriptNumberTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.STRING, new TypescriptKotlinScriptStringTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.BOOLEAN, new TypescriptKotlinScriptBooleanTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.NULL, new TypescriptKotlinScriptNullTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.UNDEFINED, new TypescriptKotlinScriptUndefinedTranslator());

        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.ARG_TYPE, new TypescriptKotlinScriptArgTypeTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.REFERENCE, new TypescriptKotlinReferenceTranslator());

        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.IMPORT, new TypescriptKotlinImportTranslator());

        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.FUNCTION, new TypescriptKotlinFunctionTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.PARAM_LIST, new TypescriptKotlinParamListTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.PARAM_TYPE, new TypescriptKotlinParamTypeTranslator());

        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.CALLBACK_FUNCTION, new TypescriptKotlinCallbackFunctionTranslator());

        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.INVOKE, new TypescriptKotlinInvokeTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.INVOKE_OBJECT, new TypescriptKotlinInvokeObjectTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.INVOKE_ACCESS, new TypescriptKotlinInvokeAccessTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.NEW_INSTANCE, new TypescriptKotlinNewInstanceStatementTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.INVOKE_ACCESS_ELEMENT, new TypescriptKotlinInvokeAccessElementTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.INVOKE_ACCESS_ARRAY, new TypescriptKotlinInvokeAccessArrayTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.INVOKE_PARAM, new TypescriptKotlinInvokeParamTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.INVOKE_PARAM_LIST, new TypescriptKotlinInvokeParamListTranslator());

        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.ANONYMOUS_OBJECT, new TypescriptKotlinAnonymousObjectTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.ANONYMOUS_OBJECT_PARAM_LIST, new TypescriptKotlinAnonymousObjectParamListTranslator());

        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SELF_ACTION, new TypescriptKotlinSelfActionTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SELF_DECREMENT, new TypescriptKotlinSelfDecrementTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SELF_INCREMENT, new TypescriptKotlinSelfIncrementTranslator());

        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.IF, new TypescriptKotlinIfTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.FOR, new TypescriptKotlinForTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.WHILE, new TypescriptKotlinWhileTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.LOOP_CONTROL, new TypescriptKotlinLoopControlTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.CALCULATE, new TypescriptKotlinCalculateTranslator());

        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.OF_LIST, new TypescriptKotlinOfListTranslator());

        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL, new TypescriptKotlinSymbolTranslator<>());

        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_NOT, new TypescriptKotlinNotSymbolTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_AND, new TypescriptKotlinAndSymbolTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_BREAKING_AND, new TypescriptKotlinBreakingAndSymbolTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_OR, new TypescriptKotlinOrSymbolTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_BREAKING_OR, new TypescriptKotlinBreakingOrSymbolTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_EQUALS, new TypescriptKotlinEqualsSymbolTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_STRICT_EQUALS, new TypescriptKotlinStrictEqualsSymbolTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_LESS_THAN, new TypescriptKotlinLessThanSymbolTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_MORE_THAN, new TypescriptKotlinMoreThanSymbolTranslator());

        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_ADDITION_ASSIGMENT, new TypescriptKotlinAdditionAssigmentSymbolTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_SUBTRACTION_ASSIGMENT, new TypescriptKotlinSubtractionAssigmentSymbolTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_DIVISION_ASSIGMENT, new TypescriptKotlinDivisionAssigmentSymbolTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_MULTIPLICATION_ASSIGMENT, new TypescriptKotlinMultiplicationAssigmentSymbolTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_POW_ASSIGMENT, new TypescriptKotlinPowAssigmentSymbolTranslator());

        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_PLUS, new TypescriptKotlinPlusSymbolTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_MINUS, new TypescriptKotlinMinusSymbolTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_DIVIDE, new TypescriptKotlinDivideSymbolTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_MULTIPLY, new TypescriptKotlinMultiplySymbolTranslator());
        registerKotlinScript(DEFAULT_PROVIDER, TypescriptTranslateElement.SYMBOL_POW, new TypescriptKotlinPowSymbolTranslator());
    }

    @Override
    public LanguageTranslateTarget target() {
        return LanguageTranslateTarget.KOTLIN_SCRIPT;
    }
}
