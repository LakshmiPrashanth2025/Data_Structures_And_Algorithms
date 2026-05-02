public class FibonacciRecursion {

    // Recursive method to find the nth Fibonacci number
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n; // Base case: 0 or 1
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive step
    }

    public static void main(String[] args) {
        int count = 10; // Number of Fibonacci numbers to print

        System.out.println("Fibonacci sequence up to " + count + " terms:");
        for (int i = 0; i < count; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
