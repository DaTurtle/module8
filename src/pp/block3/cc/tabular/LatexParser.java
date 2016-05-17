// Generated from C:/Users/Jan-Willem/IdeaProjects/module8/src/pp/block3/cc/tabular\Latex.g4 by ANTLR 4.5.1
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LatexParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, WS=8, ALPHANUM=9, 
		EOL=10, LCR=11;
	public static final int
		RULE_total = 0, RULE_comment = 1, RULE_tabular = 2, RULE_table = 3, RULE_row = 4, 
		RULE_entry = 5;
	public static final String[] ruleNames = {
		"total", "comment", "tabular", "table", "row", "entry"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'%'", "' '", "'\\begin{tabular}{'", "'}'", "'\\end{tabular}'", 
		"'&'", "'\\\\'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "WS", "ALPHANUM", "EOL", 
		"LCR"
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
	public String getGrammarFileName() { return "Latex.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LatexParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TotalContext extends ParserRuleContext {
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public List<TabularContext> tabular() {
			return getRuleContexts(TabularContext.class);
		}
		public TabularContext tabular(int i) {
			return getRuleContext(TabularContext.class,i);
		}
		public TotalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_total; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).enterTotal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).exitTotal(this);
		}
	}

	public final TotalContext total() throws RecognitionException {
		TotalContext _localctx = new TotalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_total);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(14);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(12);
					comment();
					}
					break;
				case T__1:
				case T__2:
					{
					setState(13);
					tabular();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(16); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0) );
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

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode EOL() { return getToken(LatexParser.EOL, 0); }
		public List<TerminalNode> ALPHANUM() { return getTokens(LatexParser.ALPHANUM); }
		public TerminalNode ALPHANUM(int i) {
			return getToken(LatexParser.ALPHANUM, i);
		}
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).exitComment(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_comment);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(T__0);
			setState(22);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(19);
					_la = _input.LA(1);
					if ( !(_la==T__1 || _la==ALPHANUM) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					} 
				}
				setState(24);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(25);
			match(EOL);
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

	public static class TabularContext extends ParserRuleContext {
		public TerminalNode LCR() { return getToken(LatexParser.LCR, 0); }
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public TabularContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tabular; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).enterTabular(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).exitTabular(this);
		}
	}

	public final TabularContext tabular() throws RecognitionException {
		TabularContext _localctx = new TabularContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tabular);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(27);
				match(T__1);
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(33);
			match(T__2);
			setState(34);
			match(LCR);
			setState(35);
			match(T__3);
			{
			setState(39);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(36);
					match(T__1);
					}
					} 
				}
				setState(41);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
			setState(42);
			table();
			{
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(43);
				match(T__1);
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(49);
			match(T__4);
			{
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(50);
					match(T__1);
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class TableContext extends ParserRuleContext {
		public List<RowContext> row() {
			return getRuleContexts(RowContext.class);
		}
		public RowContext row(int i) {
			return getRuleContext(RowContext.class,i);
		}
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).exitTable(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(56);
					row();
					}
					} 
				}
				setState(61);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class RowContext extends ParserRuleContext {
		public List<EntryContext> entry() {
			return getRuleContexts(EntryContext.class);
		}
		public EntryContext entry(int i) {
			return getRuleContext(EntryContext.class,i);
		}
		public RowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).enterRow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).exitRow(this);
		}
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_row);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(62);
					match(T__1);
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
			setState(68);
			entry();
			{
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(69);
				match(T__1);
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(75);
				match(T__5);
				{
				setState(79);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(76);
						match(T__1);
						}
						} 
					}
					setState(81);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				}
				setState(82);
				entry();
				{
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(83);
					match(T__1);
					}
					}
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(T__6);
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

	public static class EntryContext extends ParserRuleContext {
		public List<TerminalNode> ALPHANUM() { return getTokens(LatexParser.ALPHANUM); }
		public TerminalNode ALPHANUM(int i) {
			return getToken(LatexParser.ALPHANUM, i);
		}
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).enterEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).exitEntry(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_entry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ALPHANUM) {
				{
				{
				setState(96);
				match(ALPHANUM);
				}
				}
				setState(101);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\ri\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\6\2\21\n\2\r\2\16\2\22\3\3"+
		"\3\3\7\3\27\n\3\f\3\16\3\32\13\3\3\3\3\3\3\4\7\4\37\n\4\f\4\16\4\"\13"+
		"\4\3\4\3\4\3\4\3\4\7\4(\n\4\f\4\16\4+\13\4\3\4\3\4\7\4/\n\4\f\4\16\4\62"+
		"\13\4\3\4\3\4\7\4\66\n\4\f\4\16\49\13\4\3\5\7\5<\n\5\f\5\16\5?\13\5\3"+
		"\6\7\6B\n\6\f\6\16\6E\13\6\3\6\3\6\7\6I\n\6\f\6\16\6L\13\6\3\6\3\6\7\6"+
		"P\n\6\f\6\16\6S\13\6\3\6\3\6\7\6W\n\6\f\6\16\6Z\13\6\7\6\\\n\6\f\6\16"+
		"\6_\13\6\3\6\3\6\3\7\7\7d\n\7\f\7\16\7g\13\7\3\7\3\30\2\b\2\4\6\b\n\f"+
		"\2\3\4\2\4\4\13\13p\2\20\3\2\2\2\4\24\3\2\2\2\6 \3\2\2\2\b=\3\2\2\2\n"+
		"C\3\2\2\2\fe\3\2\2\2\16\21\5\4\3\2\17\21\5\6\4\2\20\16\3\2\2\2\20\17\3"+
		"\2\2\2\21\22\3\2\2\2\22\20\3\2\2\2\22\23\3\2\2\2\23\3\3\2\2\2\24\30\7"+
		"\3\2\2\25\27\t\2\2\2\26\25\3\2\2\2\27\32\3\2\2\2\30\31\3\2\2\2\30\26\3"+
		"\2\2\2\31\33\3\2\2\2\32\30\3\2\2\2\33\34\7\f\2\2\34\5\3\2\2\2\35\37\7"+
		"\4\2\2\36\35\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!#\3\2\2\2\" \3"+
		"\2\2\2#$\7\5\2\2$%\7\r\2\2%)\7\6\2\2&(\7\4\2\2\'&\3\2\2\2(+\3\2\2\2)\'"+
		"\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,\60\5\b\5\2-/\7\4\2\2.-\3\2\2\2"+
		"/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62\60\3\2\2\2\63"+
		"\67\7\7\2\2\64\66\7\4\2\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678"+
		"\3\2\2\28\7\3\2\2\29\67\3\2\2\2:<\5\n\6\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2"+
		"\2=>\3\2\2\2>\t\3\2\2\2?=\3\2\2\2@B\7\4\2\2A@\3\2\2\2BE\3\2\2\2CA\3\2"+
		"\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2\2FJ\5\f\7\2GI\7\4\2\2HG\3\2\2\2IL\3\2"+
		"\2\2JH\3\2\2\2JK\3\2\2\2K]\3\2\2\2LJ\3\2\2\2MQ\7\b\2\2NP\7\4\2\2ON\3\2"+
		"\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TX\5\f\7\2UW\7\4"+
		"\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2[M\3"+
		"\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\7\t\2\2a\13"+
		"\3\2\2\2bd\7\13\2\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\r\3\2\2\2"+
		"ge\3\2\2\2\20\20\22\30 )\60\67=CJQX]e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}