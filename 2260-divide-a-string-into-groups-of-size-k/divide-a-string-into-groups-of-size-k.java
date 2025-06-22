class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        // Calculate the number of parts. Use Math.ceil equivalent for integer division.
        // (n + k - 1) / k works for positive integers.
        int numParts = (n + k - 1) / k;

        String[] result = new String[numParts];

        for (int i = 0; i < numParts; i++) {
            int startIndex = i * k;
            // Determine the end index for the current substring
            int endIndex = Math.min(startIndex + k, n);

            // Extract the substring
            String currentPart = s.substring(startIndex, endIndex);

            // If it's the last part and it needs padding
            if (currentPart.length() < k) {
                StringBuilder sb = new StringBuilder(currentPart);
                while (sb.length() < k) {
                    sb.append(fill);
                }
                result[i] = sb.toString();
            } else {
                result[i] = currentPart;
            }
        }

        return result;
    }
}