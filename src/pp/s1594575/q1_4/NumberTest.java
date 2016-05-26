package pp.s1594575.q1_4;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import pp.block3.cc.antlr.CalcLexer;
import pp.block3.cc.antlr.CalcParser;
import pp.block3.cc.antlr.Calculator;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jan-Willem on 21-5-2016.
 */
public class NumberTest {

    private final ParseTreeWalker walker = new ParseTreeWalker();
    private final MyNumberListener numberListener = new MyNumberListener();

    @Test
    public void test() {
        test(13, "b1101");
        test(844, "b1101001100");
        test(8614, "x21A6");
        test(43981, "xABCD");
        test(9874, "9874");
        test(0, "0");
    }

    private void test(int expected, String expr) {
        ParseTree tree = parseNum(expr);
        this.numberListener.init();
        this.walker.walk(this.numberListener, tree);
        assertEquals(expected, this.numberListener.val(tree));
    }

    private ParseTree parseNum(String text) {
        CharStream chars = new ANTLRInputStream(text);
        Lexer lexer = new NumberLexer(chars);
        TokenStream tokens = new CommonTokenStream(lexer);
        NumberParser parser = new NumberParser(tokens);
        return parser.num();
    }
}
