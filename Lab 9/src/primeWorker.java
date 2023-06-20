import java.util.stream.IntStream;

public class primeWorker {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 50)
                .parallel()
                .filter(primeWorker::isPrime)
                .forEach(num -> System.out.println("Thread: " + Thread.currentThread().getName() + " processed " + num));

        long primeCount = IntStream.rangeClosed(1, 50)
                .parallel()
                .filter(primeWorker::isPrime)
                .count();

        System.out.println("Total prime numbers: " + primeCount);
    }

    public static boolean isPrime(int number) {
        if (number <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }

        return true;
    }
}
