// Java Program to find the max profit when multiple
// transactions are allowed
// USe graph to track price movement - sell it before it falls
/*
*   Input: prices[] = {100, 180, 260, 310, 40, 535, 695}
*   Output: 865 - 
*   Explanation:       Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210
*                      Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655
*                      Maximum Profit  = 210 + 655 = 865
 */

public class BuySellStockMultipleTransactionsAllowed {
    
    static int maximumProfit(int[] prices) {
        int addedMaxProfits = 0;

        // Keep on adding the difference between
        // adjacent when the prices increase from previous day/ element
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                addedMaxProfits += prices[i] - prices[i - 1];
            }
        }
        
        return addedMaxProfits;
    }

    public static void main(String[] args) {
        int[] prices = { 100, 180, 260, 310, 40, 535, 695 };
        System.out.println(maximumProfit(prices));
    }
}
