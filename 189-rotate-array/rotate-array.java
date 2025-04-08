class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // First will reverse the whole array
        reverse(0, n - 1, nums);
        // Now will reverse the k elements
        reverse(0, k - 1, nums);
        // now will reverse the rest
        reverse(k, n - 1, nums);
    }

    private void reverse(int start, int end, int[] nums) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}