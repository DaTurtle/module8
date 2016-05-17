package pp.block3.cc.symbol;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Bas on 17/05/2016.
 */
public class SymbolTableImplementation implements SymbolTable {

    private HashMap<Integer, HashMap<Integer, HashSet<String>>> scopeLevelDictionary = new HashMap<>();

    @Override
    public void openScope() {
        scopeLevelDictionary.put(scopeLevelDictionary.size()-1, scopeLevelDictionary.get(scopeLevelDictionary.size()-1));
    }

    @Override
    public void closeScope() {
        if(scopeLevelDictionary.remove(scopeLevelDictionary.size()-1) == null){
            throw(new RuntimeException());
        }

    }


    @Override
    public boolean add(String id) {
        scopeLevelDictionary.get(scopeLevelDictionary.size()-1).add(id);
        return false;
    }

    @Override
    public boolean contains(String id) {
        return scopeLevelDictionary.get(scopeLevelDictionary.size()-1).contains(id);
    }
}
