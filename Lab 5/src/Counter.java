import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    
    private static AtomicInteger counter = new AtomicInteger(0);
    
    public static void main(String[] args) {
        
        Thread incThread = new Thread(() -> {
            while (true) {
                int value = counter.incrementAndGet();
                System.out.println("Task 1 incremented counter to " + value);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread checkThread = new Thread(() -> {
            while (true) {
                int value = counter.get();
                if (value >= 50) {
                    System.out.println("Task 2 detected counter value of " + value + ", stopping program...");
                    System.exit(0);
                } else {
                    System.out.println("Task 2 checking counter value of " + value);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        incThread.start();
        checkThread.start();
        
    }
}
