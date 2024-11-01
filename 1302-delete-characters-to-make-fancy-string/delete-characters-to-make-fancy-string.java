class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int n = sb.length();
            if (n < 2 || !(sb.charAt(n - 1) == ch && sb.charAt(n - 2) == ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}