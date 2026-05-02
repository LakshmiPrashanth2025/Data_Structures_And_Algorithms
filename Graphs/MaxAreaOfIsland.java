public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfsToFindIslandArea(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfsToFindIslandArea(int[][] grid, int i, int j) {
        // Out of bounds or water
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        // Mark as visited
        grid[i][j] = 0;

        // Count current land + explore all 4 directions
        int area = 1;
        area += dfsToFindIslandArea(grid, i + 1, j); // down
        area += dfsToFindIslandArea(grid, i - 1, j); // up
        area += dfsToFindIslandArea(grid, i, j + 1); // right
        area += dfsToFindIslandArea(grid, i, j - 1); // left

        return area;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();
        int[][] grid = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,1,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,1,0},
            {0,0,0,0,0,0,0,0,1,1,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0}
        };

        System.out.println(solution.maxAreaOfIsland(grid)); // Output: 6
    }
}
