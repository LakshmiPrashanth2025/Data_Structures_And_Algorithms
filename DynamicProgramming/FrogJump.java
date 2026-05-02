public class FrogJump {

    public static int calculateMinimumCost(int[] stairHeights) {
        int totalStairs = stairHeights.length;
        int[] minCostToReach = new int[totalStairs];

        minCostToReach[0] = 0; // No cost to stand on the first stair

        for (int currentStair = 1; currentStair < totalStairs; currentStair++)
        {

            // Step 1 - calculate (cost for prev stair + cost to this step)
            int jumpCostFromPrevStair = Math.abs(stairHeights[currentStair] - stairHeights[currentStair - 1]);
            int costFromPrevStair = minCostToReach[currentStair - 1] + jumpCostFromPrevStair;

            // Step 2 - calculate (cost for prev to prev stair + cost to this step)
            int costFromTwoStairsBack = Integer.MAX_VALUE;
            if (currentStair > 1) {
                int jumpCostFromTwoStairsBack = Math.abs(stairHeights[currentStair] - stairHeights[currentStair - 2]);
                costFromTwoStairsBack = minCostToReach[currentStair - 2] + jumpCostFromTwoStairsBack;
            }

             // Step 3 - calculate cost for current stair
            minCostToReach[currentStair] = Math.min(costFromPrevStair, costFromTwoStairsBack);
        }

        return minCostToReach[totalStairs - 1]; // Return final cost to reach the last stair
    }

    public static void main(String[] args) {
        int[] stairHeights = {10, 30, 40, 20}; // Example input
        int minimumTotalCost = calculateMinimumCost(stairHeights);
        System.out.println("Minimum total cost: " + minimumTotalCost);
    }
}
