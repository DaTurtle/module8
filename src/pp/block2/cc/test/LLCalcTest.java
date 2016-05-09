package pp.block2.cc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Test;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;
import pp.block2.cc.ll.*;

public class LLCalcTest {
	/** Tests the LL-calculator for the Sentence grammar. */
	@Test
	public void testSentenceOrig() {
		Grammar g = Grammars.makeSentence();
		// Without the last (recursive) rule, the grammar is LL-1
		assertTrue(createCalc(g).isLL1());
	}

	@Test
	public void testIf() {
		Grammar g = Grammars.makeGrammarIf();
		NonTerm stat = g.getNonterminal("Stat");
		NonTerm elsePart = g.getNonterminal("ElsePart");
		Term iffy = g.getTerminal(If.IF);
        Term expressy = g.getTerminal(If.COND);
        Term elsy = g.getTerminal(If.ELSE);
        Term assigny = g.getTerminal(If.ASSIGN);
		Term eof = Symbol.EOF;
		Term empty = Symbol.EMPTY;
		LLCalc calc = createCalc(g);
		//FIRST
		Map<Symbol, Set<Term>> first = calc.getFirst();
		Map<Symbol, Set<Term>> test1Map = new HashMap<Symbol, Set<Term>>();
        HashSet<Term> test1Set = new HashSet<Term>();
        test1Set.add(iffy);
        test1Set.add(assigny);
        HashSet<Term> test1dot1Set = new HashSet<Term>();
        for( Term term : g.getTerminals()){
            HashSet<Term> tempo = new HashSet<Term>();
            tempo.add(term);
            test1Map.put(term, tempo);
        }
        test1dot1Set.add(elsy);
        test1dot1Set.add(empty);
		test1Map.put(stat, test1Set);
        test1Map.put(elsePart, test1dot1Set);
		assertEquals(test1Map, first.get(stat));
		//MOAR test to be made
		//FOLLOW
		Map<NonTerm, Set<Term>> follow = calc.getFollow();
        Map<Symbol, Set<Term>> test2Map = new HashMap<Symbol, Set<Term>>();
        HashSet<Term> test2Set = new HashSet<Term>();
        test2Set.add(eof);
        test2Set.add(expressy);
        HashSet<Term> test2dot1Set = new HashSet<Term>();
        test2dot1Set.add(assigny);
        test2dot1Set.add(iffy);
		test2dot1Set.add(eof);
        test2Map.put(stat, test2Set);
        test2Map.put(elsePart, test2dot1Set);
		assertEquals(test2Map, follow.get(stat));
		//MOAR test to be made
		//FIRSTP
		Map<Rule, Set<Term>> firstp = calc.getFirstp();
        Map<Rule, Set<Term>> test3Map = new HashMap<Rule, Set<Term>>();
		List <Rule> elsePartRules = g.getRules(elsePart);
        HashSet<Term> test3Set = new HashSet<Term>();
        test3Set.add(elsy);
        test3Set.add(assigny);
        test3Set.add(iffy);
        test3Map.put(g.getRules().get(0), test3Set);
        assertEquals(test3Map, firstp.get(elsePartRules.get(0)));
        Map<Rule, Set<Term>> test3Mapdot = new HashMap<Rule, Set<Term>>();
        HashSet<Term> test3dotSet = new HashSet<Term>();
        test3dotSet.add(eof);
        test3Mapdot.put(g.getRules().get(1), test3dotSet);
        assertEquals(test3Mapdot, firstp.get(elsePartRules.get(1)));
		assertFalse(calc.isLL(1));
		//MOAR test to be made

	}

	@Test
	public void testSentenceExtended() {
		Grammar g = Grammars.makeSentence();
		// Without the last (recursive) rule, the grammar is LL-1
		assertTrue(createCalc(g).isLL1());
		// Now add the last rule, causing the grammar to fail
		// Define the non-terminals
		NonTerm subj = g.getNonterminal("Subject");
		NonTerm obj = g.getNonterminal("Object");
		NonTerm sent = g.getNonterminal("Sentence");
		NonTerm mod = g.getNonterminal("Modifier");
		g.addRule(mod, mod, mod);
		// Define the terminals
		Term adj = g.getTerminal(Sentence.ADJECTIVE);
		Term noun = g.getTerminal(Sentence.NOUN);
		Term verb = g.getTerminal(Sentence.VERB);
		Term end = g.getTerminal(Sentence.ENDMARK);
		LLCalc calc = createCalc(g);
		// FIRST sets
		Map<Symbol, Set<Term>> first = calc.getFirst();
		assertEquals(set(adj, noun), first.get(sent));
		assertEquals(set(adj, noun), first.get(subj));
		assertEquals(set(adj, noun), first.get(obj));
		assertEquals(set(adj), first.get(mod));
		// FOLLOW sets
		Map<NonTerm, Set<Term>> follow = calc.getFollow();
		assertEquals(set(Symbol.EOF), follow.get(sent));
		assertEquals(set(verb), follow.get(subj));
		assertEquals(set(end), follow.get(obj));
		assertEquals(set(noun, adj), follow.get(mod));
		// FIRST+ sets: test per rule
		Map<Rule, Set<Term>> firstp = calc.getFirstp();
		List<Rule> subjRules = g.getRules(subj);
		assertEquals(set(noun), firstp.get(subjRules.get(0)));
		assertEquals(set(adj), firstp.get(subjRules.get(1)));
		// is-LL1-test
		assertFalse(calc.isLL1());
	}

	/** Creates an LL1-calculator for a given grammar. */
	private LLCalc createCalc(Grammar g) {
		return new LLCalcImplementation(g); // your implementation of LLCalc (Ex. 2-CC.5)
	}

	@SuppressWarnings("unchecked")
	private <T> Set<T> set(T... elements) {
		return new HashSet<>(Arrays.asList(elements));
	}
}
