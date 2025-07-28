class Pair{
	int row;
	int col;
	
	public Pair(int row, int col){
		this.row = row;
		this.col = col;
	}
}

class Solution {
    public void wallsAndGates(int[][] rooms){
		if(rooms.length == 0 || rooms == null || rooms[0].length == 0) return;
		int m = rooms.length;
		int n = rooms[0].length;
		
		Queue<Pair> queue = new LinkedList<>();
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(rooms[i][j] == 0){
					queue.offer(new Pair(i, j));
				}
			}
		}
		
		int[] dRow = {-1, 0, 1, 0};
		int[] dCol = {0, 1, 0, -1};
		
		while(!queue.isEmpty()){
			Pair pr = queue.poll();
			int row = pr.row;
			int col = pr.col;
			for(int i = 0; i < 4; i++){
				int newRow = row + dRow[i];
				int newCol = col + dCol[i];
				if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && rooms[newRow][newCol] == Integer.MAX_VALUE){
					rooms[newRow][newCol] = rooms[row][col] + 1;
					queue.offer(new Pair(newRow, newCol));
				}
			}
		}
    }
}