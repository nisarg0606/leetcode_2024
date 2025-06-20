class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maximumSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maximumSum = Math.max(maximumSum, currentSum);
        }

        return maximumSum;
    }
}