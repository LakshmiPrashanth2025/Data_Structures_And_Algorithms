public class FibonacciByDP {
    // Add Previous 2 Numbers 
  
    // Function to calculate the nth Fibonacci number
    // using space optimization
    static int nthFibonacci(int n) {
        if (n <= 1) return n;

        // To store the curr Fibonacci number
        int curr = 0;

        // To store the previous Fibonacci numbers
        int prev1 = 1;
        int prev2 = 0;

        // Loop to calculate Fibonacci numbers from 2 to n
        for (int i = 2; i <= n; i++) {
          
            // Calculate the curr Fibonacci number
            curr = prev1 + prev2;

            // Update prev2 to the last Fibonacci number
            prev2 = prev1;

            // Update prev1 to the curr Fibonacci number
            prev1 = curr;
        }

        return curr;
    }

    public static void main(String[] args) {
        int n = 5;
        int result = nthFibonacci(n);
        System.out.println(result);
    }

    
}
