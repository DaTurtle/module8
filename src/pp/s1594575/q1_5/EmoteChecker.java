package pp.s1594575.q1_5;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import pp.block2.cc.Parser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by Jan-Willem on 19-5-2016.
 */
public class EmoteChecker extends EmoteBaseListener {
    private MyEmoteDepth emo;
    private ArrayList<Exception> errorlist;
    private String path;

    public EmoteChecker (String path) {
        this.path = path;
        emo = new MyEmoteDepth();
        errorlist = new ArrayList<>();
        FileReader fr = null;
        ANTLRInputStream ain = null;
        try {
            String start = new File("").getAbsolutePath();
            fr = new FileReader(start + "\\src\\pp\\s1594575\\q1_5\\" + path);
            ain = new ANTLRInputStream(fr);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        EmoteLexer elex = new EmoteLexer(ain);
        EmoteParser epars = new EmoteParser(new CommonTokenStream(elex));
        ParseTree tree = epars.text();
        new ParseTreeWalker().walk(this, tree);
    }


    @Override public void enterWordItem(EmoteParser.WordItemContext ctx) {
        String excl = "";
        if (ctx.EXCL() != null) {
            excl = ctx.EXCL().getText();
        }
        String word = ctx.WORD().getText();

        if (excl.length() != emo.getIntensity(word)) {
            errorlist.add(new Exception("File: \"" + path + "\" Has incorrect intensity at: " + ctx.getStart().getLine() + ", " + ctx.getStart().getCharPositionInLine()));
        }
    }

    @Override public void enterTextItem(EmoteParser.TextItemContext ctx) {
        emo.openScope();
    }

    @Override public void exitTextItem(EmoteParser.TextItemContext ctx) {
        emo.closeScope();
    }

    @Override public void exitRaiseItem(EmoteParser.RaiseItemContext ctx) {
        emo.add(ctx.WORD().getText());
    }

    public static void main(String[] args) {
        EmoteChecker ec = new EmoteChecker("ok1.txt");
        if (ec.errorlist.size() == 0) {
            System.out.println("No errors in file: \"" + ec.path + "\"");
        } else {
            for (Exception e : ec.errorlist) {
                System.err.println(e.toString());
            }
        }
        ec = new EmoteChecker("err1.txt");
        if (ec.errorlist.size() == 0) {
            System.out.println("No errors in file: \"" + ec.path + "\"");
        } else {
            for (Exception e : ec.errorlist) {
                System.err.println(e.toString());
            }
        }
    }
}
