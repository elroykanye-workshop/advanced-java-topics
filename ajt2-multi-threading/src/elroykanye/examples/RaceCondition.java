package elroykanye.examples;

class Counter {
    int val = 0;
    void inc() { val++; }
    void dec() { val--; }

    /*
     * This class has a single field, 'val' which gets incremented and decremented when the methods inc() and dec() are
     * called respectively. After invoking each of these methods the same number of times, the value of 'val' will come
     * back to 0.
     * In an environment with multiple threads, the case is not the same.
     * To get this more, look at the main class, 'RaceCondition' below:
     */
}
public class RaceCondition extends Thread {
    /*
     * The race condition demonstrates a case where two threads created which can both access the same object, are
     * updating the value of such object concurrently. At the end of running such processes, the final value held by
     * that cannot be own and can only be guessed.
     * This is because, it is not possible to predict when either thread updated the value of that object, unless this
     * program was run on a single core machine.
     * Run this thread in the main class to see the demonstration in console.
     */
    Counter counter = new Counter();

    public void run() {
        new Decrement(this.counter);
        new Increment(this.counter);

        System.out.println("Final value of counter val = " + counter.val);
    }

}

class Increment extends Thread {
    // this thread picks the val property of the Counter and increments it

    private final Counter counter;
    Increment(Counter counter) {this.counter = counter; start();}

    @Override
    public void run() {
        for(int i = 0; i < 10000; i++) {
            if(i % 100 == 0) System.out.println("Increment ++ : " + counter.val);
            this.counter.inc();
        }

    }
}

class Decrement extends Thread {
    /// this thread picks the val property of the Counter and decrements it
    private final Counter counter;
    Decrement(Counter counter) {this.counter = counter; start();}

    @Override
    public void run() {
        for(int i = 0; i < 10000; i++) {
            if(i % 100 == 0) System.out.println(" -- Decrement: " + this.counter.val);
            counter.dec();
        }
    }
}
