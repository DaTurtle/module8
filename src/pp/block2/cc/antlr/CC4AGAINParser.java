// Generated from C:/Users/Bas/Documents/GitHub/module8/src/pp/block2/cc/antlr\CC4AGAIN.g4 by ANTLR 4.5.1
package pp.block2.cc.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CC4AGAINParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		A=1, B=2, C=3;
	public static final int
		RULE_l = 0, RULE_r = 1, RULE_r2 = 2, RULE_q = 3, RULE_q2 = 4;
	public static final String[] ruleNames = {
		"l", "r", "r2", "q", "q2"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'a'", "'b'", "'c'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "A", "B", "C"
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
	public String getGrammarFileName() { return "CC4AGAIN.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CC4AGAINParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LContext extends ParserRuleContext {
		public RContext r() {
			return getRuleContext(RContext.class,0);
		}
		public TerminalNode A() { return getToken(CC4AGAINParser.A, 0); }
		public QContext q() {
			return getRuleContext(QContext.class,0);
		}
		public TerminalNode B() { return getToken(CC4AGAINParser.B, 0); }
		public LContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_l; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC4AGAINListener ) ((CC4AGAINListener)listener).enterL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC4AGAINListener ) ((CC4AGAINListener)listener).exitL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CC4AGAINVisitor ) return ((CC4AGAINVisitor<? extends T>)visitor).visitL(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LContext l() throws RecognitionException {
		LContext _localctx = new LContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_l);
		try {
			setState(17);
			switch (_input.LA(1)) {
			case A:
			case C:
				enterOuterAlt(_localctx, 1);
				{
				setState(10);
				r();
				setState(11);
				match(A);
				}
				break;
			case B:
				enterOuterAlt(_localctx, 2);
				{
				setState(13);
				q();
				setState(14);
				match(B);
				setState(15);
				match(A);
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

	public static class RContext extends ParserRuleContext {
		public List<TerminalNode> A() { return getTokens(CC4AGAINParser.A); }
		public TerminalNode A(int i) {
			return getToken(CC4AGAINParser.A, i);
		}
		public TerminalNode B() { return getToken(CC4AGAINParser.B, 0); }
		public R2Context r2() {
			return getRuleContext(R2Context.class,0);
		}
		public TerminalNode C() { return getToken(CC4AGAINParser.C, 0); }
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC4AGAINListener ) ((CC4AGAINListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC4AGAINListener ) ((CC4AGAINListener)listener).exitR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CC4AGAINVisitor ) return ((CC4AGAINVisitor<? extends T>)visitor).visitR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_r);
		try {
			setState(28);
			switch (_input.LA(1)) {
			case A:
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				match(A);
				setState(20);
				match(B);
				setState(21);
				match(A);
				setState(22);
				r2();
				}
				break;
			case C:
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				match(C);
				setState(24);
				match(A);
				setState(25);
				match(B);
				setState(26);
				match(A);
				setState(27);
				r2();
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

	public static class R2Context extends ParserRuleContext {
		public TerminalNode B() { return getToken(CC4AGAINParser.B, 0); }
		public TerminalNode C() { return getToken(CC4AGAINParser.C, 0); }
		public R2Context r2() {
			return getRuleContext(R2Context.class,0);
		}
		public R2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC4AGAINListener ) ((CC4AGAINListener)listener).enterR2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC4AGAINListener ) ((CC4AGAINListener)listener).exitR2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CC4AGAINVisitor ) return ((CC4AGAINVisitor<? extends T>)visitor).visitR2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final R2Context r2() throws RecognitionException {
		R2Context _localctx = new R2Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_r2);
		try {
			setState(34);
			switch (_input.LA(1)) {
			case B:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				match(B);
				setState(31);
				match(C);
				setState(32);
				r2();
				}
				break;
			case A:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class QContext extends ParserRuleContext {
		public TerminalNode B() { return getToken(CC4AGAINParser.B, 0); }
		public Q2Context q2() {
			return getRuleContext(Q2Context.class,0);
		}
		public QContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_q; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC4AGAINListener ) ((CC4AGAINListener)listener).enterQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC4AGAINListener ) ((CC4AGAINListener)listener).exitQ(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CC4AGAINVisitor ) return ((CC4AGAINVisitor<? extends T>)visitor).visitQ(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QContext q() throws RecognitionException {
		QContext _localctx = new QContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_q);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(B);
			setState(37);
			q2();
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

	public static class Q2Context extends ParserRuleContext {
		public TerminalNode B() { return getToken(CC4AGAINParser.B, 0); }
		public TerminalNode C() { return getToken(CC4AGAINParser.C, 0); }
		public Q2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_q2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC4AGAINListener ) ((CC4AGAINListener)listener).enterQ2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC4AGAINListener ) ((CC4AGAINListener)listener).exitQ2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CC4AGAINVisitor ) return ((CC4AGAINVisitor<? extends T>)visitor).visitQ2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Q2Context q2() throws RecognitionException {
		Q2Context _localctx = new Q2Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_q2);
		try {
			setState(42);
			switch (_input.LA(1)) {
			case B:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(B);
				setState(40);
				match(C);
				}
				break;
			case C:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				match(C);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\5/\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\24\n\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\37\n\3\3\4\3\4\3\4\3\4\5\4%\n\4\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\5\6-\n\6\3\6\2\2\7\2\4\6\b\n\2\2-\2\23\3\2\2\2"+
		"\4\36\3\2\2\2\6$\3\2\2\2\b&\3\2\2\2\n,\3\2\2\2\f\r\5\4\3\2\r\16\7\3\2"+
		"\2\16\24\3\2\2\2\17\20\5\b\5\2\20\21\7\4\2\2\21\22\7\3\2\2\22\24\3\2\2"+
		"\2\23\f\3\2\2\2\23\17\3\2\2\2\24\3\3\2\2\2\25\26\7\3\2\2\26\27\7\4\2\2"+
		"\27\30\7\3\2\2\30\37\5\6\4\2\31\32\7\5\2\2\32\33\7\3\2\2\33\34\7\4\2\2"+
		"\34\35\7\3\2\2\35\37\5\6\4\2\36\25\3\2\2\2\36\31\3\2\2\2\37\5\3\2\2\2"+
		" !\7\4\2\2!\"\7\5\2\2\"%\5\6\4\2#%\3\2\2\2$ \3\2\2\2$#\3\2\2\2%\7\3\2"+
		"\2\2&\'\7\4\2\2\'(\5\n\6\2(\t\3\2\2\2)*\7\4\2\2*-\7\5\2\2+-\7\5\2\2,)"+
		"\3\2\2\2,+\3\2\2\2-\13\3\2\2\2\6\23\36$,";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}