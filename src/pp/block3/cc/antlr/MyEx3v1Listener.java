package pp.block3.cc.antlr;

/**
 * Created by Jan-Willem on 26-5-2016.
 */

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class MyEx3v1Listener extends Ex3v1BaseListener {

    private ParseTreeProperty<Type> vals;

    public void init() {
        this.vals = new ParseTreeProperty<>();
    }

    @Override public void exitEqual(Ex3v1Parser.EqualContext ctx) {
        set(ctx, val(ctx.expr(0)) == val(ctx.expr(1)) ? Type.BOOL : Type.ERR);
    }

    @Override public void exitPlus(Ex3v1Parser.PlusContext ctx) {
        set(ctx, val(ctx.expr(0)) == val(ctx.expr(1)) ? val(ctx.expr(0)) : Type.ERR);
    }

    @Override public void exitExponent(Ex3v1Parser.ExponentContext ctx) {
        set(ctx, (val(ctx.expr(0)) == Type.NUM && val(ctx.expr(1)) == Type.NUM) ?
                Type.NUM :
                (val(ctx.expr(0)) == Type.STR && val(ctx.expr(1)) == Type.NUM) ?
                        Type.STR :
                        Type.ERR);
    }

    @Override public void exitParam(Ex3v1Parser.ParamContext ctx) {
        set(ctx, val(ctx.expr()));
    }

    @Override public void exitNumber(Ex3v1Parser.NumberContext ctx) {
        set(ctx, Type.NUM);
    }

    @Override public void exitBoolean(Ex3v1Parser.BooleanContext ctx) {
        set(ctx, Type.BOOL);
    }

    @Override public void exitString(Ex3v1Parser.StringContext ctx) {
        set(ctx, Type.STR);
    }

    private void set(ParseTree node, Type val) {
        this.vals.put(node, val);
    }

    public Type val(ParseTree node) {
        return this.vals.get(node);
    }
}