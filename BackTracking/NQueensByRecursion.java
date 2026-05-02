import java.util.*;

public class NQueensByRecursion {

    public List<List<String>> solveNQueens(int n) {
        Board board = new Board(n);
        List<List<String>> results = new ArrayList<>();
        backtrack(0, board, results);
        return results;
    }

    private void backtrack(int row, Board board, List<List<String>> results) {
        if (row == board.size()) {
            results.add(board.toStringList());
            return;
        }

        for (int col = 0; col < board.size(); col++) {
            if (board.isSafe(row, col)) {
                board.placeQueen(row, col);
                backtrack(row + 1, board, results);
                board.removeQueen(row, col);
            }
        }
    }

    public static void main(String[] args) {
        NQueensByRecursion solver = new NQueensByRecursion();
        int n = 4; // You can change this value to test with different board sizes
        List<List<String>> solutions = solver.solveNQueens(n);

        System.out.println("Total solutions for N = " + n + ": " + solutions.size());
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}

class Board {
    private final char[][] board;
    private final int n;

    public Board(int n) {
        this.n = n;
        board = new char[n][n];
        for (char[] row : board){
            Arrays.fill(row, '.');
        } 
    }

    public int size() {
        return n;
    }

    public void placeQueen(int row, int col) {
        board[row][col] = 'Q';
    }

    public void removeQueen(int row, int col) {
        board[row][col] = '.';
    }

    public boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q') return false;
        return true;
    }

    public List<String> toStringList() {
        List<String> result = new ArrayList<>();
        for (char[] row : board)
            result.add(new String(row));
        return result;
    }
}
