// Generated from C:/Users/Bas/Documents/GitHub/module8/src/pp/block2/cc/ll\Calc.g4 by ANTLR 4.5.1
package pp.block2.cc.JansRekenmachine;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheses(CalcParser.ParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code number}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(CalcParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negation}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(CalcParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subtraction}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtraction(CalcParser.SubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplication}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(CalcParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exponantion}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponantion(CalcParser.ExponantionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addition}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(CalcParser.AdditionContext ctx);
}