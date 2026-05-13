public class RotationCountOfArray_2 {

    
        // Function to count the number of rotations in a sorted and rotated array
        static int countRotations(int[] arr) {

            int low = 0, high = arr.length - 1;
    
            while (low <= high) {
                // If the subarray is already sorted, the smallest element is at 'low'
                if (arr[low] <= arr[high]) {
                    return low;
                }
    
                int mid = low + (high - low) / 2;
                int next = (mid + 1) % arr.length;
                int prev = (mid - 1 + arr.length) % arr.length;
    
                // Check if mid is the minimum element
                if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                    return mid;
                }
    
                // Decide which half to choose
                if (arr[mid] >= arr[low]) {
                    // Left half is sorted, go right
                    low = mid + 1;
                } else {
                    // Right half is sorted, go left
                    high = mid - 1;
                }
            }
    
            return 0; // Should never reach here if input is a valid rotated sorted array
        }
    
        public static void main(String[] args) {
            int[] arr = {15, 18, 2, 3, 6, 12};
            System.out.println("Rotation count: " + countRotations(arr)); // Output: 2
        }
   
    

}
