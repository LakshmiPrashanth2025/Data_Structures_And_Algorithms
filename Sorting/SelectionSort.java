/*
 * Time complexity: Best / Average / Worst: O(n²)
 * 1.   Start with an array of size n.
 * 2.   Repeat steps 3–6 for i from 0 to n-2: (Each iteration places the correct element at position i)
 * 3.   Set minIndex = i (assume the current position holds the smallest element)
 * 4.   For each j from i+1 to n-1:
 *           If array[j] < array[minIndex],
 *              update minIndex = j
 * 5.  After inner loop ends: 
 *          If minIndex ≠ i:
 *              swap array[i] and array[minIndex]
 * 6.  Continue to the next position (i = i + 1)
 * 7.  End when all elements have been placed in sorted order.
 */

public class SelectionSort {

    // Method to perform selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Outer loop: One by one move the boundary of the unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Assume the minimum is the first element
            int minIndex = i;

            // Inner loop: Find the minimum element in the remaining unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;  // Update index of the new minimum
                }
            }

            // Swap the found minimum with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Method to print array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] data = {29, 10, 14, 37, 13};

        System.out.println("Original array:");
        printArray(data);

        selectionSort(data);

        System.out.println("Sorted array:");
        printArray(data);
    }
}
