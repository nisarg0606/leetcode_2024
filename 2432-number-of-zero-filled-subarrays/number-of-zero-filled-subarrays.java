class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0, result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                result += count;
            } else {
                count = 0;
            }
        }
        return result;
    }
}