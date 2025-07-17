class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    private void bfs(int row, int col, int[][] vis, char[][] grid) {
        vis[row][col] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;

        while (!queue.isEmpty()) {
            int r = queue.peek().first;
            int c = queue.peek().second;
            queue.remove();

            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    if (Math.abs(delRow) == Math.abs(delCol)) {
                        continue; // Skip diagonals
                    }
                    int nRow = r + delRow;
                    int nCol = c + delCol;
                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                            && grid[nRow][nCol] == '1' && vis[nRow][nCol] == 0) {
                        vis[nRow][nCol] = 1;
                        queue.add(new Pair(nRow, nCol));
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (vis[row][col] == 0 && grid[row][col] == '1') {
                    count++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return count;
    }
}