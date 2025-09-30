class Counter {
    int count = 0; // shared resource

    public synchronized void increment() {
        count++;
    }
}

class MyThread extends Thread {
    Counter counter;

    MyThread(Counter c) {
        counter = c;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class SyncCounterDemo {
    public static void main(String[] args) {
        Counter c = new Counter();

        MyThread t1 = new MyThread(c);
        MyThread t2 = new MyThread(c);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count (expected 2000): " + c.count);
    }
}
