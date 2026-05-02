// Java program to search an element in row-wise
// and column-wise sorted matrix

public class SearchInSortedMatrix {

    static boolean matrixSearch(int[][] matrix, int valueToSearch) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        
        int j = m - 1;

        while (i < n && j >= 0) {

            // If x > mat[i][j], then x will be greater
            // than all elements to the left of 
            // mat[i][j] in row i, so increment i
            if ( valueToSearch > matrix[i][j]) {
                i++;
            }

            // If x < mat[i][j], then x will be smaller
            // than all elements to the bottom of
            // mat[i][j] in column j, so decrement j
            else if ( valueToSearch < matrix[i][j]) {
                j--;
            }

            // If x = mat[i][j], return true
            else {
                return true;
            }
        }

        // If x was not found, return false
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {3, 30, 38},
            {20, 52, 54},
            {35, 60, 69}
        };
        int valueToSearch = 35;

        if (matrixSearch(matrix, valueToSearch))
            System.out.println("true");
        else
            System.out.println("false");
    }
}


