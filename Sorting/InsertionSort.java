/*
Think of how you sort playing cards in your hand:
Start with one card.
Pick the next card and insert it into its correct position relative to the sorted cards on the left.
Repeat for all cards.
*/
/*
 * 1. Start with an array of size n.
 * 2. Repeat from index i = 1 to n - 1:
 *      (Because a single-element subarray at index 0 is already sorted.)
 * 3. Let key = arr[i]
 *      (Store the current element to be inserted into the sorted part.)
 * 4. Set j = i - 1
 *      (Start comparing from the last index of the sorted part.)
 * 5.  While j >= 0 and arr[j] > key:
 *          a. Move arr[j] one position to the right: arr[j + 1] = arr[j]
 *          b. Decrease j by 1
 * 6. Insert the key into its correct position: arr[j + 1] = key  * 
 * 7. Repeat steps 3–6 for the rest of the array.
 */
public class InsertionSort {

    // Insertion Sort method
    public static void insertionSort(int[] arr) {
        
        // Start from index 1 since index 0 is trivially sorted
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];  // The element we want to insert at the correct position
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];  // Shift element to the right
                j--;  // Move to the previous element
            }

            // Place the key at the correct sorted position
            arr[j + 1] = key;
        }
    }

    // Method to print an array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main method to run the example
    public static void main(String[] args) {
        int[] numbers = {9, 5, 1, 4, 3};

        System.out.println("Original array:");
        printArray(numbers);

        insertionSort(numbers);

        System.out.println("Sorted array using Insertion Sort:");
        printArray(numbers);
    }
}
