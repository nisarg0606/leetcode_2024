class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> colorMap = new HashMap<>();
        HashMap<Integer, Integer> ballMap = new HashMap<>();
        // int n = queries.length;
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (ballMap.containsKey(queries[i][0])) {
                int prevColor = ballMap.get(queries[i][0]);
                colorMap.put(prevColor, colorMap.get(prevColor) - 1);
                if (colorMap.get(prevColor) == 0)
                    colorMap.remove(prevColor);
            }
            ballMap.put(queries[i][0], queries[i][1]);
            colorMap.put(queries[i][1], colorMap.getOrDefault(queries[i][1], 0) + 1);
            result[i] = colorMap.size();
        }
        return result;
    }
}