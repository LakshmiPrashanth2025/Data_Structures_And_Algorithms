public class PrintToN {

    public static void printNumbers(int n) {
        if (n == 0) {
            return;
        }
        printNumbers(n - 1); // recursive call
        System.out.print(n + " "); // print after recursive call to maintain 1 to n order
    }

    public static void main(String[] args) {
        int n = 10;
        printNumbers(n); // Output: 1 2 3 4 5 6 7 8 9 10
    }
}