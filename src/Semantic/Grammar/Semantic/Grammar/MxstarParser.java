// Generated from C:/Users/31072/Desktop/K/Semantic/Grammar\Mxstar.g4 by ANTLR 4.10.1
package Semantic.Grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxstarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, Int=34, Bool=35, String=36, Void=37, New=38, Class=39, 
		Null=40, True=41, False=42, This=43, If=44, Else=45, For=46, While=47, 
		Break=48, Continue=49, Return=50, ConstString=51, ID=52, Number=53, Whitespace=54, 
		LineComment=55, BlockComment=56;
	public static final int
		RULE_program = 0, RULE_classDef = 1, RULE_funcDef = 2, RULE_lambdaFunc = 3, 
		RULE_funcVarDef = 4, RULE_varDef = 5, RULE_constructFuncDef = 6, RULE_oneVarDef = 7, 
		RULE_stmt = 8, RULE_part = 9, RULE_expr = 10, RULE_returnType = 11, RULE_varType = 12, 
		RULE_newType = 13, RULE_basicType = 14, RULE_primary = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "classDef", "funcDef", "lambdaFunc", "funcVarDef", "varDef", 
			"constructFuncDef", "oneVarDef", "stmt", "part", "expr", "returnType", 
			"varType", "newType", "basicType", "primary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'{'", "'}'", "'('", "','", "')'", "'['", "'&'", "']'", 
			"'->'", "'='", "'.'", "'++'", "'--'", "'!'", "'~'", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'<<'", "'>>'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", 
			"'|'", "'^'", "'&&'", "'||'", "'int'", "'bool'", "'string'", "'void'", 
			"'new'", "'class'", "'null'", "'true'", "'false'", "'this'", "'if'", 
			"'else'", "'for'", "'while'", "'break'", "'continue'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "Int", "Bool", 
			"String", "Void", "New", "Class", "Null", "True", "False", "This", "If", 
			"Else", "For", "While", "Break", "Continue", "Return", "ConstString", 
			"ID", "Number", "Whitespace", "LineComment", "BlockComment"
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
	public String getGrammarFileName() { return "Mxstar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxstarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public List<ClassDefContext> classDef() {
			return getRuleContexts(ClassDefContext.class);
		}
		public ClassDefContext classDef(int i) {
			return getRuleContext(ClassDefContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Void) | (1L << Class) | (1L << ID))) != 0)) {
				{
				setState(37);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(32);
					funcDef();
					}
					break;
				case 2:
					{
					setState(33);
					varDef();
					setState(34);
					match(T__0);
					}
					break;
				case 3:
					{
					setState(36);
					classDef();
					}
					break;
				}
				}
				setState(41);
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

	public static class ClassDefContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(MxstarParser.Class, 0); }
		public TerminalNode ID() { return getToken(MxstarParser.ID, 0); }
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<ConstructFuncDefContext> constructFuncDef() {
			return getRuleContexts(ConstructFuncDefContext.class);
		}
		public ConstructFuncDefContext constructFuncDef(int i) {
			return getRuleContext(ConstructFuncDefContext.class,i);
		}
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(Class);
			setState(43);
			match(ID);
			setState(44);
			match(T__1);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Void) | (1L << ID))) != 0)) {
				{
				setState(50);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(45);
					funcDef();
					}
					break;
				case 2:
					{
					setState(46);
					constructFuncDef();
					}
					break;
				case 3:
					{
					setState(47);
					varDef();
					setState(48);
					match(T__0);
					}
					break;
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(T__2);
			setState(56);
			match(T__0);
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

	public static class FuncDefContext extends ParserRuleContext {
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MxstarParser.ID, 0); }
		public PartContext part() {
			return getRuleContext(PartContext.class,0);
		}
		public List<FuncVarDefContext> funcVarDef() {
			return getRuleContexts(FuncVarDefContext.class);
		}
		public FuncVarDefContext funcVarDef(int i) {
			return getRuleContext(FuncVarDefContext.class,i);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			returnType();
			setState(59);
			match(ID);
			setState(60);
			match(T__3);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << ID))) != 0)) {
				{
				setState(61);
				funcVarDef();
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(62);
					match(T__4);
					setState(63);
					funcVarDef();
					}
					}
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(71);
			match(T__5);
			setState(72);
			part();
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

	public static class LambdaFuncContext extends ParserRuleContext {
		public PartContext part() {
			return getRuleContext(PartContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<FuncVarDefContext> funcVarDef() {
			return getRuleContexts(FuncVarDefContext.class);
		}
		public FuncVarDefContext funcVarDef(int i) {
			return getRuleContext(FuncVarDefContext.class,i);
		}
		public LambdaFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterLambdaFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitLambdaFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitLambdaFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaFuncContext lambdaFunc() throws RecognitionException {
		LambdaFuncContext _localctx = new LambdaFuncContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_lambdaFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__6);
			setState(75);
			match(T__7);
			setState(76);
			match(T__8);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(77);
				match(T__3);
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << ID))) != 0)) {
					{
					setState(78);
					funcVarDef();
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(79);
						match(T__4);
						setState(80);
						funcVarDef();
						}
						}
						setState(85);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(88);
				match(T__5);
				}
			}

			setState(91);
			match(T__9);
			setState(92);
			part();
			setState(93);
			match(T__3);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__6) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << ConstString) | (1L << ID) | (1L << Number))) != 0)) {
				{
				setState(94);
				expr(0);
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(95);
					match(T__4);
					setState(96);
					expr(0);
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(104);
			match(T__5);
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

	public static class FuncVarDefContext extends ParserRuleContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public OneVarDefContext oneVarDef() {
			return getRuleContext(OneVarDefContext.class,0);
		}
		public FuncVarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcVarDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterFuncVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitFuncVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitFuncVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncVarDefContext funcVarDef() throws RecognitionException {
		FuncVarDefContext _localctx = new FuncVarDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcVarDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			varType();
			setState(107);
			oneVarDef();
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

	public static class VarDefContext extends ParserRuleContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public List<OneVarDefContext> oneVarDef() {
			return getRuleContexts(OneVarDefContext.class);
		}
		public OneVarDefContext oneVarDef(int i) {
			return getRuleContext(OneVarDefContext.class,i);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			varType();
			setState(110);
			oneVarDef();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(111);
				match(T__4);
				setState(112);
				oneVarDef();
				}
				}
				setState(117);
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

	public static class ConstructFuncDefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MxstarParser.ID, 0); }
		public PartContext part() {
			return getRuleContext(PartContext.class,0);
		}
		public List<FuncVarDefContext> funcVarDef() {
			return getRuleContexts(FuncVarDefContext.class);
		}
		public FuncVarDefContext funcVarDef(int i) {
			return getRuleContext(FuncVarDefContext.class,i);
		}
		public ConstructFuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructFuncDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterConstructFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitConstructFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitConstructFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructFuncDefContext constructFuncDef() throws RecognitionException {
		ConstructFuncDefContext _localctx = new ConstructFuncDefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constructFuncDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(ID);
			setState(119);
			match(T__3);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << ID))) != 0)) {
				{
				setState(120);
				funcVarDef();
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(121);
					match(T__4);
					setState(122);
					funcVarDef();
					}
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(130);
			match(T__5);
			setState(131);
			part();
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

	public static class OneVarDefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MxstarParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public OneVarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneVarDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterOneVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitOneVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitOneVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OneVarDefContext oneVarDef() throws RecognitionException {
		OneVarDefContext _localctx = new OneVarDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_oneVarDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(ID);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(134);
				match(T__10);
				setState(135);
				expr(0);
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

	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprstmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprstmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterExprstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitExprstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitExprstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhilestmtContext extends StmtContext {
		public TerminalNode While() { return getToken(MxstarParser.While, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public WhilestmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterWhilestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitWhilestmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitWhilestmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForstmtContext extends StmtContext {
		public ExprContext init;
		public ExprContext cond;
		public ExprContext next;
		public TerminalNode For() { return getToken(MxstarParser.For, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ForstmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterForstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitForstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitForstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDefstmtContext extends StmtContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public VarDefstmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterVarDefstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitVarDefstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitVarDefstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfstmtContext extends StmtContext {
		public StmtContext st1;
		public StmtContext st2;
		public TerminalNode If() { return getToken(MxstarParser.If, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode Else() { return getToken(MxstarParser.Else, 0); }
		public IfstmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterIfstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitIfstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitIfstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PartstmtContext extends StmtContext {
		public PartContext part() {
			return getRuleContext(PartContext.class,0);
		}
		public PartstmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterPartstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitPartstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitPartstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnstmtContext extends StmtContext {
		public TerminalNode Return() { return getToken(MxstarParser.Return, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnstmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterReturnstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitReturnstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitReturnstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakstmtContext extends StmtContext {
		public TerminalNode Break() { return getToken(MxstarParser.Break, 0); }
		public BreakstmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterBreakstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitBreakstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitBreakstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SemistmtContext extends StmtContext {
		public SemistmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterSemistmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitSemistmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitSemistmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinuestmtContext extends StmtContext {
		public TerminalNode Continue() { return getToken(MxstarParser.Continue, 0); }
		public ContinuestmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterContinuestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitContinuestmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitContinuestmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stmt);
		int _la;
		try {
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new PartstmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				part();
				}
				break;
			case 2:
				_localctx = new VarDefstmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				varDef();
				setState(140);
				match(T__0);
				}
				break;
			case 3:
				_localctx = new IfstmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				match(If);
				setState(143);
				match(T__3);
				setState(144);
				expr(0);
				setState(145);
				match(T__5);
				setState(146);
				((IfstmtContext)_localctx).st1 = stmt();
				setState(149);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(147);
					match(Else);
					setState(148);
					((IfstmtContext)_localctx).st2 = stmt();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new ForstmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(151);
				match(For);
				setState(152);
				match(T__3);
				setState(155);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(153);
					varDef();
					}
					break;
				case 2:
					{
					setState(154);
					((ForstmtContext)_localctx).init = expr(0);
					}
					break;
				}
				setState(157);
				match(T__0);
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__6) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << ConstString) | (1L << ID) | (1L << Number))) != 0)) {
					{
					setState(158);
					((ForstmtContext)_localctx).cond = expr(0);
					}
				}

				setState(161);
				match(T__0);
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__6) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << ConstString) | (1L << ID) | (1L << Number))) != 0)) {
					{
					setState(162);
					((ForstmtContext)_localctx).next = expr(0);
					}
				}

				setState(165);
				match(T__5);
				setState(166);
				stmt();
				}
				break;
			case 5:
				_localctx = new WhilestmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(167);
				match(While);
				setState(168);
				match(T__3);
				setState(169);
				expr(0);
				setState(170);
				match(T__5);
				setState(171);
				stmt();
				}
				break;
			case 6:
				_localctx = new ReturnstmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(173);
				match(Return);
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__6) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << ConstString) | (1L << ID) | (1L << Number))) != 0)) {
					{
					setState(174);
					expr(0);
					}
				}

				setState(177);
				match(T__0);
				}
				break;
			case 7:
				_localctx = new ContinuestmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(178);
				match(Continue);
				setState(179);
				match(T__0);
				}
				break;
			case 8:
				_localctx = new BreakstmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(180);
				match(Break);
				setState(181);
				match(T__0);
				}
				break;
			case 9:
				_localctx = new ExprstmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(182);
				expr(0);
				setState(183);
				match(T__0);
				}
				break;
			case 10:
				_localctx = new SemistmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(185);
				match(T__0);
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

	public static class PartContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public PartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartContext part() throws RecognitionException {
		PartContext _localctx = new PartContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_part);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__1);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__6) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << ConstString) | (1L << ID) | (1L << Number))) != 0)) {
				{
				{
				setState(189);
				stmt();
				}
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(195);
			match(T__2);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterFuncexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitFuncexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitFuncexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixexprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrefixexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterPrefixexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitPrefixexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitPrefixexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryexprContext extends ExprContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimaryexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterPrimaryexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitPrimaryexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitPrimaryexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewexprContext extends ExprContext {
		public TerminalNode New() { return getToken(MxstarParser.New, 0); }
		public NewTypeContext newType() {
			return getRuleContext(NewTypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NewexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterNewexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitNewexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitNewexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuffixexprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SuffixexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterSuffixexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitSuffixexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitSuffixexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaexprContext extends ExprContext {
		public LambdaFuncContext lambdaFunc() {
			return getRuleContext(LambdaFuncContext.class,0);
		}
		public LambdaexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterLambdaexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitLambdaexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitLambdaexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryexprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinaryexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterBinaryexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitBinaryexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitBinaryexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AssignexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterAssignexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitAssignexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitAssignexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprinexprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprinexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterExprinexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitExprinexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitExprinexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterArrexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitArrexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitArrexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassexprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(MxstarParser.ID, 0); }
		public ClassexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterClassexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitClassexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitClassexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Null:
			case True:
			case False:
			case This:
			case ConstString:
			case ID:
			case Number:
				{
				_localctx = new PrimaryexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(198);
				primary();
				}
				break;
			case T__3:
				{
				_localctx = new ExprinexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				match(T__3);
				setState(200);
				expr(0);
				setState(201);
				match(T__5);
				}
				break;
			case New:
				{
				_localctx = new NewexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				match(New);
				setState(204);
				newType();
				setState(210);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(205);
					match(T__3);
					setState(207);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__6) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << ConstString) | (1L << ID) | (1L << Number))) != 0)) {
						{
						setState(206);
						expr(0);
						}
					}

					setState(209);
					match(T__5);
					}
					break;
				}
				}
				break;
			case T__12:
			case T__13:
				{
				_localctx = new PrefixexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				((PrefixexprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
					((PrefixexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(213);
				expr(12);
				}
				break;
			case T__14:
			case T__15:
				{
				_localctx = new PrefixexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				((PrefixexprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__14 || _la==T__15) ) {
					((PrefixexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(215);
				expr(11);
				}
				break;
			case T__16:
			case T__17:
				{
				_localctx = new PrefixexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				((PrefixexprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__16 || _la==T__17) ) {
					((PrefixexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(217);
				expr(10);
				}
				break;
			case T__6:
				{
				_localctx = new LambdaexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218);
				lambdaFunc();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(270);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(268);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(221);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(222);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(223);
						expr(10);
						}
						break;
					case 2:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(224);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(225);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__16 || _la==T__17) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(226);
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(227);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(228);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__22) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(229);
						expr(8);
						}
						break;
					case 4:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(230);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(231);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(232);
						expr(7);
						}
						break;
					case 5:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(233);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(234);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__27 || _la==T__28) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(235);
						expr(6);
						}
						break;
					case 6:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(236);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(237);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__29) | (1L << T__30))) != 0)) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(238);
						expr(5);
						}
						break;
					case 7:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(239);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(240);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__31 || _la==T__32) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(241);
						expr(4);
						}
						break;
					case 8:
						{
						_localctx = new AssignexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(242);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(243);
						match(T__10);
						setState(244);
						expr(2);
						}
						break;
					case 9:
						{
						_localctx = new ArrexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(245);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(246);
						match(T__6);
						setState(247);
						expr(0);
						setState(248);
						match(T__8);
						}
						break;
					case 10:
						{
						_localctx = new FuncexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(250);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(251);
						match(T__3);
						setState(260);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__6) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << ConstString) | (1L << ID) | (1L << Number))) != 0)) {
							{
							setState(252);
							expr(0);
							setState(257);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__4) {
								{
								{
								setState(253);
								match(T__4);
								setState(254);
								expr(0);
								}
								}
								setState(259);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(262);
						match(T__5);
						}
						break;
					case 11:
						{
						_localctx = new ClassexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(263);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(264);
						match(T__11);
						setState(265);
						match(ID);
						}
						break;
					case 12:
						{
						_localctx = new SuffixexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(266);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(267);
						((SuffixexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__12 || _la==T__13) ) {
							((SuffixexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(272);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ReturnTypeContext extends ParserRuleContext {
		public TerminalNode Void() { return getToken(MxstarParser.Void, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitReturnType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_returnType);
		try {
			setState(275);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				match(Void);
				}
				break;
			case Int:
			case Bool:
			case String:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
				varType();
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

	public static class VarTypeContext extends ParserRuleContext {
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterVarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitVarType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitVarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			basicType();
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(278);
				match(T__6);
				setState(279);
				match(T__8);
				}
				}
				setState(284);
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

	public static class NewTypeContext extends ParserRuleContext {
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public NewTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterNewType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitNewType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitNewType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewTypeContext newType() throws RecognitionException {
		NewTypeContext _localctx = new NewTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_newType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			basicType();
			setState(292);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(286);
					match(T__6);
					setState(287);
					expr(0);
					setState(288);
					match(T__8);
					}
					} 
				}
				setState(294);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			setState(299);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(295);
					match(T__6);
					setState(296);
					match(T__8);
					}
					} 
				}
				setState(301);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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

	public static class BasicTypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MxstarParser.ID, 0); }
		public TerminalNode Bool() { return getToken(MxstarParser.Bool, 0); }
		public TerminalNode Int() { return getToken(MxstarParser.Int, 0); }
		public TerminalNode String() { return getToken(MxstarParser.String, 0); }
		public BasicTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterBasicType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitBasicType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitBasicType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicTypeContext basicType() throws RecognitionException {
		BasicTypeContext _localctx = new BasicTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_basicType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << ID))) != 0)) ) {
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

	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MxstarParser.ID, 0); }
		public TerminalNode Number() { return getToken(MxstarParser.Number, 0); }
		public TerminalNode Null() { return getToken(MxstarParser.Null, 0); }
		public TerminalNode This() { return getToken(MxstarParser.This, 0); }
		public TerminalNode True() { return getToken(MxstarParser.True, 0); }
		public TerminalNode False() { return getToken(MxstarParser.False, 0); }
		public TerminalNode ConstString() { return getToken(MxstarParser.ConstString, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxstarListener ) ((MxstarListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxstarVisitor ) return ((MxstarVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << ConstString) | (1L << ID) | (1L << Number))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 16);
		case 9:
			return precpred(_ctx, 15);
		case 10:
			return precpred(_ctx, 14);
		case 11:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00018\u0133\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"&\b\u0000\n\u0000\f\u0000)\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"3\b\u0001\n\u0001\f\u00016\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002A\b\u0002\n\u0002\f\u0002D\t\u0002\u0003\u0002F\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003R\b\u0003\n\u0003"+
		"\f\u0003U\t\u0003\u0003\u0003W\b\u0003\u0001\u0003\u0003\u0003Z\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003b\b\u0003\n\u0003\f\u0003e\t\u0003\u0003\u0003g\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005r\b\u0005\n\u0005\f\u0005u\t"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006|\b\u0006\n\u0006\f\u0006\u007f\t\u0006\u0003\u0006\u0081\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\u0089\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0096\b\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u009c\b\b\u0001\b\u0001\b\u0003\b\u00a0\b\b"+
		"\u0001\b\u0001\b\u0003\b\u00a4\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00b0\b\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00bb"+
		"\b\b\u0001\t\u0001\t\u0005\t\u00bf\b\t\n\t\f\t\u00c2\t\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u00d0\b\n\u0001\n\u0003\n\u00d3\b\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00dc\b\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0100\b\n\n\n\f\n\u0103"+
		"\t\n\u0003\n\u0105\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0005\n\u010d\b\n\n\n\f\n\u0110\t\n\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u0114\b\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u0119\b\f\n\f\f\f\u011c"+
		"\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0123\b\r\n\r\f\r"+
		"\u0126\t\r\u0001\r\u0001\r\u0005\r\u012a\b\r\n\r\f\r\u012d\t\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0000\u0001\u0014\u0010"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e\u0000\u000b\u0001\u0000\r\u000e\u0001\u0000\u000f\u0010\u0001"+
		"\u0000\u0011\u0012\u0001\u0000\u0013\u0015\u0001\u0000\u0016\u0017\u0001"+
		"\u0000\u0018\u001b\u0001\u0000\u001c\u001d\u0002\u0000\b\b\u001e\u001f"+
		"\u0001\u0000 !\u0002\u0000\"$44\u0002\u0000(+35\u015d\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0002*\u0001\u0000\u0000\u0000\u0004:\u0001\u0000\u0000\u0000"+
		"\u0006J\u0001\u0000\u0000\u0000\bj\u0001\u0000\u0000\u0000\nm\u0001\u0000"+
		"\u0000\u0000\fv\u0001\u0000\u0000\u0000\u000e\u0085\u0001\u0000\u0000"+
		"\u0000\u0010\u00ba\u0001\u0000\u0000\u0000\u0012\u00bc\u0001\u0000\u0000"+
		"\u0000\u0014\u00db\u0001\u0000\u0000\u0000\u0016\u0113\u0001\u0000\u0000"+
		"\u0000\u0018\u0115\u0001\u0000\u0000\u0000\u001a\u011d\u0001\u0000\u0000"+
		"\u0000\u001c\u012e\u0001\u0000\u0000\u0000\u001e\u0130\u0001\u0000\u0000"+
		"\u0000 &\u0003\u0004\u0002\u0000!\"\u0003\n\u0005\u0000\"#\u0005\u0001"+
		"\u0000\u0000#&\u0001\u0000\u0000\u0000$&\u0003\u0002\u0001\u0000% \u0001"+
		"\u0000\u0000\u0000%!\u0001\u0000\u0000\u0000%$\u0001\u0000\u0000\u0000"+
		"&)\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000"+
		"\u0000(\u0001\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000*+\u0005"+
		"\'\u0000\u0000+,\u00054\u0000\u0000,4\u0005\u0002\u0000\u0000-3\u0003"+
		"\u0004\u0002\u0000.3\u0003\f\u0006\u0000/0\u0003\n\u0005\u000001\u0005"+
		"\u0001\u0000\u000013\u0001\u0000\u0000\u00002-\u0001\u0000\u0000\u0000"+
		"2.\u0001\u0000\u0000\u00002/\u0001\u0000\u0000\u000036\u0001\u0000\u0000"+
		"\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000057\u0001\u0000"+
		"\u0000\u000064\u0001\u0000\u0000\u000078\u0005\u0003\u0000\u000089\u0005"+
		"\u0001\u0000\u00009\u0003\u0001\u0000\u0000\u0000:;\u0003\u0016\u000b"+
		"\u0000;<\u00054\u0000\u0000<E\u0005\u0004\u0000\u0000=B\u0003\b\u0004"+
		"\u0000>?\u0005\u0005\u0000\u0000?A\u0003\b\u0004\u0000@>\u0001\u0000\u0000"+
		"\u0000AD\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000"+
		"\u0000\u0000CF\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000E=\u0001"+
		"\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000"+
		"GH\u0005\u0006\u0000\u0000HI\u0003\u0012\t\u0000I\u0005\u0001\u0000\u0000"+
		"\u0000JK\u0005\u0007\u0000\u0000KL\u0005\b\u0000\u0000LY\u0005\t\u0000"+
		"\u0000MV\u0005\u0004\u0000\u0000NS\u0003\b\u0004\u0000OP\u0005\u0005\u0000"+
		"\u0000PR\u0003\b\u0004\u0000QO\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000"+
		"\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TW\u0001\u0000"+
		"\u0000\u0000US\u0001\u0000\u0000\u0000VN\u0001\u0000\u0000\u0000VW\u0001"+
		"\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XZ\u0005\u0006\u0000\u0000"+
		"YM\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000"+
		"\u0000[\\\u0005\n\u0000\u0000\\]\u0003\u0012\t\u0000]f\u0005\u0004\u0000"+
		"\u0000^c\u0003\u0014\n\u0000_`\u0005\u0005\u0000\u0000`b\u0003\u0014\n"+
		"\u0000a_\u0001\u0000\u0000\u0000be\u0001\u0000\u0000\u0000ca\u0001\u0000"+
		"\u0000\u0000cd\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001"+
		"\u0000\u0000\u0000f^\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000"+
		"gh\u0001\u0000\u0000\u0000hi\u0005\u0006\u0000\u0000i\u0007\u0001\u0000"+
		"\u0000\u0000jk\u0003\u0018\f\u0000kl\u0003\u000e\u0007\u0000l\t\u0001"+
		"\u0000\u0000\u0000mn\u0003\u0018\f\u0000ns\u0003\u000e\u0007\u0000op\u0005"+
		"\u0005\u0000\u0000pr\u0003\u000e\u0007\u0000qo\u0001\u0000\u0000\u0000"+
		"ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000"+
		"\u0000t\u000b\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000vw\u0005"+
		"4\u0000\u0000w\u0080\u0005\u0004\u0000\u0000x}\u0003\b\u0004\u0000yz\u0005"+
		"\u0005\u0000\u0000z|\u0003\b\u0004\u0000{y\u0001\u0000\u0000\u0000|\u007f"+
		"\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000"+
		"\u0000~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080"+
		"x\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u0006\u0000\u0000\u0083\u0084"+
		"\u0003\u0012\t\u0000\u0084\r\u0001\u0000\u0000\u0000\u0085\u0088\u0005"+
		"4\u0000\u0000\u0086\u0087\u0005\u000b\u0000\u0000\u0087\u0089\u0003\u0014"+
		"\n\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000"+
		"\u0000\u0089\u000f\u0001\u0000\u0000\u0000\u008a\u00bb\u0003\u0012\t\u0000"+
		"\u008b\u008c\u0003\n\u0005\u0000\u008c\u008d\u0005\u0001\u0000\u0000\u008d"+
		"\u00bb\u0001\u0000\u0000\u0000\u008e\u008f\u0005,\u0000\u0000\u008f\u0090"+
		"\u0005\u0004\u0000\u0000\u0090\u0091\u0003\u0014\n\u0000\u0091\u0092\u0005"+
		"\u0006\u0000\u0000\u0092\u0095\u0003\u0010\b\u0000\u0093\u0094\u0005-"+
		"\u0000\u0000\u0094\u0096\u0003\u0010\b\u0000\u0095\u0093\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u00bb\u0001\u0000\u0000"+
		"\u0000\u0097\u0098\u0005.\u0000\u0000\u0098\u009b\u0005\u0004\u0000\u0000"+
		"\u0099\u009c\u0003\n\u0005\u0000\u009a\u009c\u0003\u0014\n\u0000\u009b"+
		"\u0099\u0001\u0000\u0000\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d"+
		"\u009f\u0005\u0001\u0000\u0000\u009e\u00a0\u0003\u0014\n\u0000\u009f\u009e"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a3\u0005\u0001\u0000\u0000\u00a2\u00a4"+
		"\u0003\u0014\n\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005"+
		"\u0006\u0000\u0000\u00a6\u00bb\u0003\u0010\b\u0000\u00a7\u00a8\u0005/"+
		"\u0000\u0000\u00a8\u00a9\u0005\u0004\u0000\u0000\u00a9\u00aa\u0003\u0014"+
		"\n\u0000\u00aa\u00ab\u0005\u0006\u0000\u0000\u00ab\u00ac\u0003\u0010\b"+
		"\u0000\u00ac\u00bb\u0001\u0000\u0000\u0000\u00ad\u00af\u00052\u0000\u0000"+
		"\u00ae\u00b0\u0003\u0014\n\u0000\u00af\u00ae\u0001\u0000\u0000\u0000\u00af"+
		"\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1"+
		"\u00bb\u0005\u0001\u0000\u0000\u00b2\u00b3\u00051\u0000\u0000\u00b3\u00bb"+
		"\u0005\u0001\u0000\u0000\u00b4\u00b5\u00050\u0000\u0000\u00b5\u00bb\u0005"+
		"\u0001\u0000\u0000\u00b6\u00b7\u0003\u0014\n\u0000\u00b7\u00b8\u0005\u0001"+
		"\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9\u00bb\u0005\u0001"+
		"\u0000\u0000\u00ba\u008a\u0001\u0000\u0000\u0000\u00ba\u008b\u0001\u0000"+
		"\u0000\u0000\u00ba\u008e\u0001\u0000\u0000\u0000\u00ba\u0097\u0001\u0000"+
		"\u0000\u0000\u00ba\u00a7\u0001\u0000\u0000\u0000\u00ba\u00ad\u0001\u0000"+
		"\u0000\u0000\u00ba\u00b2\u0001\u0000\u0000\u0000\u00ba\u00b4\u0001\u0000"+
		"\u0000\u0000\u00ba\u00b6\u0001\u0000\u0000\u0000\u00ba\u00b9\u0001\u0000"+
		"\u0000\u0000\u00bb\u0011\u0001\u0000\u0000\u0000\u00bc\u00c0\u0005\u0002"+
		"\u0000\u0000\u00bd\u00bf\u0003\u0010\b\u0000\u00be\u00bd\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c2\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000"+
		"\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c3\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005\u0003\u0000"+
		"\u0000\u00c4\u0013\u0001\u0000\u0000\u0000\u00c5\u00c6\u0006\n\uffff\uffff"+
		"\u0000\u00c6\u00dc\u0003\u001e\u000f\u0000\u00c7\u00c8\u0005\u0004\u0000"+
		"\u0000\u00c8\u00c9\u0003\u0014\n\u0000\u00c9\u00ca\u0005\u0006\u0000\u0000"+
		"\u00ca\u00dc\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005&\u0000\u0000\u00cc"+
		"\u00d2\u0003\u001a\r\u0000\u00cd\u00cf\u0005\u0004\u0000\u0000\u00ce\u00d0"+
		"\u0003\u0014\n\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001"+
		"\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d3\u0005"+
		"\u0006\u0000\u0000\u00d2\u00cd\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d3\u00dc\u0001\u0000\u0000\u0000\u00d4\u00d5\u0007"+
		"\u0000\u0000\u0000\u00d5\u00dc\u0003\u0014\n\f\u00d6\u00d7\u0007\u0001"+
		"\u0000\u0000\u00d7\u00dc\u0003\u0014\n\u000b\u00d8\u00d9\u0007\u0002\u0000"+
		"\u0000\u00d9\u00dc\u0003\u0014\n\n\u00da\u00dc\u0003\u0006\u0003\u0000"+
		"\u00db\u00c5\u0001\u0000\u0000\u0000\u00db\u00c7\u0001\u0000\u0000\u0000"+
		"\u00db\u00cb\u0001\u0000\u0000\u0000\u00db\u00d4\u0001\u0000\u0000\u0000"+
		"\u00db\u00d6\u0001\u0000\u0000\u0000\u00db\u00d8\u0001\u0000\u0000\u0000"+
		"\u00db\u00da\u0001\u0000\u0000\u0000\u00dc\u010e\u0001\u0000\u0000\u0000"+
		"\u00dd\u00de\n\t\u0000\u0000\u00de\u00df\u0007\u0003\u0000\u0000\u00df"+
		"\u010d\u0003\u0014\n\n\u00e0\u00e1\n\b\u0000\u0000\u00e1\u00e2\u0007\u0002"+
		"\u0000\u0000\u00e2\u010d\u0003\u0014\n\t\u00e3\u00e4\n\u0007\u0000\u0000"+
		"\u00e4\u00e5\u0007\u0004\u0000\u0000\u00e5\u010d\u0003\u0014\n\b\u00e6"+
		"\u00e7\n\u0006\u0000\u0000\u00e7\u00e8\u0007\u0005\u0000\u0000\u00e8\u010d"+
		"\u0003\u0014\n\u0007\u00e9\u00ea\n\u0005\u0000\u0000\u00ea\u00eb\u0007"+
		"\u0006\u0000\u0000\u00eb\u010d\u0003\u0014\n\u0006\u00ec\u00ed\n\u0004"+
		"\u0000\u0000\u00ed\u00ee\u0007\u0007\u0000\u0000\u00ee\u010d\u0003\u0014"+
		"\n\u0005\u00ef\u00f0\n\u0003\u0000\u0000\u00f0\u00f1\u0007\b\u0000\u0000"+
		"\u00f1\u010d\u0003\u0014\n\u0004\u00f2\u00f3\n\u0002\u0000\u0000\u00f3"+
		"\u00f4\u0005\u000b\u0000\u0000\u00f4\u010d\u0003\u0014\n\u0002\u00f5\u00f6"+
		"\n\u0010\u0000\u0000\u00f6\u00f7\u0005\u0007\u0000\u0000\u00f7\u00f8\u0003"+
		"\u0014\n\u0000\u00f8\u00f9\u0005\t\u0000\u0000\u00f9\u010d\u0001\u0000"+
		"\u0000\u0000\u00fa\u00fb\n\u000f\u0000\u0000\u00fb\u0104\u0005\u0004\u0000"+
		"\u0000\u00fc\u0101\u0003\u0014\n\u0000\u00fd\u00fe\u0005\u0005\u0000\u0000"+
		"\u00fe\u0100\u0003\u0014\n\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u0100"+
		"\u0103\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0101"+
		"\u0102\u0001\u0000\u0000\u0000\u0102\u0105\u0001\u0000\u0000\u0000\u0103"+
		"\u0101\u0001\u0000\u0000\u0000\u0104\u00fc\u0001\u0000\u0000\u0000\u0104"+
		"\u0105\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106"+
		"\u010d\u0005\u0006\u0000\u0000\u0107\u0108\n\u000e\u0000\u0000\u0108\u0109"+
		"\u0005\f\u0000\u0000\u0109\u010d\u00054\u0000\u0000\u010a\u010b\n\r\u0000"+
		"\u0000\u010b\u010d\u0007\u0000\u0000\u0000\u010c\u00dd\u0001\u0000\u0000"+
		"\u0000\u010c\u00e0\u0001\u0000\u0000\u0000\u010c\u00e3\u0001\u0000\u0000"+
		"\u0000\u010c\u00e6\u0001\u0000\u0000\u0000\u010c\u00e9\u0001\u0000\u0000"+
		"\u0000\u010c\u00ec\u0001\u0000\u0000\u0000\u010c\u00ef\u0001\u0000\u0000"+
		"\u0000\u010c\u00f2\u0001\u0000\u0000\u0000\u010c\u00f5\u0001\u0000\u0000"+
		"\u0000\u010c\u00fa\u0001\u0000\u0000\u0000\u010c\u0107\u0001\u0000\u0000"+
		"\u0000\u010c\u010a\u0001\u0000\u0000\u0000\u010d\u0110\u0001\u0000\u0000"+
		"\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000"+
		"\u0000\u010f\u0015\u0001\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000"+
		"\u0000\u0111\u0114\u0005%\u0000\u0000\u0112\u0114\u0003\u0018\f\u0000"+
		"\u0113\u0111\u0001\u0000\u0000\u0000\u0113\u0112\u0001\u0000\u0000\u0000"+
		"\u0114\u0017\u0001\u0000\u0000\u0000\u0115\u011a\u0003\u001c\u000e\u0000"+
		"\u0116\u0117\u0005\u0007\u0000\u0000\u0117\u0119\u0005\t\u0000\u0000\u0118"+
		"\u0116\u0001\u0000\u0000\u0000\u0119\u011c\u0001\u0000\u0000\u0000\u011a"+
		"\u0118\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b"+
		"\u0019\u0001\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011d"+
		"\u0124\u0003\u001c\u000e\u0000\u011e\u011f\u0005\u0007\u0000\u0000\u011f"+
		"\u0120\u0003\u0014\n\u0000\u0120\u0121\u0005\t\u0000\u0000\u0121\u0123"+
		"\u0001\u0000\u0000\u0000\u0122\u011e\u0001\u0000\u0000\u0000\u0123\u0126"+
		"\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0124\u0125"+
		"\u0001\u0000\u0000\u0000\u0125\u012b\u0001\u0000\u0000\u0000\u0126\u0124"+
		"\u0001\u0000\u0000\u0000\u0127\u0128\u0005\u0007\u0000\u0000\u0128\u012a"+
		"\u0005\t\u0000\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u012a\u012d\u0001"+
		"\u0000\u0000\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012b\u012c\u0001"+
		"\u0000\u0000\u0000\u012c\u001b\u0001\u0000\u0000\u0000\u012d\u012b\u0001"+
		"\u0000\u0000\u0000\u012e\u012f\u0007\t\u0000\u0000\u012f\u001d\u0001\u0000"+
		"\u0000\u0000\u0130\u0131\u0007\n\u0000\u0000\u0131\u001f\u0001\u0000\u0000"+
		"\u0000!%\'24BESVYcfs}\u0080\u0088\u0095\u009b\u009f\u00a3\u00af\u00ba"+
		"\u00c0\u00cf\u00d2\u00db\u0101\u0104\u010c\u010e\u0113\u011a\u0124\u012b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}