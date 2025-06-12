class Solution {
    public int maxDistance(int[][] grid) {
    int n = grid.length;
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[n][n];
    
    // First, add all land cells to the queue as starting points
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                queue.offer(new int[]{i, j});
                visited[i][j] = true;
            }
        }
    }
    
    // If there's no land or all cells are land, return -1
    if (queue.isEmpty() || queue.size() == n * n) {
        return -1;
    }
    
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int distance = -1; // Start at -1 since we'll increment before processing land cells
    
    // BFS to find the farthest water cell
    while (!queue.isEmpty()) {
        int size = queue.size();
        distance++; // Increment distance for each level of BFS
        
        for (int i = 0; i < size; i++) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            
            // Check all four adjacent cells
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n 
                    && !visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }
    
    return distance;
}

}