import java.util.Random;

public class compare {
    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[500000000];
        Random rand = new Random();

        // Fill the array with randomly generated numbers in the range of 1 to 50,000
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(50000) + 1;
        }

        // Sequential version
        timer timer1 = new timer();
        timer1.start();

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

    //use join to wait until the thread to finish finding each own largest number

        timer1.end();

        System.out.println("Sequential version:");
        System.out.println("Largest number: " + max);
        System.out.println("Time taken: " + timer1.getDuration() + " ms");

        // Concurrent version
        timer timer2 = new timer();
        timer2.start();

        int mid = array.length / 2;

        findMaxThread t1 = new findMaxThread();
        findMaxThread t2 = new findMaxThread();

        t1.FindMaxThread(array, 0, mid);
        t2.FindMaxThread(array, mid, array.length);

        t1.run();
        t2.run();
  
        t1.join();
        t2.join();

        int max1 = t1.getMax();
        int max2 = t2.getMax();

        int maxConcurrent = Math.max(max1, max2);

        timer2.end();

        System.out.println("Concurrent version:");
        System.out.println("Largest number: " + maxConcurrent);
        System.out.println("Time taken: " + timer2.getDuration() + " ns");
    }
}
