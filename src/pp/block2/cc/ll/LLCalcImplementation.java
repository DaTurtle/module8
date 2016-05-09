package pp.block2.cc.ll;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;

import java.util.*;

/**
 * Created by Bas on 08/05/2016.
 */
public class LLCalcImplementation implements LLCalc {
    private Grammar grammar;

    public LLCalcImplementation(Grammar givenG) {

        this.grammar = givenG;
    }

    @Override
    public Map<Symbol, Set<Term>> getFirst() {


//        ArrayList<Symbol> lhs = new ArrayList<>();
//        ArrayList<List<Symbol>> rhs = new ArrayList<>();
//        for (Rule r : grammar.getRules()) {
//            lhs.add(r.getLHS());
//            rhs.add(r.getRHS());
//        }
//
//        for (NonTerm nonterm : grammar.getNonterminals()) {
//            for (int i = 0; i < rhs.size(); i++) {
//                List<Symbol> rhsi = rhs.get(i);
//                while (rhsi.contains(nonterm)) {
//                    rhsi.remove(nonterm);
//                    int index = lhs.indexOf(nonterm);
//                    rhsi.addAll(rhs.get(index));
//                }
//            }
//        }
//
//        ArrayList<HashSet<Term>> asdf = new ArrayList<>();
//        for (int i = 0; i < rhs.size(); i++) {
//            HashSet<Term> temp = new HashSet<>();
//            for (Symbol s: rhs.get(i)) {
//                temp.add((Term) s);
//            }
//            asdf.add(temp);
//        }
//
//        Map<Symbol, Set<Term>> res = new HashMap<>();
//        for (int i = 0; i < lhs.size(); i++) {
//            res.put(lhs.get(i), asdf.get(i));
//        }
//
//        return res;
/*

        ArrayList<Symbol> lhs = new ArrayList<>();
        ArrayList<Symbol> rhs = new ArrayList<>();
        for (Rule r : grammar.getRules()) {
            lhs.add(r.getLHS());
            rhs.add(r.getRHS().get(0));
        }

        for (NonTerm nonterm : grammar.getNonterminals()) {
            for (int i = 0; i < rhs.size(); i++) {
                while (rhs.contains(nonterm)) {
                    int index = rhs.indexOf(nonterm);
                    rhs.remove(nonterm);
                    ArrayList<Integer> temp = new ArrayList<>();
                    for (int j = 0; j < lhs.size(); j++) {
                        if (lhs.get(j).equals(nonterm)) {
                            temp.add(j);
                        }
                    }
                    for (Integer j : temp) {
                        lhs.add()
                    }
                    rhs.addAll(rhs.get(index));
                }
            }
        }
        //WAIT FOR IT!!
        Map result = new HashMap<Symbol, Set<Term>>();
        for(NonTerm nonterm: grammar.getNonterminals()) {
            List<Rule> rulesOfNonTerm = grammar.getRules(nonterm);
            Set firstSet = new HashSet<Term>();
            for(Rule selectedRule: rulesOfNonTerm){
                Symbol theFirstSymbol = selectedRule.getRHS().get(0);
               if (theFirstSymbol instanceof Term){
                   firstSet.add(theFirstSymbol);
               } else {

               }

            }
        }




    }

    public Set<Term> getFirst(NonTerm noni){
        Set result = new HashSet<Term>();
      for(Rule selectedRule:  grammar.getRules(noni)){
          Symbol theFirstSymbol = selectedRule.getRHS().get(0);
          if(theFirstSymbol instanceof Term) {
              result.add(theFirstSymbol);
          } else {
              result.add(getFirst((NonTerm) theFirstSymbol));
          }
      }
    }
*/
        Map result = new HashMap<Symbol, Set<Term>>();
        for (Term term : grammar.getTerminals()) {
            Set putitin = new HashSet<Term>();
            result.put(term, putitin.add(term));
        }
        //nog empties toevoegen?
        for (NonTerm nonTerm : grammar.getNonterminals()) {
            result.put(nonTerm, new HashSet<Term>());
        }
        boolean changed = true;
        while(changed){
            for(Rule rule : grammar.getRules()){
                Set<Term> termy = new HashSet<Term>();
                if(!rule.getRHS().isEmpty()){
                    termy.addAll((Set<Term>) result.get((Symbol) rule.getRHS().get(0)));
                    //remove empties?
                    int i = 1;
                    while( (HashSet<Symbol>) result.get((Term) rule.getRHS().get(i)).contains(Symbol.EMPTY) && i <= rule.getRHS().size() -1){
                        //dit klopt ook al allemaal niet
                        termy.addAll((HashSet<Term>) result.get((Symbol) rule.getRHS().get(i+1)));
                        i++;
                    }
                }
                if( i = k && (HashSet<Symbol>) result.get((Term) rule.getRHS().get(k)).contains(Symbol.EMPTY)){
                    termy.add(Symbol.EMPTY);
                    //WTF i dont get!!!!!!!
                    //moeten we een copy maken van de rules en daar in bewerken?
                }
            }

    }

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
