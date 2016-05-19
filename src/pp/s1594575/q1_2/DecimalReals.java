// Generated from C:/Users/Jan-Willem/IdeaProjects/module8/src/pp/s1594575/q1_2\DecimalReals.g4 by ANTLR 4.5.1
package pp.s1594575.q1_2;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DecimalReals extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FLOAT=1, DOUBLE=2, WS=3;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"FLOAT", "DOUBLE", "WS", "F", "D", "E", "DOT", "NEG", "DIGIT", "NEGNUM", 
		"SEP", "NEGSEP", "REAL"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "FLOAT", "DOUBLE", "WS"
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


	public DecimalReals(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DecimalReals.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\5o\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3%\n\3\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\6\13"+
		"8\n\13\r\13\16\139\3\13\3\13\6\13>\n\13\r\13\16\13?\5\13B\n\13\3\f\7\f"+
		"E\n\f\f\f\16\fH\13\f\3\f\3\f\6\fL\n\f\r\f\16\fM\3\f\6\fQ\n\f\r\f\16\f"+
		"R\3\f\3\f\7\fW\n\f\f\f\16\fZ\13\f\5\f\\\n\f\3\r\3\r\3\r\3\r\5\rb\n\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16n\n\16\2\2\17\3\3"+
		"\5\4\7\5\t\2\13\2\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33\2\3\2\6\5\2\13"+
		"\f\17\17\"\"\4\2HHhh\4\2FFff\4\2GGggq\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\3\35\3\2\2\2\5$\3\2\2\2\7&\3\2\2\2\t*\3\2\2\2\13,\3\2\2\2\r.\3\2"+
		"\2\2\17\60\3\2\2\2\21\62\3\2\2\2\23\64\3\2\2\2\25A\3\2\2\2\27[\3\2\2\2"+
		"\31a\3\2\2\2\33m\3\2\2\2\35\36\5\33\16\2\36\37\5\t\5\2\37\4\3\2\2\2 !"+
		"\5\33\16\2!\"\5\13\6\2\"%\3\2\2\2#%\5\33\16\2$ \3\2\2\2$#\3\2\2\2%\6\3"+
		"\2\2\2&\'\t\2\2\2\'(\3\2\2\2()\b\4\2\2)\b\3\2\2\2*+\t\3\2\2+\n\3\2\2\2"+
		",-\t\4\2\2-\f\3\2\2\2./\t\5\2\2/\16\3\2\2\2\60\61\7\60\2\2\61\20\3\2\2"+
		"\2\62\63\7/\2\2\63\22\3\2\2\2\64\65\4\62;\2\65\24\3\2\2\2\668\5\23\n\2"+
		"\67\66\3\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:B\3\2\2\2;=\5\21\t\2<>"+
		"\5\23\n\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A\67\3\2\2"+
		"\2A;\3\2\2\2B\26\3\2\2\2CE\5\23\n\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3"+
		"\2\2\2GI\3\2\2\2HF\3\2\2\2IK\5\17\b\2JL\5\23\n\2KJ\3\2\2\2LM\3\2\2\2M"+
		"K\3\2\2\2MN\3\2\2\2N\\\3\2\2\2OQ\5\23\n\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2"+
		"\2RS\3\2\2\2ST\3\2\2\2TX\5\17\b\2UW\5\23\n\2VU\3\2\2\2WZ\3\2\2\2XV\3\2"+
		"\2\2XY\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2[F\3\2\2\2[P\3\2\2\2\\\30\3\2\2\2]"+
		"b\5\27\f\2^_\5\21\t\2_`\5\27\f\2`b\3\2\2\2a]\3\2\2\2a^\3\2\2\2b\32\3\2"+
		"\2\2cd\5\31\r\2de\5\r\7\2ef\5\25\13\2fn\3\2\2\2gh\5\25\13\2hi\5\r\7\2"+
		"ij\5\25\13\2jn\3\2\2\2kn\5\31\r\2ln\5\25\13\2mc\3\2\2\2mg\3\2\2\2mk\3"+
		"\2\2\2ml\3\2\2\2n\34\3\2\2\2\16\2$9?AFMRX[am\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}