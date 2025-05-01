// class Solution {
//     public int lengthOfLongestSubstring(String s) {
        // int maxLen = 0;
        // int n = s.length();
        // for (int i = 0; i < n; i++) {
        //     int[] hash = new int[256];
        //     for (int j = i; j < n; j++) {
        //         if (hash[s.charAt(j)] == 1)
        //             break;
        //         int length = j - i + 1;
        //         maxLen = Math.max(length, maxLen);
        //         hash[s.charAt(j)] = 1;
        //     }
        // }
        // return maxLen;

        // int[] hash = new int[256];
        // Arrays.fill(hash, -1);
        // int left = 0, right = 0, maxLen = 0;
        // int n = s.length();
        // while (right < n) {
        //     if (hash[s.charAt(right)] != -1) {
        //         if (hash[s.charAt(right)] >= left)
        //             left = hash[s.charAt(right)] + 1;
        //     }
        //     int length = right - left + 1;
        //     maxLen = Math.max(length, maxLen);

        //     hash[s.charAt(right)] = right;
        //     right++;
        // }

        // return maxLen;
    // }
// }

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         Map<Character, Integer> map = new HashMap<>();
//         int maxLen = 0;
//         int left = 0;

//         for (int right = 0; right < s.length(); right++) {
//             char ch = s.charAt(right);

//             if (map.containsKey(ch) && map.get(ch) >= left) {
//                 left = map.get(ch) + 1; // move left just after the previous occurrence
//             }

//             map.put(ch, right); // update latest index of current char
//             maxLen = Math.max(maxLen, right - left + 1); // update result
//         }

//         return maxLen;
//     }
// }


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128]; // stores last seen position + 1
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            left = Math.max(left, lastSeen[ch]); // move left if needed
            maxLen = Math.max(maxLen, right - left + 1);
            lastSeen[ch] = right + 1; // store index + 1 to avoid default 0 confusion
        }

        return maxLen;
    }
}
