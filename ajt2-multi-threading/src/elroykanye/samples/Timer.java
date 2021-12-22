package elroykanye.samples;

import java.time.Instant;

public class Timer extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(Instant.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Timer has been interrupted");
            }
        }
    }

}
