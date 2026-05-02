import java.util.ArrayList;
import java.util.List;

public class PrintMatrixInSpiralForm {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        List<Integer> spiralOrder = getSpiralOrder(matrix);
        printResult(spiralOrder);
    }

    // Main method to get spiral order
    public static List<Integer> getSpiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Traverse Right to left
            traverseTopRow(matrix, result, top, left, right);
            top++;

           // Traverse top to bottom
            traverseRightColumn(matrix, result, top, bottom, right);
            right--;

            // Traverse Left to Right
            if (top <= bottom) {
                traverseBottomRow(matrix, result, bottom, right, left);
                bottom--;
            }

            // Traverse bottom to Top
            if (left <= right) {
                traverseLeftColumn(matrix, result, bottom, top, left);
                left++;
            }
        }

        return result;
    }

    private static void traverseTopRow(int[][] matrix, List<Integer> result, int row, int startCol, int endCol) {
        for (int col = startCol; col <= endCol; col++) {
            result.add(matrix[row][col]);
        }
    }

    private static void traverseRightColumn(int[][] matrix, List<Integer> result, int startRow, int endRow, int col) {
        for (int row = startRow; row <= endRow; row++) {
            result.add(matrix[row][col]);
        }
    }

    private static void traverseBottomRow(int[][] matrix, List<Integer> result, int row, int startCol, int endCol) {
        for (int col = startCol; col >= endCol; col--) {
            result.add(matrix[row][col]);
        }
    }

    private static void traverseLeftColumn(int[][] matrix, List<Integer> result, int startRow, int endRow, int col) {
        for (int row = startRow; row >= endRow; row--) {
            result.add(matrix[row][col]);
        }
    }

    private static void printResult(List<Integer> result) {
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
