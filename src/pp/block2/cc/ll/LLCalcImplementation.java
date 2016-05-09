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

        ArrayList<Symbol> lhs = new ArrayList<>();
        ArrayList<Symbol> rhs = new ArrayList<>();
        for (Rule r : grammar.getRules()) {
            lhs.add(r.getLHS());
            rhs.add(r.getRHS().get(0));
        }


        ArrayList<Symbol> lhsclean = new ArrayList<>();
        ArrayList<Term> rhsclean = new ArrayList<>();

        while (lhs.size() > 0) {
            for (int i = 0; i < lhs.size(); i++) {
                Symbol right = rhs.get(i);
                Symbol left = lhs.get(i);
                if (right instanceof Term) {
                    lhsclean.add(left);
                    rhsclean.add((Term) right);
                    lhs.remove(i);
                    rhs.remove(i);

                } else if (right instanceof NonTerm) {
                    lhs.remove(i);
                    rhs.remove(i);
                    for (int j = 0; j < lhs.size(); j++) {
                        if (lhs.get(j).equals(right)) {
                            lhs.add(left);
                            rhs.add(rhs.get(j));
                        }
                    }
                    for (int j = 0; j < lhsclean.size(); j++) {
                        if (lhs.get(j).equals(right)) {
                            lhs.add(left);
                            rhs.add(rhs.get(j));
                        }
                    }
                }
            }
        }
        //Combine into maps
        HashMap<Symbol, Set<Term>> res = new HashMap<>();

        for (int i = 0; i < lhsclean.size(); i++) {
            Symbol left = lhsclean.get(i);
            ArrayList<Term> rights = new ArrayList<>();
            rights.add(rhsclean.get(i));
            for (int j = i+1; j < lhsclean.size(); j++) {
                Symbol otherleft = lhsclean.get(j);

                if (left.equals(otherleft)) {
                    rights.add(rhsclean.get(j));
                    lhsclean.remove(j);
                    rhsclean.remove(j);
                }
            }
            res.put(left, new HashSet<>(rights));
            lhsclean.remove(i);
            rhsclean.remove(i);
        }
        return res;
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
