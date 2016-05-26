package pp.s1594575.q1_4;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by Jan-Willem on 21-5-2016.
 */
public class MyNumberListener extends NumberBaseListener {

    /** Map storing the val attribute for all parse tree nodes. */
    private ParseTreeProperty<Integer> vals;
    private int multiplier = 10;
    private int depth = 0;

    /** Initialises the calculator before using it to walk a tree. */
    public void init() {
        this.depth = 0;
        this.multiplier= 10;
        this.vals = new ParseTreeProperty<Integer>();
    }

    /** Sets the val attribute of a given node. */
    private void set(ParseTree node, int val) {
        this.vals.put(node, val);
    }

    /** Retrieves the val attribute of a given node. */
    public int val(ParseTree node) {
        return this.vals.get(node);
    }

    public int getVal(String text) {
        char c = text.charAt(0);
        return Character.getNumericValue(c);
    }


    @Override
    public void exitNum(NumberParser.NumContext ctx) {
        set(ctx, val(ctx.seq()));
    }

    @Override
    public void exitSeq(NumberParser.SeqContext ctx) {
        if (ctx.seq() != null) {
            set(ctx, (val(ctx.seq()) + (int) Math.pow(multiplier, depth) * val(ctx.dig())));
            System.out.println("dig: " + val(ctx.dig()) + " seq: " + val(ctx.seq()) + " mult: " + (int) Math.pow(multiplier, depth) + " current: " + val(ctx));
        } else {
            set(ctx, val(ctx.dig()));
            System.out.println("dig: " + val(ctx.dig()));
        }
        depth++;
    }

    @Override
    public void exitPrf(NumberParser.PrfContext ctx) {
        if (ctx.getText().charAt(0) == 'b') {
            multiplier = 2;
        } else {
            multiplier = 16;
        }
    }

    @Override
    public void exitDig(NumberParser.DigContext ctx) {
        set(ctx, getVal(ctx.getText()));
    }

}
