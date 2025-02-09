class Solution {
    public long countBadPairs(int[] nums) {
        // int badPairs = 0;
        // for (int i = 0; i < nums.length; i++) {
        // for (int j = i; j < nums.length; j++) {
        // if (i == j)
        // continue;
        // if((j - i) != (nums[j] - nums[i])) badPairs++;
        // }
        // }
        // return badPairs;

        int n = nums.length;
        long totalPairs = (long) n * (n - 1) / 2;

        HashMap<Integer, Integer> map = new HashMap<>();

        long goodPairs = 0;

        for (int i = 0; i < n; i++) {
            int goodPair = i - nums[i];

            if (map.containsKey(goodPair)) {
                goodPairs += map.get(goodPair);
            }

            map.put(goodPair, map.getOrDefault(goodPair, 0) + 1);
        }

        return totalPairs - goodPairs;
    }
}