
import java.util.Arrays;

public class FloorInSortedArraySolution
 {
    
        static int findFloor(int[] arr, int x) {
            int idx = Arrays.binarySearch(arr, x);
    
            // If element not found, get insertion position
            if (idx < 0) {
                idx = Math.abs(idx) - 2; // Move to the previous index
            }
    
            return (idx >= 0) ? idx : -1; // Return -1 if no floor exists
        }
    
        public static void main(String[] args) {
            int arr[] = { 1, 2, 4, 6, 10, 12, 14 };
            int x = 7;
    
            int floorindex = findFloor(arr, x);
            
            System.out.println(floorindex);
            
        }
}