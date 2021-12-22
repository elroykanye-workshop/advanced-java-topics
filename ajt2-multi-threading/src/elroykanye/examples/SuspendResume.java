package elroykanye.examples;

class SuspendResumeThread extends Thread {
    boolean active = true;

    public void Suspend() {
        active = false;
    }

    public synchronized void Resume() {
        active = true;
        notify();
    }

    public synchronized void run() {
        try {
            while(true) {
                if(active) {
                    System.out.println("Running...");
                    Thread.sleep(500);
                } else {
                    System.out.println("Suspended...");
                    wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SuspendResume {
    public static void main() throws InterruptedException {
        SuspendResumeThread srt = new SuspendResumeThread();

        srt.start();

        while(true) {
            Thread.sleep(1000);
            srt.Suspend();
            Thread.sleep(1000);
            srt.Resume();
        }
    }
}