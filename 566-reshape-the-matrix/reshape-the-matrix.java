class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int noe = 0;
        List<Integer> arr = new ArrayList<>();
        for (int[] row : mat) {
            for (int element : row) {
                arr.add(element);
                noe += 1;
            }
        }
        if(noe != (r * c)){
            return mat;
        }
        int[][] result = new int[r][c];
        int index = 0;
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[i].length; j++){
                result[i][j] = arr.get(index);
                index++;
            }
        }
        return result;
    }
}
