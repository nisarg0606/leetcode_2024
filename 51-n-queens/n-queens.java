class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        dfs(board, 0, result);
        return result;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> result) {
        if (colIndex == board.length) {
            result.add(construct(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, result);
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && (x == i || x + y == i + j || x + j == y + i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }
}