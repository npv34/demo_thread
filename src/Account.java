package src;

public class Account {
    private double balance;
    private String id;

    public Account(String id, double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Thread deposit(double amount, Bank bank) {
        return new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                try {
                    Thread.sleep(5000);
                    balance += amount;
                    bank.setBalance(amount);
                    System.out.println(Thread.currentThread().getName() + " done");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }
}
