import java.util.*;

class Pair {
    int row;
    int col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cntIslands = 0;
        Queue<Pair> queue = new LinkedList<>();

        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1') {
                    cntIslands++;
                    grid[row][col] = '0'; // mark visited
                    queue.offer(new Pair(row, col));
                    while (!queue.isEmpty()) {
                        Pair p = queue.poll();
                        for (int[] dir : directions) {
                            int newRow = p.row + dir[0];
                            int newCol = p.col + dir[1];
                            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == '1') {
                                grid[newRow][newCol] = '0'; // mark visited
                                queue.offer(new Pair(newRow, newCol));
                            }
                        }
                    }
                }
            }
        }

        return cntIslands;
    }
}
