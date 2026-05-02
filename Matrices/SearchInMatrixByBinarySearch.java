
// Java program to search an element in row-wise
// and column-wise sorted matrix

public class SearchInMatrixByBinarySearch {
    public static boolean binarySearch(int[] mat, int target) {
        int low = 0, high = mat.length - 1;

        // Standard binary search algorithm
        while (low <= high) {
            int mid = (low + high) / 2;

            if (mat[mid] == target) 
                return true;  // Element found
            else if (target > mat[mid]) 
                low = mid + 1; // Search in the right half
            else 
                high = mid - 1; // Search in the left half
        }
        return false;  // Element not found
    }
    
    static boolean matSearch(int[][] mat, int x) {
        int n = mat.length; // Number of rows

        // Iterate over each row and perform binary search
        for (int i = 0; i < n; i++) {
            if (binarySearch(mat[i], x)) 
                return true;  // Element found in one of the rows
        }
        return false;  // Element not found in any row
    }

    public static void main(String[] args) {
        int[][] mat = {{3, 30, 38},
                       {20, 52, 54},
					   {35, 60, 69}};
        int x = 35;
        
        if(matSearch(mat, x)) 
            System.out.println("true");
        else 
            System.out.println("false");
    }
}