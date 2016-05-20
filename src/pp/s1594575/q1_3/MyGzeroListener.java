package pp.s1594575.q1_3;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import pp.block3.cc.symbol.DeclUseLexer;
import pp.block3.cc.symbol.DeclUseParser;
import pp.block3.cc.symbol.SymbolTableImplementation;

import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by Jan-Willem on 20-5-2016.
 */
public class MyGzeroListener implements GzeroListener{

    public MyGzeroListener (String text) {

        ANTLRInputStream ain = new ANTLRInputStream(text);
        GzeroLexer glex = new GzeroLexer(ain);
        GzeroParser gpars = new GzeroParser(new CommonTokenStream(glex));
        ParseTree tree = gpars.e();
        new ParseTreeWalker().walk(this, tree);

    }

    @Override
    public void enterE(GzeroParser.EContext ctx) {
        System.out.println("Entered E: " + ctx.getText());
    }

    @Override
    public void exitE(GzeroParser.EContext ctx) {
        System.out.println("Exit E");
    }

    @Override
    public void enterEprime(GzeroParser.EprimeContext ctx) {
        System.out.println("Entered Eprime: " + ctx.getText());
    }

    @Override
    public void exitEprime(GzeroParser.EprimeContext ctx) {
        System.out.println("Exit Eprime");
    }

    @Override
    public void enterF(GzeroParser.FContext ctx) {
        System.out.println("Entered F: " + ctx.getText());
    }

    @Override
    public void exitF(GzeroParser.FContext ctx) {
        System.out.println("Exit F");
    }

    @Override
    public void enterT(GzeroParser.TContext ctx) {
        System.out.println("Entered T: " + ctx.getText());
    }

    @Override
    public void exitT(GzeroParser.TContext ctx) {
        System.out.println("Exit T");
    }

    @Override
    public void enterTprime(GzeroParser.TprimeContext ctx) {
        System.out.println("Entered Tprime: " + ctx.getText());
    }

    @Override
    public void exitTprime(GzeroParser.TprimeContext ctx) {
        System.out.println("Exit Tprime");
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
