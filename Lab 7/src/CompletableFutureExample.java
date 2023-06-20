import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) {
        // Creating a CompletableFuture and defining an asynchronous task
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // Simulating a long-running task
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        });

        // Chaining dependent action
        CompletableFuture<String> result = future.thenApplyAsync(number -> "Result: " + number);

        // Handling the result
        result.thenAcceptAsync(System.out::println);

        // Waiting for completion
        try {
            result.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
