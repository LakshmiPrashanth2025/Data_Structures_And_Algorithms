// Java Program for Maximum Subarray Sum using Kadane's Algorithm
/*
 *  To calculate the maximum sum of subarray ending at current element, say maxEnding, we can use the maximum sum ending at the previous element. So for any element, we have two choices:
 *    Choice 1: Extend the maximum sum subarray ending at the previous element: 
 *           If the maximum subarray sum ending at the previous index is positive, 
 *              then it is always better to extend the subarray.
 *              By adding the current element to it. 
 *    Choice 2: Start a new subarray starting from the current element: 
 *           If the maximum subarray sum ending at the previous index is negative/ less than current element, 
 *              it is always better to start a new subarray from the current element.
 */

public class MaximumSubArraysSumKadameAlgorithm {

    // Function to find the maximum subarray sum
    static int maxSubarraySum(int[] arr) {
        int res = arr[0];
        int maxEnding = arr[0];

        for (int i = 1; i < arr.length; i++) {
            
            // Find the maximum sum ending at index i by either extending 
            // the maximum sum subarray ending at index i - 1 
            // or by starting a new subarray from index i
             maxEnding = Math.max(maxEnding + arr[i], arr[i]);
          
            // Update res if maximum subarray sum ending at index i > res
            res = Math.max(res, maxEnding);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySum(arr));
    }
}