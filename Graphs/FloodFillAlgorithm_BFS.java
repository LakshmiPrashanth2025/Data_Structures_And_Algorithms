import java.util.LinkedList;
import java.util.Queue;

public class FloodFillAlgorithm_BFS {
    
    // Directions for up, down, left, right moves
    private static final int[][] DIRECTIONS = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor == newColor) {
            return image; // No change needed
        }
        
        int rows = image.length;
        int cols = image[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = newColor;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1];
            
            for (int[] dir : DIRECTIONS) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                // Check bounds and color match
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && image[nr][nc] == originalColor) {
                    image[nr][nc] = newColor;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        
        return image;
    }
    
    // Helper function to print the image
    public static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;
        
        System.out.println("Original Image:");
        printImage(image);
        
        floodFill(image, sr, sc, newColor);
        
        System.out.println("\nFlood Filled Image:");
        printImage(image);
    }
}
