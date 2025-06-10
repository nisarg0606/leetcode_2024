import java.util.*;

class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        
        // Count frequencies
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        // Classify odd and even counts
        for (int count : freq.values()) {
            if (count % 2 == 0) {
                minEven = Math.min(minEven, count);
            } else {
                maxOdd = Math.max(maxOdd, count);
            }
        }

        // If we found both an odd and even character count
        if (maxOdd != Integer.MIN_VALUE && minEven != Integer.MAX_VALUE) {
            return maxOdd - minEven;
        }

        return -1;
    }
}
