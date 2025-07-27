class Pair{
	int row;
	int col;
	Pair(int row, int col){
		this.row = row;
		this.col = col;
	}
}

class Solution {

    public int numIslands(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int cntIslands = 0;
		int[][] visited = new int[n][m];
		Queue<Pair> queue = new LinkedList<>();
		
		int[] dRow = {-1, 0, 1, 0};
		int[] dCol = {0, 1, 0, -1};
		
		for(int row = 0; row < n; row++){
			for(int col = 0; col < m; col++){
				if(grid[row][col] == '1' && visited[row][col] == 0){
					cntIslands++;
					visited[row][col] = 1;
					queue.offer(new Pair(row, col));
					while(!queue.isEmpty()){
						int r = queue.peek().row;
						int c = queue.peek().col;
						queue.remove();
						for(int i = 0; i < 4; i++){
							int nRow = r + dRow[i];
							int nCol = c + dCol[i];
							if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && grid[nRow][nCol] == '1'){
								visited[nRow][nCol] = 1;
								queue.offer(new Pair(nRow, nCol));
							}
						}
					}
				}
			}
		}
		
		return cntIslands;
	}
}