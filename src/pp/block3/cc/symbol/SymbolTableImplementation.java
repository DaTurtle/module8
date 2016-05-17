package pp.block3.cc.symbol;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bas on 17/05/2016.
 */
public class SymbolTableImplementation implements SymbolTable {

    HashMap<Integer, Set<String>> scopeLevelDictionary;

    public SymbolTableImplementation() {
        scopeLevelDictionary = new HashMap<>();
        scopeLevelDictionary.put(0, new HashSet<String>());
    }

    public HashMap<Integer, Set<String>> getMap(){
        return scopeLevelDictionary;
    }

    @Override
    public void openScope() {
        scopeLevelDictionary.put(scopeLevelDictionary.size(), new HashSet<String>());
    }

    @Override
    public void closeScope() {
        if (scopeLevelDictionary.size() == 1) {
            throw new RuntimeException("already in outer scope");
        } else {
            scopeLevelDictionary.remove(scopeLevelDictionary.size()-1);
        }
    }


    @Override
    public boolean add(String id) {
        boolean result = false;
        System.out.println("adding " + id + " to level " + scopeLevelDictionary.size());
        if(scopeLevelDictionary.get(scopeLevelDictionary.size()-1).contains(id)){
            result = false;
        } else {
            scopeLevelDictionary.get(scopeLevelDictionary.size()-1).add(id);
            result = true;
        }
        return result;
    }

    @Override
    public boolean contains(String id) {
        boolean res = false;
        System.out.println("contains " + id + " at level " + scopeLevelDictionary.size());
        for (Integer i : scopeLevelDictionary.keySet()){
            Set<String> set = scopeLevelDictionary.get(i);
            for (String s : set) {
                if (s.equals(id)) {
                    res = true;
                }
            }
        }
        return res;
    }
}
