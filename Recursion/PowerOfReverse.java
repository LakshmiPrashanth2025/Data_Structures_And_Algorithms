public class PowerOfReverse {

    // Method to reverse the digits of a number
    public static int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    // Main logic to compute n^reverse(n)
    public static double powerOfReverse(int n) {
        int reversed = reverse(n);
        return Math.pow(n, reversed);
    }

    public static void main(String[] args) {
        int n = 12; // example input
        double result = powerOfReverse(n);
        System.out.println(n + "^" + reverse(n) + " = " + result);
    }
}

