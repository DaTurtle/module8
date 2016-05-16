// Generated from C:/Users/Bas/Documents/GitHub/module8/src/pp/block2/cc/antlr\CC4AGAIN.g4 by ANTLR 4.5.1
package pp.block2.cc.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CC4AGAINParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CC4AGAINVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CC4AGAINParser#l}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitL(CC4AGAINParser.LContext ctx);
	/**
	 * Visit a parse tree produced by {@link CC4AGAINParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(CC4AGAINParser.RContext ctx);
	/**
	 * Visit a parse tree produced by {@link CC4AGAINParser#r2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR2(CC4AGAINParser.R2Context ctx);
	/**
	 * Visit a parse tree produced by {@link CC4AGAINParser#q}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQ(CC4AGAINParser.QContext ctx);
	/**
	 * Visit a parse tree produced by {@link CC4AGAINParser#q2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQ2(CC4AGAINParser.Q2Context ctx);
}