package pp.block2.cc.JansRekenmachine;

import java.math.BigInteger;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block2.cc.ParseException;

public class Calculator extends CalcBaseListener {

    private ParseTreeProperty<BigInteger> temps;
    private BigInteger result;

    private boolean errorDetected;

    public BigInteger calc(Lexer lexer) throws ParseException{
        errorDetected = false;
        temps = new ParseTreeProperty<BigInteger>();
        CalcParser parser = new CalcParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expr();
        new ParseTreeWalker().walk(this, tree);
        if(errorDetected)
            throw new ParseException();
        return result;
    }

    @Override public void exitParentheses(@NotNull CalcParser.ParenthesesContext ctx) {
        temps.put(ctx, temps.get(ctx.getChild(1)));
    }

    @Override public void exitNumber(@NotNull CalcParser.NumberContext ctx) {
        BigInteger value = new BigInteger(ctx.getChild(0).getText());
        temps.put(ctx, value);
    }

    @Override public void exitNegation(@NotNull CalcParser.NegationContext ctx) {
        temps.put(ctx, temps.get(ctx.getChild(1)).multiply(new BigInteger("-1")));
    }

    @Override public void exitSubtraction(@NotNull CalcParser.SubtractionContext ctx) {
        BigInteger value = BigInteger.ZERO;
        value = value.add(temps.get(ctx.getChild(0)));
        value = value.subtract(temps.get(ctx.getChild(2)));
        temps.put(ctx, value);
    }

    @Override public void exitMultiplication(@NotNull CalcParser.MultiplicationContext ctx) {
        BigInteger value = BigInteger.ONE;
        value = value.multiply(temps.get(ctx.getChild(0)));
        value = value.multiply(temps.get(ctx.getChild(2)));
        temps.put(ctx, value);
    }

    @Override public void exitExponantion(@NotNull CalcParser.ExponantionContext ctx) {
        BigInteger value = BigInteger.ONE;
        value = value.multiply(temps.get(ctx.getChild(0)));
        value = value.pow(temps.get(ctx.getChild(2)).intValue());
        temps.put(ctx, value);
    }

    @Override public void exitAddition(@NotNull CalcParser.AdditionContext ctx) {
        BigInteger value = BigInteger.ZERO;
        value = value.add(temps.get(ctx.getChild(0)));
        value = value.add(temps.get(ctx.getChild(2)));
        temps.put(ctx, value);
    }

    @Override public void exitEveryRule(@NotNull ParserRuleContext ctx) {
        this.result = temps.get(ctx);
    }

    @Override public void visitTerminal(@NotNull TerminalNode node) {
        //System.out.print(node.getText());
    }

    @Override public void visitErrorNode(@NotNull ErrorNode node) {
        errorDetected = true;
    }


}