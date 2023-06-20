public class SequenceFactorial {
    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long sum = 0;
        for (int i = 1; i <= 20; i++) {
            sum += factorial(i);
        }
        System.out.println("Sum of factorials: " + sum);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double seconds = duration / 1_000_000_000.0;
        System.out.println("Time taken: " + seconds + " seconds");
    }
}
