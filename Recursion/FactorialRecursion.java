public class FactorialRecursion {

    // Recursive method to calculate factorial
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // base case
        }
        return n * factorial(n - 1); // recursive call
    }

    public static void main(String[] args) {
        int number = 5; // You can change this to any number
        long result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }
}
