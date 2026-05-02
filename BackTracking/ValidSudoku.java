
public class ValidSudoku {

    /*
     * A valid Sudoku configuration requires that 
     * each row, column, 
     * and 3x3 sub-matrix 
     * must contain the digits 1-9 without repetition.
     */

    static boolean isValid(int[][] matrix){

        // Arrays to track seen numbers in rows,
        // columns, and sub-matrix
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] subMat = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                // Skip empty cells
                if (matrix[i][j] == 0)
                    continue;

                int val = matrix[i][j];
                int pos = 1 << (val - 1);

                // Check for duplicates in the current row
                if ((rows[i] & pos) > 0)
                    return false;
                rows[i] |= pos;

                // Check for duplicates
                // in the current column
                if ((cols[j] & pos) > 0)
                    return false;
                cols[j] |= pos;

                // Calculate the index for the 3x3
                // sub-matrix
                int idx = (i / 3) * 3 + j / 3;

                // Check for duplicates in the current
                // sub-matrix
                if ((subMat[idx] & pos) > 0)
                    return false;
                subMat[idx] |= pos;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        int[][] mat = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                        { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                        { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                        { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                        { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                        { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                        { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                        { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                        { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };

        System.out.println(isValid(mat) ? "true" : "false");
    }
}