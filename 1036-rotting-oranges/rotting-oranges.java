class Pair {
    int row;
    int col;
    int time;

    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        int cntFresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = 2;
                    queue.add(new Pair(i, j, 0));
                } else {
                    visited[i][j] = 0;
                }

                if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }

        int time = 0;
        int drow[] = { -1, 0, 1, 0 };
        int dcol[] = { 0, 1, 0, -1 };
        int cnt = 0;
        while (!queue.isEmpty()) {
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().time;
            time = Math.max(time, t);
            queue.remove();
            for (int i = 0; i < 4; i++) {
                int nRow = r + drow[i];
                int nCol = c + dcol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0
                        && grid[nRow][nCol] == 1) {
                    queue.add(new Pair(nRow, nCol, t + 1));
                    visited[nRow][nCol] = 2;
                    cnt++;
                }
            }

        }
        if (cnt != cntFresh)
            return -1;
        return time;
    }
}