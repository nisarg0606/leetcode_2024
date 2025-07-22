class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        // int n = nums.length;
        // int result = 0;
        // Set<Integer> set = new HashSet<>();
        // for (int start = 0; start < n; start++) {
        //     set.clear();
        //     int currentSum = 0;
        //     for (int end = start; end < n && !set.contains(nums[end]); end++) {
        //         currentSum += nums[end];
        //         set.add(nums[end]);
        //     }
        //     result = Math.max(result, currentSum);
        // }

        // return result;

        // int result = 0;
        // int currentSum = 0;
        // HashSet<Integer> set = new HashSet<>();
        // int start = 0;
        // for (int end = 0; end < nums.length; end++) {
        //     while (set.contains(nums[end])) {
        //         set.remove(nums[start]);
        //         currentSum -= nums[start];
        //         start++;
        //     }
        //     currentSum += nums[end];
        //     set.add(nums[end]);
        //     result = Math.max(result, currentSum);
        // }

        // return result;

        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int result = 0;
        int currentSum = 0;
        int i = 0, j = 0;
        while (j < n) {
            if (!set.contains(nums[j])) {
                currentSum += nums[j];
                result = Math.max(currentSum, result);
                set.add(nums[j]);
                j++;
            } else {
                while (i < n && set.contains(nums[j])) {
                    currentSum -= nums[i];
                    set.remove(nums[i]);
                    i++;
                }
            }
        }
        return result;
    }
}