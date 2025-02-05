package com.github.cao.awa.translator.structuring.builtin.typescript.visitor;

import com.github.cao.awa.translator.structuring.builtin.typescript.antlr.TypescriptBaseVisitor;
import com.github.cao.awa.translator.structuring.builtin.typescript.antlr.TypescriptParser;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.TypescriptFile;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.object.anonymous.TypescriptAnonymousObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.object.anonymous.TypescriptAnonymousObjectParamList;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.object.callback.TypescriptCallbackFunction;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.action.TypescriptSelfAction;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.action.TypescriptSelfDecrement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.action.TypescriptSelfIncrement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.TypescriptIf;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.TypescriptCalculate;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptOperators;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.loop.TypescriptFor;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.loop.TypescriptLoopControl;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.loop.TypescriptWhile;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.loop.control.TypescriptLoopControlType;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.function.TypescriptFunction;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.function.TypescriptParamList;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.function.TypescriptParamType;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.importing.TypescriptImportStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.TypescriptInvoke;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.TypescriptInvokeObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.access.TypescriptInvokeAccess;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.access.TypescriptInvokeAccessArray;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.access.TypescriptInvokeAccessElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.param.TypescriptInvokeParam;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.param.TypescriptInvokeParamList;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.constant.TypescriptConstant;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.constant.bool.TypescriptBoolean;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.constant.number.TypescriptNumber;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.constant.string.TypescriptString;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.constant.undefined.TypescriptNull;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.constant.undefined.TypescriptUndefined;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.instance.TypescriptNewInstanceStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.list.TypescriptOfList;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.ref.TypescriptReference;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.vararg.TypescriptArgType;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.variable.TypescriptDefineVariable;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

import java.math.BigDecimal;
import java.util.List;

public class LanguageTypescriptVisitor extends TypescriptBaseVisitor<StructuringAst> {
    private StructuringAst current;

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

        if (ctx.forStatement() != null) {
            return visitForStatement(ctx.forStatement());
        }

        if (ctx.whileStatement() != null) {
            return visitWhileStatement(ctx.whileStatement());
        }

        if (ctx.continueStatement() != null) {
            return visitContinueStatement(ctx.continueStatement());
        }

        if (ctx.breakStatement() != null) {
            return visitBreakStatement(ctx.breakStatement());
        }

