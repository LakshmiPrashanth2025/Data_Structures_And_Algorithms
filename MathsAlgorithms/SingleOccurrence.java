import java.util.Arrays;

public class SingleOccurrence {

    // Works only if there are 2 single occurence elements
    public static void findSingleOccurrences(int[] arr) {

        // 1. If the array is null or empty, print a message and exit.
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty or null.");
            return;
        }

        /*  2.XOR (^) every number in the array.
        *   Since x ^ x = 0 and x ^ 0 = x, all duplicate pairs will cancel each other out.
        *   The result (xorSum) will be: A ^ B, where A and B are the two unique non-repeatingA elements.
        */
        int xorSum = 0;
        for (int num : arr) {
            xorSum ^= num;
        }

        // 3. Step 3: Handle case when all elements are paired and there are no single occurence elements
        if (xorSum == 0) {
            System.out.println("No single occurrence elements found (all elements appear in pairs).");
            return;
        }

        //   4: Find the rightmost set bit in xorSum
        int tempXor = xorSum;
        int rightmostSetBit = 1;
        while ((tempXor & 1) == 0) {
            rightmostSetBit <<= 1;
            tempXor >>= 1;
        }


        /*
        *    5: Partition numbers into two groups and XOR within each group
        *   Grouping the numbers in array into the 2 groups is based on (where right most bit is set) and group 2 (where right most bit is not set)
        */
        int group1Xor = 0;
        int group2Xor = 0;

        for (int num : arr) {
            if ((num & rightmostSetBit) == 0) {
                group1Xor ^= num;
            } else {
                group2Xor ^= num;
            }
        }

        System.out.println("Single occurrence elements are: " + group1Xor + " and " + group2Xor);
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 4, 1, 3, 2, 5};
        findSingleOccurrences(arr); // Output: Single occurrence elements are: 1 and 5

        int[] arr2 = {1, 4, 2, 1, 4, 3, 5, 2};
         findSingleOccurrences(arr2); // Output: Single occurrence elements are: 3 and 5
    }
}
