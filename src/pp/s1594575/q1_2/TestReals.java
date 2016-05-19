package pp.s1594575.q1_2;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.junit.Test;
import pp.block1.cc.test.LexerTester;

/**
 * Created by Jan-Willem on 19-5-2016.
 */
public class TestReals {

    private static LexerTester tester = new LexerTester(DecimalReals.class);


    @Test
    public void test() {
        tester.correct("1.0f");
        tester.correct("1.0d");
        tester.correct("1.0F");
        tester.correct("1.0D");
        tester.correct(".0f");
        tester.correct(".2d");
        tester.correct("1.f");
        tester.correct("-1.f");
        tester.correct("1.");
        tester.correct("1.0");
        tester.correct("1234.1234");
        tester.correct("1e2");
        tester.correct("2.e5");
        tester.correct("3.e-5f");
        tester.correct("3.e5d");
        tester.correct(".3e5F");
        tester.correct("-3.456e-5f");
        tester.correct("13.e5D");
        tester.correct("1.1");

        tester.yields("1.1.1", DecimalReals.DOUBLE, DecimalReals.DOUBLE); // 1.1, .1
        tester.yields("1.1e1.1", DecimalReals.DOUBLE, DecimalReals.DOUBLE); // 1.1e1, .1
        tester.yields("1f1", DecimalReals.FLOAT, DecimalReals.DOUBLE); // 1f, 1
        tester.yields("1e1-1f", DecimalReals.DOUBLE, DecimalReals.FLOAT); // 1e1, -1f

        tester.wrong("f");
        tester.wrong(".");
        tester.wrong("-");
        tester.wrong("D");

    }

}
