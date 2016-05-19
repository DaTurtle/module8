package pp.s1594575.q1_5;

import pp.block3.cc.symbol.SymbolTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MySymbolTable implements SymbolTable {

    HashMap<Integer, Set<String>> depthmap;

    public MySymbolTable() {
        depthmap = new HashMap<>();
        depthmap.put(0, new HashSet<String>());
    }

    public HashMap<Integer, Set<String>> getMap(){
        return depthmap;
    }

    @Override
    public void openScope() {
        depthmap.put(depthmap.size(), new HashSet<String>());
    }

    @Override
    public void closeScope() {
        if (depthmap.size() == 1) {
            throw new RuntimeException("already in outer scope");
        } else {
            depthmap.remove(depthmap.size()-1);
        }
    }


    @Override
    public boolean add(String id) {
        boolean result = false;
        System.out.println("adding " + id + " to level " + depthmap.size());
        if(depthmap.get(depthmap.size()-1).contains(id)){
            result = false;
        } else {
            depthmap.get(depthmap.size()-1).add(id);
            result = true;
        }
        return result;
    }

    @Override
    public boolean contains(String id) {
        boolean res = false;
        System.out.println("contains " + id + " at level " + depthmap.size());
        for (Integer i : depthmap.keySet()){
            Set<String> set = depthmap.get(i);
            for (String s : set) {
                if (s.equals(id)) {
                    res = true;
                }
            }
        }
        return res;
    }
}
