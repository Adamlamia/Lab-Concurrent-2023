import java.util.Random;

public class ReadStack implements Runnable {
    private StackAccess stackAccess;

    public ReadStack(StackAccess stackAccess) {
        this.stackAccess = stackAccess;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                int value = stackAccess.pop();
                System.out.println("Read value: " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class WriteStack implements Runnable {
    private StackAccess stackAccess;
    private Random random;

    public WriteStack(StackAccess stackAccess) {
        this.stackAccess = stackAccess;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            int value = random.nextInt(100);
            try {
                stackAccess.push(value);
                System.out.println("Write value: " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class PeekStack implements Runnable {
    private StackAccess stackAccess;

    public PeekStack(StackAccess stackAccess) {
        this.stackAccess = stackAccess;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            int value = stackAccess.peek();
            System.out.println("Peek value: " + value);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
