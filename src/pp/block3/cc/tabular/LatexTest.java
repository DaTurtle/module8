package pp.block3.cc.tabular;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.FileReader;

/**
 * Created by Jan-Willem on 17-5-2016.
 */
public class LatexTest {


    @Test
    public void test() {

        FileReader fr = null;
        ANTLRInputStream ain = null;
        try {
            fr = new FileReader("C:\\Users\\Jan-Willem\\IdeaProjects\\module8\\src\\pp\\block3\\cc\\tabular\\tabular-5.tex");
            ain = new ANTLRInputStream(fr);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        LatexLexer llex = new LatexLexer(ain);
        LatexParser lpars = new LatexParser(new CommonTokenStream(llex));
        ParseTree tree = lpars.table();
        System.out.println(tree.getText());
    }
}
