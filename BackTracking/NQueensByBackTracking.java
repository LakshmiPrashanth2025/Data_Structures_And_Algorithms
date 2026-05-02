import java.util.*;

public class NQueensByBackTracking {

    public static void main(String[] args) {
        int n = 8;
        NQueensByBackTracking solver = new NQueensByBackTracking();
        List<List<String>> solutions = solver.solveNQueens(n);
        
        System.out.println("Total Solutions: " + solutions.size());
        printSolutions(solutions);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        Board board = new Board(n);
        solve(0, board, solutions);
        return solutions;
    }

    private void solve(int row, Board board, List<List<String>> solutions) {
        if (row == board.size()) {
            solutions.add(board.toList());
            return;
        }

        for (int col = 0; col < board.size(); col++) {
            if (board.isSafe(row, col)) {
                board.placeQueen(row, col);
                solve(row + 1, board, solutions);
                board.removeQueen(row, col); // Backtrack
            }
        }
    }

    private static void printSolutions(List<List<String>> solutions) {
        for (List<String> board : solutions) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println(); // Separate each solution
        }
    }
}

class Board {

    private final int n;
    private final int[] queens;          // queens[row] = col
    private final boolean[] cols;
    private final boolean[] diag1;
    private final boolean[] diag2;

    public Board(int n) {
        this.n = n;
        this.queens = new int[n];
        this.cols = new boolean[n];
        this.diag1 = new boolean[2 * n - 1]; // row - col + n - 1
        this.diag2 = new boolean[2 * n - 1]; // row + col
    }

    public int size() {
        return n;
    }

    public boolean isSafe(int row, int col) {
        return !cols[col] && !diag1[row - col + n - 1] && !diag2[row + col];
    }

    public void placeQueen(int row, int col) {
        queens[row] = col;
        cols[col] = true;
        diag1[row - col + n - 1] = true;
        diag2[row + col] = true;
    }

    public void removeQueen(int row, int col) {
        cols[col] = false;
        diag1[row - col + n - 1] = false;
        diag2[row + col] = false;
    }

    public List<String> toList() {
        List<String> board = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            char[] line = new char[n];
            Arrays.fill(line, '.');
            line[queens[row]] = 'Q';
            board.add(new String(line));
        }
        return board;
    }
}
