public class BankAccount {
    private double balance;

    public synchronized void deposit(double amount) {
        System.out.println("Deposit of " + amount + " started");
        double newBalance = balance + amount;
        try {
            Thread.sleep(1000); // simulate deposit process
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = newBalance;
        System.out.println("Deposit of " + amount + " completed. New balance is " + balance);
    }

    public synchronized void withdraw(double amount) {
        System.out.println("Withdrawal of " + amount + " started");
        double newBalance = balance - amount;
        try {
            Thread.sleep(1000); // simulate withdrawal process
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = newBalance;
        System.out.println("Withdrawal of " + amount + " completed. New balance is " + balance);
    }

    public double getBalance() {
        return balance;
    }
}
