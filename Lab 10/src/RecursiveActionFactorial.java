import java.util.concurrent.RecursiveAction;

public class RecursiveActionFactorial extends RecursiveAction {
    private final int start;
    private final int end;
    private long result;

    public RecursiveActionFactorial(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start <= 5) { // Base case: if the range is small enough, compute the sum directly
            result = 0;
            for (int i = start; i <= end; i++) {
                result += factorial(i);
            }
        } else {
            int mid = start + (end - start) / 2;

            RecursiveActionFactorial leftSum = new RecursiveActionFactorial(start, mid);
            RecursiveActionFactorial rightSum = new RecursiveActionFactorial(mid + 1, end);

            leftSum.fork(); // Fork the left task asynchronously
            rightSum.compute(); // Compute the right task synchronously
            leftSum.join(); // Wait for the left task to complete

            result = leftSum.result + rightSum.result; // Combine the results
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

        RecursiveActionFactorial calculator = new RecursiveActionFactorial(1, 20);
        calculator.invoke();
        long result = calculator.result;
        System.out.println("Sum of factorials: " + result);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double seconds = duration / 1_000_000_000.0;
        System.out.println("Time taken: " + seconds + " seconds");
    }
}
