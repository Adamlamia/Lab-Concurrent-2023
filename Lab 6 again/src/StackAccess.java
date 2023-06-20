import java.util.Random;

public class StackAccess {

    private final int STACK_SIZE = 3;
    private final Object[] stack = new Object[STACK_SIZE];
    private int top = -1;

    public synchronized void push(Object item) throws InterruptedException {
        while (top == STACK_SIZE - 1) {
            wait(1000); // Wait for the stack to become not full
        }
        top++;
        stack[top] = item;
        notifyAll(); // Signal any waiting threads
    }

    //implement the lock to do this programe


    public synchronized Object pop() throws InterruptedException {//what happen if there no more pop action when stack is full
        while (top == -1) {
            wait(1000); // Wait for the stack to become not empty
        }
        Object item = stack[top];
        stack[top] = null;
        notifyAll(); // Signal any waiting threads
        return item;
    }

    public synchronized Object peek() throws InterruptedException {
        while (top == -1) {
            wait(1000); // Wait for the stack to become not empty
        }
        return stack[top];
    }
}

class ReadStack implements Runnable {
    private final StackAccess stackAccess;

    public ReadStack(StackAccess stackAccess) {
        this.stackAccess = stackAccess;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                Object item = stackAccess.pop();
                System.out.println(Thread.currentThread().getName() + " popped " + item);
                Thread.sleep(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}

class WriteStack implements Runnable {
    private final StackAccess stackAccess;
    private final Random random;

    public WriteStack(StackAccess stackAccess) {
        this.stackAccess = stackAccess;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                int item = random.nextInt(100);
                stackAccess.push(item);
                System.out.println(Thread.currentThread().getName() + " pushed " + item);
                Thread.sleep(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}

class PeekStack implements Runnable {
    private final StackAccess stackAccess;

    public PeekStack(StackAccess stackAccess) {
        this.stackAccess = stackAccess;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                Object item = stackAccess.peek();
                System.out.println(Thread.currentThread().getName() + " peeked " + item);
                Thread.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
