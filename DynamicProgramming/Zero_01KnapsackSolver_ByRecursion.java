class Zero_01KnapsackSolver_ByRecursion {

    // Recursive function to find the maximum value that can be put in the knapsack
    static int getMaxKnapsackValue(int knapsackCapacity, int[] values, int[] weights, int itemCount) {

        // Base Case: No items left or no remaining capacity
        if (itemCount == 0 || knapsackCapacity == 0)
        {
            return 0;
        }

        // If the current item's weight exceeds knapsack capacity, we cannot take it
        if (weights[itemCount - 1] > knapsackCapacity) {
            return getMaxKnapsackValue(knapsackCapacity, values, weights, itemCount - 1);
        }

        // Store the current item's value & Calculate remaining capacity if we take the current item
        int currentItemValue = values[itemCount - 1];
        int remainingCapacity = knapsackCapacity - weights[itemCount - 1];

        // Option 1: Take the current item
        int takeCurrentValue = currentItemValue + 
            getMaxKnapsackValue(remainingCapacity, values, weights, itemCount - 1);

        // Option 2: Don't take the current item
        int notTakeCurrentValue = getMaxKnapsackValue(knapsackCapacity, values, weights, itemCount - 1);

        // Return the maximum value from the two options
        return Math.max(takeCurrentValue, notTakeCurrentValue);
    }

    static int solveKnapsack(int knapsackCapacity, int[] values, int[] weights) {
        int numberOfItems = values.length;
        return getMaxKnapsackValue(knapsackCapacity, values, weights, numberOfItems);
    }

    public static void main(String[] args) {
        int[] itemValues = {1, 2, 3};
        int[] itemWeights = {4, 5, 1};
        int knapsackCapacity = 4;

        //If we select the item with weight 4, the possible profit is 1. 
        //And if we select the item with weight 1, the possible profit is 3. 
        //So the maximum possible profit is 3
        System.out.println("The possible value of the profit:" + 
                solveKnapsack(knapsackCapacity, itemValues, itemWeights));
    }
}
