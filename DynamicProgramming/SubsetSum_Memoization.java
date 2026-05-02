import java.util.Arrays;

public class SubsetSum_Memoization {

    // Recursive helper to determine if a subset with the given target sum exists
    static boolean hasSubsetWithSum(int[] numbers, int numElements, int targetSum, int[][] memo) {
        
        // Base case: subset with sum 0 is always possible (empty subset)
        if (targetSum == 0) {
            return true;
        }

        // Base case: no elements left to process
        if (numElements <= 0) {
            return false;
        }

        // If the result is already computed, return it
        if (memo[numElements][targetSum] != -1) {
            return memo[numElements][targetSum] == 1;
        }

        // If the current element is greater than the remaining sum, skip it
        if (numbers[numElements - 1] > targetSum) {
            memo[numElements][targetSum] = hasSubsetWithSum(numbers, numElements - 1, targetSum, memo) ? 1 : 0;
        } else {
            // Try including and excluding the current element
            boolean include = hasSubsetWithSum(numbers, numElements - 1, targetSum - numbers[numElements - 1], memo);
            boolean exclude = hasSubsetWithSum(numbers, numElements - 1, targetSum, memo);
            memo[numElements][targetSum] = (include || exclude) ? 1 : 0;
        }

        return memo[numElements][targetSum] == 1;
    }

    // Main function to check if any subset sums to the target value
    static boolean isSubsetSum(int[] numbers, int targetSum) {
        int numElements = numbers.length;
        int[][] memo = new int[numElements + 1][targetSum + 1];

        // Initialize memoization table with -1 (uncomputed)
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return hasSubsetWithSum(numbers, numElements, targetSum, memo);
    }

    public static void main(String[] args) {
        int[] inputArray = { 1, 5, 3, 7, 4 };
        int targetSum = 12;

        if (isSubsetSum(inputArray, targetSum)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
