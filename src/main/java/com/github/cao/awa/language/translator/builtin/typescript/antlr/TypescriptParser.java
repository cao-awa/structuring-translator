// Generated from D:/Codes/Java/language-translator/grammar/typescript/Typescript.g4 by ANTLR 4.13.1
package com.github.cao.awa.language.translator.builtin.typescript.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TypescriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, BLOCK_COMMENT=2, WHITESPACES=3, String=4, Point=5, LeftBrace=6, 
		RightBrace=7, LeftAngleBracket=8, RightAngleBracket=9, LeftBracket=10, 
		RightBracket=11, LeftParenthesis=12, RightParenthesis=13, StricEquals=14, 
		Equals=15, Equal=16, CallbackAssigment=17, Null=18, Undefined=19, Colon=20, 
		Semicolon=21, Comma=22, Var=23, Let=24, Const=25, True=26, False=27, Function=28, 
		Import=29, From=30, New=31, If=32, Else=33, Return=34, AndSign=35, OrSign=36, 
		Decrement=37, Increment=38, AddisionAssignment=39, SubtractionAssignment=40, 
		MultiplicationAssignment=41, DivisionAssignment=42, PowAssignment=43, 
		Plus=44, Minus=45, Multiply=46, Divide=47, Pow=48, BreakingAndSign=49, 
		BreakingOrSign=50, Not=51, Identifier=52, FullName=53, Number=54;
	public static final int
		RULE_program = 0, RULE_defineStatement = 1, RULE_theStatement = 2, RULE_importStatement = 3, 
		RULE_defineFunction = 4, RULE_defineVariableStatement = 5, RULE_resultPresenting = 6, 
		RULE_resultingStatement = 7, RULE_ofList = 8, RULE_ifStatement = 9, RULE_elseStatement = 10, 
		RULE_elseIfStatement = 11, RULE_statementBlock = 12, RULE_variableSelfAction = 13, 
		RULE_variableSelfDecrement = 14, RULE_beforeDecrement = 15, RULE_afterDecrement = 16, 
		RULE_variableSelfIncrement = 17, RULE_beforeIncrement = 18, RULE_afterIncrement = 19, 
		RULE_callbackFunction = 20, RULE_callbackParamList = 21, RULE_callbackParam = 22, 
		RULE_anonymousObject = 23, RULE_anonymousObjectParamList = 24, RULE_anonymousObjectParam = 25, 
		RULE_calculatableResultPresenting = 26, RULE_calculateStatementWithParen = 27, 
		RULE_calculateLeftStatementWithParen = 28, RULE_calculateStatement = 29, 
		RULE_calculateStatementWithTotalParen = 30, RULE_calculateLeft = 31, RULE_extraCalculateStatement = 32, 
		RULE_returnStatement = 33, RULE_invokeStatement = 34, RULE_invokeObject = 35, 
		RULE_invokeAccess = 36, RULE_accessElement = 37, RULE_accessArray = 38, 
		RULE_fluentInvokeStatement = 39, RULE_newInstanceStatement = 40, RULE_variableName = 41, 
		RULE_paramList = 42, RULE_paramType = 43, RULE_argType = 44, RULE_typedArgType = 45, 
		RULE_extraArgTypes = 46, RULE_arrayArgType = 47, RULE_arrayDefinition = 48, 
		RULE_tokenList = 49, RULE_validToken = 50, RULE_extraToken = 51, RULE_invokeParamList = 52, 
		RULE_validInvokeParam = 53, RULE_validExtraInvokeParam = 54, RULE_constant = 55, 
		RULE_assignmentIdentifier = 56, RULE_point = 57, RULE_leftBrace = 58, 
		RULE_rightBrace = 59, RULE_leftAngleBracket = 60, RULE_rightAngleBracket = 61, 
		RULE_leftBracket = 62, RULE_rightBracket = 63, RULE_leftParenthesis = 64, 
		RULE_rightParenthesis = 65, RULE_leftParen = 66, RULE_rightParen = 67, 
		RULE_assignment = 68, RULE_isEndingLine = 69, RULE_and = 70, RULE_or = 71, 
		RULE_addisionAssignment = 72, RULE_subtractionAssignment = 73, RULE_multiplicationAssignment = 74, 
		RULE_divisionAssignment = 75, RULE_powAssignment = 76, RULE_plus = 77, 
		RULE_minus = 78, RULE_multiply = 79, RULE_divide = 80, RULE_pow = 81, 
		RULE_operator = 82, RULE_arithmetic = 83, RULE_breakingAnd = 84, RULE_breakingOr = 85, 
		RULE_not = 86, RULE_lessThan = 87, RULE_moreThan = 88, RULE_comparingAnd = 89, 
		RULE_comparingOr = 90, RULE_comparing = 91, RULE_isDefineField = 92, RULE_fullNameOrIdentifier = 93, 
		RULE_identifier = 94, RULE_fullName = 95, RULE_number = 96, RULE_bool = 97;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "defineStatement", "theStatement", "importStatement", "defineFunction", 
			"defineVariableStatement", "resultPresenting", "resultingStatement", 
			"ofList", "ifStatement", "elseStatement", "elseIfStatement", "statementBlock", 
			"variableSelfAction", "variableSelfDecrement", "beforeDecrement", "afterDecrement", 
			"variableSelfIncrement", "beforeIncrement", "afterIncrement", "callbackFunction", 
			"callbackParamList", "callbackParam", "anonymousObject", "anonymousObjectParamList", 
			"anonymousObjectParam", "calculatableResultPresenting", "calculateStatementWithParen", 
			"calculateLeftStatementWithParen", "calculateStatement", "calculateStatementWithTotalParen", 
			"calculateLeft", "extraCalculateStatement", "returnStatement", "invokeStatement", 
			"invokeObject", "invokeAccess", "accessElement", "accessArray", "fluentInvokeStatement", 
			"newInstanceStatement", "variableName", "paramList", "paramType", "argType", 
			"typedArgType", "extraArgTypes", "arrayArgType", "arrayDefinition", "tokenList", 
			"validToken", "extraToken", "invokeParamList", "validInvokeParam", "validExtraInvokeParam", 
			"constant", "assignmentIdentifier", "point", "leftBrace", "rightBrace", 
			"leftAngleBracket", "rightAngleBracket", "leftBracket", "rightBracket", 
			"leftParenthesis", "rightParenthesis", "leftParen", "rightParen", "assignment", 
			"isEndingLine", "and", "or", "addisionAssignment", "subtractionAssignment", 
			"multiplicationAssignment", "divisionAssignment", "powAssignment", "plus", 
			"minus", "multiply", "divide", "pow", "operator", "arithmetic", "breakingAnd", 
			"breakingOr", "not", "lessThan", "moreThan", "comparingAnd", "comparingOr", 
			"comparing", "isDefineField", "fullNameOrIdentifier", "identifier", "fullName", 
			"number", "bool"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'.'", "'{'", "'}'", "'<'", "'>'", "'['", 
			"']'", "'('", "')'", "'==='", "'=='", "'='", "'=>'", "'null'", "'undefined'", 
			"':'", "';'", "','", "'var'", "'let'", "'const'", "'true'", "'false'", 
			"'function'", "'import'", "'from'", "'new'", "'if'", "'else'", "'return'", 
			"'&'", "'|'", "'--'", "'++'", "'+='", "'-='", "'*='", "'/='", "'^='", 
			"'+'", "'-'", "'*'", "'/'", "'^'", "'&&'", "'||'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LINE_COMMENT", "BLOCK_COMMENT", "WHITESPACES", "String", "Point", 
			"LeftBrace", "RightBrace", "LeftAngleBracket", "RightAngleBracket", "LeftBracket", 
			"RightBracket", "LeftParenthesis", "RightParenthesis", "StricEquals", 
			"Equals", "Equal", "CallbackAssigment", "Null", "Undefined", "Colon", 
			"Semicolon", "Comma", "Var", "Let", "Const", "True", "False", "Function", 
			"Import", "From", "New", "If", "Else", "Return", "AndSign", "OrSign", 
			"Decrement", "Increment", "AddisionAssignment", "SubtractionAssignment", 
			"MultiplicationAssignment", "DivisionAssignment", "PowAssignment", "Plus", 
			"Minus", "Multiply", "Divide", "Pow", "BreakingAndSign", "BreakingOrSign", 
			"Not", "Identifier", "FullName", "Number"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Typescript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TypescriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public DefineStatementContext defineStatement() {
			return getRuleContext(DefineStatementContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			defineStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefineStatementContext extends ParserRuleContext {
		public List<TheStatementContext> theStatement() {
			return getRuleContexts(TheStatementContext.class);
		}
		public TheStatementContext theStatement(int i) {
			return getRuleContext(TheStatementContext.class,i);
		}
		public DefineStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterDefineStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitDefineStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitDefineStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineStatementContext defineStatement() throws RecognitionException {
		DefineStatementContext _localctx = new DefineStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_defineStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 13511216357965856L) != 0)) {
				{
				setState(199); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(198);
					theStatement();
					}
					}
					setState(201); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 13511216357965856L) != 0) );
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TheStatementContext extends ParserRuleContext {
		public IsEndingLineContext isEndingLine() {
			return getRuleContext(IsEndingLineContext.class,0);
		}
		public ImportStatementContext importStatement() {
			return getRuleContext(ImportStatementContext.class,0);
		}
		public DefineVariableStatementContext defineVariableStatement() {
			return getRuleContext(DefineVariableStatementContext.class,0);
		}
		public InvokeStatementContext invokeStatement() {
			return getRuleContext(InvokeStatementContext.class,0);
		}
		public VariableSelfActionContext variableSelfAction() {
			return getRuleContext(VariableSelfActionContext.class,0);
		}
		public DefineFunctionContext defineFunction() {
			return getRuleContext(DefineFunctionContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public TheStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_theStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterTheStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitTheStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitTheStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TheStatementContext theStatement() throws RecognitionException {
		TheStatementContext _localctx = new TheStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_theStatement);
		try {
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Point:
			case Var:
			case Let:
			case Const:
			case Import:
			case Decrement:
			case Increment:
			case Identifier:
			case FullName:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(209);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(205);
					importStatement();
					}
					break;
				case 2:
					{
					setState(206);
					defineVariableStatement();
					}
					break;
				case 3:
					{
					setState(207);
					invokeStatement();
					}
					break;
				case 4:
					{
					setState(208);
					variableSelfAction();
					}
					break;
				}
				setState(211);
				isEndingLine();
				}
				}
				break;
			case Function:
			case If:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Function:
					{
					setState(213);
					defineFunction();
					}
					break;
				case If:
					{
					setState(214);
					ifStatement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportStatementContext extends ParserRuleContext {
		public TerminalNode Import() { return getToken(TypescriptParser.Import, 0); }
		public LeftBraceContext leftBrace() {
			return getRuleContext(LeftBraceContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public RightBraceContext rightBrace() {
			return getRuleContext(RightBraceContext.class,0);
		}
		public TerminalNode From() { return getToken(TypescriptParser.From, 0); }
		public TerminalNode String() { return getToken(TypescriptParser.String, 0); }
		public List<TerminalNode> Comma() { return getTokens(TypescriptParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(TypescriptParser.Comma, i);
		}
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterImportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitImportStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitImportStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(Import);
			setState(220);
			leftBrace();
			setState(221);
			identifier();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(224); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(222);
					match(Comma);
					setState(223);
					identifier();
					}
					}
					setState(226); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Comma );
				}
			}

			setState(230);
			rightBrace();
			setState(231);
			match(From);
			setState(232);
			match(String);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefineFunctionContext extends ParserRuleContext {
		public TerminalNode Function() { return getToken(TypescriptParser.Function, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LeftParenContext leftParen() {
			return getRuleContext(LeftParenContext.class,0);
		}
		public RightParenContext rightParen() {
			return getRuleContext(RightParenContext.class,0);
		}
		public LeftBraceContext leftBrace() {
			return getRuleContext(LeftBraceContext.class,0);
		}
		public DefineStatementContext defineStatement() {
			return getRuleContext(DefineStatementContext.class,0);
		}
		public RightBraceContext rightBrace() {
			return getRuleContext(RightBraceContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public TerminalNode Colon() { return getToken(TypescriptParser.Colon, 0); }
		public ArgTypeContext argType() {
			return getRuleContext(ArgTypeContext.class,0);
		}
		public DefineFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterDefineFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitDefineFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitDefineFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineFunctionContext defineFunction() throws RecognitionException {
		DefineFunctionContext _localctx = new DefineFunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_defineFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(Function);
			setState(235);
			identifier();
			setState(236);
			leftParen();
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(237);
				paramList();
				}
			}

			setState(240);
			rightParen();
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Colon) {
				{
				setState(241);
				match(Colon);
				setState(242);
				argType();
				}
			}

			setState(245);
			leftBrace();
			setState(246);
			defineStatement();
			setState(247);
			rightBrace();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefineVariableStatementContext extends ParserRuleContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public IsDefineFieldContext isDefineField() {
			return getRuleContext(IsDefineFieldContext.class,0);
		}
		public TerminalNode Colon() { return getToken(TypescriptParser.Colon, 0); }
		public ArgTypeContext argType() {
			return getRuleContext(ArgTypeContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ResultPresentingContext resultPresenting() {
			return getRuleContext(ResultPresentingContext.class,0);
		}
		public AssignmentIdentifierContext assignmentIdentifier() {
			return getRuleContext(AssignmentIdentifierContext.class,0);
		}
		public LeftBracketContext leftBracket() {
			return getRuleContext(LeftBracketContext.class,0);
		}
		public RightBracketContext rightBracket() {
			return getRuleContext(RightBracketContext.class,0);
		}
		public DefineVariableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineVariableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterDefineVariableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitDefineVariableStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitDefineVariableStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineVariableStatementContext defineVariableStatement() throws RecognitionException {
		DefineVariableStatementContext _localctx = new DefineVariableStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_defineVariableStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 58720256L) != 0)) {
				{
				setState(249);
				isDefineField();
				}
			}

			setState(252);
			variableName();
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(253);
					match(Colon);
					setState(254);
					argType();
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LeftBracket) {
						{
						setState(255);
						leftBracket();
						setState(256);
						rightBracket();
						}
					}

					}
				}

				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Equal) {
					{
					setState(262);
					assignment();
					setState(265);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						setState(263);
						resultPresenting();
						}
						break;
					case 2:
						{
						setState(264);
						assignmentIdentifier();
						}
						break;
					}
					}
				}

				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ResultPresentingContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FullNameContext fullName() {
			return getRuleContext(FullNameContext.class,0);
		}
		public ResultingStatementContext resultingStatement() {
			return getRuleContext(ResultingStatementContext.class,0);
		}
		public ResultPresentingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resultPresenting; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterResultPresenting(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitResultPresenting(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitResultPresenting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResultPresentingContext resultPresenting() throws RecognitionException {
		ResultPresentingContext _localctx = new ResultPresentingContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_resultPresenting);
		try {
			setState(275);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				constant();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(273);
				fullName();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(274);
				resultingStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ResultingStatementContext extends ParserRuleContext {
		public InvokeStatementContext invokeStatement() {
			return getRuleContext(InvokeStatementContext.class,0);
		}
		public NewInstanceStatementContext newInstanceStatement() {
			return getRuleContext(NewInstanceStatementContext.class,0);
		}
		public CalculateStatementContext calculateStatement() {
			return getRuleContext(CalculateStatementContext.class,0);
		}
		public AnonymousObjectContext anonymousObject() {
			return getRuleContext(AnonymousObjectContext.class,0);
		}
		public CallbackFunctionContext callbackFunction() {
			return getRuleContext(CallbackFunctionContext.class,0);
		}
		public VariableSelfActionContext variableSelfAction() {
			return getRuleContext(VariableSelfActionContext.class,0);
		}
		public OfListContext ofList() {
			return getRuleContext(OfListContext.class,0);
		}
		public ResultingStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resultingStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterResultingStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitResultingStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitResultingStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResultingStatementContext resultingStatement() throws RecognitionException {
		ResultingStatementContext _localctx = new ResultingStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_resultingStatement);
		try {
			setState(284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				invokeStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				newInstanceStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(279);
				calculateStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(280);
				anonymousObject();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(281);
				callbackFunction();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(282);
				variableSelfAction();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(283);
				ofList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OfListContext extends ParserRuleContext {
		public LeftBracketContext leftBracket() {
			return getRuleContext(LeftBracketContext.class,0);
		}
		public RightBracketContext rightBracket() {
			return getRuleContext(RightBracketContext.class,0);
		}
		public List<ResultPresentingContext> resultPresenting() {
			return getRuleContexts(ResultPresentingContext.class);
		}
		public ResultPresentingContext resultPresenting(int i) {
			return getRuleContext(ResultPresentingContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(TypescriptParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(TypescriptParser.Comma, i);
		}
		public OfListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ofList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterOfList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitOfList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitOfList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OfListContext ofList() throws RecognitionException {
		OfListContext _localctx = new OfListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ofList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			leftBracket();
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31525612062250096L) != 0)) {
				{
				{
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(287);
					match(Comma);
					}
				}

				setState(290);
				resultPresenting();
				setState(292);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(291);
					match(Comma);
					}
					break;
				}
				}
				}
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(299);
			rightBracket();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(TypescriptParser.If, 0); }
		public LeftParenContext leftParen() {
			return getRuleContext(LeftParenContext.class,0);
		}
		public RightParenContext rightParen() {
			return getRuleContext(RightParenContext.class,0);
		}
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public ResultPresentingContext resultPresenting() {
			return getRuleContext(ResultPresentingContext.class,0);
		}
		public CalculateStatementContext calculateStatement() {
			return getRuleContext(CalculateStatementContext.class,0);
		}
		public ElseIfStatementContext elseIfStatement() {
			return getRuleContext(ElseIfStatementContext.class,0);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(If);
			setState(302);
			leftParen();
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(303);
				resultPresenting();
				}
				break;
			case 2:
				{
				setState(304);
				calculateStatement();
				}
				break;
			}
			setState(307);
			rightParen();
			setState(308);
			statementBlock();
			setState(311);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				{
				setState(309);
				elseIfStatement();
				}
				}
				break;
			case 2:
				{
				{
				setState(310);
				elseStatement();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(TypescriptParser.Else, 0); }
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(Else);
			setState(314);
			statementBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseIfStatementContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(TypescriptParser.Else, 0); }
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ElseIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterElseIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitElseIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitElseIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfStatementContext elseIfStatement() throws RecognitionException {
		ElseIfStatementContext _localctx = new ElseIfStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_elseIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			match(Else);
			setState(317);
			ifStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementBlockContext extends ParserRuleContext {
		public LeftBraceContext leftBrace() {
			return getRuleContext(LeftBraceContext.class,0);
		}
		public RightBraceContext rightBrace() {
			return getRuleContext(RightBraceContext.class,0);
		}
		public DefineStatementContext defineStatement() {
			return getRuleContext(DefineStatementContext.class,0);
		}
		public StatementBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterStatementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitStatementBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitStatementBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementBlockContext statementBlock() throws RecognitionException {
		StatementBlockContext _localctx = new StatementBlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statementBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			leftBrace();
			{
			setState(320);
			defineStatement();
			}
			setState(321);
			rightBrace();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableSelfActionContext extends ParserRuleContext {
		public VariableSelfDecrementContext variableSelfDecrement() {
			return getRuleContext(VariableSelfDecrementContext.class,0);
		}
		public VariableSelfIncrementContext variableSelfIncrement() {
			return getRuleContext(VariableSelfIncrementContext.class,0);
		}
		public VariableSelfActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableSelfAction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterVariableSelfAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitVariableSelfAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitVariableSelfAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableSelfActionContext variableSelfAction() throws RecognitionException {
		VariableSelfActionContext _localctx = new VariableSelfActionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variableSelfAction);
		try {
			setState(325);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				variableSelfDecrement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
				variableSelfIncrement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableSelfDecrementContext extends ParserRuleContext {
		public InvokeAccessContext invokeAccess() {
			return getRuleContext(InvokeAccessContext.class,0);
		}
		public BeforeDecrementContext beforeDecrement() {
			return getRuleContext(BeforeDecrementContext.class,0);
		}
		public AfterDecrementContext afterDecrement() {
			return getRuleContext(AfterDecrementContext.class,0);
		}
		public VariableSelfDecrementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableSelfDecrement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterVariableSelfDecrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitVariableSelfDecrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitVariableSelfDecrement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableSelfDecrementContext variableSelfDecrement() throws RecognitionException {
		VariableSelfDecrementContext _localctx = new VariableSelfDecrementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_variableSelfDecrement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Decrement) {
				{
				setState(327);
				beforeDecrement();
				}
			}

			setState(330);
			invokeAccess();
			setState(332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(331);
				afterDecrement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BeforeDecrementContext extends ParserRuleContext {
		public TerminalNode Decrement() { return getToken(TypescriptParser.Decrement, 0); }
		public BeforeDecrementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beforeDecrement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterBeforeDecrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitBeforeDecrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitBeforeDecrement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeforeDecrementContext beforeDecrement() throws RecognitionException {
		BeforeDecrementContext _localctx = new BeforeDecrementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_beforeDecrement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(Decrement);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AfterDecrementContext extends ParserRuleContext {
		public TerminalNode Decrement() { return getToken(TypescriptParser.Decrement, 0); }
		public AfterDecrementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_afterDecrement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterAfterDecrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitAfterDecrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitAfterDecrement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AfterDecrementContext afterDecrement() throws RecognitionException {
		AfterDecrementContext _localctx = new AfterDecrementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_afterDecrement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(Decrement);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableSelfIncrementContext extends ParserRuleContext {
		public InvokeAccessContext invokeAccess() {
			return getRuleContext(InvokeAccessContext.class,0);
		}
		public BeforeIncrementContext beforeIncrement() {
			return getRuleContext(BeforeIncrementContext.class,0);
		}
		public AfterIncrementContext afterIncrement() {
			return getRuleContext(AfterIncrementContext.class,0);
		}
		public VariableSelfIncrementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableSelfIncrement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterVariableSelfIncrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitVariableSelfIncrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitVariableSelfIncrement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableSelfIncrementContext variableSelfIncrement() throws RecognitionException {
		VariableSelfIncrementContext _localctx = new VariableSelfIncrementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_variableSelfIncrement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Increment) {
				{
				setState(338);
				beforeIncrement();
				}
			}

			setState(341);
			invokeAccess();
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(342);
				afterIncrement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BeforeIncrementContext extends ParserRuleContext {
		public TerminalNode Increment() { return getToken(TypescriptParser.Increment, 0); }
		public BeforeIncrementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beforeIncrement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterBeforeIncrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitBeforeIncrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitBeforeIncrement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeforeIncrementContext beforeIncrement() throws RecognitionException {
		BeforeIncrementContext _localctx = new BeforeIncrementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_beforeIncrement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(Increment);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AfterIncrementContext extends ParserRuleContext {
		public TerminalNode Increment() { return getToken(TypescriptParser.Increment, 0); }
		public AfterIncrementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_afterIncrement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterAfterIncrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitAfterIncrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitAfterIncrement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AfterIncrementContext afterIncrement() throws RecognitionException {
		AfterIncrementContext _localctx = new AfterIncrementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_afterIncrement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			match(Increment);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallbackFunctionContext extends ParserRuleContext {
		public TerminalNode CallbackAssigment() { return getToken(TypescriptParser.CallbackAssigment, 0); }
		public LeftBraceContext leftBrace() {
			return getRuleContext(LeftBraceContext.class,0);
		}
		public DefineStatementContext defineStatement() {
			return getRuleContext(DefineStatementContext.class,0);
		}
		public RightBraceContext rightBrace() {
			return getRuleContext(RightBraceContext.class,0);
		}
		public CallbackParamContext callbackParam() {
			return getRuleContext(CallbackParamContext.class,0);
		}
		public LeftParenContext leftParen() {
			return getRuleContext(LeftParenContext.class,0);
		}
		public RightParenContext rightParen() {
			return getRuleContext(RightParenContext.class,0);
		}
		public CallbackParamListContext callbackParamList() {
			return getRuleContext(CallbackParamListContext.class,0);
		}
		public CallbackFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callbackFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterCallbackFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitCallbackFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitCallbackFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallbackFunctionContext callbackFunction() throws RecognitionException {
		CallbackFunctionContext _localctx = new CallbackFunctionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_callbackFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParenthesis:
				{
				{
				setState(349);
				leftParen();
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(350);
					callbackParamList();
					}
				}

				setState(353);
				rightParen();
				}
				}
				break;
			case Identifier:
				{
				setState(355);
				callbackParam();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(358);
			match(CallbackAssigment);
			setState(359);
			leftBrace();
			setState(360);
			defineStatement();
			setState(361);
			rightBrace();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallbackParamListContext extends ParserRuleContext {
		public List<CallbackParamContext> callbackParam() {
			return getRuleContexts(CallbackParamContext.class);
		}
		public CallbackParamContext callbackParam(int i) {
			return getRuleContext(CallbackParamContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(TypescriptParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(TypescriptParser.Comma, i);
		}
		public CallbackParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callbackParamList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterCallbackParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitCallbackParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitCallbackParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallbackParamListContext callbackParamList() throws RecognitionException {
		CallbackParamListContext _localctx = new CallbackParamListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_callbackParamList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			callbackParam();
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(364);
				match(Comma);
				setState(365);
				callbackParam();
				}
				}
				setState(370);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallbackParamContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Colon() { return getToken(TypescriptParser.Colon, 0); }
		public ArgTypeContext argType() {
			return getRuleContext(ArgTypeContext.class,0);
		}
		public CallbackParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callbackParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterCallbackParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitCallbackParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitCallbackParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallbackParamContext callbackParam() throws RecognitionException {
		CallbackParamContext _localctx = new CallbackParamContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_callbackParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			identifier();
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Colon) {
				{
				setState(372);
				match(Colon);
				setState(373);
				argType();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnonymousObjectContext extends ParserRuleContext {
		public LeftBraceContext leftBrace() {
			return getRuleContext(LeftBraceContext.class,0);
		}
		public RightBraceContext rightBrace() {
			return getRuleContext(RightBraceContext.class,0);
		}
		public AnonymousObjectParamListContext anonymousObjectParamList() {
			return getRuleContext(AnonymousObjectParamListContext.class,0);
		}
		public AnonymousObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymousObject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterAnonymousObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitAnonymousObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitAnonymousObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnonymousObjectContext anonymousObject() throws RecognitionException {
		AnonymousObjectContext _localctx = new AnonymousObjectContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_anonymousObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			leftBrace();
			{
			setState(377);
			anonymousObjectParamList();
			}
			setState(378);
			rightBrace();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnonymousObjectParamListContext extends ParserRuleContext {
		public List<AnonymousObjectParamContext> anonymousObjectParam() {
			return getRuleContexts(AnonymousObjectParamContext.class);
		}
		public AnonymousObjectParamContext anonymousObjectParam(int i) {
			return getRuleContext(AnonymousObjectParamContext.class,i);
		}
		public AnonymousObjectParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymousObjectParamList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterAnonymousObjectParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitAnonymousObjectParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitAnonymousObjectParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnonymousObjectParamListContext anonymousObjectParamList() throws RecognitionException {
		AnonymousObjectParamListContext _localctx = new AnonymousObjectParamListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_anonymousObjectParamList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(380);
				anonymousObjectParam();
				}
				}
				setState(383); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnonymousObjectParamContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Colon() { return getToken(TypescriptParser.Colon, 0); }
		public ResultPresentingContext resultPresenting() {
			return getRuleContext(ResultPresentingContext.class,0);
		}
		public TerminalNode Comma() { return getToken(TypescriptParser.Comma, 0); }
		public AnonymousObjectParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymousObjectParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterAnonymousObjectParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitAnonymousObjectParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitAnonymousObjectParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnonymousObjectParamContext anonymousObjectParam() throws RecognitionException {
		AnonymousObjectParamContext _localctx = new AnonymousObjectParamContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_anonymousObjectParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			identifier();
			setState(386);
			match(Colon);
			setState(387);
			resultPresenting();
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(388);
				match(Comma);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CalculatableResultPresentingContext extends ParserRuleContext {
		public CalculateStatementWithParenContext calculateStatementWithParen() {
			return getRuleContext(CalculateStatementWithParenContext.class,0);
		}
		public InvokeStatementContext invokeStatement() {
			return getRuleContext(InvokeStatementContext.class,0);
		}
		public NewInstanceStatementContext newInstanceStatement() {
			return getRuleContext(NewInstanceStatementContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FullNameContext fullName() {
			return getRuleContext(FullNameContext.class,0);
		}
		public CalculatableResultPresentingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calculatableResultPresenting; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterCalculatableResultPresenting(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitCalculatableResultPresenting(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitCalculatableResultPresenting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalculatableResultPresentingContext calculatableResultPresenting() throws RecognitionException {
		CalculatableResultPresentingContext _localctx = new CalculatableResultPresentingContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_calculatableResultPresenting);
		try {
			setState(397);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(391);
				calculateStatementWithParen();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(392);
				invokeStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(393);
				newInstanceStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(394);
				constant();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(395);
				identifier();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(396);
				fullName();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CalculateStatementWithParenContext extends ParserRuleContext {
		public LeftParenContext leftParen() {
			return getRuleContext(LeftParenContext.class,0);
		}
		public RightParenContext rightParen() {
			return getRuleContext(RightParenContext.class,0);
		}
		public CalculateLeftStatementWithParenContext calculateLeftStatementWithParen() {
			return getRuleContext(CalculateLeftStatementWithParenContext.class,0);
		}
		public List<ExtraCalculateStatementContext> extraCalculateStatement() {
			return getRuleContexts(ExtraCalculateStatementContext.class);
		}
		public ExtraCalculateStatementContext extraCalculateStatement(int i) {
			return getRuleContext(ExtraCalculateStatementContext.class,i);
		}
		public CalculateStatementWithParenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calculateStatementWithParen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterCalculateStatementWithParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitCalculateStatementWithParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitCalculateStatementWithParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalculateStatementWithParenContext calculateStatementWithParen() throws RecognitionException {
		CalculateStatementWithParenContext _localctx = new CalculateStatementWithParenContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_calculateStatementWithParen);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			leftParen();
			{
			setState(400);
			calculateLeftStatementWithParen();
			}
			setState(401);
			rightParen();
			setState(405);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(402);
					extraCalculateStatement();
					}
					} 
				}
				setState(407);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CalculateLeftStatementWithParenContext extends ParserRuleContext {
		public CalculateStatementContext calculateStatement() {
			return getRuleContext(CalculateStatementContext.class,0);
		}
		public CalculatableResultPresentingContext calculatableResultPresenting() {
			return getRuleContext(CalculatableResultPresentingContext.class,0);
		}
		public CalculateLeftStatementWithParenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calculateLeftStatementWithParen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterCalculateLeftStatementWithParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitCalculateLeftStatementWithParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitCalculateLeftStatementWithParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalculateLeftStatementWithParenContext calculateLeftStatementWithParen() throws RecognitionException {
		CalculateLeftStatementWithParenContext _localctx = new CalculateLeftStatementWithParenContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_calculateLeftStatementWithParen);
		try {
			setState(410);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(408);
				calculateStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(409);
				calculatableResultPresenting();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CalculateStatementContext extends ParserRuleContext {
		public CalculateLeftContext calculateLeft() {
			return getRuleContext(CalculateLeftContext.class,0);
		}
		public List<ExtraCalculateStatementContext> extraCalculateStatement() {
			return getRuleContexts(ExtraCalculateStatementContext.class);
		}
		public ExtraCalculateStatementContext extraCalculateStatement(int i) {
			return getRuleContext(ExtraCalculateStatementContext.class,i);
		}
		public CalculateStatementWithTotalParenContext calculateStatementWithTotalParen() {
			return getRuleContext(CalculateStatementWithTotalParenContext.class,0);
		}
		public CalculateStatementWithParenContext calculateStatementWithParen() {
			return getRuleContext(CalculateStatementWithParenContext.class,0);
		}
		public CalculateStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calculateStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterCalculateStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitCalculateStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitCalculateStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalculateStatementContext calculateStatement() throws RecognitionException {
		CalculateStatementContext _localctx = new CalculateStatementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_calculateStatement);
		int _la;
		try {
			setState(427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(412);
				calculateLeft();
				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503152950821632L) != 0)) {
					{
					{
					setState(413);
					extraCalculateStatement();
					}
					}
					setState(418);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(419);
				calculateStatementWithTotalParen();
				setState(423);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503152950821632L) != 0)) {
					{
					{
					setState(420);
					extraCalculateStatement();
					}
					}
					setState(425);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(426);
				calculateStatementWithParen();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CalculateStatementWithTotalParenContext extends ParserRuleContext {
		public LeftParenContext leftParen() {
			return getRuleContext(LeftParenContext.class,0);
		}
		public CalculateLeftContext calculateLeft() {
			return getRuleContext(CalculateLeftContext.class,0);
		}
		public RightParenContext rightParen() {
			return getRuleContext(RightParenContext.class,0);
		}
		public List<ExtraCalculateStatementContext> extraCalculateStatement() {
			return getRuleContexts(ExtraCalculateStatementContext.class);
		}
		public ExtraCalculateStatementContext extraCalculateStatement(int i) {
			return getRuleContext(ExtraCalculateStatementContext.class,i);
		}
		public CalculateStatementWithTotalParenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calculateStatementWithTotalParen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterCalculateStatementWithTotalParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitCalculateStatementWithTotalParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitCalculateStatementWithTotalParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalculateStatementWithTotalParenContext calculateStatementWithTotalParen() throws RecognitionException {
		CalculateStatementWithTotalParenContext _localctx = new CalculateStatementWithTotalParenContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_calculateStatementWithTotalParen);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			leftParen();
			setState(430);
			calculateLeft();
			setState(434);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503152950821632L) != 0)) {
				{
				{
				setState(431);
				extraCalculateStatement();
				}
				}
				setState(436);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(437);
			rightParen();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CalculateLeftContext extends ParserRuleContext {
		public CalculatableResultPresentingContext calculatableResultPresenting() {
			return getRuleContext(CalculatableResultPresentingContext.class,0);
		}
		public CalculateLeftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calculateLeft; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterCalculateLeft(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitCalculateLeft(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitCalculateLeft(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalculateLeftContext calculateLeft() throws RecognitionException {
		CalculateLeftContext _localctx = new CalculateLeftContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_calculateLeft);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			calculatableResultPresenting();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExtraCalculateStatementContext extends ParserRuleContext {
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public CalculatableResultPresentingContext calculatableResultPresenting() {
			return getRuleContext(CalculatableResultPresentingContext.class,0);
		}
		public ExtraCalculateStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extraCalculateStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterExtraCalculateStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitExtraCalculateStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitExtraCalculateStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtraCalculateStatementContext extraCalculateStatement() throws RecognitionException {
		ExtraCalculateStatementContext _localctx = new ExtraCalculateStatementContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_extraCalculateStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(441);
			operator();
			setState(442);
			calculatableResultPresenting();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(TypescriptParser.Return, 0); }
		public ResultPresentingContext resultPresenting() {
			return getRuleContext(ResultPresentingContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			match(Return);
			setState(445);
			resultPresenting();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InvokeStatementContext extends ParserRuleContext {
		public InvokeObjectContext invokeObject() {
			return getRuleContext(InvokeObjectContext.class,0);
		}
		public LeftParenContext leftParen() {
			return getRuleContext(LeftParenContext.class,0);
		}
		public RightParenContext rightParen() {
			return getRuleContext(RightParenContext.class,0);
		}
		public InvokeParamListContext invokeParamList() {
			return getRuleContext(InvokeParamListContext.class,0);
		}
		public List<FluentInvokeStatementContext> fluentInvokeStatement() {
			return getRuleContexts(FluentInvokeStatementContext.class);
		}
		public FluentInvokeStatementContext fluentInvokeStatement(int i) {
			return getRuleContext(FluentInvokeStatementContext.class,i);
		}
		public InvokeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invokeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterInvokeStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitInvokeStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitInvokeStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvokeStatementContext invokeStatement() throws RecognitionException {
		InvokeStatementContext _localctx = new InvokeStatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_invokeStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			invokeObject();
			setState(448);
			leftParen();
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31525612058055792L) != 0)) {
				{
				setState(449);
				invokeParamList();
				}
			}

			setState(452);
			rightParen();
			setState(456);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(453);
					fluentInvokeStatement();
					}
					} 
				}
				setState(458);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InvokeObjectContext extends ParserRuleContext {
		public List<InvokeAccessContext> invokeAccess() {
			return getRuleContexts(InvokeAccessContext.class);
		}
		public InvokeAccessContext invokeAccess(int i) {
			return getRuleContext(InvokeAccessContext.class,i);
		}
		public InvokeObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invokeObject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterInvokeObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitInvokeObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitInvokeObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvokeObjectContext invokeObject() throws RecognitionException {
		InvokeObjectContext _localctx = new InvokeObjectContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_invokeObject);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(459);
				invokeAccess();
				}
				}
				setState(462); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 13510798882111520L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InvokeAccessContext extends ParserRuleContext {
		public AccessArrayContext accessArray() {
			return getRuleContext(AccessArrayContext.class,0);
		}
		public AccessElementContext accessElement() {
			return getRuleContext(AccessElementContext.class,0);
		}
		public InvokeAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invokeAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterInvokeAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitInvokeAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitInvokeAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvokeAccessContext invokeAccess() throws RecognitionException {
		InvokeAccessContext _localctx = new InvokeAccessContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_invokeAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(464);
				accessArray();
				}
				break;
			case 2:
				{
				setState(465);
				accessElement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AccessElementContext extends ParserRuleContext {
		public FullNameOrIdentifierContext fullNameOrIdentifier() {
			return getRuleContext(FullNameOrIdentifierContext.class,0);
		}
		public TerminalNode Point() { return getToken(TypescriptParser.Point, 0); }
		public AccessElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterAccessElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitAccessElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitAccessElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessElementContext accessElement() throws RecognitionException {
		AccessElementContext _localctx = new AccessElementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_accessElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Point) {
				{
				setState(468);
				match(Point);
				}
			}

			setState(471);
			fullNameOrIdentifier();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AccessArrayContext extends ParserRuleContext {
		public AccessElementContext accessElement() {
			return getRuleContext(AccessElementContext.class,0);
		}
		public LeftBracketContext leftBracket() {
			return getRuleContext(LeftBracketContext.class,0);
		}
		public ResultPresentingContext resultPresenting() {
			return getRuleContext(ResultPresentingContext.class,0);
		}
		public RightBracketContext rightBracket() {
			return getRuleContext(RightBracketContext.class,0);
		}
		public AccessArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterAccessArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitAccessArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitAccessArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessArrayContext accessArray() throws RecognitionException {
		AccessArrayContext _localctx = new AccessArrayContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_accessArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(473);
			accessElement();
			setState(474);
			leftBracket();
			setState(475);
			resultPresenting();
			setState(476);
			rightBracket();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FluentInvokeStatementContext extends ParserRuleContext {
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LeftParenContext leftParen() {
			return getRuleContext(LeftParenContext.class,0);
		}
		public RightParenContext rightParen() {
			return getRuleContext(RightParenContext.class,0);
		}
		public InvokeParamListContext invokeParamList() {
			return getRuleContext(InvokeParamListContext.class,0);
		}
		public FluentInvokeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fluentInvokeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterFluentInvokeStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitFluentInvokeStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitFluentInvokeStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FluentInvokeStatementContext fluentInvokeStatement() throws RecognitionException {
		FluentInvokeStatementContext _localctx = new FluentInvokeStatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_fluentInvokeStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			point();
			setState(479);
			identifier();
			setState(480);
			leftParen();
			setState(482);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31525612058055792L) != 0)) {
				{
				setState(481);
				invokeParamList();
				}
			}

			setState(484);
			rightParen();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NewInstanceStatementContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(TypescriptParser.New, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LeftParenContext leftParen() {
			return getRuleContext(LeftParenContext.class,0);
		}
		public RightParenContext rightParen() {
			return getRuleContext(RightParenContext.class,0);
		}
		public InvokeParamListContext invokeParamList() {
			return getRuleContext(InvokeParamListContext.class,0);
		}
		public NewInstanceStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newInstanceStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterNewInstanceStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitNewInstanceStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitNewInstanceStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewInstanceStatementContext newInstanceStatement() throws RecognitionException {
		NewInstanceStatementContext _localctx = new NewInstanceStatementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_newInstanceStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			match(New);
			setState(487);
			identifier();
			setState(488);
			leftParen();
			setState(490);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31525612058055792L) != 0)) {
				{
				setState(489);
				invokeParamList();
				}
			}

			setState(492);
			rightParen();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FullNameContext fullName() {
			return getRuleContext(FullNameContext.class,0);
		}
		public VariableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterVariableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitVariableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitVariableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableNameContext variableName() throws RecognitionException {
		VariableNameContext _localctx = new VariableNameContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_variableName);
		try {
			setState(496);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(494);
				identifier();
				}
				break;
			case FullName:
				enterOuterAlt(_localctx, 2);
				{
				setState(495);
				fullName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends ParserRuleContext {
		public List<ParamTypeContext> paramType() {
			return getRuleContexts(ParamTypeContext.class);
		}
		public ParamTypeContext paramType(int i) {
			return getRuleContext(ParamTypeContext.class,i);
		}
		public TerminalNode Comma() { return getToken(TypescriptParser.Comma, 0); }
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			paramType();
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(499);
				match(Comma);
				setState(500);
				paramType();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamTypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Colon() { return getToken(TypescriptParser.Colon, 0); }
		public ArgTypeContext argType() {
			return getRuleContext(ArgTypeContext.class,0);
		}
		public ParamTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterParamType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitParamType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitParamType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamTypeContext paramType() throws RecognitionException {
		ParamTypeContext _localctx = new ParamTypeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_paramType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			identifier();
			setState(504);
			match(Colon);
			setState(505);
			argType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgTypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypedArgTypeContext typedArgType() {
			return getRuleContext(TypedArgTypeContext.class,0);
		}
		public ArrayArgTypeContext arrayArgType() {
			return getRuleContext(ArrayArgTypeContext.class,0);
		}
		public ArgTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterArgType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitArgType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitArgType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgTypeContext argType() throws RecognitionException {
		ArgTypeContext _localctx = new ArgTypeContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_argType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			identifier();
			setState(509);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftAngleBracket) {
				{
				setState(508);
				typedArgType();
				}
			}

			setState(512);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				setState(511);
				arrayArgType();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypedArgTypeContext extends ParserRuleContext {
		public LeftAngleBracketContext leftAngleBracket() {
			return getRuleContext(LeftAngleBracketContext.class,0);
		}
		public ArgTypeContext argType() {
			return getRuleContext(ArgTypeContext.class,0);
		}
		public RightAngleBracketContext rightAngleBracket() {
			return getRuleContext(RightAngleBracketContext.class,0);
		}
		public List<ExtraArgTypesContext> extraArgTypes() {
			return getRuleContexts(ExtraArgTypesContext.class);
		}
		public ExtraArgTypesContext extraArgTypes(int i) {
			return getRuleContext(ExtraArgTypesContext.class,i);
		}
		public TypedArgTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedArgType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterTypedArgType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitTypedArgType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitTypedArgType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedArgTypeContext typedArgType() throws RecognitionException {
		TypedArgTypeContext _localctx = new TypedArgTypeContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_typedArgType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			leftAngleBracket();
			setState(515);
			argType();
			setState(519);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(516);
				extraArgTypes();
				}
				}
				setState(521);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(522);
			rightAngleBracket();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExtraArgTypesContext extends ParserRuleContext {
		public TerminalNode Comma() { return getToken(TypescriptParser.Comma, 0); }
		public ArgTypeContext argType() {
			return getRuleContext(ArgTypeContext.class,0);
		}
		public ExtraArgTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extraArgTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterExtraArgTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitExtraArgTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitExtraArgTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtraArgTypesContext extraArgTypes() throws RecognitionException {
		ExtraArgTypesContext _localctx = new ExtraArgTypesContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_extraArgTypes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			match(Comma);
			setState(525);
			argType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayArgTypeContext extends ParserRuleContext {
		public List<ArrayDefinitionContext> arrayDefinition() {
			return getRuleContexts(ArrayDefinitionContext.class);
		}
		public ArrayDefinitionContext arrayDefinition(int i) {
			return getRuleContext(ArrayDefinitionContext.class,i);
		}
		public ArrayArgTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayArgType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterArrayArgType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitArrayArgType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitArrayArgType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayArgTypeContext arrayArgType() throws RecognitionException {
		ArrayArgTypeContext _localctx = new ArrayArgTypeContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_arrayArgType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(527);
					arrayDefinition();
					}
					} 
				}
				setState(532);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayDefinitionContext extends ParserRuleContext {
		public LeftBracketContext leftBracket() {
			return getRuleContext(LeftBracketContext.class,0);
		}
		public RightBracketContext rightBracket() {
			return getRuleContext(RightBracketContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ArrayDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterArrayDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitArrayDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitArrayDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDefinitionContext arrayDefinition() throws RecognitionException {
		ArrayDefinitionContext _localctx = new ArrayDefinitionContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_arrayDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533);
			leftBracket();
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Number) {
				{
				setState(534);
				number();
				}
			}

			setState(537);
			rightBracket();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TokenListContext extends ParserRuleContext {
		public ValidTokenContext validToken() {
			return getRuleContext(ValidTokenContext.class,0);
		}
		public List<ExtraTokenContext> extraToken() {
			return getRuleContexts(ExtraTokenContext.class);
		}
		public ExtraTokenContext extraToken(int i) {
			return getRuleContext(ExtraTokenContext.class,i);
		}
		public TokenListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterTokenList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitTokenList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitTokenList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenListContext tokenList() throws RecognitionException {
		TokenListContext _localctx = new TokenListContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_tokenList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			validToken();
			setState(543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(540);
				extraToken();
				}
				}
				setState(545);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValidTokenContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ValidTokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_validToken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterValidToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitValidToken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitValidToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValidTokenContext validToken() throws RecognitionException {
		ValidTokenContext _localctx = new ValidTokenContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_validToken);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(546);
				identifier();
				}
				break;
			case String:
			case Null:
			case Undefined:
			case True:
			case False:
			case Number:
				{
				setState(547);
				constant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExtraTokenContext extends ParserRuleContext {
		public TerminalNode Comma() { return getToken(TypescriptParser.Comma, 0); }
		public ValidTokenContext validToken() {
			return getRuleContext(ValidTokenContext.class,0);
		}
		public ExtraTokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extraToken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterExtraToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitExtraToken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitExtraToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtraTokenContext extraToken() throws RecognitionException {
		ExtraTokenContext _localctx = new ExtraTokenContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_extraToken);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			match(Comma);
			setState(551);
			validToken();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InvokeParamListContext extends ParserRuleContext {
		public ValidInvokeParamContext validInvokeParam() {
			return getRuleContext(ValidInvokeParamContext.class,0);
		}
		public List<ValidExtraInvokeParamContext> validExtraInvokeParam() {
			return getRuleContexts(ValidExtraInvokeParamContext.class);
		}
		public ValidExtraInvokeParamContext validExtraInvokeParam(int i) {
			return getRuleContext(ValidExtraInvokeParamContext.class,i);
		}
		public InvokeParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invokeParamList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterInvokeParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitInvokeParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitInvokeParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvokeParamListContext invokeParamList() throws RecognitionException {
		InvokeParamListContext _localctx = new InvokeParamListContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_invokeParamList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			validInvokeParam();
			setState(557);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(554);
				validExtraInvokeParam();
				}
				}
				setState(559);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValidInvokeParamContext extends ParserRuleContext {
		public ValidTokenContext validToken() {
			return getRuleContext(ValidTokenContext.class,0);
		}
		public ResultPresentingContext resultPresenting() {
			return getRuleContext(ResultPresentingContext.class,0);
		}
		public ValidInvokeParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_validInvokeParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterValidInvokeParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitValidInvokeParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitValidInvokeParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValidInvokeParamContext validInvokeParam() throws RecognitionException {
		ValidInvokeParamContext _localctx = new ValidInvokeParamContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_validInvokeParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(560);
				validToken();
				}
				break;
			case 2:
				{
				setState(561);
				resultPresenting();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValidExtraInvokeParamContext extends ParserRuleContext {
		public TerminalNode Comma() { return getToken(TypescriptParser.Comma, 0); }
		public ValidInvokeParamContext validInvokeParam() {
			return getRuleContext(ValidInvokeParamContext.class,0);
		}
		public ValidExtraInvokeParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_validExtraInvokeParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterValidExtraInvokeParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitValidExtraInvokeParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitValidExtraInvokeParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValidExtraInvokeParamContext validExtraInvokeParam() throws RecognitionException {
		ValidExtraInvokeParamContext _localctx = new ValidExtraInvokeParamContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_validExtraInvokeParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			match(Comma);
			setState(566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31525612058055792L) != 0)) {
				{
				setState(565);
				validInvokeParam();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(TypescriptParser.String, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode Null() { return getToken(TypescriptParser.Null, 0); }
		public TerminalNode Undefined() { return getToken(TypescriptParser.Undefined, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(573);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case String:
				{
				setState(568);
				match(String);
				}
				break;
			case Number:
				{
				setState(569);
				number();
				}
				break;
			case Null:
				{
				setState(570);
				match(Null);
				}
				break;
			case Undefined:
				{
				setState(571);
				match(Undefined);
				}
				break;
			case True:
			case False:
				{
				setState(572);
				bool();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentIdentifierContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AssignmentIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterAssignmentIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitAssignmentIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitAssignmentIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentIdentifierContext assignmentIdentifier() throws RecognitionException {
		AssignmentIdentifierContext _localctx = new AssignmentIdentifierContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_assignmentIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointContext extends ParserRuleContext {
		public TerminalNode Point() { return getToken(TypescriptParser.Point, 0); }
		public PointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_point; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterPoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitPoint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitPoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointContext point() throws RecognitionException {
		PointContext _localctx = new PointContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_point);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577);
			match(Point);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LeftBraceContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(TypescriptParser.LeftBrace, 0); }
		public LeftBraceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftBrace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterLeftBrace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitLeftBrace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitLeftBrace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftBraceContext leftBrace() throws RecognitionException {
		LeftBraceContext _localctx = new LeftBraceContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_leftBrace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
			match(LeftBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RightBraceContext extends ParserRuleContext {
		public TerminalNode RightBrace() { return getToken(TypescriptParser.RightBrace, 0); }
		public RightBraceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightBrace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterRightBrace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitRightBrace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitRightBrace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightBraceContext rightBrace() throws RecognitionException {
		RightBraceContext _localctx = new RightBraceContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_rightBrace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(581);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LeftAngleBracketContext extends ParserRuleContext {
		public TerminalNode LeftAngleBracket() { return getToken(TypescriptParser.LeftAngleBracket, 0); }
		public LeftAngleBracketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftAngleBracket; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterLeftAngleBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitLeftAngleBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitLeftAngleBracket(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftAngleBracketContext leftAngleBracket() throws RecognitionException {
		LeftAngleBracketContext _localctx = new LeftAngleBracketContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_leftAngleBracket);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			match(LeftAngleBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RightAngleBracketContext extends ParserRuleContext {
		public TerminalNode RightAngleBracket() { return getToken(TypescriptParser.RightAngleBracket, 0); }
		public RightAngleBracketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightAngleBracket; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterRightAngleBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitRightAngleBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitRightAngleBracket(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightAngleBracketContext rightAngleBracket() throws RecognitionException {
		RightAngleBracketContext _localctx = new RightAngleBracketContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_rightAngleBracket);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585);
			match(RightAngleBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LeftBracketContext extends ParserRuleContext {
		public TerminalNode LeftBracket() { return getToken(TypescriptParser.LeftBracket, 0); }
		public LeftBracketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftBracket; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterLeftBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitLeftBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitLeftBracket(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftBracketContext leftBracket() throws RecognitionException {
		LeftBracketContext _localctx = new LeftBracketContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_leftBracket);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			match(LeftBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RightBracketContext extends ParserRuleContext {
		public TerminalNode RightBracket() { return getToken(TypescriptParser.RightBracket, 0); }
		public RightBracketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightBracket; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterRightBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitRightBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitRightBracket(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightBracketContext rightBracket() throws RecognitionException {
		RightBracketContext _localctx = new RightBracketContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_rightBracket);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LeftParenthesisContext extends ParserRuleContext {
		public TerminalNode LeftParenthesis() { return getToken(TypescriptParser.LeftParenthesis, 0); }
		public LeftParenthesisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftParenthesis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterLeftParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitLeftParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitLeftParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftParenthesisContext leftParenthesis() throws RecognitionException {
		LeftParenthesisContext _localctx = new LeftParenthesisContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_leftParenthesis);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591);
			match(LeftParenthesis);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RightParenthesisContext extends ParserRuleContext {
		public TerminalNode RightParenthesis() { return getToken(TypescriptParser.RightParenthesis, 0); }
		public RightParenthesisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightParenthesis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterRightParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitRightParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitRightParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightParenthesisContext rightParenthesis() throws RecognitionException {
		RightParenthesisContext _localctx = new RightParenthesisContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_rightParenthesis);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			match(RightParenthesis);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LeftParenContext extends ParserRuleContext {
		public TerminalNode LeftParenthesis() { return getToken(TypescriptParser.LeftParenthesis, 0); }
		public LeftParenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftParen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterLeftParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitLeftParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitLeftParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftParenContext leftParen() throws RecognitionException {
		LeftParenContext _localctx = new LeftParenContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_leftParen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			match(LeftParenthesis);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RightParenContext extends ParserRuleContext {
		public TerminalNode RightParenthesis() { return getToken(TypescriptParser.RightParenthesis, 0); }
		public RightParenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightParen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterRightParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitRightParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitRightParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightParenContext rightParen() throws RecognitionException {
		RightParenContext _localctx = new RightParenContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_rightParen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
			match(RightParenthesis);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode Equal() { return getToken(TypescriptParser.Equal, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			match(Equal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IsEndingLineContext extends ParserRuleContext {
		public TerminalNode Semicolon() { return getToken(TypescriptParser.Semicolon, 0); }
		public IsEndingLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isEndingLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterIsEndingLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitIsEndingLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitIsEndingLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IsEndingLineContext isEndingLine() throws RecognitionException {
		IsEndingLineContext _localctx = new IsEndingLineContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_isEndingLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AndContext extends ParserRuleContext {
		public TerminalNode AndSign() { return getToken(TypescriptParser.AndSign, 0); }
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			match(AndSign);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OrContext extends ParserRuleContext {
		public TerminalNode OrSign() { return getToken(TypescriptParser.OrSign, 0); }
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			match(OrSign);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddisionAssignmentContext extends ParserRuleContext {
		public TerminalNode AddisionAssignment() { return getToken(TypescriptParser.AddisionAssignment, 0); }
		public AddisionAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addisionAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterAddisionAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitAddisionAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitAddisionAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddisionAssignmentContext addisionAssignment() throws RecognitionException {
		AddisionAssignmentContext _localctx = new AddisionAssignmentContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_addisionAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			match(AddisionAssignment);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubtractionAssignmentContext extends ParserRuleContext {
		public TerminalNode SubtractionAssignment() { return getToken(TypescriptParser.SubtractionAssignment, 0); }
		public SubtractionAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subtractionAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterSubtractionAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitSubtractionAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitSubtractionAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubtractionAssignmentContext subtractionAssignment() throws RecognitionException {
		SubtractionAssignmentContext _localctx = new SubtractionAssignmentContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_subtractionAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
			match(SubtractionAssignment);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicationAssignmentContext extends ParserRuleContext {
		public TerminalNode MultiplicationAssignment() { return getToken(TypescriptParser.MultiplicationAssignment, 0); }
		public MultiplicationAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicationAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterMultiplicationAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitMultiplicationAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitMultiplicationAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicationAssignmentContext multiplicationAssignment() throws RecognitionException {
		MultiplicationAssignmentContext _localctx = new MultiplicationAssignmentContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_multiplicationAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611);
			match(MultiplicationAssignment);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DivisionAssignmentContext extends ParserRuleContext {
		public TerminalNode DivisionAssignment() { return getToken(TypescriptParser.DivisionAssignment, 0); }
		public DivisionAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_divisionAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterDivisionAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitDivisionAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitDivisionAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivisionAssignmentContext divisionAssignment() throws RecognitionException {
		DivisionAssignmentContext _localctx = new DivisionAssignmentContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_divisionAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(613);
			match(DivisionAssignment);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PowAssignmentContext extends ParserRuleContext {
		public TerminalNode PowAssignment() { return getToken(TypescriptParser.PowAssignment, 0); }
		public PowAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_powAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterPowAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitPowAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitPowAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowAssignmentContext powAssignment() throws RecognitionException {
		PowAssignmentContext _localctx = new PowAssignmentContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_powAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(615);
			match(PowAssignment);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PlusContext extends ParserRuleContext {
		public TerminalNode Plus() { return getToken(TypescriptParser.Plus, 0); }
		public PlusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlusContext plus() throws RecognitionException {
		PlusContext _localctx = new PlusContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_plus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			match(Plus);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MinusContext extends ParserRuleContext {
		public TerminalNode Minus() { return getToken(TypescriptParser.Minus, 0); }
		public MinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MinusContext minus() throws RecognitionException {
		MinusContext _localctx = new MinusContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_minus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			match(Minus);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplyContext extends ParserRuleContext {
		public TerminalNode Multiply() { return getToken(TypescriptParser.Multiply, 0); }
		public MultiplyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiply; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterMultiply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitMultiply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitMultiply(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplyContext multiply() throws RecognitionException {
		MultiplyContext _localctx = new MultiplyContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_multiply);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621);
			match(Multiply);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DivideContext extends ParserRuleContext {
		public TerminalNode Divide() { return getToken(TypescriptParser.Divide, 0); }
		public DivideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_divide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterDivide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitDivide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitDivide(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivideContext divide() throws RecognitionException {
		DivideContext _localctx = new DivideContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_divide);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			match(Divide);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PowContext extends ParserRuleContext {
		public TerminalNode Pow() { return getToken(TypescriptParser.Pow, 0); }
		public PowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterPow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitPow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitPow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowContext pow() throws RecognitionException {
		PowContext _localctx = new PowContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_pow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			match(Pow);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorContext extends ParserRuleContext {
		public ArithmeticContext arithmetic() {
			return getRuleContext(ArithmeticContext.class,0);
		}
		public ComparingContext comparing() {
			return getRuleContext(ComparingContext.class,0);
		}
		public NotContext not() {
			return getRuleContext(NotContext.class,0);
		}
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_operator);
		try {
			setState(630);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AddisionAssignment:
			case SubtractionAssignment:
			case MultiplicationAssignment:
			case DivisionAssignment:
			case PowAssignment:
			case Plus:
			case Minus:
			case Multiply:
			case Divide:
			case Pow:
				enterOuterAlt(_localctx, 1);
				{
				setState(627);
				arithmetic();
				}
				break;
			case LeftAngleBracket:
			case RightAngleBracket:
			case StricEquals:
			case Equals:
			case AndSign:
			case OrSign:
			case BreakingAndSign:
			case BreakingOrSign:
				enterOuterAlt(_localctx, 2);
				{
				setState(628);
				comparing();
				}
				break;
			case Not:
				enterOuterAlt(_localctx, 3);
				{
				setState(629);
				not();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticContext extends ParserRuleContext {
		public TerminalNode AddisionAssignment() { return getToken(TypescriptParser.AddisionAssignment, 0); }
		public TerminalNode SubtractionAssignment() { return getToken(TypescriptParser.SubtractionAssignment, 0); }
		public TerminalNode MultiplicationAssignment() { return getToken(TypescriptParser.MultiplicationAssignment, 0); }
		public TerminalNode DivisionAssignment() { return getToken(TypescriptParser.DivisionAssignment, 0); }
		public TerminalNode PowAssignment() { return getToken(TypescriptParser.PowAssignment, 0); }
		public TerminalNode Plus() { return getToken(TypescriptParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(TypescriptParser.Minus, 0); }
		public TerminalNode Multiply() { return getToken(TypescriptParser.Multiply, 0); }
		public TerminalNode Divide() { return getToken(TypescriptParser.Divide, 0); }
		public TerminalNode Pow() { return getToken(TypescriptParser.Pow, 0); }
		public ArithmeticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterArithmetic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitArithmetic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitArithmetic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticContext arithmetic() throws RecognitionException {
		ArithmeticContext _localctx = new ArithmeticContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_arithmetic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(632);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 562400197607424L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BreakingAndContext extends ParserRuleContext {
		public TerminalNode BreakingAndSign() { return getToken(TypescriptParser.BreakingAndSign, 0); }
		public BreakingAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakingAnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterBreakingAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitBreakingAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitBreakingAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakingAndContext breakingAnd() throws RecognitionException {
		BreakingAndContext _localctx = new BreakingAndContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_breakingAnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634);
			match(BreakingAndSign);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BreakingOrContext extends ParserRuleContext {
		public TerminalNode BreakingOrSign() { return getToken(TypescriptParser.BreakingOrSign, 0); }
		public BreakingOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakingOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterBreakingOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitBreakingOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitBreakingOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakingOrContext breakingOr() throws RecognitionException {
		BreakingOrContext _localctx = new BreakingOrContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_breakingOr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			match(BreakingOrSign);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends ParserRuleContext {
		public TerminalNode Not() { return getToken(TypescriptParser.Not, 0); }
		public NotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotContext not() throws RecognitionException {
		NotContext _localctx = new NotContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_not);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(638);
			match(Not);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LessThanContext extends ParserRuleContext {
		public TerminalNode LeftAngleBracket() { return getToken(TypescriptParser.LeftAngleBracket, 0); }
		public LessThanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lessThan; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterLessThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitLessThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitLessThan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LessThanContext lessThan() throws RecognitionException {
		LessThanContext _localctx = new LessThanContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_lessThan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640);
			match(LeftAngleBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MoreThanContext extends ParserRuleContext {
		public TerminalNode RightAngleBracket() { return getToken(TypescriptParser.RightAngleBracket, 0); }
		public MoreThanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moreThan; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterMoreThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitMoreThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitMoreThan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoreThanContext moreThan() throws RecognitionException {
		MoreThanContext _localctx = new MoreThanContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_moreThan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(642);
			match(RightAngleBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparingAndContext extends ParserRuleContext {
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public BreakingAndContext breakingAnd() {
			return getRuleContext(BreakingAndContext.class,0);
		}
		public ComparingAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparingAnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterComparingAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitComparingAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitComparingAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparingAndContext comparingAnd() throws RecognitionException {
		ComparingAndContext _localctx = new ComparingAndContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_comparingAnd);
		try {
			setState(646);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AndSign:
				enterOuterAlt(_localctx, 1);
				{
				setState(644);
				and();
				}
				break;
			case BreakingAndSign:
				enterOuterAlt(_localctx, 2);
				{
				setState(645);
				breakingAnd();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparingOrContext extends ParserRuleContext {
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public BreakingOrContext breakingOr() {
			return getRuleContext(BreakingOrContext.class,0);
		}
		public ComparingOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparingOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterComparingOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitComparingOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitComparingOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparingOrContext comparingOr() throws RecognitionException {
		ComparingOrContext _localctx = new ComparingOrContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_comparingOr);
		try {
			setState(650);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OrSign:
				enterOuterAlt(_localctx, 1);
				{
				setState(648);
				or();
				}
				break;
			case BreakingOrSign:
				enterOuterAlt(_localctx, 2);
				{
				setState(649);
				breakingOr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparingContext extends ParserRuleContext {
		public ComparingAndContext comparingAnd() {
			return getRuleContext(ComparingAndContext.class,0);
		}
		public ComparingOrContext comparingOr() {
			return getRuleContext(ComparingOrContext.class,0);
		}
		public MoreThanContext moreThan() {
			return getRuleContext(MoreThanContext.class,0);
		}
		public LessThanContext lessThan() {
			return getRuleContext(LessThanContext.class,0);
		}
		public TerminalNode Equals() { return getToken(TypescriptParser.Equals, 0); }
		public TerminalNode StricEquals() { return getToken(TypescriptParser.StricEquals, 0); }
		public ComparingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterComparing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitComparing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitComparing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparingContext comparing() throws RecognitionException {
		ComparingContext _localctx = new ComparingContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_comparing);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(658);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AndSign:
			case BreakingAndSign:
				{
				setState(652);
				comparingAnd();
				}
				break;
			case OrSign:
			case BreakingOrSign:
				{
				setState(653);
				comparingOr();
				}
				break;
			case RightAngleBracket:
				{
				setState(654);
				moreThan();
				}
				break;
			case LeftAngleBracket:
				{
				setState(655);
				lessThan();
				}
				break;
			case Equals:
				{
				setState(656);
				match(Equals);
				}
				break;
			case StricEquals:
				{
				setState(657);
				match(StricEquals);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IsDefineFieldContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(TypescriptParser.Var, 0); }
		public TerminalNode Let() { return getToken(TypescriptParser.Let, 0); }
		public TerminalNode Const() { return getToken(TypescriptParser.Const, 0); }
		public IsDefineFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isDefineField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterIsDefineField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitIsDefineField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitIsDefineField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IsDefineFieldContext isDefineField() throws RecognitionException {
		IsDefineFieldContext _localctx = new IsDefineFieldContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_isDefineField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(660);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 58720256L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FullNameOrIdentifierContext extends ParserRuleContext {
		public TerminalNode FullName() { return getToken(TypescriptParser.FullName, 0); }
		public TerminalNode Identifier() { return getToken(TypescriptParser.Identifier, 0); }
		public FullNameOrIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullNameOrIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterFullNameOrIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitFullNameOrIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitFullNameOrIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullNameOrIdentifierContext fullNameOrIdentifier() throws RecognitionException {
		FullNameOrIdentifierContext _localctx = new FullNameOrIdentifierContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_fullNameOrIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(662);
			_la = _input.LA(1);
			if ( !(_la==Identifier || _la==FullName) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(TypescriptParser.Identifier, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(664);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FullNameContext extends ParserRuleContext {
		public TerminalNode FullName() { return getToken(TypescriptParser.FullName, 0); }
		public FullNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterFullName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitFullName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitFullName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullNameContext fullName() throws RecognitionException {
		FullNameContext _localctx = new FullNameContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_fullName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
			match(FullName);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(TypescriptParser.Number, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(668);
			match(Number);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ParserRuleContext {
		public TerminalNode True() { return getToken(TypescriptParser.True, 0); }
		public TerminalNode False() { return getToken(TypescriptParser.False, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypescriptListener ) ((TypescriptListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypescriptVisitor ) return ((TypescriptVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(670);
			_la = _input.LA(1);
			if ( !(_la==True || _la==False) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00016\u02a1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"+
		"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"+
		"K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007O\u0002"+
		"P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007T\u0002"+
		"U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007Y\u0002"+
		"Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007^\u0002"+
		"_\u0007_\u0002`\u0007`\u0002a\u0007a\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0004\u0001\u00c8\b\u0001\u000b\u0001\f\u0001\u00c9\u0003\u0001\u00cc"+
		"\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00d2"+
		"\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00d8"+
		"\b\u0002\u0003\u0002\u00da\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0004\u0003\u00e1\b\u0003\u000b\u0003\f\u0003"+
		"\u00e2\u0003\u0003\u00e5\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00ef"+
		"\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00f4\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0003\u0005"+
		"\u00fb\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u0103\b\u0005\u0003\u0005\u0105\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u010a\b\u0005\u0003\u0005\u010c"+
		"\b\u0005\u0003\u0005\u010e\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u0114\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u011d\b\u0007"+
		"\u0001\b\u0001\b\u0003\b\u0121\b\b\u0001\b\u0001\b\u0003\b\u0125\b\b\u0005"+
		"\b\u0127\b\b\n\b\f\b\u012a\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0003\t\u0132\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0138"+
		"\b\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0003\r\u0146\b\r\u0001\u000e"+
		"\u0003\u000e\u0149\b\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u014d\b"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0003"+
		"\u0011\u0154\b\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0158\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u0160\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014"+
		"\u0165\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u016f\b\u0015\n\u0015"+
		"\f\u0015\u0172\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u0177\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0004\u0018\u017e\b\u0018\u000b\u0018\f\u0018\u017f\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0186\b\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u018e"+
		"\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u0194"+
		"\b\u001b\n\u001b\f\u001b\u0197\t\u001b\u0001\u001c\u0001\u001c\u0003\u001c"+
		"\u019b\b\u001c\u0001\u001d\u0001\u001d\u0005\u001d\u019f\b\u001d\n\u001d"+
		"\f\u001d\u01a2\t\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u01a6\b\u001d"+
		"\n\u001d\f\u001d\u01a9\t\u001d\u0001\u001d\u0003\u001d\u01ac\b\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u01b1\b\u001e\n\u001e\f\u001e"+
		"\u01b4\t\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 "+
		"\u0001 \u0001 \u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0003\"\u01c3"+
		"\b\"\u0001\"\u0001\"\u0005\"\u01c7\b\"\n\"\f\"\u01ca\t\"\u0001#\u0004"+
		"#\u01cd\b#\u000b#\f#\u01ce\u0001$\u0001$\u0003$\u01d3\b$\u0001%\u0003"+
		"%\u01d6\b%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0003\'\u01e3\b\'\u0001\'\u0001\'\u0001(\u0001(\u0001"+
		"(\u0001(\u0003(\u01eb\b(\u0001(\u0001(\u0001)\u0001)\u0003)\u01f1\b)\u0001"+
		"*\u0001*\u0001*\u0003*\u01f6\b*\u0001+\u0001+\u0001+\u0001+\u0001,\u0001"+
		",\u0003,\u01fe\b,\u0001,\u0003,\u0201\b,\u0001-\u0001-\u0001-\u0005-\u0206"+
		"\b-\n-\f-\u0209\t-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001/\u0005/\u0211"+
		"\b/\n/\f/\u0214\t/\u00010\u00010\u00030\u0218\b0\u00010\u00010\u00011"+
		"\u00011\u00051\u021e\b1\n1\f1\u0221\t1\u00012\u00012\u00032\u0225\b2\u0001"+
		"3\u00013\u00013\u00014\u00014\u00054\u022c\b4\n4\f4\u022f\t4\u00015\u0001"+
		"5\u00035\u0233\b5\u00016\u00016\u00036\u0237\b6\u00017\u00017\u00017\u0001"+
		"7\u00017\u00037\u023e\b7\u00018\u00018\u00019\u00019\u0001:\u0001:\u0001"+
		";\u0001;\u0001<\u0001<\u0001=\u0001=\u0001>\u0001>\u0001?\u0001?\u0001"+
		"@\u0001@\u0001A\u0001A\u0001B\u0001B\u0001C\u0001C\u0001D\u0001D\u0001"+
		"E\u0001E\u0001F\u0001F\u0001G\u0001G\u0001H\u0001H\u0001I\u0001I\u0001"+
		"J\u0001J\u0001K\u0001K\u0001L\u0001L\u0001M\u0001M\u0001N\u0001N\u0001"+
		"O\u0001O\u0001P\u0001P\u0001Q\u0001Q\u0001R\u0001R\u0001R\u0003R\u0277"+
		"\bR\u0001S\u0001S\u0001T\u0001T\u0001U\u0001U\u0001V\u0001V\u0001W\u0001"+
		"W\u0001X\u0001X\u0001Y\u0001Y\u0003Y\u0287\bY\u0001Z\u0001Z\u0003Z\u028b"+
		"\bZ\u0001[\u0001[\u0001[\u0001[\u0001[\u0001[\u0003[\u0293\b[\u0001\\"+
		"\u0001\\\u0001]\u0001]\u0001^\u0001^\u0001_\u0001_\u0001`\u0001`\u0001"+
		"a\u0001a\u0001a\u0000\u0000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPR"+
		"TVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e"+
		"\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6"+
		"\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be"+
		"\u00c0\u00c2\u0000\u0004\u0001\u0000\'0\u0001\u0000\u0017\u0019\u0001"+
		"\u000045\u0001\u0000\u001a\u001b\u0295\u0000\u00c4\u0001\u0000\u0000\u0000"+
		"\u0002\u00cb\u0001\u0000\u0000\u0000\u0004\u00d9\u0001\u0000\u0000\u0000"+
		"\u0006\u00db\u0001\u0000\u0000\u0000\b\u00ea\u0001\u0000\u0000\u0000\n"+
		"\u00fa\u0001\u0000\u0000\u0000\f\u0113\u0001\u0000\u0000\u0000\u000e\u011c"+
		"\u0001\u0000\u0000\u0000\u0010\u011e\u0001\u0000\u0000\u0000\u0012\u012d"+
		"\u0001\u0000\u0000\u0000\u0014\u0139\u0001\u0000\u0000\u0000\u0016\u013c"+
		"\u0001\u0000\u0000\u0000\u0018\u013f\u0001\u0000\u0000\u0000\u001a\u0145"+
		"\u0001\u0000\u0000\u0000\u001c\u0148\u0001\u0000\u0000\u0000\u001e\u014e"+
		"\u0001\u0000\u0000\u0000 \u0150\u0001\u0000\u0000\u0000\"\u0153\u0001"+
		"\u0000\u0000\u0000$\u0159\u0001\u0000\u0000\u0000&\u015b\u0001\u0000\u0000"+
		"\u0000(\u0164\u0001\u0000\u0000\u0000*\u016b\u0001\u0000\u0000\u0000,"+
		"\u0173\u0001\u0000\u0000\u0000.\u0178\u0001\u0000\u0000\u00000\u017d\u0001"+
		"\u0000\u0000\u00002\u0181\u0001\u0000\u0000\u00004\u018d\u0001\u0000\u0000"+
		"\u00006\u018f\u0001\u0000\u0000\u00008\u019a\u0001\u0000\u0000\u0000:"+
		"\u01ab\u0001\u0000\u0000\u0000<\u01ad\u0001\u0000\u0000\u0000>\u01b7\u0001"+
		"\u0000\u0000\u0000@\u01b9\u0001\u0000\u0000\u0000B\u01bc\u0001\u0000\u0000"+
		"\u0000D\u01bf\u0001\u0000\u0000\u0000F\u01cc\u0001\u0000\u0000\u0000H"+
		"\u01d2\u0001\u0000\u0000\u0000J\u01d5\u0001\u0000\u0000\u0000L\u01d9\u0001"+
		"\u0000\u0000\u0000N\u01de\u0001\u0000\u0000\u0000P\u01e6\u0001\u0000\u0000"+
		"\u0000R\u01f0\u0001\u0000\u0000\u0000T\u01f2\u0001\u0000\u0000\u0000V"+
		"\u01f7\u0001\u0000\u0000\u0000X\u01fb\u0001\u0000\u0000\u0000Z\u0202\u0001"+
		"\u0000\u0000\u0000\\\u020c\u0001\u0000\u0000\u0000^\u0212\u0001\u0000"+
		"\u0000\u0000`\u0215\u0001\u0000\u0000\u0000b\u021b\u0001\u0000\u0000\u0000"+
		"d\u0224\u0001\u0000\u0000\u0000f\u0226\u0001\u0000\u0000\u0000h\u0229"+
		"\u0001\u0000\u0000\u0000j\u0232\u0001\u0000\u0000\u0000l\u0234\u0001\u0000"+
		"\u0000\u0000n\u023d\u0001\u0000\u0000\u0000p\u023f\u0001\u0000\u0000\u0000"+
		"r\u0241\u0001\u0000\u0000\u0000t\u0243\u0001\u0000\u0000\u0000v\u0245"+
		"\u0001\u0000\u0000\u0000x\u0247\u0001\u0000\u0000\u0000z\u0249\u0001\u0000"+
		"\u0000\u0000|\u024b\u0001\u0000\u0000\u0000~\u024d\u0001\u0000\u0000\u0000"+
		"\u0080\u024f\u0001\u0000\u0000\u0000\u0082\u0251\u0001\u0000\u0000\u0000"+
		"\u0084\u0253\u0001\u0000\u0000\u0000\u0086\u0255\u0001\u0000\u0000\u0000"+
		"\u0088\u0257\u0001\u0000\u0000\u0000\u008a\u0259\u0001\u0000\u0000\u0000"+
		"\u008c\u025b\u0001\u0000\u0000\u0000\u008e\u025d\u0001\u0000\u0000\u0000"+
		"\u0090\u025f\u0001\u0000\u0000\u0000\u0092\u0261\u0001\u0000\u0000\u0000"+
		"\u0094\u0263\u0001\u0000\u0000\u0000\u0096\u0265\u0001\u0000\u0000\u0000"+
		"\u0098\u0267\u0001\u0000\u0000\u0000\u009a\u0269\u0001\u0000\u0000\u0000"+
		"\u009c\u026b\u0001\u0000\u0000\u0000\u009e\u026d\u0001\u0000\u0000\u0000"+
		"\u00a0\u026f\u0001\u0000\u0000\u0000\u00a2\u0271\u0001\u0000\u0000\u0000"+
		"\u00a4\u0276\u0001\u0000\u0000\u0000\u00a6\u0278\u0001\u0000\u0000\u0000"+
		"\u00a8\u027a\u0001\u0000\u0000\u0000\u00aa\u027c\u0001\u0000\u0000\u0000"+
		"\u00ac\u027e\u0001\u0000\u0000\u0000\u00ae\u0280\u0001\u0000\u0000\u0000"+
		"\u00b0\u0282\u0001\u0000\u0000\u0000\u00b2\u0286\u0001\u0000\u0000\u0000"+
		"\u00b4\u028a\u0001\u0000\u0000\u0000\u00b6\u0292\u0001\u0000\u0000\u0000"+
		"\u00b8\u0294\u0001\u0000\u0000\u0000\u00ba\u0296\u0001\u0000\u0000\u0000"+
		"\u00bc\u0298\u0001\u0000\u0000\u0000\u00be\u029a\u0001\u0000\u0000\u0000"+
		"\u00c0\u029c\u0001\u0000\u0000\u0000\u00c2\u029e\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\u0003\u0002\u0001\u0000\u00c5\u0001\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c8\u0003\u0004\u0002\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000"+
		"\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000"+
		"\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cc\u0001\u0000\u0000\u0000"+
		"\u00cb\u00c7\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000"+
		"\u00cc\u0003\u0001\u0000\u0000\u0000\u00cd\u00d2\u0003\u0006\u0003\u0000"+
		"\u00ce\u00d2\u0003\n\u0005\u0000\u00cf\u00d2\u0003D\"\u0000\u00d0\u00d2"+
		"\u0003\u001a\r\u0000\u00d1\u00cd\u0001\u0000\u0000\u0000\u00d1\u00ce\u0001"+
		"\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d0\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d4\u0003"+
		"\u008aE\u0000\u00d4\u00da\u0001\u0000\u0000\u0000\u00d5\u00d8\u0003\b"+
		"\u0004\u0000\u00d6\u00d8\u0003\u0012\t\u0000\u00d7\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d7\u00d6\u0001\u0000\u0000\u0000\u00d8\u00da\u0001\u0000\u0000"+
		"\u0000\u00d9\u00d1\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000"+
		"\u0000\u00da\u0005\u0001\u0000\u0000\u0000\u00db\u00dc\u0005\u001d\u0000"+
		"\u0000\u00dc\u00dd\u0003t:\u0000\u00dd\u00e4\u0003\u00bc^\u0000\u00de"+
		"\u00df\u0005\u0016\u0000\u0000\u00df\u00e1\u0003\u00bc^\u0000\u00e0\u00de"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e0\u0001\u0000\u0000\u0000\u00e4\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e7"+
		"\u0003v;\u0000\u00e7\u00e8\u0005\u001e\u0000\u0000\u00e8\u00e9\u0005\u0004"+
		"\u0000\u0000\u00e9\u0007\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005\u001c"+
		"\u0000\u0000\u00eb\u00ec\u0003\u00bc^\u0000\u00ec\u00ee\u0003\u0084B\u0000"+
		"\u00ed\u00ef\u0003T*\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000\u00ee\u00ef"+
		"\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f3"+
		"\u0003\u0086C\u0000\u00f1\u00f2\u0005\u0014\u0000\u0000\u00f2\u00f4\u0003"+
		"X,\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f6\u0003t:\u0000\u00f6"+
		"\u00f7\u0003\u0002\u0001\u0000\u00f7\u00f8\u0003v;\u0000\u00f8\t\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fb\u0003\u00b8\\\u0000\u00fa\u00f9\u0001\u0000"+
		"\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000"+
		"\u0000\u0000\u00fc\u010d\u0003R)\u0000\u00fd\u00fe\u0005\u0014\u0000\u0000"+
		"\u00fe\u0102\u0003X,\u0000\u00ff\u0100\u0003|>\u0000\u0100\u0101\u0003"+
		"~?\u0000\u0101\u0103\u0001\u0000\u0000\u0000\u0102\u00ff\u0001\u0000\u0000"+
		"\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0105\u0001\u0000\u0000"+
		"\u0000\u0104\u00fd\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000"+
		"\u0000\u0105\u010b\u0001\u0000\u0000\u0000\u0106\u0109\u0003\u0088D\u0000"+
		"\u0107\u010a\u0003\f\u0006\u0000\u0108\u010a\u0003p8\u0000\u0109\u0107"+
		"\u0001\u0000\u0000\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u010a\u010c"+
		"\u0001\u0000\u0000\u0000\u010b\u0106\u0001\u0000\u0000\u0000\u010b\u010c"+
		"\u0001\u0000\u0000\u0000\u010c\u010e\u0001\u0000\u0000\u0000\u010d\u0104"+
		"\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u000b"+
		"\u0001\u0000\u0000\u0000\u010f\u0114\u0003n7\u0000\u0110\u0114\u0003\u00bc"+
		"^\u0000\u0111\u0114\u0003\u00be_\u0000\u0112\u0114\u0003\u000e\u0007\u0000"+
		"\u0113\u010f\u0001\u0000\u0000\u0000\u0113\u0110\u0001\u0000\u0000\u0000"+
		"\u0113\u0111\u0001\u0000\u0000\u0000\u0113\u0112\u0001\u0000\u0000\u0000"+
		"\u0114\r\u0001\u0000\u0000\u0000\u0115\u011d\u0003D\"\u0000\u0116\u011d"+
		"\u0003P(\u0000\u0117\u011d\u0003:\u001d\u0000\u0118\u011d\u0003.\u0017"+
		"\u0000\u0119\u011d\u0003(\u0014\u0000\u011a\u011d\u0003\u001a\r\u0000"+
		"\u011b\u011d\u0003\u0010\b\u0000\u011c\u0115\u0001\u0000\u0000\u0000\u011c"+
		"\u0116\u0001\u0000\u0000\u0000\u011c\u0117\u0001\u0000\u0000\u0000\u011c"+
		"\u0118\u0001\u0000\u0000\u0000\u011c\u0119\u0001\u0000\u0000\u0000\u011c"+
		"\u011a\u0001\u0000\u0000\u0000\u011c\u011b\u0001\u0000\u0000\u0000\u011d"+
		"\u000f\u0001\u0000\u0000\u0000\u011e\u0128\u0003|>\u0000\u011f\u0121\u0005"+
		"\u0016\u0000\u0000\u0120\u011f\u0001\u0000\u0000\u0000\u0120\u0121\u0001"+
		"\u0000\u0000\u0000\u0121\u0122\u0001\u0000\u0000\u0000\u0122\u0124\u0003"+
		"\f\u0006\u0000\u0123\u0125\u0005\u0016\u0000\u0000\u0124\u0123\u0001\u0000"+
		"\u0000\u0000\u0124\u0125\u0001\u0000\u0000\u0000\u0125\u0127\u0001\u0000"+
		"\u0000\u0000\u0126\u0120\u0001\u0000\u0000\u0000\u0127\u012a\u0001\u0000"+
		"\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0128\u0129\u0001\u0000"+
		"\u0000\u0000\u0129\u012b\u0001\u0000\u0000\u0000\u012a\u0128\u0001\u0000"+
		"\u0000\u0000\u012b\u012c\u0003~?\u0000\u012c\u0011\u0001\u0000\u0000\u0000"+
		"\u012d\u012e\u0005 \u0000\u0000\u012e\u0131\u0003\u0084B\u0000\u012f\u0132"+
		"\u0003\f\u0006\u0000\u0130\u0132\u0003:\u001d\u0000\u0131\u012f\u0001"+
		"\u0000\u0000\u0000\u0131\u0130\u0001\u0000\u0000\u0000\u0132\u0133\u0001"+
		"\u0000\u0000\u0000\u0133\u0134\u0003\u0086C\u0000\u0134\u0137\u0003\u0018"+
		"\f\u0000\u0135\u0138\u0003\u0016\u000b\u0000\u0136\u0138\u0003\u0014\n"+
		"\u0000\u0137\u0135\u0001\u0000\u0000\u0000\u0137\u0136\u0001\u0000\u0000"+
		"\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u0013\u0001\u0000\u0000"+
		"\u0000\u0139\u013a\u0005!\u0000\u0000\u013a\u013b\u0003\u0018\f\u0000"+
		"\u013b\u0015\u0001\u0000\u0000\u0000\u013c\u013d\u0005!\u0000\u0000\u013d"+
		"\u013e\u0003\u0012\t\u0000\u013e\u0017\u0001\u0000\u0000\u0000\u013f\u0140"+
		"\u0003t:\u0000\u0140\u0141\u0003\u0002\u0001\u0000\u0141\u0142\u0003v"+
		";\u0000\u0142\u0019\u0001\u0000\u0000\u0000\u0143\u0146\u0003\u001c\u000e"+
		"\u0000\u0144\u0146\u0003\"\u0011\u0000\u0145\u0143\u0001\u0000\u0000\u0000"+
		"\u0145\u0144\u0001\u0000\u0000\u0000\u0146\u001b\u0001\u0000\u0000\u0000"+
		"\u0147\u0149\u0003\u001e\u000f\u0000\u0148\u0147\u0001\u0000\u0000\u0000"+
		"\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000"+
		"\u014a\u014c\u0003H$\u0000\u014b\u014d\u0003 \u0010\u0000\u014c\u014b"+
		"\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000\u0000\u014d\u001d"+
		"\u0001\u0000\u0000\u0000\u014e\u014f\u0005%\u0000\u0000\u014f\u001f\u0001"+
		"\u0000\u0000\u0000\u0150\u0151\u0005%\u0000\u0000\u0151!\u0001\u0000\u0000"+
		"\u0000\u0152\u0154\u0003$\u0012\u0000\u0153\u0152\u0001\u0000\u0000\u0000"+
		"\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0155\u0001\u0000\u0000\u0000"+
		"\u0155\u0157\u0003H$\u0000\u0156\u0158\u0003&\u0013\u0000\u0157\u0156"+
		"\u0001\u0000\u0000\u0000\u0157\u0158\u0001\u0000\u0000\u0000\u0158#\u0001"+
		"\u0000\u0000\u0000\u0159\u015a\u0005&\u0000\u0000\u015a%\u0001\u0000\u0000"+
		"\u0000\u015b\u015c\u0005&\u0000\u0000\u015c\'\u0001\u0000\u0000\u0000"+
		"\u015d\u015f\u0003\u0084B\u0000\u015e\u0160\u0003*\u0015\u0000\u015f\u015e"+
		"\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000\u0000\u0160\u0161"+
		"\u0001\u0000\u0000\u0000\u0161\u0162\u0003\u0086C\u0000\u0162\u0165\u0001"+
		"\u0000\u0000\u0000\u0163\u0165\u0003,\u0016\u0000\u0164\u015d\u0001\u0000"+
		"\u0000\u0000\u0164\u0163\u0001\u0000\u0000\u0000\u0165\u0166\u0001\u0000"+
		"\u0000\u0000\u0166\u0167\u0005\u0011\u0000\u0000\u0167\u0168\u0003t:\u0000"+
		"\u0168\u0169\u0003\u0002\u0001\u0000\u0169\u016a\u0003v;\u0000\u016a)"+
		"\u0001\u0000\u0000\u0000\u016b\u0170\u0003,\u0016\u0000\u016c\u016d\u0005"+
		"\u0016\u0000\u0000\u016d\u016f\u0003,\u0016\u0000\u016e\u016c\u0001\u0000"+
		"\u0000\u0000\u016f\u0172\u0001\u0000\u0000\u0000\u0170\u016e\u0001\u0000"+
		"\u0000\u0000\u0170\u0171\u0001\u0000\u0000\u0000\u0171+\u0001\u0000\u0000"+
		"\u0000\u0172\u0170\u0001\u0000\u0000\u0000\u0173\u0176\u0003\u00bc^\u0000"+
		"\u0174\u0175\u0005\u0014\u0000\u0000\u0175\u0177\u0003X,\u0000\u0176\u0174"+
		"\u0001\u0000\u0000\u0000\u0176\u0177\u0001\u0000\u0000\u0000\u0177-\u0001"+
		"\u0000\u0000\u0000\u0178\u0179\u0003t:\u0000\u0179\u017a\u00030\u0018"+
		"\u0000\u017a\u017b\u0003v;\u0000\u017b/\u0001\u0000\u0000\u0000\u017c"+
		"\u017e\u00032\u0019\u0000\u017d\u017c\u0001\u0000\u0000\u0000\u017e\u017f"+
		"\u0001\u0000\u0000\u0000\u017f\u017d\u0001\u0000\u0000\u0000\u017f\u0180"+
		"\u0001\u0000\u0000\u0000\u01801\u0001\u0000\u0000\u0000\u0181\u0182\u0003"+
		"\u00bc^\u0000\u0182\u0183\u0005\u0014\u0000\u0000\u0183\u0185\u0003\f"+
		"\u0006\u0000\u0184\u0186\u0005\u0016\u0000\u0000\u0185\u0184\u0001\u0000"+
		"\u0000\u0000\u0185\u0186\u0001\u0000\u0000\u0000\u01863\u0001\u0000\u0000"+
		"\u0000\u0187\u018e\u00036\u001b\u0000\u0188\u018e\u0003D\"\u0000\u0189"+
		"\u018e\u0003P(\u0000\u018a\u018e\u0003n7\u0000\u018b\u018e\u0003\u00bc"+
		"^\u0000\u018c\u018e\u0003\u00be_\u0000\u018d\u0187\u0001\u0000\u0000\u0000"+
		"\u018d\u0188\u0001\u0000\u0000\u0000\u018d\u0189\u0001\u0000\u0000\u0000"+
		"\u018d\u018a\u0001\u0000\u0000\u0000\u018d\u018b\u0001\u0000\u0000\u0000"+
		"\u018d\u018c\u0001\u0000\u0000\u0000\u018e5\u0001\u0000\u0000\u0000\u018f"+
		"\u0190\u0003\u0084B\u0000\u0190\u0191\u00038\u001c\u0000\u0191\u0195\u0003"+
		"\u0086C\u0000\u0192\u0194\u0003@ \u0000\u0193\u0192\u0001\u0000\u0000"+
		"\u0000\u0194\u0197\u0001\u0000\u0000\u0000\u0195\u0193\u0001\u0000\u0000"+
		"\u0000\u0195\u0196\u0001\u0000\u0000\u0000\u01967\u0001\u0000\u0000\u0000"+
		"\u0197\u0195\u0001\u0000\u0000\u0000\u0198\u019b\u0003:\u001d\u0000\u0199"+
		"\u019b\u00034\u001a\u0000\u019a\u0198\u0001\u0000\u0000\u0000\u019a\u0199"+
		"\u0001\u0000\u0000\u0000\u019b9\u0001\u0000\u0000\u0000\u019c\u01a0\u0003"+
		">\u001f\u0000\u019d\u019f\u0003@ \u0000\u019e\u019d\u0001\u0000\u0000"+
		"\u0000\u019f\u01a2\u0001\u0000\u0000\u0000\u01a0\u019e\u0001\u0000\u0000"+
		"\u0000\u01a0\u01a1\u0001\u0000\u0000\u0000\u01a1\u01ac\u0001\u0000\u0000"+
		"\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000\u01a3\u01a7\u0003<\u001e\u0000"+
		"\u01a4\u01a6\u0003@ \u0000\u01a5\u01a4\u0001\u0000\u0000\u0000\u01a6\u01a9"+
		"\u0001\u0000\u0000\u0000\u01a7\u01a5\u0001\u0000\u0000\u0000\u01a7\u01a8"+
		"\u0001\u0000\u0000\u0000\u01a8\u01ac\u0001\u0000\u0000\u0000\u01a9\u01a7"+
		"\u0001\u0000\u0000\u0000\u01aa\u01ac\u00036\u001b\u0000\u01ab\u019c\u0001"+
		"\u0000\u0000\u0000\u01ab\u01a3\u0001\u0000\u0000\u0000\u01ab\u01aa\u0001"+
		"\u0000\u0000\u0000\u01ac;\u0001\u0000\u0000\u0000\u01ad\u01ae\u0003\u0084"+
		"B\u0000\u01ae\u01b2\u0003>\u001f\u0000\u01af\u01b1\u0003@ \u0000\u01b0"+
		"\u01af\u0001\u0000\u0000\u0000\u01b1\u01b4\u0001\u0000\u0000\u0000\u01b2"+
		"\u01b0\u0001\u0000\u0000\u0000\u01b2\u01b3\u0001\u0000\u0000\u0000\u01b3"+
		"\u01b5\u0001\u0000\u0000\u0000\u01b4\u01b2\u0001\u0000\u0000\u0000\u01b5"+
		"\u01b6\u0003\u0086C\u0000\u01b6=\u0001\u0000\u0000\u0000\u01b7\u01b8\u0003"+
		"4\u001a\u0000\u01b8?\u0001\u0000\u0000\u0000\u01b9\u01ba\u0003\u00a4R"+
		"\u0000\u01ba\u01bb\u00034\u001a\u0000\u01bbA\u0001\u0000\u0000\u0000\u01bc"+
		"\u01bd\u0005\"\u0000\u0000\u01bd\u01be\u0003\f\u0006\u0000\u01beC\u0001"+
		"\u0000\u0000\u0000\u01bf\u01c0\u0003F#\u0000\u01c0\u01c2\u0003\u0084B"+
		"\u0000\u01c1\u01c3\u0003h4\u0000\u01c2\u01c1\u0001\u0000\u0000\u0000\u01c2"+
		"\u01c3\u0001\u0000\u0000\u0000\u01c3\u01c4\u0001\u0000\u0000\u0000\u01c4"+
		"\u01c8\u0003\u0086C\u0000\u01c5\u01c7\u0003N\'\u0000\u01c6\u01c5\u0001"+
		"\u0000\u0000\u0000\u01c7\u01ca\u0001\u0000\u0000\u0000\u01c8\u01c6\u0001"+
		"\u0000\u0000\u0000\u01c8\u01c9\u0001\u0000\u0000\u0000\u01c9E\u0001\u0000"+
		"\u0000\u0000\u01ca\u01c8\u0001\u0000\u0000\u0000\u01cb\u01cd\u0003H$\u0000"+
		"\u01cc\u01cb\u0001\u0000\u0000\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000"+
		"\u01ce\u01cc\u0001\u0000\u0000\u0000\u01ce\u01cf\u0001\u0000\u0000\u0000"+
		"\u01cfG\u0001\u0000\u0000\u0000\u01d0\u01d3\u0003L&\u0000\u01d1\u01d3"+
		"\u0003J%\u0000\u01d2\u01d0\u0001\u0000\u0000\u0000\u01d2\u01d1\u0001\u0000"+
		"\u0000\u0000\u01d3I\u0001\u0000\u0000\u0000\u01d4\u01d6\u0005\u0005\u0000"+
		"\u0000\u01d5\u01d4\u0001\u0000\u0000\u0000\u01d5\u01d6\u0001\u0000\u0000"+
		"\u0000\u01d6\u01d7\u0001\u0000\u0000\u0000\u01d7\u01d8\u0003\u00ba]\u0000"+
		"\u01d8K\u0001\u0000\u0000\u0000\u01d9\u01da\u0003J%\u0000\u01da\u01db"+
		"\u0003|>\u0000\u01db\u01dc\u0003\f\u0006\u0000\u01dc\u01dd\u0003~?\u0000"+
		"\u01ddM\u0001\u0000\u0000\u0000\u01de\u01df\u0003r9\u0000\u01df\u01e0"+
		"\u0003\u00bc^\u0000\u01e0\u01e2\u0003\u0084B\u0000\u01e1\u01e3\u0003h"+
		"4\u0000\u01e2\u01e1\u0001\u0000\u0000\u0000\u01e2\u01e3\u0001\u0000\u0000"+
		"\u0000\u01e3\u01e4\u0001\u0000\u0000\u0000\u01e4\u01e5\u0003\u0086C\u0000"+
		"\u01e5O\u0001\u0000\u0000\u0000\u01e6\u01e7\u0005\u001f\u0000\u0000\u01e7"+
		"\u01e8\u0003\u00bc^\u0000\u01e8\u01ea\u0003\u0084B\u0000\u01e9\u01eb\u0003"+
		"h4\u0000\u01ea\u01e9\u0001\u0000\u0000\u0000\u01ea\u01eb\u0001\u0000\u0000"+
		"\u0000\u01eb\u01ec\u0001\u0000\u0000\u0000\u01ec\u01ed\u0003\u0086C\u0000"+
		"\u01edQ\u0001\u0000\u0000\u0000\u01ee\u01f1\u0003\u00bc^\u0000\u01ef\u01f1"+
		"\u0003\u00be_\u0000\u01f0\u01ee\u0001\u0000\u0000\u0000\u01f0\u01ef\u0001"+
		"\u0000\u0000\u0000\u01f1S\u0001\u0000\u0000\u0000\u01f2\u01f5\u0003V+"+
		"\u0000\u01f3\u01f4\u0005\u0016\u0000\u0000\u01f4\u01f6\u0003V+\u0000\u01f5"+
		"\u01f3\u0001\u0000\u0000\u0000\u01f5\u01f6\u0001\u0000\u0000\u0000\u01f6"+
		"U\u0001\u0000\u0000\u0000\u01f7\u01f8\u0003\u00bc^\u0000\u01f8\u01f9\u0005"+
		"\u0014\u0000\u0000\u01f9\u01fa\u0003X,\u0000\u01faW\u0001\u0000\u0000"+
		"\u0000\u01fb\u01fd\u0003\u00bc^\u0000\u01fc\u01fe\u0003Z-\u0000\u01fd"+
		"\u01fc\u0001\u0000\u0000\u0000\u01fd\u01fe\u0001\u0000\u0000\u0000\u01fe"+
		"\u0200\u0001\u0000\u0000\u0000\u01ff\u0201\u0003^/\u0000\u0200\u01ff\u0001"+
		"\u0000\u0000\u0000\u0200\u0201\u0001\u0000\u0000\u0000\u0201Y\u0001\u0000"+
		"\u0000\u0000\u0202\u0203\u0003x<\u0000\u0203\u0207\u0003X,\u0000\u0204"+
		"\u0206\u0003\\.\u0000\u0205\u0204\u0001\u0000\u0000\u0000\u0206\u0209"+
		"\u0001\u0000\u0000\u0000\u0207\u0205\u0001\u0000\u0000\u0000\u0207\u0208"+
		"\u0001\u0000\u0000\u0000\u0208\u020a\u0001\u0000\u0000\u0000\u0209\u0207"+
		"\u0001\u0000\u0000\u0000\u020a\u020b\u0003z=\u0000\u020b[\u0001\u0000"+
		"\u0000\u0000\u020c\u020d\u0005\u0016\u0000\u0000\u020d\u020e\u0003X,\u0000"+
		"\u020e]\u0001\u0000\u0000\u0000\u020f\u0211\u0003`0\u0000\u0210\u020f"+
		"\u0001\u0000\u0000\u0000\u0211\u0214\u0001\u0000\u0000\u0000\u0212\u0210"+
		"\u0001\u0000\u0000\u0000\u0212\u0213\u0001\u0000\u0000\u0000\u0213_\u0001"+
		"\u0000\u0000\u0000\u0214\u0212\u0001\u0000\u0000\u0000\u0215\u0217\u0003"+
		"|>\u0000\u0216\u0218\u0003\u00c0`\u0000\u0217\u0216\u0001\u0000\u0000"+
		"\u0000\u0217\u0218\u0001\u0000\u0000\u0000\u0218\u0219\u0001\u0000\u0000"+
		"\u0000\u0219\u021a\u0003~?\u0000\u021aa\u0001\u0000\u0000\u0000\u021b"+
		"\u021f\u0003d2\u0000\u021c\u021e\u0003f3\u0000\u021d\u021c\u0001\u0000"+
		"\u0000\u0000\u021e\u0221\u0001\u0000\u0000\u0000\u021f\u021d\u0001\u0000"+
		"\u0000\u0000\u021f\u0220\u0001\u0000\u0000\u0000\u0220c\u0001\u0000\u0000"+
		"\u0000\u0221\u021f\u0001\u0000\u0000\u0000\u0222\u0225\u0003\u00bc^\u0000"+
		"\u0223\u0225\u0003n7\u0000\u0224\u0222\u0001\u0000\u0000\u0000\u0224\u0223"+
		"\u0001\u0000\u0000\u0000\u0225e\u0001\u0000\u0000\u0000\u0226\u0227\u0005"+
		"\u0016\u0000\u0000\u0227\u0228\u0003d2\u0000\u0228g\u0001\u0000\u0000"+
		"\u0000\u0229\u022d\u0003j5\u0000\u022a\u022c\u0003l6\u0000\u022b\u022a"+
		"\u0001\u0000\u0000\u0000\u022c\u022f\u0001\u0000\u0000\u0000\u022d\u022b"+
		"\u0001\u0000\u0000\u0000\u022d\u022e\u0001\u0000\u0000\u0000\u022ei\u0001"+
		"\u0000\u0000\u0000\u022f\u022d\u0001\u0000\u0000\u0000\u0230\u0233\u0003"+
		"d2\u0000\u0231\u0233\u0003\f\u0006\u0000\u0232\u0230\u0001\u0000\u0000"+
		"\u0000\u0232\u0231\u0001\u0000\u0000\u0000\u0233k\u0001\u0000\u0000\u0000"+
		"\u0234\u0236\u0005\u0016\u0000\u0000\u0235\u0237\u0003j5\u0000\u0236\u0235"+
		"\u0001\u0000\u0000\u0000\u0236\u0237\u0001\u0000\u0000\u0000\u0237m\u0001"+
		"\u0000\u0000\u0000\u0238\u023e\u0005\u0004\u0000\u0000\u0239\u023e\u0003"+
		"\u00c0`\u0000\u023a\u023e\u0005\u0012\u0000\u0000\u023b\u023e\u0005\u0013"+
		"\u0000\u0000\u023c\u023e\u0003\u00c2a\u0000\u023d\u0238\u0001\u0000\u0000"+
		"\u0000\u023d\u0239\u0001\u0000\u0000\u0000\u023d\u023a\u0001\u0000\u0000"+
		"\u0000\u023d\u023b\u0001\u0000\u0000\u0000\u023d\u023c\u0001\u0000\u0000"+
		"\u0000\u023eo\u0001\u0000\u0000\u0000\u023f\u0240\u0003\u00bc^\u0000\u0240"+
		"q\u0001\u0000\u0000\u0000\u0241\u0242\u0005\u0005\u0000\u0000\u0242s\u0001"+
		"\u0000\u0000\u0000\u0243\u0244\u0005\u0006\u0000\u0000\u0244u\u0001\u0000"+
		"\u0000\u0000\u0245\u0246\u0005\u0007\u0000\u0000\u0246w\u0001\u0000\u0000"+
		"\u0000\u0247\u0248\u0005\b\u0000\u0000\u0248y\u0001\u0000\u0000\u0000"+
		"\u0249\u024a\u0005\t\u0000\u0000\u024a{\u0001\u0000\u0000\u0000\u024b"+
		"\u024c\u0005\n\u0000\u0000\u024c}\u0001\u0000\u0000\u0000\u024d\u024e"+
		"\u0005\u000b\u0000\u0000\u024e\u007f\u0001\u0000\u0000\u0000\u024f\u0250"+
		"\u0005\f\u0000\u0000\u0250\u0081\u0001\u0000\u0000\u0000\u0251\u0252\u0005"+
		"\r\u0000\u0000\u0252\u0083\u0001\u0000\u0000\u0000\u0253\u0254\u0005\f"+
		"\u0000\u0000\u0254\u0085\u0001\u0000\u0000\u0000\u0255\u0256\u0005\r\u0000"+
		"\u0000\u0256\u0087\u0001\u0000\u0000\u0000\u0257\u0258\u0005\u0010\u0000"+
		"\u0000\u0258\u0089\u0001\u0000\u0000\u0000\u0259\u025a\u0005\u0015\u0000"+
		"\u0000\u025a\u008b\u0001\u0000\u0000\u0000\u025b\u025c\u0005#\u0000\u0000"+
		"\u025c\u008d\u0001\u0000\u0000\u0000\u025d\u025e\u0005$\u0000\u0000\u025e"+
		"\u008f\u0001\u0000\u0000\u0000\u025f\u0260\u0005\'\u0000\u0000\u0260\u0091"+
		"\u0001\u0000\u0000\u0000\u0261\u0262\u0005(\u0000\u0000\u0262\u0093\u0001"+
		"\u0000\u0000\u0000\u0263\u0264\u0005)\u0000\u0000\u0264\u0095\u0001\u0000"+
		"\u0000\u0000\u0265\u0266\u0005*\u0000\u0000\u0266\u0097\u0001\u0000\u0000"+
		"\u0000\u0267\u0268\u0005+\u0000\u0000\u0268\u0099\u0001\u0000\u0000\u0000"+
		"\u0269\u026a\u0005,\u0000\u0000\u026a\u009b\u0001\u0000\u0000\u0000\u026b"+
		"\u026c\u0005-\u0000\u0000\u026c\u009d\u0001\u0000\u0000\u0000\u026d\u026e"+
		"\u0005.\u0000\u0000\u026e\u009f\u0001\u0000\u0000\u0000\u026f\u0270\u0005"+
		"/\u0000\u0000\u0270\u00a1\u0001\u0000\u0000\u0000\u0271\u0272\u00050\u0000"+
		"\u0000\u0272\u00a3\u0001\u0000\u0000\u0000\u0273\u0277\u0003\u00a6S\u0000"+
		"\u0274\u0277\u0003\u00b6[\u0000\u0275\u0277\u0003\u00acV\u0000\u0276\u0273"+
		"\u0001\u0000\u0000\u0000\u0276\u0274\u0001\u0000\u0000\u0000\u0276\u0275"+
		"\u0001\u0000\u0000\u0000\u0277\u00a5\u0001\u0000\u0000\u0000\u0278\u0279"+
		"\u0007\u0000\u0000\u0000\u0279\u00a7\u0001\u0000\u0000\u0000\u027a\u027b"+
		"\u00051\u0000\u0000\u027b\u00a9\u0001\u0000\u0000\u0000\u027c\u027d\u0005"+
		"2\u0000\u0000\u027d\u00ab\u0001\u0000\u0000\u0000\u027e\u027f\u00053\u0000"+
		"\u0000\u027f\u00ad\u0001\u0000\u0000\u0000\u0280\u0281\u0005\b\u0000\u0000"+
		"\u0281\u00af\u0001\u0000\u0000\u0000\u0282\u0283\u0005\t\u0000\u0000\u0283"+
		"\u00b1\u0001\u0000\u0000\u0000\u0284\u0287\u0003\u008cF\u0000\u0285\u0287"+
		"\u0003\u00a8T\u0000\u0286\u0284\u0001\u0000\u0000\u0000\u0286\u0285\u0001"+
		"\u0000\u0000\u0000\u0287\u00b3\u0001\u0000\u0000\u0000\u0288\u028b\u0003"+
		"\u008eG\u0000\u0289\u028b\u0003\u00aaU\u0000\u028a\u0288\u0001\u0000\u0000"+
		"\u0000\u028a\u0289\u0001\u0000\u0000\u0000\u028b\u00b5\u0001\u0000\u0000"+
		"\u0000\u028c\u0293\u0003\u00b2Y\u0000\u028d\u0293\u0003\u00b4Z\u0000\u028e"+
		"\u0293\u0003\u00b0X\u0000\u028f\u0293\u0003\u00aeW\u0000\u0290\u0293\u0005"+
		"\u000f\u0000\u0000\u0291\u0293\u0005\u000e\u0000\u0000\u0292\u028c\u0001"+
		"\u0000\u0000\u0000\u0292\u028d\u0001\u0000\u0000\u0000\u0292\u028e\u0001"+
		"\u0000\u0000\u0000\u0292\u028f\u0001\u0000\u0000\u0000\u0292\u0290\u0001"+
		"\u0000\u0000\u0000\u0292\u0291\u0001\u0000\u0000\u0000\u0293\u00b7\u0001"+
		"\u0000\u0000\u0000\u0294\u0295\u0007\u0001\u0000\u0000\u0295\u00b9\u0001"+
		"\u0000\u0000\u0000\u0296\u0297\u0007\u0002\u0000\u0000\u0297\u00bb\u0001"+
		"\u0000\u0000\u0000\u0298\u0299\u00054\u0000\u0000\u0299\u00bd\u0001\u0000"+
		"\u0000\u0000\u029a\u029b\u00055\u0000\u0000\u029b\u00bf\u0001\u0000\u0000"+
		"\u0000\u029c\u029d\u00056\u0000\u0000\u029d\u00c1\u0001\u0000\u0000\u0000"+
		"\u029e\u029f\u0007\u0003\u0000\u0000\u029f\u00c3\u0001\u0000\u0000\u0000"+
		"@\u00c9\u00cb\u00d1\u00d7\u00d9\u00e2\u00e4\u00ee\u00f3\u00fa\u0102\u0104"+
		"\u0109\u010b\u010d\u0113\u011c\u0120\u0124\u0128\u0131\u0137\u0145\u0148"+
		"\u014c\u0153\u0157\u015f\u0164\u0170\u0176\u017f\u0185\u018d\u0195\u019a"+
		"\u01a0\u01a7\u01ab\u01b2\u01c2\u01c8\u01ce\u01d2\u01d5\u01e2\u01ea\u01f0"+
		"\u01f5\u01fd\u0200\u0207\u0212\u0217\u021f\u0224\u022d\u0232\u0236\u023d"+
		"\u0276\u0286\u028a\u0292";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}