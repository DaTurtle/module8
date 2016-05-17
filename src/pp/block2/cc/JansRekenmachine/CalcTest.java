package pp.block2.cc.JansRekenmachine;

import org.junit.Test;

/**
 * Created by Bas on 17/05/2016.
 */
public class CalcTest {
    @Test
    public void test() {
        Calculator calc = new Calculator();
        CalcLexer clex = new CalcLexer();
        calc.calc();
    }
}
