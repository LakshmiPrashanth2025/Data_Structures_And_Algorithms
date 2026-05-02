public class PowerFunction {
    
    // Recursive method to calculate power
    public static double power(double base, int exponent) {
        // Base case
        if (exponent == 0) {
            return 1;
        }
        
        // If exponent is negative
        if (exponent < 0) {
            return 1 / power(base, -exponent);
        }

        // Recursive step
        return base * power(base, exponent - 1);
    }

    public static void main(String[] args) {
        System.out.println(power(2, 3));     // Output: 8.0
        System.out.println(power(5, 0));     // Output: 1.0
        System.out.println(power(2, -2));    // Output: 0.25
    }
}