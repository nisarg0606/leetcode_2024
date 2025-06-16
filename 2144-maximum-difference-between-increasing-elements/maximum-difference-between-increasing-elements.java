class Solution {
    public int maximumDifference(int[] nums) {
        int maxDifference = -1, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                maxDifference = Math.max(maxDifference, nums[j] - nums[i]);
            }
        }
        if (maxDifference == 0)
            return -1;
        return maxDifference;
    }
}