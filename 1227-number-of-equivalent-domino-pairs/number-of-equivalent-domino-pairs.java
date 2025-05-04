class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        for(int i = 0; i < dominoes.length; i++){
            int a, b, c, d;
            a = dominoes[i][0];
            b = dominoes[i][1];
            for(int j = i+1; j < dominoes.length; j++){
                c = dominoes[j][0];
                d = dominoes[j][1];
                if(((a == c) && (b == d)) || ((a == d) && (b == c))){
                    count++;
                }
            }
        }
        return count;
    }
}