package elroykanye.samples;

import java.time.Instant;

public class Sleep {
    public void clocker() {
        while(true) {
            System.out.println(Instant.now());
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println("Clocker interrupted");
            }
        }
    }
}
