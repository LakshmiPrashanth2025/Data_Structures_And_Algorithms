// Class for finding first and last occurrence of x in sorted array

import java.util.ArrayList;

public class FindFirstAndLastOccurence {


    // Function for finding last occurrence of x
    static int findLastPositionOfIntegerInArray(int[] arr, int x) {
        int n = arr.length;
        
        // Initialize low and high index
        // to find the last occurrence
        int low = 0, high = n - 1;
        
        // Initialize last occurrence
        int lastPosition = -1;
        
        // Find last occurrence of x
        while(low <= high) {
            
            // Find the mid index
            int mid = (low + high) / 2;
            
            // If x is equal to arr[mid]
            if(x == arr[mid]) {
                lastPosition = mid;
                low = mid + 1;
            }
            
            // If x is less than arr[mid], 
            // then search in the left subarray
            else if(x < arr[mid])
                high = mid - 1;
            
            // If x is greater than arr[mid], 
            // then search in the right subarray
            else
                low = mid + 1;
        }
        
        return lastPosition;
    }
    
    // Function for finding first occurrence of x
    static int findFirstPositionOfIntegerInArray(int[] arr, int x) {
        int n = arr.length;
        
        // Initialize low and high index
        // to find the first occurrence
        int low = 0, high = n - 1;
        
        // Initialize first occurrence
        int firstPositionOfChar = -1;
        
        // Find first occurrence of x
        while(low <= high) {
            
            // Find the mid index
            int mid = (low + high) / 2;
            
            // If x is equal to arr[mid]
            if(x == arr[mid]) {
                firstPositionOfChar = mid;
                high = mid - 1;
            }
            
            // If x is less than arr[mid], 
            // then search in the left subarray
            else if(x < arr[mid])
                high = mid - 1;
            
            // If x is greater than arr[mid], 
            // then search in the right subarray
            else
                low = mid + 1;
        }
        
        return firstPositionOfChar;
    }
    
    // Function for finding first and last occurrence of x
    static ArrayList<Integer> find(int[] arr, int x) {
        int n = arr.length;
        
        // Find first and last index
        int first = findFirstPositionOfIntegerInArray(arr, x);
        int last = findLastPositionOfIntegerInArray(arr, x);
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(first);
        res.add(last);
        return res;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int x = 5;
        ArrayList<Integer> res = find(arr, x);
        System.out.println(res.get(0) + " " + res.get(1));
    }
}