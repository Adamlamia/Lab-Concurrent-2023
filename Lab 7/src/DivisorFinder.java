import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DivisorFinder {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 25000;
    private static final int TASK_SIZE = 1000;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        List<Callable<Result>> tasks = new ArrayList<>(); //subtask return Result

        for (int i = RANGE_START; i <= RANGE_END; i += TASK_SIZE) {
            int start = i;
            int end = Math.min(start + TASK_SIZE - 1, RANGE_END);
            tasks.add(() -> findNumberWithMaxDivisors(start, end));
        }

        List<CompletableFuture<Result>> futures = new ArrayList<>();
        for (Callable<Result> task : tasks) {
            CompletableFuture<Result> future = CompletableFuture.supplyAsync(() -> {
                try {
                    return task.call();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }, executorService);
            futures.add(future);
        }

        Result maxResult = null;
        for (CompletableFuture<Result> future : futures) {
            Result result = future.get();
            if (maxResult == null || result.numDivisors > maxResult.numDivisors) {
                maxResult = result;
            }
        }

        System.out.println("Number with the most divisors: " + maxResult.number);
        System.out.println("Number of divisors: " + maxResult.numDivisors);

        executorService.shutdown();
    }

    private static Result findNumberWithMaxDivisors(int start, int end) {
        int maxDivisors = 0;
        int numberWithMaxDivisors = -1;
        for (int i = start; i <= end; i++) {
            int numDivisors = getNumDivisors(i);
            if (numDivisors > maxDivisors) {
                maxDivisors = numDivisors;
                numberWithMaxDivisors = i;
            }
        }
        return new Result(numberWithMaxDivisors, maxDivisors);
    }

    //counting divisor
    private static int getNumDivisors(int num) {
        int numDivisors = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                numDivisors++;
            }
        }
        return numDivisors;
    }

    private static class Result {
        private final int number;
        private final int numDivisors;

        public Result(int number, int numDivisors) {
            this.number = number;
            this.numDivisors = numDivisors;
        }
    }
}
