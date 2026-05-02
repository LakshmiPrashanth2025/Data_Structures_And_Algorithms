// Java program for coin change problem using recursion

public class Coinchange_CountWays_Recursion {

    // Recursive function to count the number of ways to make up the targetAmount
    static int countWays(int[] coinTypes, int numCoins, int targetAmount) {

        // Base Case: If targetAmount is 0, there's one valid combination (no coins used)
        if (targetAmount == 0) {
            return 1;
        }

        // Base Case: If targetAmount becomes negative or no coins left to use, no solution
        if (targetAmount < 0 || numCoins == 0){
             return 0;
        }

        // Option 1: Include current coin (coinTypes[numCoins - 1])
        int includeCurrentCoin = countWays(coinTypes, numCoins, targetAmount - coinTypes[numCoins - 1]);

        // Option 2: Exclude current coin and move to next
        int excludeCurrentCoin = countWays(coinTypes, numCoins - 1, targetAmount);

        // Total ways is sum of both options
        return includeCurrentCoin + excludeCurrentCoin;
    }

    // Wrapper method to start recursion
    static int getTotalWays(int[] coinTypes, int targetAmount) {
        return countWays(coinTypes, coinTypes.length, targetAmount);
    }

    public static void main(String[] args) {
        int[] coinTypes = {1, 2, 3};
        int targetAmount = 5;
        System.out.println(getTotalWays(coinTypes, targetAmount));
    }
}
