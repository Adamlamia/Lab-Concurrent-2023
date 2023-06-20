import java.util.concurrent.RecursiveTask;

public class RecursiveTaskFactorial extends RecursiveTask<Long> {
    private final int start;
    private final int end;

    public RecursiveTaskFactorial(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= 5) { // Base case: if the range is small enough, compute the sum directly
            long sum = 0;
            for (int i = start; i <= end; i++) {
                sum += factorial(i);
            }
            return sum;
        } else {
            int mid = start + (end - start) / 2;

            RecursiveTaskFactorial leftSum = new RecursiveTaskFactorial(start, mid);
            RecursiveTaskFactorial rightSum = new RecursiveTaskFactorial(mid + 1, end);

            leftSum.fork(); // Fork the left task asynchronously
            long rightResult = rightSum.compute(); // Compute the right task synchronously
            long leftResult = leftSum.join(); // Wait for the left task's result

            return leftResult + rightResult; // Combine the results
        }
    }

    private long factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        RecursiveTaskFactorial calculator = new RecursiveTaskFactorial(1, 20);
        long result = calculator.compute();
        System.out.println("Sum of factorials: " + result);

        long endTime = System.nanoTime();
    long duration = endTime - startTime;
    double seconds = duration / 1_000_000_000.0;
    System.out.println("Time taken: " + seconds + " seconds");
    }
}
