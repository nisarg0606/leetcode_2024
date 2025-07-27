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
		int cntFrest = 0;
		
		// Find the location of Rotten Oranges and create a visited array to mark them as rotten
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(grid[i][j] == 2){
					visited[i][j] = 2;
					queue.offer(new Pair(i, j, 0));
				}else if(grid[i][j] == 1){
					cntFrest++; // count number of frest oranges which can or cannot be rotten 
				}else{
					visited[i][j] = 0;
				}
			}
		}
		
		int time = 0;
		int[] dRow = { -1, 0, 1, 0 }; // up, right side, down, left side
		int[] dCol = { 0, 1, 0, -1 }; // up, right side, down, left side
		int rottenOranges = 0;
		while(!queue.isEmpty()){
			int r = queue.peek().row;
			int c = queue.peek().col;
			int t = queue.peek().time;
			time = Math.max(t, time); // Update the time which it will take to rotten
			queue.remove();
			for(int i = 0; i < 4; i++){
				int nRow = dRow[i] + r; // Check surrounding row
				int nCol = dCol[i] + c; // Check Surrounding column
				// Check if the row and column are in bound, they are not visted and oranges are fresh
				if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && visited[nRow][nCol] == 0){
					visited[nRow][nCol] = 2;
					queue.offer(new Pair(nRow, nCol, t+1));
					rottenOranges++;
				}
			}
		}
		if(rottenOranges == cntFrest)return time; // if all the oranges are rotten then return the time else return -1 as it failed to rotten all of them
		return -1;
	}
}