import java.util.*;

/**
 * RatInMaze: Finds all paths for a rat to travel from the top-left corner (0, 0)
 * to the bottom-right corner (n-1, n-1) in a square maze using recursion and backtracking.
 *
 * Problem:
 * - The maze is a square grid (n x n) filled with 0s and 1s.
 * - A value of 1 means the cell is open and the rat can move through it.
 * - A value of 0 means the cell is blocked and cannot be used.
 * - The rat can move in four directions: Up ('U'), Down ('D'), Left ('L'), and Right ('R').
 * - The goal is to find all possible paths from the start (0, 0) to the destination (n-1, n-1)
 *   without visiting the same cell twice in one path.
 *
 *  Solution Steps:
 * 1. Start at (0, 0). If it's blocked, return no paths.
 * 2. Use recursion to explore all four possible directions.
 * 3. For each direction, check if the move is valid (inside bounds, open cell, not visited).
 * 4. If valid, mark the cell as visited and recursively explore the next cell.
 * 5. If (n-1, n-1) is reached, add the current path to the result.
 * 6. Backtrack by unmarking cells as visited to allow other paths.
 * 7. Return all found paths.
 * 
 * Detailed Steps to Solve:
 * 1. Start from the top-left cell (0, 0).
 * 2. Check if the cell is open (value = 1). If not, there is no path, return empty list.
 * 3. Use a helper function (backtracking approach) to explore each possible direction:
 *    - Move Down, Left, Right, or Up (in that order).
 * 4. For each move:
 *    - Make sure the new cell is inside the maze.
 *    - Check that it's not blocked (value = 1).
 *    - Make sure the cell hasn’t been visited in the current path.
 * 5. If the move is valid:
 *    - Mark the cell as visited.
 *    - Add the direction letter to the current path.
 *    - Recursively continue from the new cell.
 *    - After exploring, unmark the current cell to allow it to be used in other paths (backtracking).
 * 6. If the destination (n-1, n-1) is reached, add the complete path string to the result list.
 * 7. After all possibilities are explored, return the list of all valid paths.
 *
 * Notes:
 * - This approach uses recursion and backtracking to explore all possible ways the rat can go.
 * - Each valid path is recorded as a string like "DRDDRR".
 * - The algorithm avoids cycles by tracking visited cells during each path.
 */
public class RatInMaze {

    public static List<String> findPaths(int[][] mat) {
        List<String> result = new ArrayList<>();
        int n = mat.length;
        boolean[][] visited = new boolean[n][n];

        if (mat[0][0] == 1) {
            backtrack(mat, visited, 0, 0, "", result);
        }

        return result;
    }

    private static void backtrack(int[][] mat, boolean[][] visited, int row, int col, String path, List<String> result) {
        int n = mat.length;

        // Base case: destination reached
        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }

        // Direction vectors: D, L, R, U
        int[] rowDir = {1, 0, 0, -1};
        int[] colDir = {0, -1, 1, 0};
        char[] moveChar = {'D', 'L', 'R', 'U'};

        for (int i = 0; i < 4; i++) {
            int nextRow = rowDir[i] + row;
            int nextCol = colDir[i] + col;

            if (isSafe(mat, visited, nextRow, nextCol)) {
                visited[row][col] = true;
                backtrack(mat, visited, nextRow, nextCol, path + moveChar[i], result);
                visited[row][col] = false;  // Backtrack
            }
        }
    }

    private static boolean isSafe(int[][] mat, boolean[][] visited, int row, int col) {
        int n = mat.length;
        return (row >= 0 && col >= 0 && row < n && col < n && mat[row][col] == 1 && !visited[row][col]);
    }

    // Driver code to test
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        List<String> paths = findPaths(maze);

        if (paths.isEmpty()) {
            System.out.println("No path found.");
        } else {
            System.out.println("D: DOWN, U: UP, L : LEFT, R: RIGHT");
            
            System.out.println("Paths from (0,0) to (n-1,n-1):");
            for (String path : paths) {
                System.out.println(path);
            }
        }
    }
}
