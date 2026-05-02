/**
Rat in a Maze Problem - Solved using Recursion and Backtracking
Problem:
Given an n x n maze represented as a 2D array where 1 means open path and 0 means blocked,
find a path from the top-left (0,0) to the bottom-right (n-1,n-1).
Rat can move only right and down.
Pseudocode Logic (Step-by-step):

Start at cell (0, 0).

If (x, y) is the destination and maze[x][y] == 1:

 - Mark it in the solution path and return true.
Check if current cell (x, y) is a safe move (inside bounds and maze[x][y] == 1):

 a. Mark cell as part of solution path.

 b. Try moving right (x, y + 1) recursively.

 c. If moving right returns true, return true.

 d. Try moving down (x + 1, y) recursively.

 e. If moving down returns true, return true.
If neither move is valid:


 - Backtrack: unmark cell (x, y) from solution path.

 - Return false.
If all paths fail, print "No path found".

Backtracking ensures that incorrect paths are abandoned and only valid paths are retained.
*/
public class RatInAMaze {

    public static boolean solveMaze(int[][] maze) {
            int n = maze.length;
            int[][] solution = new int[n][n];
    
            if (solveMazeUtil(maze, 0, 0, solution)) {
                printSolution(solution);
                return true;
            } else {
                System.out.println("No path found");
                return false;
            }
        }
    
        private static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] solution) {
            int n = maze.length;
    
            // Base case: if (x, y) is goal and is valid
            if (x == n - 1 && y == n - 1 && maze[x][y] == 1) {
                solution[x][y] = 1;
                return true;
            }
    
            // Check if maze[x][y] is a valid move
            if (isSafe(maze, x, y)) {
                // Mark x, y as part of the solution path
                solution[x][y] = 1;
    
                // Move right
                if (solveMazeUtil(maze, x, y + 1, solution)) {
                    return true;
                }
    
                // Move down
                if (solveMazeUtil(maze, x + 1, y, solution)) {
                    return true;
                }
    
                // Backtrack
                solution[x][y] = 0;
            }
    
            return false;
        }
    
        private static boolean isSafe(int[][] maze, int x, int y) {
            int n = maze.length;
            return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1);
        }
    
        private static void printSolution(int[][] solution) {
            for (int[] row : solution) {
                for (int cell : row) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        }
    
        // Driver method
        public static void main(String[] args) {
            int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
            };
    
            solveMaze(maze);
        }
    }
    