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
    private Map<Symbol, Set<Term>> first;
    private Map<NonTerm, Set<Term>> follow;
    private Map<Rule, Set<Term>> firstp;

    public LLCalcImplementation(Grammar givenG) {

        this.grammar = givenG;

    }

    @Override
    public Map<Symbol, Set<Term>> getFirst() {
        Map<Symbol, Set<Term>> first = new HashMap<Symbol, Set<Term>>();
        Set<Term> termini = new HashSet<Term>(grammar.getTerminals());
        termini.add(Symbol.EMPTY);
        termini.add(Symbol.EOF);
        for(Term termi: termini) {
            HashSet<Term> mom = new HashSet<Term>();
            mom.add(termi);
            first.put(termi, mom);
        }
        for(NonTerm termo: grammar.getNonterminals()){
            first.put(termo, new HashSet<Term>());
        }
        boolean changing = true;
        while (changing){
            changing =false;
            for(Rule ruli: grammar.getRules()){
                List<Symbol> brood = ruli.getRHS();
                Set<Term> rhs = new HashSet<Term>();
                Set<Term> tempoFirst = new HashSet<>(first.get(brood.get(0)));
                tempoFirst.remove(Symbol.EMPTY);
                rhs.addAll(tempoFirst);
                int i =0;
                while ( first.get(brood.get(i)).contains(Symbol.EMPTY) && i < brood.size()-1){
                    tempoFirst = new HashSet<>(first.get(brood.get(i+1)));
                    tempoFirst.remove(Symbol.EMPTY);
                    rhs.addAll(tempoFirst);
                    i++;
                }
                if (i == brood.size()-1 && first.get(brood.get(i)).contains(Symbol.EMPTY)){
                    rhs.add(Symbol.EMPTY);
                }
                int oldSize = first.get(ruli.getLHS()).size();
                Set<Term> feesttoeter = new HashSet<>(first.get(ruli.getLHS()));
                feesttoeter.addAll(rhs);
                first.put(ruli.getLHS(), feesttoeter);
                if(!changing){
                    changing = oldSize != first.get(ruli.getLHS()).size();
                }
            }
        }
        return first;
    }

    @Override
    public Map<NonTerm, Set<Term>> getFollow() {
        if(first == null){
           first = getFirst();
        }
        Map<NonTerm, Set<Term>> follow = new HashMap<>();
        for(NonTerm termo : grammar.getNonterminals()){
            follow.put(termo, new HashSet<>());
        }
        Set<Term> temporarySet = follow.get(grammar.getStart());
        temporarySet.add(Symbol.EOF);
        follow.put(grammar.getStart(), temporarySet);
        boolean changing = true;
        while(changing){
            changing = false;
            for(Rule ruli: grammar.getRules()){
                Set<Term> trailer = new HashSet<>(follow.get(ruli.getLHS()));
                List<Symbol> brood = ruli.getRHS();
                for(int i = brood.size()-1; i >=0; i--){
                    if (brood.get(i) instanceof NonTerm){
                        Set<Term> tomperarySet = new HashSet<>(follow.get(brood.get(i)));
                        tomperarySet.addAll(trailer);
                        if(!changing){
                            changing = tomperarySet.size() != follow.get(brood.get(i)).size();
                        }
                        follow.put((NonTerm) brood.get(i), tomperarySet);
                        if(first.get(brood.get(i)).contains(Symbol.EMPTY)){
                            Set<Term> temporaryFirst = new HashSet<>(first.get(brood.get(i)));
                            temporaryFirst.remove(Symbol.EMPTY);
                            trailer.addAll(temporaryFirst);
                        } else {
                            trailer  = first.get(brood.get(i));
                        }
                    } else {
                        trailer  = first.get(brood.get(i));
                    }
                }
            }
        }
        return follow;
    }

    @Override
    public Map<Rule, Set<Term>> getFirstp() {
        if (first == null){
            first = getFirst();
        }
        if (follow == null){
            follow = getFollow();
        }
        Map<Rule, Set<Term>> firstp =new HashMap<Rule, Set<Term>>();
        for(Rule ruli: grammar.getRules()){
            if(first.get(ruli.getRHS().get(0)).contains(Symbol.EMPTY)){
                Set<Term> termi  =new HashSet<>();
                termi.addAll(follow.get(ruli.getLHS()));
                termi.addAll(first.get(ruli.getRHS().get(0)));
                firstp.put(ruli, termi);
            } else {
                firstp.put(ruli, first.get(ruli.getRHS().get(0)));
            }
        }
        return firstp;
    }

    @Override
    public boolean isLL1() {
        if(firstp == null){
            firstp = getFirstp();
        }
        Map<NonTerm, Integer> expectedSizer = new HashMap<>();
        Map<NonTerm, Set<Term>> resultedSets = new HashMap<>();
        for (Rule r : firstp.keySet()) {
            Set<Term> terms = firstp.get(r);
            int newValue;
            if(expectedSizer.get(r.getLHS()) == null) {
                newValue = terms.size();
            } else {
                newValue = expectedSizer.get(r.getLHS()) + terms.size();
            }
            System.out.println(String.valueOf(r.getLHS()) +":"+String.valueOf(newValue));
            expectedSizer.put(r.getLHS(), newValue);
            if ( resultedSets.get(r.getLHS()) != null) {
                resultedSets.get(r.getLHS()).addAll(terms);
            } else {
                resultedSets.put(r.getLHS(), new HashSet<>(terms));
            }
        }
        boolean res = true;
        for (NonTerm key : expectedSizer.keySet()) {
            System.out.println(String.valueOf(key) + ": " + String.valueOf(expectedSizer.get(key)) + " " + String.valueOf(resultedSets.get(key).size()) );
            if (expectedSizer.get(key) != resultedSets.get(key).size()) {
                res = false;
                break;
            }
        }
        return res;
    }



    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*    public Set<Term> getTerms(NonTerm nonterm) {
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
    }*/
}
