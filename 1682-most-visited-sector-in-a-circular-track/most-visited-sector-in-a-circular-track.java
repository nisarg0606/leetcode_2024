class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < rounds.length - 1; i++) {
            int start = rounds[i];
            int end = rounds[i + 1];
            if (i == 0) {
                map.put(start, map.getOrDefault(start, 0) + 1);
            }
            if (start <= end) {
                for (int j = start + 1; j <= end; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
            } else {
                for (int j = start + 1; j <= n; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
                for (int j = 1; j <= end; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
            }
        }
        // map.put(rounds[rounds.length - 1], map.getOrDefault(rounds[rounds.length -
        // 1], 0) + 1);
        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        List<Integer> result = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                result.add(key);
            }
        }
        return result;
    }
}