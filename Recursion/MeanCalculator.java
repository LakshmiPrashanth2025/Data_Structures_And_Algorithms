public class MeanCalculator {

    // Recursive function to calculate sum of array
    public static int recursiveSum(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }
        return recursiveSum(arr, n - 1) + arr[n - 1];
    }

    // Function to calculate mean
    public static double recursiveMean(int[] arr) {
        int sum = recursiveSum(arr, arr.length);
        return (double) sum / arr.length;
    }
    

    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 10};
        System.out.println("Mean: " + recursiveMean(array));
    }
}