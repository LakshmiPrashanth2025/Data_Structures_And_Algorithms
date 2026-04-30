public class SumOfQueriesII {
  

        public static long sumOfQueries(int[] arr, int[] queries) {
            int n = arr.length;
            int q = queries.length / 2;
            
            // Step 1: Create prefix sum array
            long[] prefixSum = new long[n + 1];
            for (int i = 0; i < n; i++) {
                prefixSum[i + 1] = prefixSum[i] + arr[i];
            }
    
            // Step 2: Compute the sum of all queries
            long totalSum = 0;
            for (int i = 0; i < queries.length; i += 2) {
                int l = queries[i];
                int r = queries[i + 1];
                totalSum += prefixSum[r + 1] - prefixSum[l];
            }
    
            return totalSum;
        }
    
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};

            // 2 queries: sum(1 to 3) + sum(0 to 2) = (2+3+4) + (1+2+3) = 9 + 6 = 15    
            int[] queries = {1, 3, 0, 2};  
            
            long result = sumOfQueries(arr, queries);
            System.out.println("Total Sum of Queries: " + result);
        }
   
    

}
