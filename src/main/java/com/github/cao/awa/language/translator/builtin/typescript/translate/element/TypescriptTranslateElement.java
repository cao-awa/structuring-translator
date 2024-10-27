package com.github.cao.awa.language.translator.builtin.typescript.translate.element;

import com.github.cao.awa.language.translator.builtin.typescript.tree.TypescriptFile;
import com.github.cao.awa.language.translator.builtin.typescript.tree.object.anonymous.TypescriptAnonymousObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.object.anonymous.TypescriptAnonymousObjectParamList;
import com.github.cao.awa.language.translator.builtin.typescript.tree.object.callback.TypescriptCallbackFunction;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.TypescriptConstant;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.bool.TypescriptBoolean;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.number.TypescriptNumber;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.string.TypescriptString;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.undefined.TypescriptNull;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.undefined.TypescriptUndefined;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.ref.TypescriptReference;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.action.TypescriptSelfAction;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.action.TypescriptSelfDecrement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.action.TypescriptSelfIncrement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.TypescriptIf;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.TypescriptCalculate;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.function.TypescriptFunction;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.function.TypescriptParamList;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.function.TypescriptParamType;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.importing.TypescriptImportStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.TypescriptInvoke;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.TypescriptInvokeObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.access.TypescriptInvokeAccess;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.access.TypescriptInvokeAccessArray;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.access.TypescriptInvokeAccessElement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.param.TypescriptInvokeParam;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.param.TypescriptInvokeParamList;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.vararg.TypescriptArgType;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.variable.TypescriptDefineVariable;
import com.github.cao.awa.language.translator.translate.lang.element.TranslateElementData;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;
import com.github.cao.awa.sinuatum.manipulate.Manipulate;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.Map;

public class TypescriptTranslateElement {
    private static final Map<Class<?>, TranslateElementData<?>> elements = CollectionFactor.hashMap();

    public static final TranslateElementData<TypescriptFile> FILE = create(TypescriptFile.class);
    public static final TranslateElementData<TypescriptStatement> STATEMENT = create(TypescriptStatement.class);
    public static final TranslateElementData<TypescriptDefineVariable> DEFINE_VARIABLE = create(TypescriptDefineVariable.class);

    public static final TranslateElementData<TypescriptConstant> CONSTANT = create(TypescriptConstant.class);
    public static final TranslateElementData<TypescriptNull> NULL = create(TypescriptNull.class);
    public static final TranslateElementData<TypescriptUndefined> UNDEFINED = create(TypescriptUndefined.class);
    public static final TranslateElementData<TypescriptNumber> NUMBER = create(TypescriptNumber.class);
    public static final TranslateElementData<TypescriptString> STRING = create(TypescriptString.class);
    public static final TranslateElementData<TypescriptBoolean> BOOLEAN = create(TypescriptBoolean.class);

    public static final TranslateElementData<TypescriptArgType> ARG_TYPE = create(TypescriptArgType.class);
    public static final TranslateElementData<TypescriptReference> REFERENCE = create(TypescriptReference.class);

    public static final TranslateElementData<TypescriptImportStatement> IMPORT = create(TypescriptImportStatement.class);

    public static final TranslateElementData<TypescriptFunction> FUNCTION = create(TypescriptFunction.class);
    public static final TranslateElementData<TypescriptParamList> PARAM_LIST = create(TypescriptParamList.class);
    public static final TranslateElementData<TypescriptParamType> PARAM_TYPE = create(TypescriptParamType.class);

    public static final TranslateElementData<TypescriptCallbackFunction> CALLBACK_FUNCTION = create(TypescriptCallbackFunction.class);

    public static final TranslateElementData<TypescriptInvoke> INVOKE = create(TypescriptInvoke.class);
    public static final TranslateElementData<TypescriptInvokeObject> INVOKE_OBJECT = create(TypescriptInvokeObject.class);
    public static final TranslateElementData<TypescriptInvokeAccess> INVOKE_ACCESS = create(TypescriptInvokeAccess.class);
    public static final TranslateElementData<TypescriptInvokeAccessElement> INVOKE_ACCESS_ELEMENT = create(TypescriptInvokeAccessElement.class);
    public static final TranslateElementData<TypescriptInvokeAccessArray> INVOKE_ACCESS_ARRAY = create(TypescriptInvokeAccessArray.class);
    public static final TranslateElementData<TypescriptInvokeParam> INVOKE_PARAM = create(TypescriptInvokeParam.class);
    public static final TranslateElementData<TypescriptInvokeParamList> INVOKE_PARAM_LIST = create(TypescriptInvokeParamList.class);

    public static final TranslateElementData<TypescriptAnonymousObject> ANONYMOUS_OBJECT = create(TypescriptAnonymousObject.class);
    public static final TranslateElementData<TypescriptAnonymousObjectParamList> ANONYMOUS_OBJECT_PARAM_LIST = create(TypescriptAnonymousObjectParamList.class);

    public static final TranslateElementData<TypescriptSelfAction> SELF_ACTION = create(TypescriptSelfAction.class);
    public static final TranslateElementData<TypescriptSelfDecrement> SELF_DECREMENT = create(TypescriptSelfDecrement.class);
    public static final TranslateElementData<TypescriptSelfIncrement> SELF_INCREMENT = create(TypescriptSelfIncrement.class);

    public static final TranslateElementData<TypescriptIf> IF = create(TypescriptIf.class);
    public static final TranslateElementData<TypescriptCalculate> CALCULATE = create(TypescriptCalculate.class);

    public static <X extends LanguageAst> TranslateElementData<X> create(Class<X> ast) {
        TranslateElementData<X> elementData = new TranslateElementData<>(ast);
        elements.put(ast, elementData);
        return elementData;
    }

    public static <X extends LanguageAst> TranslateElementData<X> byType(Class<X> type) {
        return Manipulate.cast(elements.get(type));
    }
}