import java.util.LinkedList;
import java.util.Queue;

public class BankingQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        CallingQueue callingQueue = new CallingQueue(queue);
        CustomerInLine customerInLine = new CustomerInLine(queue);

        Thread callingThread = new Thread(callingQueue);
        Thread customerThread = new Thread(customerInLine);

        callingThread.start();
        customerThread.start();

        try {
            callingThread.join();
            customerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CallingQueue implements Runnable {
    private final Queue<Integer> queue;

    public CallingQueue(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Calling number " + i);
            queue.add(i);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CustomerInLine implements Runnable {
    private final Queue<Integer> queue;

    public CustomerInLine(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Integer number = queue.poll(); // use poll() instead of remove()
            if (number != null) {
                System.out.println("Customer with number " + number + " is being served.");

                if (number == 4) {
                    System.out.println("Congratulations! You are the fourth person in the queue.");
                }
            } else {
                if (Thread.currentThread().isInterrupted()) {
                    break; // exit the loop if the thread is interrupted
                }
            }
        }
    }
}
