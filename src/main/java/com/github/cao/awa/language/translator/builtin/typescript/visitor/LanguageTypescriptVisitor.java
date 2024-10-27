package com.github.cao.awa.language.translator.builtin.typescript.visitor;

import com.github.cao.awa.language.translator.builtin.typescript.antlr.TypescriptBaseVisitor;
import com.github.cao.awa.language.translator.builtin.typescript.antlr.TypescriptParser;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.TypescriptIf;
import com.github.cao.awa.language.translator.builtin.typescript.tree.TypescriptFile;
import com.github.cao.awa.language.translator.builtin.typescript.tree.object.anonymous.TypescriptAnonymousObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.object.anonymous.TypescriptAnonymousObjectParamList;
import com.github.cao.awa.language.translator.builtin.typescript.tree.object.callback.TypescriptCallbackFunction;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.string.TypescriptString;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.action.TypescriptSelfAction;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.action.TypescriptSelfDecrement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.action.TypescriptSelfIncrement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.TypescriptCalculate;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.ApsOperators;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.function.TypescriptFunction;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.function.TypescriptParamList;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.function.TypescriptParamType;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.TypescriptResultStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.TypescriptConstant;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.bool.TypescriptBoolean;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.number.TypescriptNumber;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.undefined.TypescriptNull;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.undefined.TypescriptUndefined;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.ref.TypescriptReference;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
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
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

import java.math.BigDecimal;
import java.util.List;

public class LanguageTypescriptVisitor extends TypescriptBaseVisitor<LanguageAst> {
    private LanguageAst current;

    @Override
    public TypescriptFile visitProgram(TypescriptParser.ProgramContext ctx) {
        TypescriptFile file = new TypescriptFile(null);
        this.current = file;

        visitChildren(ctx);

        return file;
    }

    @Override
    public TypescriptFunction visitDefineFunction(TypescriptParser.DefineFunctionContext ctx) {
        TypescriptFunction function = new TypescriptFunction(this.current);
        function.name(ctx.identifier().getText());

        if (ctx.paramList() != null) {
            function.params(visitParamList(ctx.paramList()));
        }

        List<TypescriptParser.TheStatementContext> theStatements = ctx.defineStatement().theStatement();

        if (theStatements != null) {
            for (TypescriptParser.TheStatementContext theStatement : theStatements) {
                function.addStatement(visitTheStatement(theStatement));
            }
        }

        return function;
    }

    @Override
    public TypescriptParamList visitParamList(TypescriptParser.ParamListContext ctx) {
        TypescriptParamList params = new TypescriptParamList(this.current);

        for (TypescriptParser.ParamTypeContext paramType : ctx.paramType()) {
            params.addArg(visitParamType(paramType));
        }

        return params;
    }

    @Override
    public TypescriptStatement visitTheStatement(TypescriptParser.TheStatementContext ctx) {
        if (ctx.defineVariableStatement() != null) {
            return visitDefineVariableStatement(ctx.defineVariableStatement());
        }

        if (ctx.importStatement() != null) {
            return visitImportStatement(ctx.importStatement());
        }

        if (ctx.defineFunction() != null) {
            return visitDefineFunction(ctx.defineFunction());
        }

        if (ctx.invokeStatement() != null) {
            return visitInvokeStatement(ctx.invokeStatement());
        }

        if (ctx.variableSelfAction() != null) {
            TypescriptSelfAction selfAction = visitVariableSelfAction(ctx.variableSelfAction());
            selfAction.isEnding(true);
            return selfAction;
        }

        if (ctx.ifStatement() != null) {
            return visitIfStatement(ctx.ifStatement());
        }

        return null;
    }

    @Override
    public LanguageAst visitElseIfStatement(TypescriptParser.ElseIfStatementContext ctx) {
        return super.visitElseIfStatement(ctx);
    }

    @Override
    public LanguageAst visitElseStatement(TypescriptParser.ElseStatementContext ctx) {
        return super.visitElseStatement(ctx);
    }

    @Override
    public TypescriptIf visitIfStatement(TypescriptParser.IfStatementContext ctx) {
        TypescriptIf ifStatement = new TypescriptIf(this.current);

        if (ctx.statementBlock() != null) {
            if (ctx.statementBlock().defineStatement().theStatement() != null) {
                for (TypescriptParser.TheStatementContext theStatement : ctx.statementBlock().defineStatement().theStatement()) {
                    ifStatement.addStatement(visitTheStatement(theStatement));
                }
            }
        }

        ifStatement.predicate(visitResultPresenting(ctx.resultPresenting()));

        if (ctx.elseIfStatement() != null) {
            ifStatement.elseIfStatement(visitIfStatement(ctx.elseIfStatement().ifStatement()));
        } else {
            if (ctx.elseStatement() != null && ctx.elseStatement().statementBlock().defineStatement().theStatement() != null) {
                for (TypescriptParser.TheStatementContext theStatement : ctx.elseStatement().statementBlock().defineStatement().theStatement()) {
                    ifStatement.addElseStatement(visitTheStatement(theStatement));
                }
            }
        }

        return ifStatement;
    }

    @Override
    public TypescriptCalculate visitCalculateStatement(TypescriptParser.CalculateStatementContext ctx) {
        TypescriptCalculate ast = new TypescriptCalculate(this.current);

        if (ctx.calculateStatementWithTotalParen() != null) {
            ast = visitCalculateStatementWithTotalParen(ctx.calculateStatementWithTotalParen());
            ast.totalWithParen(true);
        } else {
            if (ctx.calculateStatementWithParen() != null) {
                ast = visitCalculateStatementWithParen(ctx.calculateStatementWithParen());
                ast.totalWithParen(true);
            } else {
                ast.left(visitCalculateLeft(ctx.calculateLeft()));
            }
        }

        if (ctx.extraCalculateStatement() != null) {
            for (TypescriptParser.ExtraCalculateStatementContext extraCalculateStatementContext : ctx.extraCalculateStatement()) {
                TypescriptSymbol symbol = visitOperator(extraCalculateStatementContext.operator());

                TypescriptResultStatement theRight = visitCalculatableResultPresenting(extraCalculateStatementContext.calculatableResultPresenting());

                if (ast.right() == null) {
                    ast.symbol(symbol);
                    ast.right(theRight);
                } else {
                    TypescriptCalculate extraAst = new TypescriptCalculate(this.current);
                    extraAst.symbol(symbol);
                    extraAst.right(theRight);

                    ast.rights().add(extraAst);
                }
            }
        }

        return ast;
    }

    @Override
    public TypescriptCalculate visitCalculateStatementWithTotalParen(TypescriptParser.CalculateStatementWithTotalParenContext ctx) {
        TypescriptCalculate ast = new TypescriptCalculate(this.current);

        ast.left(visitCalculateLeft(ctx.calculateLeft()));
        if (ctx.extraCalculateStatement() != null) {
            for (TypescriptParser.ExtraCalculateStatementContext extraCalculateStatementContext : ctx.extraCalculateStatement()) {
                TypescriptSymbol symbol = visitOperator(extraCalculateStatementContext.operator());

                TypescriptResultStatement theRight = visitCalculatableResultPresenting(extraCalculateStatementContext.calculatableResultPresenting());

                if (ast.right() == null) {
                    ast.symbol(symbol);
                    ast.right(theRight);
                } else {
                    TypescriptCalculate extraAst = new TypescriptCalculate(this.current);
                    extraAst.symbol(symbol);
                    extraAst.right(theRight);

                    ast.rights().add(extraAst);
                }
            }
        }

        return ast;
    }

    @Override
    public TypescriptResultStatement visitCalculateLeft(TypescriptParser.CalculateLeftContext ctx) {
        return visitCalculatableResultPresenting(ctx.calculatableResultPresenting());
    }

