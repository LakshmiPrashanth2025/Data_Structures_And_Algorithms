import java.util.*;

public class QueensAttackKing {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        // Store all queen positions in a HashSet for quick lookup
        Set<String> queenSet = new HashSet<>();
        for (int[] q : queens) {
            queenSet.add(q[0] + "," + q[1]);
        }

        List<List<Integer>> result = new ArrayList<>();

        // 8 directions: vertical, horizontal, and diagonal
        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},   // up, down, left, right
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}  // diagonals
        };

        for (int[] dir : directions) {
            int x = king[0], y = king[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                x += dir[0];
                y += dir[1];
                String pos = x + "," + y;
                if (queenSet.contains(pos)) {
                    result.add(Arrays.asList(x, y));
                    break; // stop looking in this direction after finding one queen
                }
            }
        }

        return result;
    }

    // Sample test
    public static void main(String[] args) {
        QueensAttackKing solver = new QueensAttackKing();

        int[][] queens = {
            {0,1},{1,0},{4,0},{0,4},{3,3},{2,4}
        };
        int[] king = {0,0};

        List<List<Integer>> attackers = solver.queensAttacktheKing(queens, king);
        System.out.println("Queens that can attack the king: " + attackers);
    }
}
