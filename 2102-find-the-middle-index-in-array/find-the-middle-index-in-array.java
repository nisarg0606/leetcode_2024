class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        int cumulativeSum = 0;

        for (int i = 0; i < n; i++) {
            int leftSide = cumulativeSum;
            int rightSide = sum - cumulativeSum - nums[i];

            if (leftSide == rightSide)
                return i;

            cumulativeSum += nums[i];
        }

        return -1;
    }
}