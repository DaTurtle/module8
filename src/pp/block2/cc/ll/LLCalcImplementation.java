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

    public Set<Term> getTerms(NonTerm nonterm) {
        List<Rule> rules = grammar.getRules(nonterm);
        Set<Term> terms = new HashSet<>();
        for (Rule r : rules) {
            Symbol sym = r.getRHS().get(0);
            if (sym instanceof Term) {
                terms.add((Term)sym);
            } else if (sym instanceof NonTerm) {
                terms.addAll(getTerms((NonTerm) sym));
            }
        }
        return terms;
    }

    @Override
    public Map<Symbol, Set<Term>> getFirst() {
        Map<Symbol, Set<Term>> res = new HashMap<>();
        for (Rule r : grammar.getRules()) {
            res.put(r.getLHS(), getTerms(r.getLHS()));
        }
        return res;
    }

    public Set<Term> getFollows(Symbol sym) {
        List<Rule> rules = grammar.getRules();
        Set<Term> res = new HashSet<>();
        for (int i = 0; i < rules.size(); i++) {
            Rule rule = rules.get(i);
            List<Symbol> rhs = rule.getRHS();
            for (int j = 0; j < rhs.size(); j++) {
                if (rhs.get(j).equals(sym)){
                    if (j+1 < rules.size()) {
                        if (rhs.get(j+1) instanceof Term) {
                            res.add((Term) rhs.get(j+1));
                        } else if(rhs.get(j+1) instanceof NonTerm) {
                            res.addAll(getTerms((NonTerm)rhs.get(j+1)));
                        }
                    } else {
                        res.addAll(getFollows(rule.getLHS()));
                    }
                }
            }
        }
        return res;
    }

    @Override
    public Map<NonTerm, Set<Term>> getFollow() {
        Map<NonTerm, Set<Term>> res = new HashMap<>();
        for (Rule r : grammar.getRules()){
            res.put(r.getLHS(), getFollows(r.getLHS()));
        }
        return res;
    }

    @Override
    public Map<Rule, Set<Term>> getFirstp() {
        Map<Rule, Set<Term>> res = new HashMap<>();
        for (Rule r : grammar.getRules()) {
            res.put(r, getTerms(r.getLHS()));
        }
        return res;
    }

    @Override
    public boolean isLL1() {
        Map<Rule, Set<Term>> firstp = getFirstp();
        boolean res = true;
        for (Rule r : firstp.keySet()) {
            Set<Term> rhs = firstp.get(r);
            res = res && (rhs.size()==1);
        }
        return res;
    }
}
