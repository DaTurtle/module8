package pp.block1.cc.dfa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan-Willem on 27-4-2016.
 */
public class MyScanner implements Scanner {
    @Override
    public List<String> scan(State dfa, String text) {
        ArrayList<String> words = new ArrayList<>();
        State init = dfa;
        int i = 0;
        int lastaccept = -1;
        while (i < (text.length()-1) && dfa.hasNext(text.charAt(i))) {

            String word = "";
            int wordloc = i;
            while (i < text.length() && dfa.hasNext(text.charAt(i))) {
                word = word + text.charAt(i);
                dfa = dfa.getNext(text.charAt(i));
                if (dfa.isAccepting()) {
                    lastaccept = i;
                }
                i++;
            }
//            System.out.println(word);
//            System.out.println(i + " " + lastaccept+" "+ text.length());
            if (lastaccept == i-1) {
//                System.out.println("max: " +word);
                words.add(word);
            } else {
                word = text.substring(wordloc, lastaccept+1);
//                System.out.println("min: " + word);
                words.add(word);
                if (i == lastaccept+2) {
                    break;
                }
                i = lastaccept+1;
            }
            dfa = init;
        }
        return words;
    }
}
