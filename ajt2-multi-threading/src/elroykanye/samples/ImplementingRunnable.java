package elroykanye.samples;

public class ImplementingRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 4; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

/*
 * Creating threads by extending the Thread class has an inherent problem. This is because a class cannot extend more
 * than one class. Normally, it may come to be that a class has to extend some other class which will conflict with the
 * Thread class. Java provides an alternative way to create threads which is by implementing the Runnable interface as
 * shown above.
 *
 * However, an object of this class is not a thread, but just a Runnable in the sense that its run() method can be
 * executed concurrently with other codes. The thread object is created and the Runnable object is passed as an argument
 *  to the constructor.
 */
