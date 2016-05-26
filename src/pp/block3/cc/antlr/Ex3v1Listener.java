// Generated from C:/Users/Jan-Willem/IdeaProjects/module8/src/pp/block3/cc/antlr\Ex3v1.g4 by ANTLR 4.5.1
package pp.block3.cc.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Ex3v1Parser}.
 */
public interface Ex3v1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code equal}
	 * labeled alternative in {@link Ex3v1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqual(Ex3v1Parser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link Ex3v1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqual(Ex3v1Parser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link Ex3v1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumber(Ex3v1Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link Ex3v1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumber(Ex3v1Parser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link Ex3v1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(Ex3v1Parser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link Ex3v1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(Ex3v1Parser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link Ex3v1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(Ex3v1Parser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link Ex3v1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(Ex3v1Parser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code param}
	 * labeled alternative in {@link Ex3v1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParam(Ex3v1Parser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code param}
	 * labeled alternative in {@link Ex3v1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParam(Ex3v1Parser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plus}
	 * labeled alternative in {@link Ex3v1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlus(Ex3v1Parser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link Ex3v1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlus(Ex3v1Parser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exponent}
	 * labeled alternative in {@link Ex3v1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExponent(Ex3v1Parser.ExponentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exponent}
	 * labeled alternative in {@link Ex3v1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExponent(Ex3v1Parser.ExponentContext ctx);
}