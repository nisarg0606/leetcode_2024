class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        // sort heights in descending order
        Arrays.sort(heights);
        String[] res = new String[names.length];
        int j = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            res[j] = map.get(heights[i]);
            j++;
        }
        return res;
    }
}