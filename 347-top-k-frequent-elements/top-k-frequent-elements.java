class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // List<Integer> result = new ArrayList<>();
        // for (Map.Entry<Integer, Integer> m : map.entrySet()) {
        //     if (m.getValue() >= k) {
        //         result.add(m.getKey());
        //     }
        // }

        // return result.stream().mapToInt(Integer::intValue).toArray();

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll().getKey();
        }

        return result;

    }
}