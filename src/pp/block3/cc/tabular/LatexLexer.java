// Generated from C:/Users/Jan-Willem/IdeaProjects/module8/src/pp/block3/cc/tabular\Latex.g4 by ANTLR 4.5.1
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LatexLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TABLESTART=1, ENDROW=2, SEP=3, ENTRY=4, TABLEEND=5, COMMENT=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"TABLESTART", "ENDROW", "SEP", "ENTRY", "TABLEEND", "COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TABLESTART", "ENDROW", "SEP", "ENTRY", "TABLEEND", "COMMENT"
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


	public LatexLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Latex.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\bZ\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\6\2%\n\2\r\2\16\2"+
		"&\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\6\5\67\n\5\r"+
		"\5\16\58\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\7\7N\n\7\f\7\16\7Q\13\7\3\7\3\7\3\b\7\bV\n\b\f\b\16\bY"+
		"\13\b\2\2\t\3\3\5\4\7\5\t\6\13\7\r\b\17\2\3\2\6\5\2eenntt\5\2\62;C\\c"+
		"|\3\2\f\f\5\2\13\f\17\17\"\"\\\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\21\3\2\2\2\5+\3\2\2\2\7\61\3\2\2\2"+
		"\t\66\3\2\2\2\13:\3\2\2\2\rK\3\2\2\2\17W\3\2\2\2\21\22\5\17\b\2\22\23"+
		"\7^\2\2\23\24\7d\2\2\24\25\7g\2\2\25\26\7i\2\2\26\27\7k\2\2\27\30\7p\2"+
		"\2\30\31\7}\2\2\31\32\7v\2\2\32\33\7c\2\2\33\34\7d\2\2\34\35\7w\2\2\35"+
		"\36\7n\2\2\36\37\7c\2\2\37 \7t\2\2 !\7\177\2\2!\"\7}\2\2\"$\3\2\2\2#%"+
		"\t\2\2\2$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\7\177\2"+
		"\2)*\5\17\b\2*\4\3\2\2\2+,\5\17\b\2,-\7^\2\2-.\7^\2\2./\3\2\2\2/\60\5"+
		"\17\b\2\60\6\3\2\2\2\61\62\5\17\b\2\62\63\7(\2\2\63\64\5\17\b\2\64\b\3"+
		"\2\2\2\65\67\t\3\2\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29"+
		"\n\3\2\2\2:;\5\17\b\2;<\7^\2\2<=\7g\2\2=>\7p\2\2>?\7f\2\2?@\7}\2\2@A\7"+
		"v\2\2AB\7c\2\2BC\7d\2\2CD\7w\2\2DE\7n\2\2EF\7c\2\2FG\7t\2\2GH\7\177\2"+
		"\2HI\3\2\2\2IJ\5\17\b\2J\f\3\2\2\2KO\7\'\2\2LN\n\4\2\2ML\3\2\2\2NQ\3\2"+
		"\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2RS\b\7\2\2S\16\3\2\2\2TV\t"+
		"\5\2\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\20\3\2\2\2YW\3\2\2\2\7"+
		"\2&8OW\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}