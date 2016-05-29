package pp.block4.cc.iloc;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.block4.cc.ErrorListener;
import pp.iloc.Simulator;
import pp.iloc.model.*;

/** Compiler from Calc.g4 to ILOC. */
public class CalcCompiler extends CalcBaseListener {
	/** Program under construction. */
	private Program prog;
	private int registerCount;
	private ParseTreeProperty<Operand> optree;
	// Attribute maps and other fields

	/** Compiles a given expression string into an ILOC program. */
	public Program compile(String text) {
		Program result = null;
		ErrorListener listener = new ErrorListener();
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new CalcLexer(chars);
		lexer.removeErrorListeners();
		lexer.addErrorListener(listener);
		TokenStream tokens = new CommonTokenStream(lexer);
		CalcParser parser = new CalcParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(listener);
		ParseTree tree = parser.complete();
		if (listener.hasErrors()) {
			System.out.printf("Parse errors in %s:%n", text);
			for (String error : listener.getErrors()) {
				System.err.println(error);
			}
		} else {
			result = compile(tree);
		}
		return result;
	}

	/** Compiles a given Calc-parse tree into an ILOC program. */
	public Program compile(ParseTree tree) {
		prog = new Program();
		registerCount = 0;
		optree = new ParseTreeProperty<>();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(this, tree);
		return prog;
	}

	/** Constructs an operation from the parameters 
	 * and adds it to the program under construction. */
	private void emit(OpCode opCode, Operand... args) {
		this.prog.addInstr(new Op(opCode, args));
	}

	/** Calls the compiler, and simulates and prints the compiled program. */
	public static void main(String[] args) {
		String[] progs = {
				"1+-3*4",
				"2*3+-4"
		};
		CalcCompiler compiler = new CalcCompiler();
		for (String expr : progs) {
			System.out.println("Processing " + expr);
			Program prog = compiler.compile(expr);
			new Simulator(prog).run();
			System.out.println(prog.prettyPrint());
		}
	}

	@Override public void exitComplete(CalcParser.CompleteContext ctx) {
		emit(OpCode.out, new Str("Outcome: "), optree.get(ctx.expr()));
	}

	@Override public void exitPar(CalcParser.ParContext ctx) {
		optree.put(ctx, optree.get(ctx.expr()));
	}

	@Override public void exitMinus(CalcParser.MinusContext ctx) {
		Reg r = new Reg("r_"+ registerCount);
		optree.put(ctx, r);
		emit(OpCode.rsubI, optree.get(ctx.expr()), new Num(0), r);
		registerCount++;
	}

	@Override public void exitNumber(CalcParser.NumberContext ctx) {
		Reg r = new Reg("r_"+ registerCount);
		optree.put(ctx, r);
		emit(OpCode.loadI, new Num(Integer.parseInt(ctx.NUMBER().getText())), r);
		registerCount++;
	}

	@Override public void exitTimes(CalcParser.TimesContext ctx) {
		Reg r = new Reg("r_"+ registerCount);
		optree.put(ctx, r);
		emit(OpCode.mult, optree.get(ctx.expr(0)), optree.get(ctx.expr(1)), r);
		registerCount++;
	}

	@Override public void exitPlus(CalcParser.PlusContext ctx) {
		Reg r = new Reg("r_"+ registerCount);
		optree.put(ctx, r);
		emit(OpCode.add, optree.get(ctx.expr(0)), optree.get(ctx.expr(1)), r);
		registerCount++;
	}


}
