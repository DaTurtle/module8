package pp.block2.cc.ll;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;

import java.util.*;

/**
 * Created by Bas on 08/05/2016.
 */
public class LLCalcImplementation implements LLCalc{
    private Grammar grammar;

    public LLCalcImplementation(Grammar givenG) {

        this.grammar = givenG;
    }

    @Override
    public Map<Symbol, Set<Term>> getFirst() {
        HashMap result = new HashMap<Symbol, Set<Term>>();
        List<Rule> rules  = grammar.getRules();
        for (Rule rule: rules ) {
            result.put(rule.getLHS(), rule.getRHS());
        }
        return result;
    }

    @Override
    public Map<NonTerm, Set<Term>> getFollow() {
        HashMap result = new HashMap<Symbol, Set<Term>>();
        List<Rule> rules  = grammar.getRules();
        for (Rule rule: rules ) {
            for()
            result.put(rule.getRHS(), );
        }
        return null;
    }

    @Override
    public Map<Rule, Set<Term>> getFirstp() {
        return null;
    }

    @Override
    public boolean isLL1() {
        return false;
    }
}
