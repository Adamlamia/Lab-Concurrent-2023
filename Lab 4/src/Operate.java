public class Operate implements Runnable {
    private final Node<Integer> node;
    private final int target;
    private final Runnable dummyTask;
    private int count;

    public Operate(Node<Integer> node, int target, Runnable dummyTask) {
        this.node = node;
        this.target = target;
        this.dummyTask = dummyTask;
        count = 0;
    }

    @Override
    public void run() {
        try {
            while (count < 2) {
                node.executeOnValue(target, () -> {
                    dummyTask.run(); //when dummyTask = target
                    count++; //Increment, after twice happended terminate program
                });
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
    }
}