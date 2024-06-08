class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim().replaceAll("\\\s+", " ");
        String[] words = s.split(" ");
        for(int i = words.length - 1; i >= 0; i--){
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }
}