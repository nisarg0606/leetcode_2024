class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end)
            return 0;
        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        int[] merged = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] > 2L * nums[j]) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        i = start;
        j = mid + 1;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j])
                merged[k++] = nums[i++];
            else
                merged[k++] = nums[j++];
        }
        while (i <= mid)
            merged[k++] = nums[i++];
        while (j <= end)
            merged[k++] = nums[j++];
        for (i = start; i <= end; i++)
            nums[i] = merged[i - start];
        return count;
    }

}