    @Override
    public TypescriptResultStatement visitCalculatableResultPresenting(TypescriptParser.CalculatableResultPresentingContext ctx) {
        if (ctx.invokeStatement() != null) {
            return visitInvokeStatement(ctx.invokeStatement());
        } else if (ctx.newInstanceStatement() != null) {
            return visitNewInstanceStatement(ctx.newInstanceStatement());
        } else if (ctx.constant() != null) {
            return visitConstant(ctx.constant());
        } else if (ctx.calculateStatementWithParen() != null) {
            return visitCalculateStatementWithParen(ctx.calculateStatementWithParen());
        } else if (ctx.identifier() != null) {
            return new TypescriptReference(this.current).name(ctx.identifier().getText());
        } else if (ctx.fullName() != null) {
            return new TypescriptReference(this.current).name(ctx.fullName().getText());
        }
        return null;
    }

    @Override
    public TypescriptCalculate visitCalculateStatementWithParen(TypescriptParser.CalculateStatementWithParenContext ctx) {
        TypescriptCalculate ast = new TypescriptCalculate(this.current);
        ast.leftWithParen(true);
        ast.left(visitCalculateLeftStatementWithParen(ctx.calculateLeftStatementWithParen()));
        if (ctx.extraCalculateStatement() != null) {
            for (TypescriptParser.ExtraCalculateStatementContext extraCalculateStatementContext : ctx.extraCalculateStatement()) {
                TypescriptSymbol symbol = visitOperator(extraCalculateStatementContext.operator());

                TypescriptResultStatement theRight = visitCalculatableResultPresenting(extraCalculateStatementContext.calculatableResultPresenting());

                if (ast.right() == null) {
                    ast.symbol(symbol);
                    ast.right(theRight);
                } else {
                    TypescriptCalculate extraAst = new TypescriptCalculate(this.current);
                    extraAst.symbol(symbol);
                    extraAst.right(theRight);

                    ast.rights().add(extraAst);
                }
            }
        }
        return ast;
    }

    @Override
    public TypescriptSymbol visitOperator(TypescriptParser.OperatorContext ctx) {
        if (ctx.arithmetic() != null) {
            return visitArithmetic(ctx.arithmetic());
        }

        if (ctx.comparing() != null) {
            return visitComparing(ctx.comparing());
        }

        if (ctx.not() != null) {
            return ApsOperators.NOT;
        }

        return null;
    }

    @Override
    public TypescriptSymbol visitComparing(TypescriptParser.ComparingContext ctx) {
        if (ctx.comparingOr() != null) {
            return visitComparingOr(ctx.comparingOr());
        }

        if (ctx.comparingAnd() != null) {
            return visitComparingAnd(ctx.comparingAnd());
        }

        if (ctx.moreThan() != null) {
            return ApsOperators.MORE_THAN;
        }

        if (ctx.lessThan() != null) {
            return ApsOperators.LESS_THAN;
        }

        if (ctx.Equals() != null) {
            return ApsOperators.EQUALS;
        }

        return null;
    }

    @Override
    public TypescriptSymbol visitComparingAnd(TypescriptParser.ComparingAndContext ctx) {
        if (ctx.and() != null) {
            return ApsOperators.AND;
        }

        if (ctx.breakingAnd() != null) {
            return ApsOperators.BREAKING_AND;
        }

        return null;
    }

    @Override
    public TypescriptSymbol visitComparingOr(TypescriptParser.ComparingOrContext ctx) {
        if (ctx.or() != null) {
            return ApsOperators.OR;
        }

        if (ctx.breakingOr() != null) {
            return ApsOperators.BREAKING_OR;
        }

        return null;
    }

