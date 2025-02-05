// Generated from D:/Codes/Java/structuring-translator/grammar/typescript/Typescript.g4 by ANTLR 4.13.2
package com.github.cao.awa.translator.structuring.builtin.typescript.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TypescriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TypescriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TypescriptParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#defineStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineStatement(TypescriptParser.DefineStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#theStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTheStatement(TypescriptParser.TheStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatement(TypescriptParser.ImportStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#defineFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineFunction(TypescriptParser.DefineFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#defineVariableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineVariableStatement(TypescriptParser.DefineVariableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#resultPresenting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResultPresenting(TypescriptParser.ResultPresentingContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#resultingStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResultingStatement(TypescriptParser.ResultingStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#ofList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOfList(TypescriptParser.OfListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(TypescriptParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(TypescriptParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(TypescriptParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(TypescriptParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(TypescriptParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#forCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCondition(TypescriptParser.ForConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#forOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForOp(TypescriptParser.ForOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(TypescriptParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(TypescriptParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#elseIfStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStatement(TypescriptParser.ElseIfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#statementBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(TypescriptParser.StatementBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#variableSelfAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableSelfAction(TypescriptParser.VariableSelfActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#variableSelfDecrement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableSelfDecrement(TypescriptParser.VariableSelfDecrementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#beforeDecrement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeforeDecrement(TypescriptParser.BeforeDecrementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#afterDecrement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAfterDecrement(TypescriptParser.AfterDecrementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#variableSelfIncrement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableSelfIncrement(TypescriptParser.VariableSelfIncrementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#beforeIncrement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeforeIncrement(TypescriptParser.BeforeIncrementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#afterIncrement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAfterIncrement(TypescriptParser.AfterIncrementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#callbackFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallbackFunction(TypescriptParser.CallbackFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#callbackParamList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallbackParamList(TypescriptParser.CallbackParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#callbackParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallbackParam(TypescriptParser.CallbackParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#anonymousObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousObject(TypescriptParser.AnonymousObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#anonymousObjectParamList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousObjectParamList(TypescriptParser.AnonymousObjectParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#anonymousObjectParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousObjectParam(TypescriptParser.AnonymousObjectParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#calculatableResultPresenting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculatableResultPresenting(TypescriptParser.CalculatableResultPresentingContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#calculateStatementWithParen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculateStatementWithParen(TypescriptParser.CalculateStatementWithParenContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#calculateLeftStatementWithParen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculateLeftStatementWithParen(TypescriptParser.CalculateLeftStatementWithParenContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#calculateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculateStatement(TypescriptParser.CalculateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#calculateStatementWithTotalParen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculateStatementWithTotalParen(TypescriptParser.CalculateStatementWithTotalParenContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#calculateLeft}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculateLeft(TypescriptParser.CalculateLeftContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#extraCalculateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtraCalculateStatement(TypescriptParser.ExtraCalculateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(TypescriptParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#invokeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvokeStatement(TypescriptParser.InvokeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#invokeObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvokeObject(TypescriptParser.InvokeObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#invokeAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvokeAccess(TypescriptParser.InvokeAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#accessElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessElement(TypescriptParser.AccessElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#accessArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessArray(TypescriptParser.AccessArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#fluentInvokeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFluentInvokeStatement(TypescriptParser.FluentInvokeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#newInstanceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewInstanceStatement(TypescriptParser.NewInstanceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#variableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableName(TypescriptParser.VariableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(TypescriptParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#paramType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamType(TypescriptParser.ParamTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#argType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgType(TypescriptParser.ArgTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#typedArgType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedArgType(TypescriptParser.TypedArgTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#extraArgTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtraArgTypes(TypescriptParser.ExtraArgTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#arrayArgType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayArgType(TypescriptParser.ArrayArgTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#arrayDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDefinition(TypescriptParser.ArrayDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#tokenList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTokenList(TypescriptParser.TokenListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#validToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidToken(TypescriptParser.ValidTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#extraToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtraToken(TypescriptParser.ExtraTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#invokeParamList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvokeParamList(TypescriptParser.InvokeParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#validInvokeParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidInvokeParam(TypescriptParser.ValidInvokeParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#validExtraInvokeParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidExtraInvokeParam(TypescriptParser.ValidExtraInvokeParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(TypescriptParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#assignmentIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentIdentifier(TypescriptParser.AssignmentIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#point}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoint(TypescriptParser.PointContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#leftBrace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftBrace(TypescriptParser.LeftBraceContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#rightBrace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightBrace(TypescriptParser.RightBraceContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#leftAngleBracket}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftAngleBracket(TypescriptParser.LeftAngleBracketContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#rightAngleBracket}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightAngleBracket(TypescriptParser.RightAngleBracketContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#leftBracket}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftBracket(TypescriptParser.LeftBracketContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#rightBracket}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightBracket(TypescriptParser.RightBracketContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#leftParenthesis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftParenthesis(TypescriptParser.LeftParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#rightParenthesis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightParenthesis(TypescriptParser.RightParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#leftParen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftParen(TypescriptParser.LeftParenContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#rightParen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightParen(TypescriptParser.RightParenContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(TypescriptParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#isEndingLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsEndingLine(TypescriptParser.IsEndingLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(TypescriptParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(TypescriptParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#addisionAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddisionAssignment(TypescriptParser.AddisionAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#subtractionAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtractionAssignment(TypescriptParser.SubtractionAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#multiplicationAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationAssignment(TypescriptParser.MultiplicationAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#divisionAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivisionAssignment(TypescriptParser.DivisionAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#powAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowAssignment(TypescriptParser.PowAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#plus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(TypescriptParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#minus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(TypescriptParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#multiply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(TypescriptParser.MultiplyContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#divide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivide(TypescriptParser.DivideContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#pow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(TypescriptParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(TypescriptParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#arithmetic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic(TypescriptParser.ArithmeticContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#breakingAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakingAnd(TypescriptParser.BreakingAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#breakingOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakingOr(TypescriptParser.BreakingOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(TypescriptParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#lessThan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThan(TypescriptParser.LessThanContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#moreThan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreThan(TypescriptParser.MoreThanContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#comparingAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparingAnd(TypescriptParser.ComparingAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#comparingOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparingOr(TypescriptParser.ComparingOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#comparing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparing(TypescriptParser.ComparingContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#isDefineField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsDefineField(TypescriptParser.IsDefineFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#fullNameOrIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullNameOrIdentifier(TypescriptParser.FullNameOrIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(TypescriptParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#fullName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullName(TypescriptParser.FullNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(TypescriptParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link TypescriptParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(TypescriptParser.BoolContext ctx);
}