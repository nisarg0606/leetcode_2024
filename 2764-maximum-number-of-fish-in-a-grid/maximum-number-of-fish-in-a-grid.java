class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxFish = 0;

        int[] dx = {0, 0, 1, -1}; // Directions for row movement
        int[] dy = {1, -1, 0, 0}; // Directions for column movement

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If it's a water cell and not visited
                if (grid[i][j] > 0 && !visited[i][j]) {
                    maxFish = Math.max(maxFish, bfs(grid, i, j, visited, dx, dy));
                }
            }
        }

        return maxFish;
    }

    private int bfs(int[][] grid, int startX, int startY, boolean[][] visited, int[] dx, int[] dy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int fishCount = 0;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            fishCount += grid[x][y]; // Collect fish at the current cell

            // Explore neighbors
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length 
                        && grid[newX][newY] > 0 && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }

        return fishCount;
    }
}
