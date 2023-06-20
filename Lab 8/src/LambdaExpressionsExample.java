@FunctionalInterface
interface MathOperation {
    int operation(int a, int b);
}

public class LambdaExpressionsExample {
    public static void main(String[] args) {
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> a / b;
        
        // Testing the lambda expressions
        int result = addition.operation(6, 3);
        System.out.println("Addition result: " + result);
        
        result = subtraction.operation(6, 3);
        System.out.println("Subtraction result: " + result);
        
        result = multiplication.operation(6, 3);
        System.out.println("Multiplication result: " + result);
        
        result = division.operation(6, 3);
        System.out.println("Division result: " + result);
    }
}
