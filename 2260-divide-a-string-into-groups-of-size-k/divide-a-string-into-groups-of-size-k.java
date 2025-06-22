class Solution {
    public String[] divideString(String s, int k, char fill) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() % k != 0) sb.append(fill);
        int n = sb.length();
        String[] res = new String[n / k];
        for (int i = 0; i < n; i += k)
            res[i / k] = sb.substring(i, i + k);

        return res;
    }
}