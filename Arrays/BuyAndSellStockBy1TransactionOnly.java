// Java Program to solve stock buy and sell
// using one traversal

// If Prices array is   {7, 10, 1, 3, 6, 9, 2} on different days
// Buy for 1 and sell for 9 
// Maximum Profit is 8 Rs

// O(n) Time and O(1) Space complexity


public class BuyAndSellStockBy1TransactionOnly {

    static int maxProfit(int[] prices) {
        int minPriceSoFar = prices[0];
        int maxProfit = 0;

        // Update the minimum value seen so far
      	// if we see smaller
        for (int i = 1; i < prices.length; i++) {
            minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
           
            // Update result if we get more profit                
            maxProfit = Math.max(maxProfit, prices[i] - minPriceSoFar);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 10, 1, 3, 6, 9, 2};
        System.out.println(maxProfit(prices));

        // min Price is 101 and maxPrice is 116 - maxProfit is 15
        int[] prices2 = {101, 110, 104, 103, 116, 115, 112};
        System.out.println(maxProfit(prices2));
    }
}