    @Override
    public TypescriptSymbol visitArithmetic(TypescriptParser.ArithmeticContext ctx) {
        if (ctx.Plus() != null) {
            return ApsOperators.PLUS;
        }

        if (ctx.Minus() != null) {
            return ApsOperators.MINUS;
        }

        if (ctx.Multiply() != null) {
            return ApsOperators.MULTIPLY;
        }

        if (ctx.Divide() != null) {
            return ApsOperators.DIVIDE;
        }

        if (ctx.Pow() != null) {
            return ApsOperators.POW;
        }

        if (ctx.AddisionAssignment() != null) {
            return ApsOperators.ADDITION_ASSIGNMENT;
        }

        if (ctx.SubtractionAssignment() != null) {
            return ApsOperators.SUBTRACTION_ASSIGNMENT;
        }

        if (ctx.MultiplicationAssignment() != null) {
            return ApsOperators.MULTIPLICATION_ASSIGNMENT;
        }

        if (ctx.DivisionAssignment() != null) {
            return ApsOperators.DIVISION_ASSIGNMENT;
        }

        if (ctx.PowAssignment() != null) {
            return ApsOperators.POW_ASSIGNMENT;
        }

        return null;
    }

    @Override
    public TypescriptResultStatement visitCalculateLeftStatementWithParen(TypescriptParser.CalculateLeftStatementWithParenContext ctx) {
        if (ctx.calculateStatement() != null) {
            return visitCalculateStatement(ctx.calculateStatement());
        }
        return visitCalculatableResultPresenting(ctx.calculatableResultPresenting());
    }


    @Override
    public LanguageAst visitDefineStatement(TypescriptParser.DefineStatementContext ctx) {
        for (TypescriptParser.TheStatementContext theStatementContext : ctx.theStatement()) {
            ((TypescriptFile) this.current).addStatement(visitTheStatement(theStatementContext));
        }

        return this.current;
    }

    @Override
    public TypescriptDefineVariable visitDefineVariableStatement(TypescriptParser.DefineVariableStatementContext ctx) {
        TypescriptDefineVariable variable = new TypescriptDefineVariable(this.current);

        variable.name(ctx.variableName().getText());

        if (ctx.Colon() != null) {
            variable.type(visitArgType(ctx.argType()));
        }

        if (ctx.assignment() != null) {
            if (ctx.assignmentIdentifier() != null) {
                variable.assigment(visitAssignmentIdentifier(ctx.assignmentIdentifier()));
            } else {
                variable.assigment(visitResultPresenting(ctx.resultPresenting()));
            }
        }

        TypescriptParser.IsDefineFieldContext defineField = ctx.isDefineField();

        variable.isFinal(defineField.Const() != null);

        return variable;
    }

    @Override
    public TypescriptResultStatement visitResultPresenting(TypescriptParser.ResultPresentingContext ctx) {
        if (ctx.resultingStatement() != null) {
            return visitResultingStatement(ctx.resultingStatement());
        }

        if (ctx.constant() != null) {
            return visitConstant(ctx.constant());
        }

        if (ctx.identifier() != null) {
            TypescriptReference reference = new TypescriptReference(this.current);
            reference.name(ctx.identifier().getText());
            return reference;
        }

        if (ctx.fullName() != null) {
            TypescriptReference reference = new TypescriptReference(this.current);
            reference.name(ctx.fullName().getText());
            return reference;
        }

        return null;
    }

    @Override
    public TypescriptResultStatement visitResultingStatement(TypescriptParser.ResultingStatementContext ctx) {
        if (ctx.invokeStatement() != null) {
            TypescriptInvoke invoke = visitInvokeStatement(ctx.invokeStatement());
            invoke.isEnding(false);
            return invoke;
        }

        if (ctx.anonymousObject() != null) {
            return visitAnonymousObject(ctx.anonymousObject());
        }

        if (ctx.callbackFunction() != null) {
            return visitCallbackFunction(ctx.callbackFunction());
        }

        if (ctx.variableSelfAction() != null) {
            TypescriptSelfAction selfAction = visitVariableSelfAction(ctx.variableSelfAction());
            selfAction.isEnding(false);
            return selfAction;
        }

        if (ctx.calculateStatement() != null) {
            return visitCalculateStatement(ctx.calculateStatement());
        }

        // TODO
        return null;
    }

    @Override
    public TypescriptSelfDecrement visitVariableSelfDecrement(TypescriptParser.VariableSelfDecrementContext ctx) {
        TypescriptSelfDecrement decrement = new TypescriptSelfDecrement(this.current);

        decrement.access(visitInvokeAccess(ctx.invokeAccess()));

        decrement.isBefore(ctx.beforeDecrement() != null);

        return decrement;
    }

