class Solution {
    private int dfs(int m, int n, int i, int j, int[][] memo) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (i >= m || j >= n) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        memo[i][j] = dfs(m, n, i + 1, j, memo) + dfs(m, n, i, j + 1, memo);
        return memo[i][j];
    }

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return dfs(m, n, 0, 0, memo);
    }
}