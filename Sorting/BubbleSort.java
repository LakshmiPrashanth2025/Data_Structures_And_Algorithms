/*
*  O(n²) – because it uses two nested loops.
*  However, in a special case, Bubble Sort can be O(n)
*/
public class BubbleSort {
    
        // Bubble Sort method
        public static void bubbleSort(int[] arr) {
            int n = arr.length;
            boolean swapped;
            
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                
                for (int j = 0; j < n - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // Swap arr[j] and arr[j + 1]
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                    }
                }
    
                // Optimization: If no elements were swapped, the array is sorted
                if (!swapped) break;
            }
        }
    
        // Main method to test the bubbleSort
        public static void main(String[] args) {
            int[] arr = {5, 1, 4, 2, 8};
    
            System.out.println("Original Array:");
            printArray(arr);
    
            bubbleSort(arr);
    
            System.out.println("Sorted Array:");
            printArray(arr);
        }
    
        // Utility method to print an array
        public static void printArray(int[] arr) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    
    
    
}
