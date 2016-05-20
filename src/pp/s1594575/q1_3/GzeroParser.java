// Generated from C:/Users/Jan-Willem/IdeaProjects/module8/src/pp/s1594575/q1_3\Gzero.g4 by ANTLR 4.5.1
package pp.s1594575.q1_3;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GzeroParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, ID=3, WS=4;
	public static final int
		RULE_e = 0, RULE_eprime = 1, RULE_f = 2, RULE_t = 3, RULE_tprime = 4;
	public static final String[] ruleNames = {
		"e", "eprime", "f", "t", "tprime"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "ID", "WS"
	};
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
	public String getGrammarFileName() { return "Gzero.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GzeroParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EContext extends ParserRuleContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public EprimeContext eprime() {
			return getRuleContext(EprimeContext.class,0);
		}
		public EContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_e; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GzeroListener ) ((GzeroListener)listener).enterE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GzeroListener ) ((GzeroListener)listener).exitE(this);
		}
	}

	public final EContext e() throws RecognitionException {
		EContext _localctx = new EContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_e);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			f();
			setState(12);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(11);
				eprime();
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

	public static class EprimeContext extends ParserRuleContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public EprimeContext eprime() {
			return getRuleContext(EprimeContext.class,0);
		}
		public EprimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eprime; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GzeroListener ) ((GzeroListener)listener).enterEprime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GzeroListener ) ((GzeroListener)listener).exitEprime(this);
		}
	}

	public final EprimeContext eprime() throws RecognitionException {
		EprimeContext _localctx = new EprimeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_eprime);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			match(T__0);
			setState(15);
			f();
			setState(17);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(16);
				eprime();
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

	public static class FContext extends ParserRuleContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GzeroListener ) ((GzeroListener)listener).enterF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GzeroListener ) ((GzeroListener)listener).exitF(this);
		}
	}

	public final FContext f() throws RecognitionException {
		FContext _localctx = new FContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_f);
		try {
			setState(25);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(19);
				match(T__1);
				setState(20);
				f();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(21);
				match(T__1);
				setState(22);
				match(T__1);
				setState(23);
				f();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(24);
				t();
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

	public static class TContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GzeroParser.ID, 0); }
		public TprimeContext tprime() {
			return getRuleContext(TprimeContext.class,0);
		}
		public TContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GzeroListener ) ((GzeroListener)listener).enterT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GzeroListener ) ((GzeroListener)listener).exitT(this);
		}
	}

	public final TContext t() throws RecognitionException {
		TContext _localctx = new TContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_t);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(ID);
			setState(29);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(28);
				tprime();
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

	public static class TprimeContext extends ParserRuleContext {
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public TprimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tprime; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GzeroListener ) ((GzeroListener)listener).enterTprime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GzeroListener ) ((GzeroListener)listener).exitTprime(this);
		}
	}

	public final TprimeContext tprime() throws RecognitionException {
		TprimeContext _localctx = new TprimeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tprime);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(T__0);
			setState(32);
			match(T__0);
			setState(34);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(33);
				t();
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\6\'\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\5\2\17\n\2\3\3\3\3\3\3\5\3\24\n\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4\34\n\4\3\5\3\5\5\5 \n\5\3\6\3\6\3\6\5\6%\n"+
		"\6\3\6\2\2\7\2\4\6\b\n\2\2\'\2\f\3\2\2\2\4\20\3\2\2\2\6\33\3\2\2\2\b\35"+
		"\3\2\2\2\n!\3\2\2\2\f\16\5\6\4\2\r\17\5\4\3\2\16\r\3\2\2\2\16\17\3\2\2"+
		"\2\17\3\3\2\2\2\20\21\7\3\2\2\21\23\5\6\4\2\22\24\5\4\3\2\23\22\3\2\2"+
		"\2\23\24\3\2\2\2\24\5\3\2\2\2\25\26\7\4\2\2\26\34\5\6\4\2\27\30\7\4\2"+
		"\2\30\31\7\4\2\2\31\34\5\6\4\2\32\34\5\b\5\2\33\25\3\2\2\2\33\27\3\2\2"+
		"\2\33\32\3\2\2\2\34\7\3\2\2\2\35\37\7\5\2\2\36 \5\n\6\2\37\36\3\2\2\2"+
		"\37 \3\2\2\2 \t\3\2\2\2!\"\7\3\2\2\"$\7\3\2\2#%\5\b\5\2$#\3\2\2\2$%\3"+
		"\2\2\2%\13\3\2\2\2\7\16\23\33\37$";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}