class BankAccount {
    private int balance = 1000;

    // synchronized method
    public synchronized void withdraw(String name, int amount) {
        if (balance >= amount) {
            System.out.println(name + " is about to withdraw " + amount);
            try {
                Thread.sleep(500); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println(name + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(name + " tried to withdraw, but insufficient balance!");
        }
    }
}

class Person extends Thread {
    private BankAccount account;
    private String personName;

    Person(BankAccount acc, String name) {
        account = acc;
        personName = name;
    }

    public void run() {
        account.withdraw(personName, 700);
    }
}

public class SyncBankDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Person p1 = new Person(account, "Person-1");
        Person p2 = new Person(account, "Person-2");

        p1.start();
        p2.start();
    }
}
