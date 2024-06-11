class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int res = 0;
        int i = 0;
        while (i < n) {
            char c = chars[i];
            int count = 0;
            while (i < n && chars[i] == c) {
                i++;
                count++;
            }
            chars[res++] = c;
            if (count > 1) {
                for (char ch : String.valueOf(count).toCharArray()) {
                    chars[res++] = ch;
                }
            }
        }
        return res;
    }
}