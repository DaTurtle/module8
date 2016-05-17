package pp.block3.cc.symbol;

import org.junit.Test;

import java.util.List;

/**
 * Created by Bas on 17/05/2016.
 */
public class TreeListenerTest {


//    @Test
//    public void test(){
//        MyTreeListener treeListener = new MyTreeListener("C:\\Users\\Bas\\Documents\\GitHub\\module8\\src\\pp\\block3\\cc\\symbol\\input");
//        List<Exception> errorlist = treeListener.getErrorlist();
//        for (Exception e : errorlist) {
//            System.out.println(e.toString());
//        }
//    }

    @Test
    public void fail(){
        MyTreeListener treeListener = new MyTreeListener("C:\\Users\\Bas\\Documents\\GitHub\\module8\\src\\pp\\block3\\cc\\symbol\\input2");
        List<Exception> errorlist = treeListener.getErrorlist();
        for (Exception e : errorlist) {
            System.out.println(e.toString());
        }
    }
}
