class Solution {
    // public int lengthOfLongestSubstring(String s) {
    // Map<Character, Integer> chars = new HashMap<>();

    // int left = 0;
    // int right = 0;

    // int res = 0;
    // while (right < s.length()) {
    //     char r = s.charAt(right);
    //     chars.put(r, chars.getOrDefault(r, 0) + 1);

    //     while (chars.get(r) > 1) {
    //         char l = s.charAt(left);
    //         chars.put(l, chars.get(l) - 1);
    //         left++;
    //     }

    //     res = Math.max(res, right - left + 1);

    //     right++;
    // }

    // return res;

    // int n = s.length(), ans = 0;
    // Map<Character, Integer> charToNextIndex = new HashMap<>();
    // for (int j = 0, i = 0; j < n; j++) {
    //     if (charToNextIndex.containsKey((s.charAt(j)))) {
    //         i = Math.max(charToNextIndex.get(s.charAt(j)), i);
    //     }
    //     ans = Math.max(ans, j - i + 1);
    //     charToNextIndex.put(s.charAt(j), j + 1);
    // }

    // return ans;

    // Integer[] chars = new Integer[128];

    // int left = 0;
    // int right = 0;

    // int res = 0;
    // while(right < s.length()){
    //     char r = s.charAt(right);

    //     Integer index = chars[r];
    //     if(index != null && index >= left && index < right){
    //         left = index + 1;
    //     }

    //     res = Math.max(res, right - left + 1);

    //     chars[r] = right;
    //     right++;
    // }

    // return res;

    //     Map<Character, Integer> map = new HashMap<>();
    //     int start = 0, len = 0;

    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if (map.containsKey(c)) {
    //             if (map.get(c) >= start)
    //                 start = map.get(c) + 1;
    //         }
    //         len = Math.max(len, i - start + 1);
    //         map.put(c, i);
    //     }
    //     return len;
    // }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                // Move left to one after the last occurrence of c, but only forward
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

}