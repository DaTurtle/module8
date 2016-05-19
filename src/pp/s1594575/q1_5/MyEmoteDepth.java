package pp.s1594575.q1_5;

import pp.block3.cc.symbol.SymbolTable;

import java.util.*;

public class MyEmoteDepth implements SymbolTable {

    HashMap<Integer, List<String>> depthmap;

    public MyEmoteDepth() {
        depthmap = new HashMap<>();
        depthmap.put(0, new ArrayList<String>());
    }

    public int getIntensity(String id) {
        int res = 0;
        for (Integer i : depthmap.keySet()){
            List<String> list = depthmap.get(i);
            for (String s : list) {
                if (s.equals(id)) {
                    res++;
                }
            }
        }
//        System.out.println("The intensity of word \"" + id + "\" is: " + res);
        return res;
    }

    public HashMap<Integer, List<String>> getMap(){
        return depthmap;
    }

    @Override
    public void openScope() {
        depthmap.put(depthmap.size(), new ArrayList<String>());
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
//        System.out.println("adding \"" + id + "\" to level " + (depthmap.size()-1));
        depthmap.get(depthmap.size()-1).add(id);
        return true;
    }

    @Override
    public boolean contains(String id) {
        boolean res = false;
        for (Integer i : depthmap.keySet()){
            List<String> list = depthmap.get(i);
            for (String s : list) {
                if (s.equals(id)) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }
}
