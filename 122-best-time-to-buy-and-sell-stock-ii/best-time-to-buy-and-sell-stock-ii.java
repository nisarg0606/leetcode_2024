class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        return dfs(0, 1, prices, dp);
    }

    public int dfs(int i, int buy, int[] prices, int[][] dp) {
        if (i == prices.length) return 0;
        if (dp[i][buy] != -1) return dp[i][buy];

        if (buy == 1) {
            int take = -prices[i] + dfs(i + 1, 0, prices, dp);
            int notTake = dfs(i + 1, 1, prices, dp);
            return dp[i][buy] = Math.max(take, notTake);
        } else {
            int sell = prices[i] + dfs(i + 1, 1, prices, dp);
            int notSell = dfs(i + 1, 0, prices, dp);
            return dp[i][buy] = Math.max(sell, notSell);
        }
    }
}
