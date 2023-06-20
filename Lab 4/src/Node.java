import java.util.concurrent.locks.*;

public class Node<T> {
    private T value;
    private final Lock lock;
    private final Condition valueChanged;

    public Node(T value) {
        this.value = value;
        lock = new ReentrantLock();
        valueChanged = lock.newCondition();
    }

    public void setValue(T newValue) {
        lock.lock();
        try {
            value = newValue;
            valueChanged.signalAll(); 
        } finally {
            lock.unlock(); //modified value will be unlocked
        }
    }

    public void executeOnValue(T desiredValue, Runnable task) throws InterruptedException {
        lock.lock();
        try {
            while (!value.equals(desiredValue)) {
                valueChanged.await();
            }
            Thread t = new Thread(task);
            t.start();
        } finally {
            lock.unlock();
        }
    }

    public T getValue() {
        return value;
    }
}
