package pp.block4.cc.cfg;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.block2.cc.NonTerm;
import pp.block4.cc.ErrorListener;
import pp.block4.cc.cfg.FragmentParser.BlockStatContext;
import pp.block4.cc.cfg.FragmentParser.BreakStatContext;

/** Template bottom-up CFG builder. */
public class BottomUpCFGBuilder extends FragmentBaseListener {
	/** The CFG being built. */
	private Graph graph;

	private ParseTreeProperty<Node> beginNodes = new ParseTreeProperty<>();
	private ParseTreeProperty<Node> endNodes = new ParseTreeProperty<>();

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
			ParseTree tree = parser.program();
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
	public Graph build(ParseTree tree) {
		this.graph = new Graph();
		new ParseTreeWalker().walk(this, tree);
		return this.graph;
	}

	@Override
	public void exitProgram(FragmentParser.ProgramContext ctx) {
		for (int i = 0; i < ctx.stat().size() - 1; i++) {
			getEndNode(ctx.stat(i)).addEdge(getBeginNode(ctx.stat(i+1)));
		}
	}

	@Override
	public void exitDecl(FragmentParser.DeclContext ctx) {
		Node node = addNode(ctx, "decl");
		addBeginNode(ctx, node);
		addEndNode(ctx, node);
	}

	@Override
	public void exitAssignStat(FragmentParser.AssignStatContext ctx) {
		Node node = addNode(ctx, "assign");
		addBeginNode(ctx, node);
		addEndNode(ctx, node);
	}

	@Override
	public void exitIfStat(FragmentParser.IfStatContext ctx) {
		Node iff = addNode(ctx, "if");
		iff.addEdge(getBeginNode(ctx.stat(0)));
		Node endif = addNode(ctx, "endif");
		if (ctx.stat().size() > 1) {
			iff.addEdge(getBeginNode(ctx.stat(1)));
			getEndNode(ctx.stat(1)).addEdge(endif);
			addEndNode(ctx, endif);
		} else {
			getEndNode(ctx.stat(0)).addEdge(endif);
			addEndNode(ctx, endif);
		}
		addBeginNode(ctx, iff);
	}

	@Override
	public void exitWhileStat(FragmentParser.WhileStatContext ctx) {
		Node node = addNode(ctx, "while");
		node.addEdge(getBeginNode(ctx.stat()));
		getEndNode(ctx.stat()).addEdge(node);
		addBeginNode(ctx, node);
		addEndNode(ctx, node);
	}

	@Override
	public void exitBlockStat(BlockStatContext ctx) {
		int last = ctx.stat().size() - 1;
		addBeginNode(ctx, getBeginNode(ctx.stat(0)));
		addEndNode(ctx, getEndNode(ctx.stat(last)));
		for (int i = 0; i < ctx.stat().size() - 1; i++) {
			getEndNode(ctx.stat(i)).addEdge(getBeginNode(ctx.stat(i+1)));
		}
	}

	@Override
	public void exitPrintStat(FragmentParser.PrintStatContext ctx) {
		Node print = addNode(ctx, "print");
		addBeginNode(ctx, print);
		addEndNode(ctx, print);
	}

	@Override
	public void enterBreakStat(BreakStatContext ctx) {
		throw new IllegalArgumentException("Break not supported");
	}

	@Override
	public void enterContStat(FragmentParser.ContStatContext ctx) {
		throw new IllegalArgumentException("Continue not supported");
	}

	/** Adds a node to he CGF, based on a given parse tree node.
	 * Gives the CFG node a meaningful ID, consisting of line number and 
	 * a further indicator.
	 */
	private Node addNode(ParserRuleContext node, String text) {
		return this.graph.addNode(node.getStart().getLine() + ": " + text);
	}

	private void addBeginNode(ParseTree tree, Node node) {
		beginNodes.put(tree, node);
	}

	private void addEndNode(ParseTree tree, Node node) {
		endNodes.put(tree, node);
	}

	private Node getBeginNode(ParseTree tree) {
		return beginNodes.get(tree);
	}

	private Node getEndNode(ParseTree tree) {
		return endNodes.get(tree);
	}

	/** Main method to build and print the CFG of a simple Java program. */
	public static void main(String[] args) {
//		if (args.length == 0) {
//			System.err.println("Usage: [filename]+");
//			return;
//		}
		ArrayList<String> files = new ArrayList<>();
		files.add("/home/willem/IdeaProjects/antlr/src/pp/block4/cc/cfg/Program41");
		files.add("/home/willem/IdeaProjects/antlr/src/pp/block4/cc/cfg/program42");
		BottomUpCFGBuilder builder = new BottomUpCFGBuilder();
		for (String filename : files) {
			File file = new File(filename);
			System.out.println(filename);
			System.out.println(builder.build(file));
		}
	}
}
