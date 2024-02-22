class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>(map.keySet());
        result.sort((n1, n2) -> map.get(n2) - map.get(n1));
        return result.subList(0, k).stream().mapToInt(i -> i).toArray();
    }
}