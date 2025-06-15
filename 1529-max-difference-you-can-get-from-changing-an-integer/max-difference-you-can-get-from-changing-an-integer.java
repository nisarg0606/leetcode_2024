class Solution {
    /**
     * Calculate the maximum possible difference by applying two separate digit replacement operations
     * @param num The input integer to be modified
     * @return The maximum possible difference between the resulting numbers
     */
    public int maxDiff(int num) {
        // Convert num to string for easier digit manipulation
        StringBuffer maxNum = new StringBuffer(String.valueOf(num));
        StringBuffer minNum = new StringBuffer(String.valueOf(num));
        int maxLen = maxNum.length();

        // STRATEGY 1: Maximize the number by replacing the leftmost non-9 digit with 9
        // We want to find the leftmost digit that isn't already 9 and replace all occurrences of it with 9
        for (int i = 0; i < maxLen; i++) {
            char digit = maxNum.charAt(i);
            if (digit != '9') {
                // Found the leftmost non-9 digit, replace all occurrences with 9
                replace(maxNum, digit, '9');
                break; // Only perform one replacement operation
            }
        }

        int minLen = minNum.length();
        
        // STRATEGY 2: Minimize the number while respecting the constraint of no leading zeros
        for (int i = 0; i < minLen; i++) {
            char digit = minNum.charAt(i);
            
            // Case 1: Working with the first digit (most significant position)
            if (i == 0) {
                if (digit != '1') {
                    // If the first digit is not already 1, replace it with 1
                    // We use 1 instead of 0 to avoid leading zeros
                    replace(minNum, digit, '1');
                    break; // Only perform one replacement operation
                }
            } 
            // Case 2: Working with non-first digits
            else {
                // For non-first positions, we want to replace with 0 to minimize the number
                // BUT we need two checks:
                // 1. Don't replace if the digit is already 0 (no change would occur)
                // 2. Don't replace if the digit is the same as the first digit
                //    This second check is crucial because if we replace a digit that also appears
                //    as the first digit, we would accidentally create a leading zero
                if (digit != '0' && digit != minNum.charAt(0)) {
                    // Found a digit that can be safely replaced with 0
                    replace(minNum, digit, '0');
                    break; // Only perform one replacement operation
                }
            }
        }
        
        // Calculate and return the difference between the maximized and minimized numbers
        return Integer.parseInt(maxNum.toString()) - Integer.parseInt(minNum.toString());
    }

    /**
     * Helper method to replace all occurrences of a character in a StringBuffer
     * @param s The StringBuffer to modify
     * @param x The character to be replaced
     * @param y The character to replace with
     */
    public void replace(StringBuffer s, char x, char y) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == x) {
                s.setCharAt(i, y);
            }
        }
    }
}