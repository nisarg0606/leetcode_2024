class Solution {
    private void dfs(int row, int col, int[][] ans, int[][] image, int color, int[] delRow, int[] delCol,
            int iniColor) {
        ans[row][col] = color;
        int n = image.length;
        int m = image[0].length;

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && image[nRow][nCol] == iniColor
                    && ans[nRow][nCol] != color) {
                dfs(nRow, nCol, ans, image, color, delRow, delCol, iniColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        int[][] ans = image;
        int delRow[] = { -1, 0, +1, 0 }; // directions of the row -1 means upper row, 0 means row on the right, +1 is the row at the bottom, 
        //last zero is for the row on the left
        int delCol[] = { 0, +1, 0, -1 }; //Same like row above -> we start from up and move clockwise
        dfs(sr, sc, ans, image, color, delRow, delCol, iniColor);
        return ans;
    }
}