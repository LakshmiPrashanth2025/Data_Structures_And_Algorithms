// Java program to implement
// unbounded knapsack problem using space optimised

public class UnboundedKnapsack_SpaceOptimizedDP {

    static int knapSack(int capacity, int[] val, int[] wt) {

        // 1D matrix for tabulation.
        int[] dp = new int[capacity + 1];

        // Calculate maximum profit for each
        // item index and knapsack weight.
        for (int i = val.length - 1; i >= 0; i--) 
        {
            for (int j = 1; j <= capacity; j++) 
            {

                int take = 0;
                if (j - wt[i] >= 0) {
                    take = val[i] + dp[j - wt[i]];
                }
                int noTake = dp[j];

                dp[j] = Math.max(take, noTake);
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
      
        int[] val = { 1, 1 };
        int[] wt = { 2, 1 };
        int capacity = 3;
        System.out.println(knapSack(capacity, val, wt));
    }
}