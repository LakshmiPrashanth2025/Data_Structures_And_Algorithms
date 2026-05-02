import java.util.*;

class Zero_01KnapsackSolver_ByRecursionAndMemoization {

    // Returns the maximum value that can be put in a knapsack of given capacity
    static int computeMaxValue(int knapsackCapacity, int[] itemValues, int[] itemWeights, int itemCount, int[][] memo) {

        // Base Case: No items left or no remaining capacity
        if (itemCount == 0 || knapsackCapacity == 0)
        {
            return 0;
        }

        // Return previously computed subproblem result if available
        if (memo[itemCount][knapsackCapacity] != -1)
        {
            return memo[itemCount][knapsackCapacity];
        }

        int includeItem = 0;

        // 1. Include the current item if its weight does not exceed remaining capacity
        if (itemWeights[itemCount - 1] <= knapsackCapacity)
        {
            includeItem = itemValues[itemCount - 1] + 
                        computeMaxValue(
                            knapsackCapacity - itemWeights[itemCount - 1],
                            itemValues, itemWeights, itemCount - 1, memo
                        );
        }

        // 2. Exclude the item
        int excludeItem = computeMaxValue(
            knapsackCapacity,
            itemValues, itemWeights, itemCount - 1, memo
        );

        // 3. Store the result and return the maximum of the two choices (include, exclude)
        return memo[itemCount][knapsackCapacity] = Math.max(includeItem, excludeItem);
    }

    // First fill memoization table with -1 in 2D matrix
    static int getMaxKnapsackValue(int knapsackCapacity, int[] itemValues, int[] itemWeights) {
        int itemCount = itemValues.length;

        // Create memoization table and initialize with -1
        int[][] memo = new int[itemCount + 1][knapsackCapacity + 1];
        for (int i = 0; i <= itemCount; i++) 
        {
            for (int j = 0; j <= knapsackCapacity; j++)
                memo[i][j] = -1;
        }

        return computeMaxValue(knapsackCapacity, itemValues, itemWeights, itemCount, memo);
    }

    public static void main(String[] args) {
        int[] itemValues = { 1, 2, 3 };
        int[] itemWeights = { 4, 5, 1 };
        int knapsackCapacity = 4;

        System.out.println(getMaxKnapsackValue(knapsackCapacity, itemValues, itemWeights));
    }
}
