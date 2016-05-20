package pp.s1594575.q1_3;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;


/**
 * Created by Jan-Willem on 20-5-2016.
 */
public class TestGzero {

    @Test
    public void test() {
        new MyGzeroListener("--a");
    }
}
