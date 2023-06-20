import java.util.Random;

public class Write implements Runnable {
    private final Node<Integer> node;
    private final Random random;

    public Write(Node<Integer> node) {
        this.node = node;
        random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                int value = random.nextInt(5); //random value 0-4 into int value
                System.out.println("Current value is " + value);
                node.setValue(value); //set ganerated value into node
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



