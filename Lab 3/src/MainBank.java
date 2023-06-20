public class MainBank {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // simulate deposit threads
        for (int i = 0; i < 5; i++) {
            Thread depositThread = new Thread(() -> {
                account.deposit(100);
            });
            depositThread.start();
        }

        // simulate withdrawal threads
        for (int i = 0; i < 3; i++) {
            Thread withdrawThread = new Thread(() -> {
                account.withdraw(50);
            });
            withdrawThread.start();
        }
    }
}