    @Override
    public TypescriptSelfIncrement visitVariableSelfIncrement(TypescriptParser.VariableSelfIncrementContext ctx) {
        TypescriptSelfIncrement increment = new TypescriptSelfIncrement(this.current);

        increment.access(visitInvokeAccess(ctx.invokeAccess()));

        increment.isBefore(ctx.beforeIncrement() != null);

        return increment;
    }

    @Override
    public TypescriptSelfAction visitVariableSelfAction(TypescriptParser.VariableSelfActionContext ctx) {
        if (ctx.variableSelfDecrement() != null) {
            return visitVariableSelfDecrement(ctx.variableSelfDecrement());
        }

        if (ctx.variableSelfIncrement() != null) {
            return visitVariableSelfIncrement(ctx.variableSelfIncrement());
        }

        return null;
    }

    @Override
    public TypescriptCallbackFunction visitCallbackFunction(TypescriptParser.CallbackFunctionContext ctx) {
        TypescriptCallbackFunction function = new TypescriptCallbackFunction(this.current);
        if (ctx.paramList() != null) {
            function.params(visitParamList(ctx.paramList()));
        }
        for (TypescriptParser.TheStatementContext statementContext : ctx.defineStatement().theStatement()) {
            function.addStatement(visitTheStatement(statementContext));
        }
        return function;
    }

    @Override
    public TypescriptAnonymousObject visitAnonymousObject(TypescriptParser.AnonymousObjectContext ctx) {
        TypescriptAnonymousObject object = new TypescriptAnonymousObject(this.current);

        object.params(visitAnonymousObjectParamList(ctx.anonymousObjectParamList()));

        return object;
    }

    @Override
    public TypescriptAnonymousObjectParamList visitAnonymousObjectParamList(TypescriptParser.AnonymousObjectParamListContext ctx) {
        TypescriptAnonymousObjectParamList params = new TypescriptAnonymousObjectParamList(this.current);

        for (TypescriptParser.AnonymousObjectParamContext objectParams : ctx.anonymousObjectParam()) {
            params.addValue(objectParams.identifier().getText(), visitResultPresenting(objectParams.resultPresenting()));
        }

        return params;
    }

