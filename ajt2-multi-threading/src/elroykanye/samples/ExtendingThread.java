package elroykanye.samples;

public class ExtendingThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

/*
 * A way of create threads is to write a class extending the Thread class and overwriting its run() method just like it
 * has been done in this class.
 *
 * The next step is to create objects from this class. Each of these objects will hold their own threads. To run the
 * created threads, call the start() method of the object and the code in the run() method will be executed.
 */
