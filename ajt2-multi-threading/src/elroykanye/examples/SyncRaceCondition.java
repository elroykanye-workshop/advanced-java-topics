package elroykanye.examples;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class SyncCounter {
    int val = 0;
    final Object o = new Object();
    synchronized void inc() {
        val++;
    }
    synchronized void dec() {
        val--;
    }

    /*
     * This class has a single field, 'val' which gets incremented and decremented when the methods inc() and dec() are
     * called respectively. After invoking each of these methods the same number of times, the value of 'val' will come
     * back to 0.
     * In an environment with multiple threads, the case is not the same.
     * To get this more, look at the main class, 'RaceCondition' below:
     */
}
public class SyncRaceCondition  {
    /*
     * The race condition demonstrates a case where two threads created which can both access the same object, are
     * updating the value of such object concurrently. At the end of running such processes, the final value held by
     * that cannot be own and can only be guessed.
     * This is because, it is not possible to predict when either thread updated the value of that object, unless this
     * program was run on a single core machine.
     *
     *  -- Run this thread in the main class to see the demonstration in console.
     *  -- OR
     *  -- Check the race-condition-result.txt file in the root of the project.
     *
     * As seen, instead of getting the final value of 'val' as 0, we get different random numbers.
     * This is because two non-atomic operations declared in inc() and dec() are executed in an overlapped way.
     * This interleaving of the operations causes the final value stored in 'val' to be what was left by the last thread
     * that held or updated it. This situation is known as the RACE CONDITION.
     * The segment of code where resources are shared by multiple threads is known as a critical section. In an
     * enterprise application, perhaps, this may cause mayhem with the data being processed.
     *
     * Go back to the MultiThreading class.
     */
    SyncCounter counter = new SyncCounter();

    public void main() throws InterruptedException {
        SyncIncrement syncIncrement = new SyncIncrement(counter);
        syncIncrement.join();

        saveFinalVal();
    }

    public synchronized void saveFinalVal() {
        System.out.println("-------- Sync Final value of counter val = " + counter.val + " --------");

        String resultFile = "race-condition-result-sync.txt";
        File file = new File(resultFile);

        String newLine = "Object: " + counter + " - val: " + counter.val;
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(resultFile, true));
            if (file.createNewFile()) {
                System.out.println("Writing...");
                bf.write(newLine);
            } else {
                System.out.println("Appending...");
                bf.append(newLine);
            }
            bf.newLine();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class SyncIncrement extends Thread {
    // this thread picks the val property of the Counter and increments it

    private final SyncCounter counter;
    SyncIncrement(SyncCounter counter) {
        this.counter = counter;
        start();
    }

    @Override
    public void run() {
        SyncDecrement syncDecrement = new SyncDecrement(this.counter);
        for(int i = 0; i < 10000; i++) {
            if(i % 100 == 0) System.out.println("Increment ++ : " + counter.val);
            this.counter.inc();
        }
        try {
            syncDecrement.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SyncDecrement extends Thread {
    /// this thread picks the val property of the Counter and decrements it
    private final SyncCounter counter;
    SyncDecrement(SyncCounter syncCounter) {
        this.counter = syncCounter;
        start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 10000; i++) {
            if(i % 100 == 0) System.out.println(" -- Decrement: " + this.counter.val);
            counter.dec();
        }
    }
}
