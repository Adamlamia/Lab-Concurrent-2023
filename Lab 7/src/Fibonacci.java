import java.util.concurrent.*;

public class Fibonacci {

    public static void main(String[] args) throws Exception {
        int n = 40; // Fibonacci number to calculate

        // Calculate Fibonacci value sequentially
        long startTime = System.currentTimeMillis();
        long fibSeq = calculateFibonacciSequential(n);
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential Fibonacci: " + fibSeq);
        System.out.println("Sequential calculation time: " + (endTime - startTime) + "ms");

        // Calculate Fibonacci value asynchronously
        startTime = System.currentTimeMillis();
        long fibAsync = calculateFibonacciAsync(n);
        endTime = System.currentTimeMillis();
        System.out.println("Asynchronous Fibonacci: " + fibAsync);
        System.out.println("Asynchronous calculation time: " + (endTime - startTime) + "ms");

        // Shutdown the executor service
        executorService.shutdown();
    }

    private static long calculateFibonacciSequential(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calculateFibonacciSequential(n - 1) + calculateFibonacciSequential(n - 2);
        }
    }

    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    private static long calculateFibonacciAsync(int n) throws Exception {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> n, executorService);
        return future.get(); // Wait for the result
    }
/*
    private static class FibonacciTask implements Callable<Long> {
        private final int n;

        public FibonacciTask(int n) {
            this.n = n;
        }
 
        @Override
        public Long call() throws Exception {
            return calculateFibonacciSequential(n);
        }
    }*/
}
