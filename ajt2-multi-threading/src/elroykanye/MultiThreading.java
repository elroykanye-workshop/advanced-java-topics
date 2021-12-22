package elroykanye;

public class MultiThreading {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();

        System.out.println("Current thread: " + mainThread);

        System.out.println("Name: " + mainThread.getName());
        System.out.println("ID: " + mainThread.getId());
        System.out.println("Priority: "+mainThread.getPriority());
        System.out.println("State: "+mainThread.getState());
        System.out.println("Changing name and priority...");
        mainThread.setName("Primary");
        mainThread.setPriority(8);
        System.out.println("After name and priority change...");
        System.out.println("Current Thread: "+mainThread);
        System.out.println("Name: "+mainThread.getName());
        System.out.println("Priority: "+mainThread.getPriority());


    }

    /*
     * A) Intro
     *
     * A thread is a control/flow/path of execution that exists within a process.
     * A process may have one or more threads in it and is referred to as a single-threaded or multi-threaded process
     * respectively.
     * Multi-threading enables us to write programs in a way where multiple activities can proceed concurrently in the
     * same program. However, a system having only one execution core executes multiple threads in an interleaved way
     * resulting in no extra benefit in terms of effective execution time.
     */

    /*
     * B) Main Thread
     *
     * When a program is supplied to the JVM for execution, it creates one thread and associates the program's main()
     * method. The thread then executes the statement contained in the main() method. As this is the first thread
     * created and running when the program begins, it is said to be the main/primary thread. Other threads if required
     * may be spawned from this thread.
     *
     * To work with the main thread, we can reference the object from Thread in the main() method. View the code above.
     */
}
