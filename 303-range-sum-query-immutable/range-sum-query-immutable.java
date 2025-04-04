class NumArray {
    int[] array;

    public NumArray(int[] nums) {
        array = new int[nums.length];
        array[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            array[i] = nums[i] + array[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return array[right];
        }

        return array[right] - array[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */