package pp.block3.cc.tabular;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;

/**
 * Created by Jan-Willem on 26-5-2016.
 */
public class MyLatexListener extends LatexBaseListener {

    private MyErrorListener el = new MyErrorListener();
    private final ParseTreeWalker walker = new ParseTreeWalker();
    private ParseTreeProperty<String> nodes;

    public static void main(String[] args) {
        String Html = new MyLatexListener().getHtml();
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("latex.html"), "utf-8"));
            writer.write(Html);
        } catch (IOException ex) {
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }

    public String getHtml() {
        init();
        ParseTree p = parse("/home/willem/IdeaProjects/antlr/src/pp/block3/cc/tabular/tabular-4.tex");
        if (el.getErrorlist().size() > 0) {
            throw new RuntimeException("Errors while parsing the file");
        }
        walker.walk(this, p);
        return "<html>\n<body>\n" + this.val(p) + "</html>\n</body>\n";
    }

    public void init() {
        this.nodes = new ParseTreeProperty<>();
    }

    private void set(ParseTree node, String val) {
        this.nodes.put(node, val);
    }

    public String val(ParseTree node) {
        return this.nodes.get(node);
    }

    @Override
    public void exitTable(LatexParser.TableContext ctx) {
        String rows = "";
        for (LatexParser.RowContext row : ctx.row()) {
            rows += val(row);
        }

        set(ctx, "<table border=\"1\">\n" + rows + "</table>\n");
    }

    @Override
    public void exitRow(LatexParser.RowContext ctx) {
        String row = "";
        for (LatexParser.EntryContext entry : ctx.entry()) {
            row += val(entry);
        }
        set(ctx, "<tr>\n" + row + "</tr>\n");
    }

    @Override
    public void exitEntry(LatexParser.EntryContext ctx) {
        String entry = "";
        if (ctx.ENTRY() != null) {
            entry = ctx.getText();
        }
        set(ctx, "<td>" + entry +"</td>\n");
    }



    private ParseTree parse(String path) {
        FileReader fr = null;
        CharStream chars = null;
        try {
            fr = new FileReader(path);
            chars = new ANTLRInputStream(fr);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        Lexer lexer = new LatexLexer(chars);
        lexer.removeErrorListeners();
        lexer.addErrorListener(el);
        TokenStream tokens = new CommonTokenStream(lexer);

        LatexParser parser = new LatexParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(el);

        return parser.table();
    }

}
