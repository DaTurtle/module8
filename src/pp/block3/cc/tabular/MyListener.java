package pp.block3.cc.tabular;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import pp.block1.cc.test.ScannerTest;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Created by willem on 5/25/16.
 */
public class MyListener extends BaseErrorListener {

    private List<String> errlist;

    public MyListener () {
        errlist = new ArrayList<>();
    }

    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        String error = "Syntax error at line " + line + " col " + charPositionInLine + " offending symbol: " + offendingSymbol.toString();
        errlist.add(error);
    }

//    public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
//    }
//
//    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
//    }
//
//    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
//    }

    public List<String> getErrors() {
        return errlist;
    }
}
