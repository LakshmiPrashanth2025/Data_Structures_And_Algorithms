import java.util.ArrayList;

public class RatInMazeGeeksAnswer {
    // Down, Left, Right, Up;
    static String directions = "DLRU";

    static int[] directionsRow = {1, 0, 0, -1};
    static int[] directionsColumn = {0, -1, 1, 0};

    // A. Function to find all paths and return them
    static ArrayList<String> ratInMaze(int[][] mazeMatrix) {
        ArrayList<String> result = new ArrayList<>();
        int n = mazeMatrix.length;
        String path = "";

        if (mazeMatrix[0][0] != 0 && mazeMatrix[n - 1][n - 1] != 0) {
            findPath(0, 0, mazeMatrix, path, result);
        }

        return result;
    }

    // B. Function to find all valid paths
    static void findPath(int row, int column, 
                        int[][] mazeMatrix, 
                        String path,
                        ArrayList<String> resultVisitedPath) 
    {
        int n = mazeMatrix.length;

        // 1. Base condition of Recursion: If destination is reached, store the path & return
        if (row == n - 1 && column == n - 1) {
            resultVisitedPath.add(path);
            return;
        }

        // 2. Mark current cell as blocked
        mazeMatrix[row][column] = 0;


        // 3. Try to find the next step in the path - in right, left, up or down, if it is valid
        for (int i = 0; i < 4; i++) {

            int newRow = row + directionsRow[i];
            int newColumn = column + directionsColumn[i];

            if (isValid(newRow, newColumn, n, mazeMatrix)) 
            {
                findPath(newRow, newColumn, mazeMatrix, 
                        path + directions.charAt(i), 
                        resultVisitedPath);
            }
        }

        // 4. Unmark current cell  
        mazeMatrix[row][column] = 1;  
        
    } // end of method

    // C. Function to Check if a cell is valid (if the cell is inside the maze matrix and open (not a blocked cell))
    static boolean isValid(int row, int column, int n, int[][] maze) {
        return row >= 0 && 
                column >= 0 && 
                row < n && 
                column < n && 
                maze[row][column] == 1;
    }    

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        ArrayList<String> resultPath = ratInMaze(maze);

        System.out.println("D: DOWN, U: UP, L : LEFT, R: RIGHT");

        if (resultPath.isEmpty()) {
            System.out.println(-1);
        } 
        else
         {
            for (String directionInPath : resultPath) {
                System.out.print( directionInPath + " ");
            }
            System.out.println();
        }
    }
}