// suspend(), resume(), stop() ekhon deprecated, tai flag diye same kaj kora hoyeche.
// Ei code shob Java version e cholbe.

class MyThread extends Thread {
    private boolean suspended = false;   // suspend flag
    private boolean stopped = false;     // stop flag

    public void run() {
        int i = 1;
        while (!stopped) {
            synchronized (this) {
                while (suspended) {
                    try {
                        wait();          // thread ke wait e rakho (suspend)
                    } catch (InterruptedException e) { }
                }
            }
            System.out.println("Running: " + i++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { }
        }
        System.out.println("Thread stopped.");
    }

    void mySuspend() { suspended = true; }

    synchronized void myResume() {
        suspended = false;
        notify();                        // thread ke jagao (resume)
    }

    void myStop() { stopped = true; }
}

public class P05_SuspendResumeStop {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();

        Thread.sleep(2000);
        System.out.println(">> Suspending thread");
        t.mySuspend();

        Thread.sleep(2000);
        System.out.println(">> Resuming thread");
        t.myResume();

        Thread.sleep(2000);
        System.out.println(">> Stopping thread");
        t.myStop();
    }
}
