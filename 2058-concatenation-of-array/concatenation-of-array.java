class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int result[] = new int[n* 2];
        for(int i = 0; i < n; i++){
            result[i] = nums[i];
        }
        int j = 0;
        for(int i = n; i < n * 2; i++){
            // int k = (i % 2 == 0) ? (i/2) : (i / 2) + 1; 
            result[i] = nums[j];
            j++; 
        }

        return result;
    }
}