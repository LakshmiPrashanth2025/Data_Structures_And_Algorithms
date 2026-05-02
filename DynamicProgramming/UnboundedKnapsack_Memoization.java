// Java program to implement
// unbounded knapsack problem using memoization.

import java.util.Arrays;

public class UnboundedKnapsack_Memoization {

    static int knapSackRecur(int i, int capacity, int[] val,
                             int[] wt, int[][] memo) {
        if (i == val.length)
            return 0;

        // If value is memoized.
        if (memo[i][capacity] != -1)
            return memo[i][capacity];

        // Consider current item only if
        // its weight is less than equal
        // to maximum weight.
        int take = 0;
        if (wt[i] <= capacity) {
            take = val[i]
                   + knapSackRecur(i, capacity - wt[i], val, wt,
                                   memo);
        }

        // Skip the current item
        int noTake = knapSackRecur(i + 1, capacity, val, wt, memo);

        // store maximum of the two and return it.
        return memo[i][capacity] = Math.max(take, noTake);
    }

    static int knapSack(int capacity, int[] val, int[] wt) {

        // 2D matrix for memoization.
        int[][] memo = new int[val.length][capacity + 1];
        for (int i = 0; i < val.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        return knapSackRecur(0, capacity, val, wt, memo);
    }

    public static void main(String[] args) {
      
        int[] val = { 1, 1 };
        int[] wt = { 2, 1 };
        int capacity = 3;
        System.out.println(knapSack(capacity, val, wt));
    }
}
