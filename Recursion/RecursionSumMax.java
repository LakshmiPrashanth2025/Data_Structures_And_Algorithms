public class RecursionSumMax {

    // Recursive method to calculate sum
    public static int getSum(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        return arr[index] + getSum(arr, index + 1);
    }

    // Recursive method to find max
    public static int getMax(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }
        return Math.max(arr[index], getMax(arr, index + 1));
    }

    public static void main(String[] args) {
        int[] numbers = {4, 8, 2, 10, 3};

        int sum = getSum(numbers, 0);
        int max = getMax(numbers, 0);

        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);
    }
}
