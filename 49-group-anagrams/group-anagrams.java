class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        For the brute force approach I think I will take a hashmap where I will first 
        take the first word and create a char array out of it. Will sort the character
        array and make it the key. Now when the new words arrive will check by sorting
        the characters
        Eg:
        "eat" -> "aet"
        "tea" -> "aet"
        'tan' -> 'ant'
        'nat' -> 'ant'
        'bat' -> 'abt'
        
        "aet" -> ["eat", "tea", "ate"]
        "ant" -> ["tan", "nat"]
        "abt" -> ["bat"]
        */

        //    Map<String, List<String>> ans = new HashMap<>();

        //    for(String s: strs){
        //     char[] chars = s.toCharArray();
        //     Arrays.sort(chars);
        //     String key = new String(chars);
        //     if(!ans.containsKey(key)){
        //         ans.put(key, new ArrayList<>());
        //     }
        //     ans.get(key).add(s);
        //    }

        //    return new ArrayList<>(ans.values());

        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append(num).append("#");
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s);
        }

        return new ArrayList<>(ans.values());

    }
}