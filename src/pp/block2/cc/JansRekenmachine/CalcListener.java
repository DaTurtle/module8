// Generated from C:/Users/Bas/Documents/GitHub/module8/src/pp/block2/cc/ll\Calc.g4 by ANTLR 4.5.1
package pp.block2.cc.JansRekenmachine;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(CalcParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(CalcParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumber(CalcParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumber(CalcParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negation}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegation(CalcParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negation}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegation(CalcParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subtraction}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubtraction(CalcParser.SubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subtraction}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubtraction(CalcParser.SubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplication}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(CalcParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplication}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(CalcParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exponantion}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExponantion(CalcParser.ExponantionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exponantion}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExponantion(CalcParser.ExponantionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addition}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddition(CalcParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addition}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddition(CalcParser.AdditionContext ctx);
}