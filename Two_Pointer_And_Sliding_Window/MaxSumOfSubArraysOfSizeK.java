import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumOfSubArraysOfSizeK {

    public static int countSubarrays(int[] arr, int n, int k) {
        int count = 0;
        if (arr == null || arr.length < n || n <= 0) {
            return count;
        }

        double currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
        }
        if (currentSum / n == k) {
            count++;
        }

        for (int i = n; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - n];
            if (currentSum / n == k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 3, 4, 1};         // Expected output: 2
        int[] arr2 = {5, 5, 5, 5, 5};         // Expected output: 3
        int[] arr3 = {1, 2, 3, 4, 5, 6};      // Expected output: 1
        int[] arr4 = {0, 0, 0, 0};            // Expected output: 2
        int[] arr5 = {1, -1, 1, -1, 1, -1};   // Expected output: 4

        System.out.println("Test 1: " + countSubarrays(arr1, 2, 2)); // [2,1], [1,3]
        System.out.println("Test 2: " + countSubarrays(arr2, 3, 5)); // [5,5,5], 3 times
        System.out.println("Test 3: " + countSubarrays(arr3, 3, 4)); // [3,4,5]
        System.out.println("Test 4: " + countSubarrays(arr4, 2, 0)); // multiple 0-sum subarrays
        System.out.println("Test 5: " + countSubarrays(arr5, 2, 0)); // alternating +1 and -1
    }
}