// Generated from C:/Users/Jan-Willem/IdeaProjects/module8/src/pp/block1/cc/antlr\PL1.g4 by ANTLR 4.5.1
package pp.block1.cc.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PL1 extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SENTENCE=1;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ALPHA", "SINGLE", "WORD", "WS", "SENTENCE"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SENTENCE"
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


	public PL1(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PL1.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\3\'\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\3\3\3\3\3\4\6\4\24\n\4\r\4"+
		"\16\4\25\3\5\6\5\31\n\5\r\5\16\5\32\3\6\3\6\3\6\3\6\7\6!\n\6\f\6\16\6"+
		"$\13\6\3\6\3\6\2\2\7\3\2\5\2\7\2\t\2\13\3\3\2\4\4\2C\\c|\5\2\13\f\17\17"+
		"\"\"\'\2\13\3\2\2\2\3\r\3\2\2\2\5\17\3\2\2\2\7\23\3\2\2\2\t\30\3\2\2\2"+
		"\13\34\3\2\2\2\r\16\t\2\2\2\16\4\3\2\2\2\17\20\7$\2\2\20\21\7$\2\2\21"+
		"\6\3\2\2\2\22\24\5\3\2\2\23\22\3\2\2\2\24\25\3\2\2\2\25\23\3\2\2\2\25"+
		"\26\3\2\2\2\26\b\3\2\2\2\27\31\t\3\2\2\30\27\3\2\2\2\31\32\3\2\2\2\32"+
		"\30\3\2\2\2\32\33\3\2\2\2\33\n\3\2\2\2\34\"\7$\2\2\35!\5\7\4\2\36!\5\5"+
		"\3\2\37!\5\t\5\2 \35\3\2\2\2 \36\3\2\2\2 \37\3\2\2\2!$\3\2\2\2\" \3\2"+
		"\2\2\"#\3\2\2\2#%\3\2\2\2$\"\3\2\2\2%&\7$\2\2&\f\3\2\2\2\7\2\25\32 \""+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}