class SharedBuffer {
    private int data;
    private boolean hasData = false; 

    public synchronized void produce(int value) {
        try {
            while (hasData) {
                wait();
            }

            data = value;
            hasData = true;
            System.out.println("Produced: " + value);

            notify();
        } catch (InterruptedException e) {
            System.out.println("Producer interrupted.");
        }
    }

    public synchronized int consume() {
        int value = 0;
        try {
            while (!hasData) {
                wait();
            }

            value = data;
            hasData = false;
            System.out.println("Consumed: " + value);

            notify();
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted.");
        }
        return value;
    }
}

class Producer extends Thread {
    private SharedBuffer buffer;

    Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private SharedBuffer buffer;

    Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
