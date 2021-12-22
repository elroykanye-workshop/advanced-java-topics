package elroykanye;


import elroykanye.examples.SuspendResume;
import elroykanye.samples.MinMaxPriority;

public class MultiThreading {
    public static void main(String[] args) throws InterruptedException {
        new MinMaxPriority().showPriority();
        System.out.println(Thread.currentThread().getPriority());
    }

    public static void sampleMain() {
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

    /*
     * C) Sleep
     *
     * A thread can be made to suspend execution using sleep() method, causing the thread to cease execution for the
     * specified duration given as a parameter to this method.
     */

    /*
     * D) Creating a Thread
     *
     * There are two ways to create threads:
     * 1) Extending the java.lang.Thread class
     * 2) Implementing the java.lang.Runnable interface.
     * Check the code samples in the samples package.
     */

    /*
     * E) Interrupting a Thread
     *
     * This can be done by sending a request to a thread using its interrupt() method that sets the thread's interrupt
     * flag.
     */

    /*
     * F) Suspending and Resuming
     *
     * A thread can be suspending and resumed using the combination of wait() and notify() methods.
     * Check the SuspendResume class in examples.
     */

    /*
     * G) Thread Priority
     *
     * Every thread in java has a priority. Higher priority threads get more preference in terms of CPU, I/O time, etc
     * than lower priority threads.
     * Priorities are represented by integer numbers from 1 (lowest) to 10 (highest) which are represented by 2 static
     * fields MIN_PRIORITY and MAX_PRIORITY
     */
}
