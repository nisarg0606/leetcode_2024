class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,
                (a, b) -> a.getValue() == b.getValue() ? b.getKey() - a.getKey() : a.getValue() - b.getValue());
        int[] res = new int[nums.length];
        int j = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            int key = entry.getKey();
            int value = entry.getValue();
            for (int i = 0; i < value; i++) {
                res[j] = key;
                j++;
            }
        }
        return res;
    }
}