// Generated from C:/Users/Jan-Willem/IdeaProjects/module8/src/pp/block3/cc/tabular\Latex.g4 by ANTLR 4.5.1
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LatexParser}.
 */
public interface LatexListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LatexParser#total}.
	 * @param ctx the parse tree
	 */
	void enterTotal(LatexParser.TotalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatexParser#total}.
	 * @param ctx the parse tree
	 */
	void exitTotal(LatexParser.TotalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatexParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(LatexParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatexParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(LatexParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatexParser#tabular}.
	 * @param ctx the parse tree
	 */
	void enterTabular(LatexParser.TabularContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatexParser#tabular}.
	 * @param ctx the parse tree
	 */
	void exitTabular(LatexParser.TabularContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatexParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(LatexParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatexParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(LatexParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatexParser#row}.
	 * @param ctx the parse tree
	 */
	void enterRow(LatexParser.RowContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatexParser#row}.
	 * @param ctx the parse tree
	 */
	void exitRow(LatexParser.RowContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatexParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(LatexParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatexParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(LatexParser.EntryContext ctx);
}