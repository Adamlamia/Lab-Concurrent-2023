public class findMaxThread extends Thread {
    private int[] array;
    private int start;
    private int end;
    private int max;

    public void FindMaxThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.max = Integer.MIN_VALUE;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
    }

    public int getMax() {
        return max;
    }
}