class Solution {
    /*
  Dutch National Flag problem solution.
  */
    public void sortColors(int[] nums) {
        // For all idx < i : nums[idx < i] = 0
        // j is an index of elements under consideration
        int p0 = 0, curr = 0;

        // For all idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // Swap p0-th and curr-th elements
                // i++ and j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            } else if (nums[curr] == 2) {
                // Swap k-th and curr-th elements
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            } else curr++;
        }
    }
}