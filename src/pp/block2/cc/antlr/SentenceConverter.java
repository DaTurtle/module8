package pp.block2.cc.antlr;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block2.cc.AST;
import pp.block2.cc.NonTerm;
import pp.block2.cc.ParseException;
import pp.block2.cc.Parser;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.Term;
import pp.block2.cc.ll.Sentence;

public class SentenceConverter //
		extends SentenceBaseListener implements Parser {
	/** Factory needed to create terminals of the {@link Sentence}
	 * grammar. See {@link pp.block2.cc.ll.SentenceParser} for
	 * example usage. */
	private final SymbolFactory fact;
	private AST ast;

	private final NonTerm SENTENCE = new NonTerm("Sentence");
	private final NonTerm SUBJECT = new NonTerm("Subject");
	private final NonTerm OBJECT = new NonTerm("Object");
	private final NonTerm MODIFIER = new NonTerm("Modifier");

	private ParseTreeProperty<AST> asts;

	private boolean errorDetected;

	public SentenceConverter() {
		this.fact = new SymbolFactory(Sentence.class);
	}

	@Override
	public AST parse(Lexer lexer) throws ParseException {
		errorDetected = false;
		asts = new ParseTreeProperty<AST>();
		SentenceParser parser = new SentenceParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.sentence();
		new ParseTreeWalker().walk(this, tree);
		if(errorDetected)
			throw new ParseException();
		return ast;
	}


	//@Override


	// From here on overwrite the listener methods
	// Use an appropriate ParseTreeProperty to
	// store the correspondence from nodes to ASTs

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void exitSentence(@NotNull SentenceParser.SentenceContext ctx) {
		ast = new AST(SENTENCE);
		for(int i = 0; i < ctx.getChildCount(); i++) {
			ast.addChild(asts.get(ctx.getChild(i)));
		}
		asts.put(ctx, ast);
	}

	@Override
	public void exitSubject(SentenceParser.SubjectContext ctx) {
		AST result = new AST(SUBJECT);
		for(int i = 0; i < ctx.getChildCount(); i++) {
			result.addChild(asts.get(ctx.getChild(i)));
		}
		asts.put(ctx, result);
	}
	@Override
	public void exitObject(SentenceParser.ObjectContext ctx) {
		AST result = new AST(OBJECT);
		for(int i = 0; i < ctx.getChildCount(); i++) {
			result.addChild(asts.get(ctx.getChild(i)));
		}
		asts.put(ctx, result);
	}
	@Override
	public void exitModifier(SentenceParser.ModifierContext ctx) {
		AST result = new AST(MODIFIER);
		for(int i = 0; i < ctx.getChildCount(); i++) {
			result.addChild(asts.get(ctx.getChild(i)));
		}
		asts.put(ctx, result); }


	@Override
	public void visitTerminal(@NotNull TerminalNode node) {
		Term term = fact.getTerminal(node.getSymbol().getType());
		Token token = node.getSymbol();
		AST result = new AST(term, token);
		asts.put(node, result);
	}

	@Override
	public void visitErrorNode(@NotNull ErrorNode node){
		errorDetected = true;
	}
}