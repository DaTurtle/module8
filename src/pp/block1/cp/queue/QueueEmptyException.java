package pp.block1.cp.queue;

/**
 * Created by Bas on 10/05/2016.
 */
public class QueueEmptyException extends Exception {

    QueueEmptyException(){
        printStackTrace();
        System.out.println("The queue is empty");
    }
}
