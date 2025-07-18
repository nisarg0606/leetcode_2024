class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (sb.length() == 1 || sb.length() == 0) {
                    sb = new StringBuilder();
                } else {
                    sb = new StringBuilder(sb.substring(0, sb.length() - 1));
                }
            } else if (ch == '#') {
                sb.append(sb.subSequence(0, sb.length()));
            } else if (ch == '%') {
                sb.reverse();
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}