package pp.block4.cc.cfg;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.block4.cc.ErrorListener;
import pp.block4.cc.cfg.FragmentParser.BreakStatContext;
import pp.block4.cc.cfg.FragmentParser.ContStatContext;
import pp.block4.cc.cfg.FragmentParser.ProgramContext;

/** Template top-down CFG builder. */
public class TopDownCFGBuilder extends FragmentBaseListener {
	/** The CFG being built. */
	private Graph graph;

	private ParseTreeProperty<Node> enters = new ParseTreeProperty<>();
	private ParseTreeProperty<Node> exits = new ParseTreeProperty<>();

	/** Builds the CFG for a program contained in a given file. */
	public Graph build(File file) {
		Graph result = null;
		ErrorListener listener = new ErrorListener();
		try {
			CharStream chars = new ANTLRInputStream(new FileReader(file));
			Lexer lexer = new FragmentLexer(chars);
			lexer.removeErrorListeners();
			lexer.addErrorListener(listener);
			TokenStream tokens = new CommonTokenStream(lexer);
			FragmentParser parser = new FragmentParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(listener);
			ProgramContext tree = parser.program();
			if (listener.hasErrors()) {
				System.out.printf("Parse errors in %s:%n", file.getPath());
				for (String error : listener.getErrors()) {
					System.err.println(error);
				}
			} else {
				result = build(tree);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/** Builds the CFG for a program given as an ANTLR parse tree. */
	public Graph build(ProgramContext tree) {
		this.graph = new Graph();
		new ParseTreeWalker().walk(this, tree);
		return this.graph;
	}

	@Override
	public void enterDecl(FragmentParser.DeclContext ctx) {
		enters.get(ctx).addEdge(exits.get(ctx));
	}

	@Override
	public void enterPrintStat(FragmentParser.PrintStatContext ctx) {
		enters.get(ctx).addEdge(exits.get(ctx));
	}

	@Override
	public void enterProgram(ProgramContext ctx) {
		Node node = new Node(0, "Program");
		for (FragmentParser.StatContext s : ctx.stat()) {
			Node childenter = addNode(s, "enter");
			Node childexit = addNode(s, "exit");
			enters.put(s, childenter);
			exits.put(s, childexit);
			node.addEdge(childenter);
			node = childexit;
		}
	}

	@Override
	public void enterWhileStat(FragmentParser.WhileStatContext ctx) {
		Node enter = enters.get(ctx);
		Node exit = exits.get(ctx);
		Node whilestat = addNode(ctx.stat(), "enter");
		Node whileexit = addNode(ctx.stat(), "exit");
		enters.put(ctx.stat(), whilestat);
		exits.put(ctx.stat(), whileexit);
		enter.addEdge(whilestat);
		enter.addEdge(exit);
		whileexit.addEdge(enter);
	}

	@Override
	public void enterIfStat(FragmentParser.IfStatContext ctx) {
		Node entrance = enters.get(ctx);
		Node exit = exits.get(ctx);
		Node ifenter = addNode(ctx.stat(0), "enter");
		Node ifexit = addNode(ctx.stat(0), "exit");
		entrance.addEdge(exit);
		enters.put(ctx.stat(0), ifenter);
		exits.put(ctx.stat(0), ifexit);
		if (ctx.stat(1) == null) {
			entrance.addEdge(ifenter);
			ifexit.addEdge(exit);
		} else {
			Node elseEntry = addNode(ctx.stat(1), "enter");
			Node elseExit = addNode(ctx.stat(1), "exit");
			enters.put(ctx.stat(1), elseEntry);
			exits.put(ctx.stat(1), elseExit);
			entrance.addEdge(ifenter);
			ifexit.addEdge(exit);
			elseExit.addEdge(exit);
		}
	}

	@Override
	public void enterBlockStat(FragmentParser.BlockStatContext ctx) {
		Node node = enters.get(ctx);
		Node exit = exits.get(ctx);
		for (FragmentParser.StatContext s : ctx.stat()) {
			Node blockEnter = addNode(s, "enter");
			Node blockExit = addNode(s, "exit");
			enters.put(s, blockEnter);
			exits.put(s, blockExit);
			node.addEdge(blockEnter);
			node = blockExit;
		}
		node.addEdge(exit);
	}

	@Override
	public void enterAssignStat(FragmentParser.AssignStatContext ctx) {
		enters.get(ctx).addEdge(exits.get(ctx));
	}

	@Override
	public void enterBreakStat(BreakStatContext ctx) {
		throw new IllegalArgumentException("Break not supported");
	}

	@Override
	public void enterContStat(ContStatContext ctx) {
		throw new IllegalArgumentException("Continue not supported");
	}

	/** Adds a node to he CGF, based on a given parse tree node.
	 * Gives the CFG node a meaningful ID, consisting of line number and 
	 * a further indicator.
	 */
	private Node addNode(ParserRuleContext node, String text) {
		return this.graph.addNode(node.getStart().getLine() + ": " + text);
	}

	/** Main method to build and print the CFG of a simple Java program. */
	public static void main(String[] args) {
//		if (args.length == 0) {
//			System.err.println("Usage: [filename]+");
//			return;
//		}
		ArrayList<String> files = new ArrayList<>();
		files.add("C:\\Users\\Jan-Willem\\IdeaProjects\\module8\\src\\pp\\block4\\cc\\cfg\\program41");
		files.add("C:\\Users\\Jan-Willem\\IdeaProjects\\module8\\src\\pp\\block4\\cc\\cfg\\program42");
		BottomUpCFGBuilder builder = new BottomUpCFGBuilder();
		for (String filename : files) {
			File file = new File(filename);
			System.out.println(filename);
			System.out.println(builder.build(file));
		}
	}
}
