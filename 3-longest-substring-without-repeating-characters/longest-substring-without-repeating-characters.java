class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, start = 0, end = 0;
        int[] map = new int[128];
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map[c] == 0) {
                map[c] = 1;
                end++;
                max = Math.max(max, end - start);
            } else {
                map[s.charAt(start)] = 0;
                start++;
            }
        }
        return max;
    }
}