class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        int[] rows = new int[N];
        int[] cols = new int[N];
        int[] boxes = new int[N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] == '.')
                    continue;
                int val = board[r][c] - '0';
                int pos = 1 << (val - 1);

                if ((rows[r] & pos) > 0)
                    return false;

                rows[r] |= pos;

                if ((cols[c] & pos) > 0)
                    return false;

                cols[c] |= pos;

                int idx = (r / 3) * 3 + c / 3;

                if ((boxes[idx] & pos) > 0)
                    return false;

                boxes[idx] |= pos;
            }
        }
        return true;
    }
}