    @Override
    public LanguageAst visitExtraCalculateStatement(TypescriptParser.ExtraCalculateStatementContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitReturnStatement(TypescriptParser.ReturnStatementContext ctx) {
        return null;
    }

    @Override
    public TypescriptInvoke visitInvokeStatement(TypescriptParser.InvokeStatementContext ctx) {
        TypescriptInvoke invoke = new TypescriptInvoke(this.current);
        invoke.invokeTarget(visitInvokeObject(ctx.invokeObject()));

        if (ctx.invokeParamList() != null) {
            invoke.params(visitInvokeParamList(ctx.invokeParamList()));
        }

        return invoke;
    }

    @Override
    public TypescriptInvokeObject visitInvokeObject(TypescriptParser.InvokeObjectContext ctx) {
        TypescriptInvokeObject object = new TypescriptInvokeObject(this.current);
        for (TypescriptParser.InvokeAccessContext invokeAccess : ctx.invokeAccess()) {
            object.addAccess(visitInvokeAccess(invokeAccess));
        }
        return object;
    }

    @Override
    public TypescriptInvokeAccess visitInvokeAccess(TypescriptParser.InvokeAccessContext ctx) {
        if (ctx.accessArray() != null) {
            return visitAccessArray(ctx.accessArray());
        }

        if (ctx.accessElement() != null) {
            return visitAccessElement(ctx.accessElement());
        }

        return null;
    }

    @Override
    public TypescriptInvokeAccessElement visitAccessElement(TypescriptParser.AccessElementContext ctx) {
        TypescriptInvokeAccessElement element = new TypescriptInvokeAccessElement(this.current);

        element.target(ctx.getText());

        return element;
    }

    @Override
    public TypescriptInvokeAccessArray visitAccessArray(TypescriptParser.AccessArrayContext ctx) {
        TypescriptInvokeAccessArray array = new TypescriptInvokeAccessArray(this.current);

        array.target(visitAccessElement(ctx.accessElement()));
        array.accessParam(visitResultPresenting(ctx.resultPresenting()));

        return array;
    }

    @Override
    public LanguageAst visitFluentInvokeStatement(TypescriptParser.FluentInvokeStatementContext ctx) {
        return null;
    }

    @Override
    public TypescriptResultStatement visitNewInstanceStatement(TypescriptParser.NewInstanceStatementContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitVariableName(TypescriptParser.VariableNameContext ctx) {
        return null;
    }

    @Override
    public TypescriptParamType visitParamType(TypescriptParser.ParamTypeContext ctx) {
        TypescriptParamType paramType = new TypescriptParamType(this.current);

        paramType.name(ctx.identifier().getText());

        if (ctx.argType() != null) {
            paramType.type(visitArgType(ctx.argType()));
        }

        return paramType;
    }

    @Override
    public TypescriptImportStatement visitImportStatement(TypescriptParser.ImportStatementContext ctx) {
        TypescriptImportStatement statement = new TypescriptImportStatement(this.current);
        statement.from(ctx.String().getText());

        for (TypescriptParser.IdentifierContext identifierContext : ctx.identifier()) {
            statement.addImport(identifierContext.getText());
        }

        return statement;
    }

    @Override
    public TypescriptArgType visitArgType(TypescriptParser.ArgTypeContext ctx) {
        TypescriptArgType ast = new TypescriptArgType(this.current);
        if (ctx.identifier() != null) {
            ast.name(ctx.identifier().getText());
        }
        if (ctx.typedArgType() != null) {
            if (ctx.typedArgType().argType() != null) {
                this.current = ast;

                ast.addArg(visitArgType(ctx.typedArgType().argType()));
                if (ctx.typedArgType().extraArgTypes() != null) {
                    for (TypescriptParser.ExtraArgTypesContext extraArgType : ctx.typedArgType().extraArgTypes()) {
                        this.current = ast;

                        ast.addArg(visitArgType(extraArgType.argType()));
                    }
                }
            }
        }
        if (ctx.arrayArgType() != null) {
            if (ctx.arrayArgType().arrayDefinition() != null && !ctx.arrayArgType().arrayDefinition().isEmpty()) {
                if (ctx.arrayArgType().arrayDefinition().size() > 1) {
                    ast.arrayDepth(ctx.arrayArgType().arrayDefinition().size());
                }
                ast.arrayArgType(true);
            }
        }
        return ast;
    }

    @Override
    public LanguageAst visitTypedArgType(TypescriptParser.TypedArgTypeContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitExtraArgTypes(TypescriptParser.ExtraArgTypesContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitArrayArgType(TypescriptParser.ArrayArgTypeContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitArrayDefinition(TypescriptParser.ArrayDefinitionContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitTokenList(TypescriptParser.TokenListContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitValidToken(TypescriptParser.ValidTokenContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitExtraToken(TypescriptParser.ExtraTokenContext ctx) {
        return null;
    }

    @Override
    public TypescriptInvokeParamList visitInvokeParamList(TypescriptParser.InvokeParamListContext ctx) {
        TypescriptInvokeParamList params = new TypescriptInvokeParamList(this.current);
        if (ctx.validInvokeParam() != null) {
            params.addParam(visitValidInvokeParam(ctx.validInvokeParam()));
        }
        for (TypescriptParser.ValidExtraInvokeParamContext invokeParam : ctx.validExtraInvokeParam()) {
            if (invokeParam.validInvokeParam() != null) {
                params.addParam(visitValidInvokeParam(invokeParam.validInvokeParam()));
            }
        }
        return params;
    }

    @Override
    public TypescriptInvokeParam visitValidInvokeParam(TypescriptParser.ValidInvokeParamContext ctx) {
        TypescriptInvokeParam param = new TypescriptInvokeParam(this.current);

        if (ctx.resultPresenting() != null) {
            param.result(visitResultPresenting(ctx.resultPresenting()));
        } else if (ctx.validToken() != null) {
            param.reference(ctx.validToken().getText());
        }

        return param;
    }

    @Override
    public TypescriptConstant<?> visitConstant(TypescriptParser.ConstantContext ctx) {
        if (ctx.String() != null) {
            TypescriptString string = new TypescriptString(this.current);
            string.value(ctx.String().getText().replace("'", "").replace("\"", ""));
            return string;
        }

        if (ctx.bool() != null) {
            TypescriptBoolean bool = new TypescriptBoolean(this.current);
            bool.value(ctx.bool().True() != null);
            return bool;
        }

        if (ctx.number() != null) {
            TypescriptNumber number = new TypescriptNumber(this.current);
            number.value(new BigDecimal(ctx.number().getText()));
            return number;
        }

        if (ctx.Null() != null) {
            return new TypescriptNull(this.current);
        }

        if (ctx.Undefined() != null) {
            return new TypescriptUndefined(this.current);
        }

        return (TypescriptConstant<?>) visitChildren(ctx);
    }

    @Override
    public TypescriptResultStatement visitAssignmentIdentifier(TypescriptParser.AssignmentIdentifierContext ctx) {
        TypescriptReference reference = new TypescriptReference(this.current);
        reference.name(ctx.identifier().getText());
        return reference;
    }

    @Override
    public LanguageAst visitPoint(TypescriptParser.PointContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitLeftBrace(TypescriptParser.LeftBraceContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitRightBrace(TypescriptParser.RightBraceContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitLeftAngleBracket(TypescriptParser.LeftAngleBracketContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitRightAngleBracket(TypescriptParser.RightAngleBracketContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitLeftBracket(TypescriptParser.LeftBracketContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitRightBracket(TypescriptParser.RightBracketContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitLeftParenthesis(TypescriptParser.LeftParenthesisContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitRightParenthesis(TypescriptParser.RightParenthesisContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitLeftParen(TypescriptParser.LeftParenContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitRightParen(TypescriptParser.RightParenContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitAssignment(TypescriptParser.AssignmentContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitIsEndingLine(TypescriptParser.IsEndingLineContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitAddisionAssignment(TypescriptParser.AddisionAssignmentContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitSubtractionAssignment(TypescriptParser.SubtractionAssignmentContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitMultiplicationAssignment(TypescriptParser.MultiplicationAssignmentContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitDivisionAssignment(TypescriptParser.DivisionAssignmentContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitPowAssignment(TypescriptParser.PowAssignmentContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitPlus(TypescriptParser.PlusContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitMinus(TypescriptParser.MinusContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitMultiply(TypescriptParser.MultiplyContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitDivide(TypescriptParser.DivideContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitPow(TypescriptParser.PowContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitBreakingAnd(TypescriptParser.BreakingAndContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitBreakingOr(TypescriptParser.BreakingOrContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitNot(TypescriptParser.NotContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitLessThan(TypescriptParser.LessThanContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitMoreThan(TypescriptParser.MoreThanContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitIsDefineField(TypescriptParser.IsDefineFieldContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitFullNameOrIdentifier(TypescriptParser.FullNameOrIdentifierContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitIdentifier(TypescriptParser.IdentifierContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitFullName(TypescriptParser.FullNameContext ctx) {
        return null;
    }

    @Override
    public LanguageAst visitNumber(TypescriptParser.NumberContext ctx) {
        TypescriptNumber number = new TypescriptNumber(this.current);
        number.value(new BigDecimal(ctx.Number().getText()));
        return number;
    }

    @Override
    public LanguageAst visitBool(TypescriptParser.BoolContext ctx) {
        TypescriptBoolean number = new TypescriptBoolean(this.current);
        number.value(ctx.True() != null);
        return number;
    }
}
