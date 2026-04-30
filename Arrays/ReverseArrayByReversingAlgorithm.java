
/*
* Uses O(2N) Time complexity 
* as it is O(N) to reverse and again O(N) 
* for dividing into 2 groups by splitting D elements  into a group 
* And Reverse the first k elements
* And reversing the II group  - Reverse the remaining elements
* Example: If Array is {1, 2, 3, 4, 5, 6, 7 } - Rotate by 3 positions
 *  Reverse 1, 2, 3,  &  then 4, 5, 6, 7
 *  3, 2, 1, 7, 6, 5, 4
 *  Now reverse entire array
 *  4, 5 ,6 ,7 ,1 ,2 ,3
 */

public class ReverseArrayByReversingAlgorithm {

    // Function to reverse a portion of the array
    static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Function to rotate the array by k positions to the left
    static void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle cases where k > n

        // Reverse the first k elements
        reverseArray(arr, 0, k - 1);

        // Reverse the remaining n-k elements
        reverseArray(arr, k, n - 1);

        // Reverse the entire array
        reverseArray(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;

        rotateLeft(arr, k);

        System.out.println("Array after rotating " + k + " positions to the left:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    
}
