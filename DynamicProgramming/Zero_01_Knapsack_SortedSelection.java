import java.util.*;

public class Zero_01_Knapsack_SortedSelection {

    static class Item {
        int value, weight;
        double ratio;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }
    }

    // Function to compute max profit with sorted items
    static int knapsack(int totalAllowedKnapsackWeight, int[] values, int[] weights) {
        int numberOfItems = values.length;

        // Step 1: Build and sort items by value-to-weight ratio
        Item[] items = new Item[numberOfItems];
        for (int i = 0; i < numberOfItems; i++) {
            items[i] = new Item(values[i], weights[i]);
        }

        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio)); // Descending order

        // Step 2: Standard 0/1 Knapsack using two rows (previousRow, currentRow)
        int[] previousRow = new int[totalAllowedKnapsackWeight + 1];
        int[] currentRow = new int[totalAllowedKnapsackWeight + 1];

        for (int i = 1; i <= numberOfItems; i++) {
            int currentItemValue = items[i - 1].value;
            int currentItemWeight = items[i - 1].weight;

            for (int weightLimit = 0; weightLimit <= totalAllowedKnapsackWeight; weightLimit++) {
                if (currentItemWeight <= weightLimit) 
                {
                    currentRow[weightLimit] = Math.max(
                                previousRow[weightLimit],
                                previousRow[weightLimit - currentItemWeight] + currentItemValue
                            );
                } 
                else 
                {
                    currentRow[weightLimit] = previousRow[weightLimit];
                }
            }

            // Prepare for next iteration
            previousRow = Arrays.copyOf(currentRow, currentRow.length);
        }

        return previousRow[totalAllowedKnapsackWeight];
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        int[] weights = {4, 5, 1};

        int totalAllowedKnapsackWeight = 4;

        int maxProfit = knapsack(totalAllowedKnapsackWeight, values, weights);
        System.out.println("Maximum Profit: " + maxProfit);  // Output: 3
    }
}
