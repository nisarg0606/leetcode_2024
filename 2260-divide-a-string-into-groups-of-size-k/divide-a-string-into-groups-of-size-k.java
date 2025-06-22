class Solution {
    public String[] divideString(String s, int k, char fill) {
        // if (k < s.length()) {
        //     return new String[] { s };
        // }
        int charactersToAdd = k - (s.length() % k);
        StringBuilder sb = new StringBuilder(s);
        if (!(charactersToAdd == k)) {
            for (int i = 0; i < charactersToAdd; i++) {
                sb.append(fill);
            }
        }
        List<String> list = new ArrayList<>();
        int n = sb.length();
        int totalStrings = n / k;
        int start = 0, end = k;
        for (int i = 0; i < totalStrings; i++) {
            list.add(sb.substring(start, end));
            start += k;
            end += k;
        }

        return list.toArray(new String[0]);
    }
}