class MessageSender {
    synchronized void sendMessage(String msg) {
        System.out.print("Sending: ");
        try {
            Thread.sleep(500); // simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(msg);
    }
}

class MyThread extends Thread {
    MessageSender sender;
    String message;

    MyThread(MessageSender s, String msg) {
        sender = s;
        message = msg;
    }

    public void run() {
        sender.sendMessage(message);
    }
}

public class SyncMessageDemo {
    public static void main(String[] args) {
        MessageSender sender = new MessageSender();

        MyThread t1 = new MyThread(sender, "Hello from Thread-1");
        MyThread t2 = new MyThread(sender, "Hello from Thread-2");

        t1.start();
        t2.start();
    }
}

