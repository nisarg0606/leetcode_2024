class Solution {
    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);

        // --- MAXIMIZE ---
        // Replace first digit that's not 9 with 9
        char toReplaceMax = ' ';
        for (char c : numStr.toCharArray()) {
            if (c != '9') {
                toReplaceMax = c;
                break;
            }
        }

        String maxStr = numStr;
        if (toReplaceMax != ' ') {
            maxStr = numStr.replace(toReplaceMax, '9');
        }

        // --- MINIMIZE ---
        // Replace first digit that's not 0 with 0
        char toReplaceMin = numStr.charAt(0); // Always try replacing the first digit
        String minStr = numStr.replace(toReplaceMin, '0');

        // Convert both to integers (leading zeros are removed by parseInt)
        int maxNum = Integer.parseInt(maxStr);
        int minNum = Integer.parseInt(minStr);

        return maxNum - minNum;
    }
}
