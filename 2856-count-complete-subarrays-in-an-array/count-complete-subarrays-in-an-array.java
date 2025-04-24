class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;

        for (int num : nums) set.add(num);
        int uniqueElements = set.size();

        if (uniqueElements == 1) return (n * (n + 1) / 2);

        int start = 0, end = 0, completeSubarrays = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (start < n) {
            while (end < n && map.size() < uniqueElements) {
                map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
                end++;
            }

            if (map.size() < uniqueElements) break;

            completeSubarrays += n - end + 1;

            map.put(nums[start], map.get(nums[start]) - 1);
            if (map.get(nums[start]) == 0) map.remove(nums[start]);
            start++;
        }

        return completeSubarrays;
    }
}
