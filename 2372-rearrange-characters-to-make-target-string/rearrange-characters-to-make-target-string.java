// class Solution {
//     public int rearrangeCharacters(String s, String target) {
//         // We will create two hashmaps for s and target both
//         Map<Character, Integer> targetMap = new TreeMap<>();
//         Map<Character, Integer> sMap = new TreeMap<>();

//         for (char ch : target.toCharArray()) {
//             targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
//         }

//         for (char ch : s.toCharArray()) {
//             if (targetMap.containsKey(ch)) {
//                 sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
//             }
//         }

//         int minCopies = Integer.MAX_VALUE;

//         for (char c : targetMap.keySet()) {
//             int countInS = sMap.getOrDefault(c, 0);
//             int requiredCount = targetMap.get(c);
//             int possibleCopies = countInS / requiredCount;

//             minCopies = Math.min(minCopies, possibleCopies);
//         }

//         return minCopies;

//     }
// }

//optimal Solution using arrays of Size 26 as the characters are english lowercase characters only

class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] sFreq = new int[26];
        int[] targetFreq = new int[26];

        for (char ch : s.toCharArray()) {
            sFreq[ch - 'a']++;
        }

        for (char ch : target.toCharArray()) {
            targetFreq[ch - 'a']++;
        }

        int minCopies = Integer.MAX_VALUE;

        for (char ch : target.toCharArray()) {
            int index = ch - 'a';
            if (targetFreq[index] > 0) {
                minCopies = Math.min(minCopies, sFreq[index] / targetFreq[index]);
            }
        }

        return minCopies;
    }
}