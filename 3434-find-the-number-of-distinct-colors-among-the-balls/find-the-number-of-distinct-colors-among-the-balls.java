class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> colorMap = new HashMap<>();
        HashMap<Integer, Integer> ballMap = new HashMap<>();
        // int n = queries.length;
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            if (ballMap.containsKey(ball)) {
                int prevColor = ballMap.get(ball);
                colorMap.put(prevColor, colorMap.get(prevColor) - 1);
                if (colorMap.get(prevColor) == 0)
                    colorMap.remove(prevColor);
            }
            ballMap.put(ball, color);
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            result[i] = colorMap.size();
        }
        return result;
    }
}