
class MyThread extends Thread {

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);

            Thread.yield();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            }
        }
    }
}

public class YeildStop {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
