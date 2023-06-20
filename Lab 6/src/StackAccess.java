import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StackAccess {
    private final int STACK_SIZE = 3;
    private int[] stack = new int[STACK_SIZE];
    private int top = -1;

    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public StackAccess(int i) {
    }

    public void push(int value) throws InterruptedException {
        lock.lock();
        try {
            while (top == STACK_SIZE - 1) {
                if (!notFull.await(1000000, TimeUnit.MICROSECONDS)) {
                    // discard push operation after 1 second of waiting
                    return;
                }
            }
            top++;
            stack[top] = value;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int pop() throws InterruptedException {
        lock.lock();
        try {
            while (top == -1) {
                if (!notEmpty.await(1000000, TimeUnit.MICROSECONDS)) {
                    // discard pop operation after 1 second of waiting
                    System.out.println("Pop " + stack[top] + " cancelled");
                    return -1;
                }
            }
            int value = stack[top];
            top--;
            notFull.signal();
            return value;
        } finally {
            lock.unlock();
        }
    }

    public int peek() {
        lock.lock();
        try {
            return top == -1 ? -1 : stack[top];
        } finally {
            lock.unlock();
        }
    }
}
