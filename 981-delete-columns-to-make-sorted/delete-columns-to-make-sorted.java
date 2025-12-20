class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        int m = strs.length;
        int n = strs[0].length();

        for(int j = 0; j < n; j++){
            for(int i = 1; i < m; i++){
                if(strs[i].charAt(j) < strs[i-1].charAt(j)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}