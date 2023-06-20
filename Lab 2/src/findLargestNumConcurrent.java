import java.util.Random;

public class findLargestNumConcurrent {

    public static void main(String[] args) {
        int[] array = new int[1000000];
        Random rand = new Random();

        // Fill the array with randomly generated numbers in the range of 1 to 50,000
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(50000) + 1;
        }

        int mid = array.length / 2;

        // Create two threads to find the largest number concurrently
        findMaxThread t1 = new findMaxThread();
        findMaxThread t2 = new findMaxThread();

        t1.FindMaxThread(array, 0, mid);
        t2.FindMaxThread(array, mid, array.length);

        t1.run();
        t2.run();

        // Determine the largest number found by each thread
        int max1 = t1.getMax();
        int max2 = t2.getMax();

        // Determine the overall largest number
        int max = Math.max(max1, max2);

        System.out.println("The largest number in the array is: " + max);
    }
}
