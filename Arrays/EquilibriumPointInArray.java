// Java program to find equilibrium index of an array
// using prefix sum and suffix sum variables
/*
 * Given an array arr[] of size n, the task is to return an equilibrium index (if any) or -1 if no equilibrium index exists. The equilibrium index of an array is an index such that the sum of all elements at lower indexes equals the sum of all elements at higher indexes.
 * Note: When the index is at the start of the array, the left sum is 0, and when it’s at the end, the right sum is 0.

 * Examples:
 * Input: arr[] = [1, 2, 0, 3]
 * Output: 2
 * Explanation: The element at index 2 is 0
 *              The sum of left of this index 2 ( i.e. 2nd element) is 1 + 2 = 3 
 *               and sum on right of index 2 is 3.
 */

public class EquilibriumPointInArray {
    static int equilibriumPoint(int[] arr) {
        int prefixSubArraySum = 0;
        int totalArraySum = 0;

        // Calculate the array sum
        for (int element : arr) {
            totalArraySum += element;
        }

        // Iterate pivot over all the elements of the array
        for (int pivot = 0; pivot < arr.length; pivot++) {
            int suffixSubArraySum = totalArraySum - prefixSubArraySum - arr[pivot];
            if (prefixSubArraySum == suffixSubArraySum) {
                return pivot;
            }

            prefixSubArraySum += arr[pivot];
        }

        // There is no equilibrium point
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};

        System.out.println(equilibriumPoint(arr));
    }
}
