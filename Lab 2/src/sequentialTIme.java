import java.util.Random;

public class sequentialTIme {

    public static void main(String[] args) {
        int[] array = new int[100000000];
        Random rand = new Random();

        // Fill the array with randomly generated numbers in the range of 1 to 50,000
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(50000) + 1;
        }

        timer timer = new timer();

        // Sequentially find the largest number in the array
        timer.start();

        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        timer.end();

        System.out.println("The largest number in the array is: " + max);
        System.out.println("Time taken: " + timer.getDuration() + " milliseconds");
    }
}
