import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer num : list) {
            if (predicate.test(num)) {
                System.out.println(num);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("All :");
        evaluate(numbers, num -> true);

        System.out.println("Odd elements :");
        evaluate(numbers, num -> num % 2 != 0);

        System.out.println("Even elements :");
        evaluate(numbers, num -> num % 2 == 0);

        System.out.println("Greater than 5:");
        evaluate(numbers, num -> num > 5);
    }
}
