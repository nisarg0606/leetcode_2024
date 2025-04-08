class Solution {
    public int maxProfit(int[] prices) {

        // int maxProfit = 0;
        // for (int i = 0; i < prices.length - 1; i++) {
        //     for (int j = i + 1; j < prices.length - 1; j++) {
        //         int profit = prices[j] - prices[i];
        //         if (profit > maxProfit)
        //             maxProfit = profit;
        //     }
        // }
        // return maxProfit;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }

        }
        return maxProfit;
    }
}