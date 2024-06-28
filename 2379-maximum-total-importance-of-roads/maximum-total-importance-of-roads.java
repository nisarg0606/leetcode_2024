class Solution {
    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) {
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        HashMap<Integer, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public long maximumImportance(int n, int[][] roads) {
        HashMap<Integer, Integer> importance = new HashMap<>();
        for (int i = 0; i < n; i++) {
            importance.put(i, 0);
        }
        // get frequency of each road and increment the frequency in the hashmap using
        // getordefault
        for (int[] road : roads) {
            importance.put(road[0], importance.getOrDefault(road[0], 0) + 1);
            importance.put(road[1], importance.getOrDefault(road[1], 0) + 1);
        }
        // the number whose frequency is maximum is the maximum importance i.e. n times
        // store the maximum importance in the hashmap
        // sort the hashmap
        importance = sortByValue(importance);
        int tempN = n;
        for (Map.Entry<Integer, Integer> entry : importance.entrySet()) {
            if (tempN == 0) {
                break;
            }
            importance.put(entry.getKey(), tempN);
            tempN--;
        }

        long maxImportance = 0;
        for (int[] road : roads) {
            maxImportance += importance.get(road[0]) + importance.get(road[1]);
        }
        return maxImportance;
    }
}