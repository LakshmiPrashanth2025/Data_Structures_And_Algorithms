public class SmallestSubarrayWithSumGreaterThanX {

    // Returns the length of the smallest subarray 
    // with sum greater than or equal to x
    static int smallestSubArrayWithSumX(int x, int[] arr) {

        int i = 0, j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        while (j < arr.length) {

            // Expand window until sum > x 
            // or end of array reached
            while (j < arr.length && sum <= x) {
                sum += arr[j++];
            }

            // If we reached end of array and sum 
            // still <= x, no valid subarray exists
            if (j == arr.length && sum <= x) break;

            // Minimize window from start 
            // while maintaining sum > x
            while (i < j && sum - arr[i] > x) {
                sum -= arr[i++];
            }

            ans = Math.min(ans, j - i);

            // Remove current start 
            // element and shift window
            sum -= arr[i];
            i++;
        }

        // Return 0 if no valid subarray
        // found, else return min length
        if (ans == Integer.MAX_VALUE) return 0;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 19};
        int x = 51;

        System.out.println("The minimum elements in subArray with sum:" + x + " is" +
            smallestSubArrayWithSumX(x, arr));
    }
}