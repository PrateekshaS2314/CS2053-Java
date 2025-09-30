class TablePrinter {
    synchronized void printTable(int num, String threadName) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " prints: " + num + " x " + i + " = " + (num * i));
            try {
                Thread.sleep(400); // delay for visibility
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {
    TablePrinter table;
    String threadName;

    MyThread(TablePrinter t, String name) {
        table = t;
        threadName = name;
    }

    public void run() {
        table.printTable(5, threadName);
    }
}

public class SyncTableDemo {
    public static void main(String[] args) {
        TablePrinter table = new TablePrinter();

        MyThread t1 = new MyThread(table, "Thread-1");
        MyThread t2 = new MyThread(table, "Thread-2");

        t1.start();
        t2.start();
    }
}
