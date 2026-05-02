import java.util.Arrays;
import java.util.Comparator;

// Sort weight

// Class to store value and weight of an item
class Item {
    int value, weight;

    // Constructor
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapSack_ByGreedy {

    // Comparator to sort items based on value/weight ratio in descending order
    static class ItemComparator implements Comparator<Item> {
        public int compare(Item a, Item b) {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1); // Reverse order for descending
        }
    }

    // Main greedy function to solve the problem
    public static double fractionalKnapsack(int W, Item[] arr) {

        // Sorting items based on value/weight ratio
        Arrays.sort(arr, new ItemComparator());

        double finalValue = 0.0; // Final result

        // Looping through all items
        for (Item item : arr) {

            // If adding the whole item won't overflow, add it completely
            if (item.weight <= W) {
                W -= item.weight;
                finalValue += item.value;
            }
            // If we can't add the current item, add the fractional part
            else {
                finalValue += item.value * ((double) W / item.weight);
                break;
            }
        }

        return finalValue;  // Returning the final value
    }

    public static void main(String[] args) {
        int W = 50;  // Weight of knapsack
        Item[] arr = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };

        // Function call
        double maxVal = fractionalKnapsack(W, arr);
        System.out.println("Maximum value we can obtain = " + maxVal);
    }
}
