package pp.block1.cc.dfa;

/**
 * Created by Jan-Willem on 27-4-2016.
 */
public class MyChecker implements Checker {
    @Override
    public boolean accepts(State start, String word) {
        if (word.length() < 1) {
            return false;
        }
        State current = start;
        for (int i = 0; i < word.length(); i++) {
            char symbol = word.charAt(i);
            if (!current.hasNext(symbol)){
                return false;
            }
            current = current.getNext(symbol);
        }
        return true;
    }
}
