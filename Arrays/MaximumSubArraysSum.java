// Java Program for Maximum Subarray Sum using Kadane's Algorithm
/*
 * Given an array arr[], the task is to find the subarray 
 * that has the maximum sum and return its sum.

* Examples:
* Input: arr[] = {2, 3, -8, 7, -1, 2, 3}
* Output: 11
* Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.
 */

public class MaximumSubArraysSum {
    
    // Function to find the maximum subarray sum
    static int maxSubarraySum(int[] arr) {
        int res = arr[0];
        int maxEnding = arr[0];

        for (int i = 1; i < arr.length; i++) {
            
            // Find the maximum sum ending at index i by either extending 
            // the maximum sum subarray ending at index i - 1 or by
            // starting a new subarray from index i
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
          
            // Update res if maximum subarray sum ending at index i > res
            res = Math.max(res, maxEnding);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySum(arr));

        int[] arr2 = {-2, -4};
        System.out.println(maxSubarraySum(arr2));

        int[] arr3 = {5, 4, 1, 7, 8};
        System.out.println(maxSubarraySum(arr3));
    }
}
