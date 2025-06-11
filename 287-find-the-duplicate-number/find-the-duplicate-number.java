class Solution {
    public int findDuplicate(int[] nums) {
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int current = Math.abs(nums[i]);
            if (nums[current] < 0) {
                duplicate = current;
                break;
            }
            nums[current] *= -1;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return duplicate;
    }
}