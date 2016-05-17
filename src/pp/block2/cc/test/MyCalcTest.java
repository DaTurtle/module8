package pp.block2.cc.test;

import junit.framework.Assert;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.junit.Test;
import pp.block2.cc.AST;
import pp.block2.cc.JansRekenmachine.CalcBaseListener;
import pp.block2.cc.JansRekenmachine.CalcLexer;
import pp.block2.cc.JansRekenmachine.CalcParser;
import pp.block2.cc.JansRekenmachine.Calculator;
import pp.block2.cc.ParseException;
import pp.block2.cc.Parser;
import pp.block2.cc.ll.Grammar;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by willem on 5/17/16.
 */
public class MyCalcTest {


    @Test
    public void succeed() {
        ANTLRInputStream in = new ANTLRInputStream("3*(5+(4^2))");
        CalcLexer cx = new CalcLexer(in);
        Calculator c = new Calculator();
        try {
            BigInteger val = c.calc(cx);
            assertEquals(63, val.intValue());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fail() {
        ANTLRInputStream in = new ANTLRInputStream("3*((5+(4^2))");
        CalcLexer cx = new CalcLexer(in);
        Calculator c = new Calculator();
        try {
            BigInteger val = c.calc(cx);
            Assert.fail("this should fail");
        } catch (Exception e) {
            //Normal behaviour
        }
    }

}
