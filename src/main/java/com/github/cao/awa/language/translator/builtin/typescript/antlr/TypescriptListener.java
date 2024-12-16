// Generated from D:/Codes/Java/language-translator/grammar/typescript/Typescript.g4 by ANTLR 4.13.1
package com.github.cao.awa.language.translator.builtin.typescript.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TypescriptParser}.
 */
public interface TypescriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TypescriptParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TypescriptParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#defineStatement}.
	 * @param ctx the parse tree
	 */
	void enterDefineStatement(TypescriptParser.DefineStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#defineStatement}.
	 * @param ctx the parse tree
	 */
	void exitDefineStatement(TypescriptParser.DefineStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#theStatement}.
	 * @param ctx the parse tree
	 */
	void enterTheStatement(TypescriptParser.TheStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#theStatement}.
	 * @param ctx the parse tree
	 */
	void exitTheStatement(TypescriptParser.TheStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportStatement(TypescriptParser.ImportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportStatement(TypescriptParser.ImportStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#defineFunction}.
	 * @param ctx the parse tree
	 */
	void enterDefineFunction(TypescriptParser.DefineFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#defineFunction}.
	 * @param ctx the parse tree
	 */
	void exitDefineFunction(TypescriptParser.DefineFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#defineVariableStatement}.
	 * @param ctx the parse tree
	 */
	void enterDefineVariableStatement(TypescriptParser.DefineVariableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#defineVariableStatement}.
	 * @param ctx the parse tree
	 */
	void exitDefineVariableStatement(TypescriptParser.DefineVariableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#resultPresenting}.
	 * @param ctx the parse tree
	 */
	void enterResultPresenting(TypescriptParser.ResultPresentingContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#resultPresenting}.
	 * @param ctx the parse tree
	 */
	void exitResultPresenting(TypescriptParser.ResultPresentingContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#resultingStatement}.
	 * @param ctx the parse tree
	 */
	void enterResultingStatement(TypescriptParser.ResultingStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#resultingStatement}.
	 * @param ctx the parse tree
	 */
	void exitResultingStatement(TypescriptParser.ResultingStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#ofList}.
	 * @param ctx the parse tree
	 */
	void enterOfList(TypescriptParser.OfListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#ofList}.
	 * @param ctx the parse tree
	 */
	void exitOfList(TypescriptParser.OfListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(TypescriptParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(TypescriptParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(TypescriptParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(TypescriptParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(TypescriptParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(TypescriptParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(TypescriptParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(TypescriptParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(TypescriptParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(TypescriptParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void enterForCondition(TypescriptParser.ForConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void exitForCondition(TypescriptParser.ForConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#forOp}.
	 * @param ctx the parse tree
	 */
	void enterForOp(TypescriptParser.ForOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#forOp}.
	 * @param ctx the parse tree
	 */
	void exitForOp(TypescriptParser.ForOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(TypescriptParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(TypescriptParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(TypescriptParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(TypescriptParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStatement(TypescriptParser.ElseIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStatement(TypescriptParser.ElseIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void enterStatementBlock(TypescriptParser.StatementBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void exitStatementBlock(TypescriptParser.StatementBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#variableSelfAction}.
	 * @param ctx the parse tree
	 */
	void enterVariableSelfAction(TypescriptParser.VariableSelfActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#variableSelfAction}.
	 * @param ctx the parse tree
	 */
	void exitVariableSelfAction(TypescriptParser.VariableSelfActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#variableSelfDecrement}.
	 * @param ctx the parse tree
	 */
	void enterVariableSelfDecrement(TypescriptParser.VariableSelfDecrementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#variableSelfDecrement}.
	 * @param ctx the parse tree
	 */
	void exitVariableSelfDecrement(TypescriptParser.VariableSelfDecrementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#beforeDecrement}.
	 * @param ctx the parse tree
	 */
	void enterBeforeDecrement(TypescriptParser.BeforeDecrementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#beforeDecrement}.
	 * @param ctx the parse tree
	 */
	void exitBeforeDecrement(TypescriptParser.BeforeDecrementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#afterDecrement}.
	 * @param ctx the parse tree
	 */
	void enterAfterDecrement(TypescriptParser.AfterDecrementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#afterDecrement}.
	 * @param ctx the parse tree
	 */
	void exitAfterDecrement(TypescriptParser.AfterDecrementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#variableSelfIncrement}.
	 * @param ctx the parse tree
	 */
	void enterVariableSelfIncrement(TypescriptParser.VariableSelfIncrementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#variableSelfIncrement}.
	 * @param ctx the parse tree
	 */
	void exitVariableSelfIncrement(TypescriptParser.VariableSelfIncrementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#beforeIncrement}.
	 * @param ctx the parse tree
	 */
	void enterBeforeIncrement(TypescriptParser.BeforeIncrementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#beforeIncrement}.
	 * @param ctx the parse tree
	 */
	void exitBeforeIncrement(TypescriptParser.BeforeIncrementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#afterIncrement}.
	 * @param ctx the parse tree
	 */
	void enterAfterIncrement(TypescriptParser.AfterIncrementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#afterIncrement}.
	 * @param ctx the parse tree
	 */
	void exitAfterIncrement(TypescriptParser.AfterIncrementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#callbackFunction}.
	 * @param ctx the parse tree
	 */
	void enterCallbackFunction(TypescriptParser.CallbackFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#callbackFunction}.
	 * @param ctx the parse tree
	 */
	void exitCallbackFunction(TypescriptParser.CallbackFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#callbackParamList}.
	 * @param ctx the parse tree
	 */
	void enterCallbackParamList(TypescriptParser.CallbackParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#callbackParamList}.
	 * @param ctx the parse tree
	 */
	void exitCallbackParamList(TypescriptParser.CallbackParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#callbackParam}.
	 * @param ctx the parse tree
	 */
	void enterCallbackParam(TypescriptParser.CallbackParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#callbackParam}.
	 * @param ctx the parse tree
	 */
	void exitCallbackParam(TypescriptParser.CallbackParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#anonymousObject}.
	 * @param ctx the parse tree
	 */
	void enterAnonymousObject(TypescriptParser.AnonymousObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#anonymousObject}.
	 * @param ctx the parse tree
	 */
	void exitAnonymousObject(TypescriptParser.AnonymousObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#anonymousObjectParamList}.
	 * @param ctx the parse tree
	 */
	void enterAnonymousObjectParamList(TypescriptParser.AnonymousObjectParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#anonymousObjectParamList}.
	 * @param ctx the parse tree
	 */
	void exitAnonymousObjectParamList(TypescriptParser.AnonymousObjectParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#anonymousObjectParam}.
	 * @param ctx the parse tree
	 */
	void enterAnonymousObjectParam(TypescriptParser.AnonymousObjectParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#anonymousObjectParam}.
	 * @param ctx the parse tree
	 */
	void exitAnonymousObjectParam(TypescriptParser.AnonymousObjectParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#calculatableResultPresenting}.
	 * @param ctx the parse tree
	 */
	void enterCalculatableResultPresenting(TypescriptParser.CalculatableResultPresentingContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#calculatableResultPresenting}.
	 * @param ctx the parse tree
	 */
	void exitCalculatableResultPresenting(TypescriptParser.CalculatableResultPresentingContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#calculateStatementWithParen}.
	 * @param ctx the parse tree
	 */
	void enterCalculateStatementWithParen(TypescriptParser.CalculateStatementWithParenContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#calculateStatementWithParen}.
	 * @param ctx the parse tree
	 */
	void exitCalculateStatementWithParen(TypescriptParser.CalculateStatementWithParenContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#calculateLeftStatementWithParen}.
	 * @param ctx the parse tree
	 */
	void enterCalculateLeftStatementWithParen(TypescriptParser.CalculateLeftStatementWithParenContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#calculateLeftStatementWithParen}.
	 * @param ctx the parse tree
	 */
	void exitCalculateLeftStatementWithParen(TypescriptParser.CalculateLeftStatementWithParenContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#calculateStatement}.
	 * @param ctx the parse tree
	 */
	void enterCalculateStatement(TypescriptParser.CalculateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#calculateStatement}.
	 * @param ctx the parse tree
	 */
	void exitCalculateStatement(TypescriptParser.CalculateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#calculateStatementWithTotalParen}.
	 * @param ctx the parse tree
	 */
	void enterCalculateStatementWithTotalParen(TypescriptParser.CalculateStatementWithTotalParenContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#calculateStatementWithTotalParen}.
	 * @param ctx the parse tree
	 */
	void exitCalculateStatementWithTotalParen(TypescriptParser.CalculateStatementWithTotalParenContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#calculateLeft}.
	 * @param ctx the parse tree
	 */
	void enterCalculateLeft(TypescriptParser.CalculateLeftContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#calculateLeft}.
	 * @param ctx the parse tree
	 */
	void exitCalculateLeft(TypescriptParser.CalculateLeftContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#extraCalculateStatement}.
	 * @param ctx the parse tree
	 */
	void enterExtraCalculateStatement(TypescriptParser.ExtraCalculateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#extraCalculateStatement}.
	 * @param ctx the parse tree
	 */
	void exitExtraCalculateStatement(TypescriptParser.ExtraCalculateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(TypescriptParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(TypescriptParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#invokeStatement}.
	 * @param ctx the parse tree
	 */
	void enterInvokeStatement(TypescriptParser.InvokeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#invokeStatement}.
	 * @param ctx the parse tree
	 */
	void exitInvokeStatement(TypescriptParser.InvokeStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#invokeObject}.
	 * @param ctx the parse tree
	 */
	void enterInvokeObject(TypescriptParser.InvokeObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#invokeObject}.
	 * @param ctx the parse tree
	 */
	void exitInvokeObject(TypescriptParser.InvokeObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#invokeAccess}.
	 * @param ctx the parse tree
	 */
	void enterInvokeAccess(TypescriptParser.InvokeAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#invokeAccess}.
	 * @param ctx the parse tree
	 */
	void exitInvokeAccess(TypescriptParser.InvokeAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#accessElement}.
	 * @param ctx the parse tree
	 */
	void enterAccessElement(TypescriptParser.AccessElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#accessElement}.
	 * @param ctx the parse tree
	 */
	void exitAccessElement(TypescriptParser.AccessElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#accessArray}.
	 * @param ctx the parse tree
	 */
	void enterAccessArray(TypescriptParser.AccessArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#accessArray}.
	 * @param ctx the parse tree
	 */
	void exitAccessArray(TypescriptParser.AccessArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#fluentInvokeStatement}.
	 * @param ctx the parse tree
	 */
	void enterFluentInvokeStatement(TypescriptParser.FluentInvokeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#fluentInvokeStatement}.
	 * @param ctx the parse tree
	 */
	void exitFluentInvokeStatement(TypescriptParser.FluentInvokeStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#newInstanceStatement}.
	 * @param ctx the parse tree
	 */
	void enterNewInstanceStatement(TypescriptParser.NewInstanceStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#newInstanceStatement}.
	 * @param ctx the parse tree
	 */
	void exitNewInstanceStatement(TypescriptParser.NewInstanceStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#variableName}.
	 * @param ctx the parse tree
	 */
	void enterVariableName(TypescriptParser.VariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#variableName}.
	 * @param ctx the parse tree
	 */
	void exitVariableName(TypescriptParser.VariableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(TypescriptParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(TypescriptParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#paramType}.
	 * @param ctx the parse tree
	 */
	void enterParamType(TypescriptParser.ParamTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#paramType}.
	 * @param ctx the parse tree
	 */
	void exitParamType(TypescriptParser.ParamTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#argType}.
	 * @param ctx the parse tree
	 */
	void enterArgType(TypescriptParser.ArgTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#argType}.
	 * @param ctx the parse tree
	 */
	void exitArgType(TypescriptParser.ArgTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#typedArgType}.
	 * @param ctx the parse tree
	 */
	void enterTypedArgType(TypescriptParser.TypedArgTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#typedArgType}.
	 * @param ctx the parse tree
	 */
	void exitTypedArgType(TypescriptParser.TypedArgTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#extraArgTypes}.
	 * @param ctx the parse tree
	 */
	void enterExtraArgTypes(TypescriptParser.ExtraArgTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#extraArgTypes}.
	 * @param ctx the parse tree
	 */
	void exitExtraArgTypes(TypescriptParser.ExtraArgTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#arrayArgType}.
	 * @param ctx the parse tree
	 */
	void enterArrayArgType(TypescriptParser.ArrayArgTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#arrayArgType}.
	 * @param ctx the parse tree
	 */
	void exitArrayArgType(TypescriptParser.ArrayArgTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#arrayDefinition}.
	 * @param ctx the parse tree
	 */
	void enterArrayDefinition(TypescriptParser.ArrayDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#arrayDefinition}.
	 * @param ctx the parse tree
	 */
	void exitArrayDefinition(TypescriptParser.ArrayDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#tokenList}.
	 * @param ctx the parse tree
	 */
	void enterTokenList(TypescriptParser.TokenListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#tokenList}.
	 * @param ctx the parse tree
	 */
	void exitTokenList(TypescriptParser.TokenListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#validToken}.
	 * @param ctx the parse tree
	 */
	void enterValidToken(TypescriptParser.ValidTokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#validToken}.
	 * @param ctx the parse tree
	 */
	void exitValidToken(TypescriptParser.ValidTokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#extraToken}.
	 * @param ctx the parse tree
	 */
	void enterExtraToken(TypescriptParser.ExtraTokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#extraToken}.
	 * @param ctx the parse tree
	 */
	void exitExtraToken(TypescriptParser.ExtraTokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#invokeParamList}.
	 * @param ctx the parse tree
	 */
	void enterInvokeParamList(TypescriptParser.InvokeParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#invokeParamList}.
	 * @param ctx the parse tree
	 */
	void exitInvokeParamList(TypescriptParser.InvokeParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#validInvokeParam}.
	 * @param ctx the parse tree
	 */
	void enterValidInvokeParam(TypescriptParser.ValidInvokeParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#validInvokeParam}.
	 * @param ctx the parse tree
	 */
	void exitValidInvokeParam(TypescriptParser.ValidInvokeParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#validExtraInvokeParam}.
	 * @param ctx the parse tree
	 */
	void enterValidExtraInvokeParam(TypescriptParser.ValidExtraInvokeParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#validExtraInvokeParam}.
	 * @param ctx the parse tree
	 */
	void exitValidExtraInvokeParam(TypescriptParser.ValidExtraInvokeParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(TypescriptParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(TypescriptParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#assignmentIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentIdentifier(TypescriptParser.AssignmentIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#assignmentIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentIdentifier(TypescriptParser.AssignmentIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#point}.
	 * @param ctx the parse tree
	 */
	void enterPoint(TypescriptParser.PointContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#point}.
	 * @param ctx the parse tree
	 */
	void exitPoint(TypescriptParser.PointContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#leftBrace}.
	 * @param ctx the parse tree
	 */
	void enterLeftBrace(TypescriptParser.LeftBraceContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#leftBrace}.
	 * @param ctx the parse tree
	 */
	void exitLeftBrace(TypescriptParser.LeftBraceContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#rightBrace}.
	 * @param ctx the parse tree
	 */
	void enterRightBrace(TypescriptParser.RightBraceContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#rightBrace}.
	 * @param ctx the parse tree
	 */
	void exitRightBrace(TypescriptParser.RightBraceContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#leftAngleBracket}.
	 * @param ctx the parse tree
	 */
	void enterLeftAngleBracket(TypescriptParser.LeftAngleBracketContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#leftAngleBracket}.
	 * @param ctx the parse tree
	 */
	void exitLeftAngleBracket(TypescriptParser.LeftAngleBracketContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#rightAngleBracket}.
	 * @param ctx the parse tree
	 */
	void enterRightAngleBracket(TypescriptParser.RightAngleBracketContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#rightAngleBracket}.
	 * @param ctx the parse tree
	 */
	void exitRightAngleBracket(TypescriptParser.RightAngleBracketContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#leftBracket}.
	 * @param ctx the parse tree
	 */
	void enterLeftBracket(TypescriptParser.LeftBracketContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#leftBracket}.
	 * @param ctx the parse tree
	 */
	void exitLeftBracket(TypescriptParser.LeftBracketContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#rightBracket}.
	 * @param ctx the parse tree
	 */
	void enterRightBracket(TypescriptParser.RightBracketContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#rightBracket}.
	 * @param ctx the parse tree
	 */
	void exitRightBracket(TypescriptParser.RightBracketContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#leftParenthesis}.
	 * @param ctx the parse tree
	 */
	void enterLeftParenthesis(TypescriptParser.LeftParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#leftParenthesis}.
	 * @param ctx the parse tree
	 */
	void exitLeftParenthesis(TypescriptParser.LeftParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#rightParenthesis}.
	 * @param ctx the parse tree
	 */
	void enterRightParenthesis(TypescriptParser.RightParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#rightParenthesis}.
	 * @param ctx the parse tree
	 */
	void exitRightParenthesis(TypescriptParser.RightParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#leftParen}.
	 * @param ctx the parse tree
	 */
	void enterLeftParen(TypescriptParser.LeftParenContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#leftParen}.
	 * @param ctx the parse tree
	 */
	void exitLeftParen(TypescriptParser.LeftParenContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#rightParen}.
	 * @param ctx the parse tree
	 */
	void enterRightParen(TypescriptParser.RightParenContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#rightParen}.
	 * @param ctx the parse tree
	 */
	void exitRightParen(TypescriptParser.RightParenContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(TypescriptParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(TypescriptParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#isEndingLine}.
	 * @param ctx the parse tree
	 */
	void enterIsEndingLine(TypescriptParser.IsEndingLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#isEndingLine}.
	 * @param ctx the parse tree
	 */
	void exitIsEndingLine(TypescriptParser.IsEndingLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(TypescriptParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(TypescriptParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(TypescriptParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(TypescriptParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#addisionAssignment}.
	 * @param ctx the parse tree
	 */
	void enterAddisionAssignment(TypescriptParser.AddisionAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#addisionAssignment}.
	 * @param ctx the parse tree
	 */
	void exitAddisionAssignment(TypescriptParser.AddisionAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#subtractionAssignment}.
	 * @param ctx the parse tree
	 */
	void enterSubtractionAssignment(TypescriptParser.SubtractionAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#subtractionAssignment}.
	 * @param ctx the parse tree
	 */
	void exitSubtractionAssignment(TypescriptParser.SubtractionAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#multiplicationAssignment}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationAssignment(TypescriptParser.MultiplicationAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#multiplicationAssignment}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationAssignment(TypescriptParser.MultiplicationAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#divisionAssignment}.
	 * @param ctx the parse tree
	 */
	void enterDivisionAssignment(TypescriptParser.DivisionAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#divisionAssignment}.
	 * @param ctx the parse tree
	 */
	void exitDivisionAssignment(TypescriptParser.DivisionAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#powAssignment}.
	 * @param ctx the parse tree
	 */
	void enterPowAssignment(TypescriptParser.PowAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#powAssignment}.
	 * @param ctx the parse tree
	 */
	void exitPowAssignment(TypescriptParser.PowAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#plus}.
	 * @param ctx the parse tree
	 */
	void enterPlus(TypescriptParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#plus}.
	 * @param ctx the parse tree
	 */
	void exitPlus(TypescriptParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#minus}.
	 * @param ctx the parse tree
	 */
	void enterMinus(TypescriptParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#minus}.
	 * @param ctx the parse tree
	 */
	void exitMinus(TypescriptParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#multiply}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(TypescriptParser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#multiply}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(TypescriptParser.MultiplyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#divide}.
	 * @param ctx the parse tree
	 */
	void enterDivide(TypescriptParser.DivideContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#divide}.
	 * @param ctx the parse tree
	 */
	void exitDivide(TypescriptParser.DivideContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#pow}.
	 * @param ctx the parse tree
	 */
	void enterPow(TypescriptParser.PowContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#pow}.
	 * @param ctx the parse tree
	 */
	void exitPow(TypescriptParser.PowContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(TypescriptParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(TypescriptParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#arithmetic}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic(TypescriptParser.ArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#arithmetic}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic(TypescriptParser.ArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#breakingAnd}.
	 * @param ctx the parse tree
	 */
	void enterBreakingAnd(TypescriptParser.BreakingAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#breakingAnd}.
	 * @param ctx the parse tree
	 */
	void exitBreakingAnd(TypescriptParser.BreakingAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#breakingOr}.
	 * @param ctx the parse tree
	 */
	void enterBreakingOr(TypescriptParser.BreakingOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#breakingOr}.
	 * @param ctx the parse tree
	 */
	void exitBreakingOr(TypescriptParser.BreakingOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#not}.
	 * @param ctx the parse tree
	 */
	void enterNot(TypescriptParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#not}.
	 * @param ctx the parse tree
	 */
	void exitNot(TypescriptParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#lessThan}.
	 * @param ctx the parse tree
	 */
	void enterLessThan(TypescriptParser.LessThanContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#lessThan}.
	 * @param ctx the parse tree
	 */
	void exitLessThan(TypescriptParser.LessThanContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#moreThan}.
	 * @param ctx the parse tree
	 */
	void enterMoreThan(TypescriptParser.MoreThanContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#moreThan}.
	 * @param ctx the parse tree
	 */
	void exitMoreThan(TypescriptParser.MoreThanContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#comparingAnd}.
	 * @param ctx the parse tree
	 */
	void enterComparingAnd(TypescriptParser.ComparingAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#comparingAnd}.
	 * @param ctx the parse tree
	 */
	void exitComparingAnd(TypescriptParser.ComparingAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#comparingOr}.
	 * @param ctx the parse tree
	 */
	void enterComparingOr(TypescriptParser.ComparingOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#comparingOr}.
	 * @param ctx the parse tree
	 */
	void exitComparingOr(TypescriptParser.ComparingOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#comparing}.
	 * @param ctx the parse tree
	 */
	void enterComparing(TypescriptParser.ComparingContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#comparing}.
	 * @param ctx the parse tree
	 */
	void exitComparing(TypescriptParser.ComparingContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#isDefineField}.
	 * @param ctx the parse tree
	 */
	void enterIsDefineField(TypescriptParser.IsDefineFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#isDefineField}.
	 * @param ctx the parse tree
	 */
	void exitIsDefineField(TypescriptParser.IsDefineFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#fullNameOrIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterFullNameOrIdentifier(TypescriptParser.FullNameOrIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#fullNameOrIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitFullNameOrIdentifier(TypescriptParser.FullNameOrIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(TypescriptParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(TypescriptParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#fullName}.
	 * @param ctx the parse tree
	 */
	void enterFullName(TypescriptParser.FullNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#fullName}.
	 * @param ctx the parse tree
	 */
	void exitFullName(TypescriptParser.FullNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(TypescriptParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(TypescriptParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypescriptParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(TypescriptParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypescriptParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(TypescriptParser.BoolContext ctx);
}