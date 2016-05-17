package pp.block3.cc.symbol;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bas on 17/05/2016.
 */
public class MyTreeListener implements DeclUseListener{

    private List<Exception> errorlist;
    private SymbolTableImplementation symboltable;

    public MyTreeListener (String path) {
        symboltable = new SymbolTableImplementation();
        errorlist = new ArrayList<>();
        FileReader fr = null;
        ANTLRInputStream ain = null;
        try {
            fr = new FileReader(path);
            ain = new ANTLRInputStream(fr);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        DeclUseLexer ulex = new DeclUseLexer(ain);
        DeclUseParser dpars = new DeclUseParser(new CommonTokenStream(ulex));
        ParseTree tree = dpars.program();
        new ParseTreeWalker().walk(this, tree);

    }

    public List<Exception> getErrorlist () {
        return errorlist;
    }

    @Override
    public void enterProgram(DeclUseParser.ProgramContext ctx) {
        symboltable.openScope();
    }

    @Override
    public void exitProgram(DeclUseParser.ProgramContext ctx) {
        try {
            symboltable.closeScope();
        } catch (Exception e) {
            errorlist.add(new Exception("already in outer scope, Token at: " + ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine() ));
        }
    }

    @Override
    public void enterSeries(DeclUseParser.SeriesContext ctx) {
    }

    @Override
    public void exitSeries(DeclUseParser.SeriesContext ctx) {
    }

    @Override
    public void enterUnit(DeclUseParser.UnitContext ctx) {
        if (ctx.getText().charAt(0)=='(') {
            symboltable.openScope();
        }
    }

    @Override
    public void exitUnit(DeclUseParser.UnitContext ctx) {
        if (ctx.getText().charAt(ctx.getText().length()-1)==')') {
            try {
                symboltable.closeScope();
            } catch (Exception e) {
                errorlist.add(new Exception("already in outer scope, Token at: " + ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine() ));
            }
        }
    }

    @Override
    public void enterDecl(DeclUseParser.DeclContext ctx) {
        System.out.println(ctx.getText().substring(2));
         if (!symboltable.add(ctx.getText().substring(2))) {
             errorlist.add(new Exception("symbol is already declared in current scope, Token at: " + ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine() ));
         }
    }

    @Override
    public void exitDecl(DeclUseParser.DeclContext ctx) {

    }

    @Override
    public void enterUse(DeclUseParser.UseContext ctx) {
        if (!symboltable.contains(ctx.getText().substring(2))) {
            errorlist.add(new Exception("symbol is not declared, Token at: " + ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine() ));
        }
    }

    @Override
    public void exitUse(DeclUseParser.UseContext ctx) {

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
