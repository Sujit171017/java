// Way 1: Thread class extend kore
class MyThread1 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("MyThread1 : " + i);
        }
    }
}

// Way 2: Runnable interface implement kore
class MyThread2 implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("MyThread2 : " + i);
        }
    }
}

public class P06_ThreadClass {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        Thread t2 = new Thread(new MyThread2());

        t1.start();
        t2.start();
    }
}