        return null;
    }

    @Override
    public TypescriptStatement visitForStatement(TypescriptParser.ForStatementContext ctx) {
        TypescriptFor forStatement = new TypescriptFor(this.current);
        List<TypescriptParser.TheStatementContext> statements = ctx.defineStatement().theStatement();

        if (ctx.forInit() != null) {
            forStatement.initStatement(visitTheStatement(ctx.forInit().theStatement()));
        }

        if (ctx.forCondition() != null) {
            forStatement.condition(visitCalculateStatement(ctx.forCondition().calculateStatement()));
        }

        TypescriptParser.ForOpContext forOp = ctx.forOp();
        if (forOp != null) {
            if (forOp.calculateStatement() != null) {
                forStatement.operationStatement(visitCalculateStatement(forOp.calculateStatement()));
            } else if (forOp.variableSelfAction() != null) {
                forStatement.operationStatement(visitVariableSelfAction(forOp.variableSelfAction()));
            }
        }

        if (!statements.isEmpty()) {
            for (TypescriptParser.TheStatementContext statement : statements) {
                forStatement.addStatement(visitTheStatement(statement));
            }
        }

        return forStatement;
    }

    @Override
    public TypescriptStatement visitWhileStatement(TypescriptParser.WhileStatementContext ctx) {
        TypescriptWhile whileStatement = new TypescriptWhile(this.current);
        whileStatement.condition(visitResultPresenting(ctx.resultPresenting()));

        List<TypescriptParser.TheStatementContext> statements = ctx.theStatement();
        for (TypescriptParser.TheStatementContext statement : statements) {
            whileStatement.addStatement(visitTheStatement(statement));
        }
        return whileStatement;
    }

    @Override
    public TypescriptStatement visitContinueStatement(TypescriptParser.ContinueStatementContext ctx) {
        return new TypescriptLoopControl(this.current, TypescriptLoopControlType.CONTINUE);
    }

    @Override
    public TypescriptStatement visitBreakStatement(TypescriptParser.BreakStatementContext ctx) {
        return new TypescriptLoopControl(this.current, TypescriptLoopControlType.BREAK);
    }

    @Override
    public StructuringAst visitElseIfStatement(TypescriptParser.ElseIfStatementContext ctx) {
        return super.visitElseIfStatement(ctx);
    }

    @Override
    public StructuringAst visitElseStatement(TypescriptParser.ElseStatementContext ctx) {
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
            return TypescriptOperators.NOT;
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
            return TypescriptOperators.MORE_THAN;
        }

        if (ctx.lessThan() != null) {
            return TypescriptOperators.LESS_THAN;
        }

        if (ctx.Equals() != null) {
            return TypescriptOperators.EQUALS;
        }

        if (ctx.StricEquals() != null) {
            return TypescriptOperators.STRICT_EQUALS;
        }

        return null;
    }

    @Override
    public TypescriptSymbol visitComparingAnd(TypescriptParser.ComparingAndContext ctx) {
        if (ctx.and() != null) {
            return TypescriptOperators.AND;
        }

        if (ctx.breakingAnd() != null) {
            return TypescriptOperators.BREAKING_AND;
        }

        return null;
    }

    @Override
    public TypescriptSymbol visitComparingOr(TypescriptParser.ComparingOrContext ctx) {
        if (ctx.or() != null) {
            return TypescriptOperators.OR;
        }

        if (ctx.breakingOr() != null) {
            return TypescriptOperators.BREAKING_OR;
        }

        return null;
    }

    @Override
    public TypescriptSymbol visitArithmetic(TypescriptParser.ArithmeticContext ctx) {
        if (ctx.Plus() != null) {
            return TypescriptOperators.PLUS;
        }

        if (ctx.Minus() != null) {
            return TypescriptOperators.MINUS;
        }

        if (ctx.Multiply() != null) {
            return TypescriptOperators.MULTIPLY;
        }

        if (ctx.Divide() != null) {
            return TypescriptOperators.DIVIDE;
        }

        if (ctx.Pow() != null) {
            return TypescriptOperators.POW;
        }

        if (ctx.AddisionAssignment() != null) {
            return TypescriptOperators.ADDITION_ASSIGNMENT;
        }

        if (ctx.SubtractionAssignment() != null) {
            return TypescriptOperators.SUBTRACTION_ASSIGNMENT;
        }

        if (ctx.MultiplicationAssignment() != null) {
            return TypescriptOperators.MULTIPLICATION_ASSIGNMENT;
        }

        if (ctx.DivisionAssignment() != null) {
            return TypescriptOperators.DIVISION_ASSIGNMENT;
        }

        if (ctx.PowAssignment() != null) {
            return TypescriptOperators.POW_ASSIGNMENT;
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
    public StructuringAst visitDefineStatement(TypescriptParser.DefineStatementContext ctx) {
        TypescriptFile fileAst = (TypescriptFile) this.current;

        for (TypescriptParser.TheStatementContext theStatementContext : ctx.theStatement()) {
            fileAst.addStatement(visitTheStatement(theStatementContext));
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

        if (ctx.isDefineField() != null) {
            TypescriptParser.IsDefineFieldContext defineField = ctx.isDefineField();

            variable.isFinal(defineField.Const() != null);
        }

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

        if (ctx.ofList() != null) {
            return visitOfList(ctx.ofList());
        }

        if (ctx.newInstanceStatement() != null) {
            return visitNewInstanceStatement(ctx.newInstanceStatement());
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
    public TypescriptResultStatement visitOfList(TypescriptParser.OfListContext ctx) {
        TypescriptOfList ofList = new TypescriptOfList(this.current);
        for (TypescriptParser.ResultPresentingContext resultPresenting : ctx.resultPresenting()) {
            ofList.addElement(visitResultPresenting(resultPresenting));
        }
        return ofList;
    }

    @Override
    public TypescriptCallbackFunction visitCallbackFunction(TypescriptParser.CallbackFunctionContext ctx) {
        TypescriptCallbackFunction function = new TypescriptCallbackFunction(this.current);
        if (ctx.callbackParamList() != null) {
            function.params(visitCallbackParamList(ctx.callbackParamList()));
        }
        for (TypescriptParser.TheStatementContext statementContext : ctx.defineStatement().theStatement()) {
            function.addStatement(visitTheStatement(statementContext));
        }
        return function;
    }

    @Override
    public TypescriptParamList visitCallbackParamList(TypescriptParser.CallbackParamListContext ctx) {
        TypescriptParamList params = new TypescriptParamList(this.current);
        for (TypescriptParser.CallbackParamContext callbackParam : ctx.callbackParam()) {
            params.addArg(visitCallbackParam(callbackParam));
        }
        return params;
    }

    @Override
    public TypescriptParamType visitCallbackParam(TypescriptParser.CallbackParamContext ctx) {
        TypescriptParamType param = new TypescriptParamType(this.current);
        param.name(ctx.identifier().getText());
        param.typeRequired(false);

        if (ctx.argType() != null) {
            param.type(visitArgType(ctx.argType()));
        }
        return param;
    }

    @Override
    public TypescriptAnonymousObject visitAnonymousObject(TypescriptParser.AnonymousObjectContext ctx) {
        TypescriptAnonymousObject object = new TypescriptAnonymousObject(this.current);

        if (ctx.anonymousObjectParamList() != null) {
            object.params(visitAnonymousObjectParamList(ctx.anonymousObjectParamList()));
        }

        return object;
    }

    @Override
    public TypescriptAnonymousObjectParamList visitAnonymousObjectParamList(TypescriptParser.AnonymousObjectParamListContext ctx) {
        TypescriptAnonymousObjectParamList params = new TypescriptAnonymousObjectParamList(this.current);

        if (ctx.anonymousObjectParam() != null) {
        for (TypescriptParser.AnonymousObjectParamContext objectParams : ctx.anonymousObjectParam()) {
            params.addValue(objectParams.identifier().getText(), visitResultPresenting(objectParams.resultPresenting()));
        }
        }

        return params;
    }

    @Override
    public StructuringAst visitExtraCalculateStatement(TypescriptParser.ExtraCalculateStatementContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitReturnStatement(TypescriptParser.ReturnStatementContext ctx) {
        return null;
    }

    @Override
    public TypescriptInvoke visitInvokeStatement(TypescriptParser.InvokeStatementContext ctx) {
        TypescriptInvoke invoke = new TypescriptInvoke(this.current);
        invoke.invokeTarget(visitInvokeObject(ctx.invokeObject()));

        if (ctx.invokeParamList() != null) {
            invoke.params(visitInvokeParamList(ctx.invokeParamList()));
        }

        if (!ctx.fluentInvokeStatement().isEmpty()) {
            for (TypescriptParser.FluentInvokeStatementContext fluentInvokeStatement : ctx.fluentInvokeStatement()) {
                invoke.addFluentInvoke(visitFluentInvokeStatement(fluentInvokeStatement));
            }
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
    public TypescriptInvoke visitFluentInvokeStatement(TypescriptParser.FluentInvokeStatementContext ctx) {
        TypescriptInvoke invoke = new TypescriptInvoke(this.current);

        if (ctx.invokeParamList() != null) {
            invoke.params(visitInvokeParamList(ctx.invokeParamList()));
        }

        invoke.invokeTarget(
                new TypescriptInvokeObject(this.current).addAccess(
                        new TypescriptInvokeAccessElement(this.current).target(
                                ctx.identifier().getText()
                        )
                )
        );

        invoke.fluent(true);

        invoke.isEnding(false);

        return invoke;
    }

    @Override
    public TypescriptNewInstanceStatement visitNewInstanceStatement(TypescriptParser.NewInstanceStatementContext ctx) {
        TypescriptNewInstanceStatement newInstanceStatement = new TypescriptNewInstanceStatement(this.current);
        newInstanceStatement.type(visitArgType(ctx.argType()));
        if (ctx.invokeParamList() != null) {
            newInstanceStatement.paramList(visitInvokeParamList(ctx.invokeParamList()));
        }
        return newInstanceStatement;
    }

    @Override
    public StructuringAst visitVariableName(TypescriptParser.VariableNameContext ctx) {
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
    public StructuringAst visitTypedArgType(TypescriptParser.TypedArgTypeContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitExtraArgTypes(TypescriptParser.ExtraArgTypesContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitArrayArgType(TypescriptParser.ArrayArgTypeContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitArrayDefinition(TypescriptParser.ArrayDefinitionContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitTokenList(TypescriptParser.TokenListContext ctx) {
        return null;
    }

    @Override
    public TypescriptResultStatement visitValidToken(TypescriptParser.ValidTokenContext ctx) {
        if (ctx.constant() != null) {
            return visitConstant(ctx.constant());
        }

        if (ctx.identifier() != null) {
            TypescriptReference reference = new TypescriptReference(this.current);
            reference.name(ctx.identifier().getText());
            return reference;
        }
        return null;
    }

    @Override
    public StructuringAst visitExtraToken(TypescriptParser.ExtraTokenContext ctx) {
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
            param.result(visitValidToken(ctx.validToken()));
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
    public StructuringAst visitPoint(TypescriptParser.PointContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitLeftBrace(TypescriptParser.LeftBraceContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitRightBrace(TypescriptParser.RightBraceContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitLeftAngleBracket(TypescriptParser.LeftAngleBracketContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitRightAngleBracket(TypescriptParser.RightAngleBracketContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitLeftBracket(TypescriptParser.LeftBracketContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitRightBracket(TypescriptParser.RightBracketContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitLeftParenthesis(TypescriptParser.LeftParenthesisContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitRightParenthesis(TypescriptParser.RightParenthesisContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitLeftParen(TypescriptParser.LeftParenContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitRightParen(TypescriptParser.RightParenContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitAssignment(TypescriptParser.AssignmentContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitIsEndingLine(TypescriptParser.IsEndingLineContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitAddisionAssignment(TypescriptParser.AddisionAssignmentContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitSubtractionAssignment(TypescriptParser.SubtractionAssignmentContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitMultiplicationAssignment(TypescriptParser.MultiplicationAssignmentContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitDivisionAssignment(TypescriptParser.DivisionAssignmentContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitPowAssignment(TypescriptParser.PowAssignmentContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitPlus(TypescriptParser.PlusContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitMinus(TypescriptParser.MinusContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitMultiply(TypescriptParser.MultiplyContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitDivide(TypescriptParser.DivideContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitPow(TypescriptParser.PowContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitBreakingAnd(TypescriptParser.BreakingAndContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitBreakingOr(TypescriptParser.BreakingOrContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitNot(TypescriptParser.NotContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitLessThan(TypescriptParser.LessThanContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitMoreThan(TypescriptParser.MoreThanContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitIsDefineField(TypescriptParser.IsDefineFieldContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitFullNameOrIdentifier(TypescriptParser.FullNameOrIdentifierContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitIdentifier(TypescriptParser.IdentifierContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitFullName(TypescriptParser.FullNameContext ctx) {
        return null;
    }

    @Override
    public StructuringAst visitNumber(TypescriptParser.NumberContext ctx) {
        TypescriptNumber number = new TypescriptNumber(this.current);
        number.value(new BigDecimal(ctx.Number().getText()));
        return number;
    }

    @Override
    public StructuringAst visitBool(TypescriptParser.BoolContext ctx) {
        TypescriptBoolean number = new TypescriptBoolean(this.current);
        number.value(ctx.True() != null);
        return number;
    }
}
