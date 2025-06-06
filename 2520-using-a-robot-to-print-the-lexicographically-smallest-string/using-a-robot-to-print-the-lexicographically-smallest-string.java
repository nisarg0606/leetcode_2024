class Solution {
    public String robotWithString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int[] charCount = new int[26];

        // Count occurrences of each character
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            stack.push(c);
            charCount[c - 'a']--;

            // Keep popping while top of stack <= smallest remaining character in the string
            while (!stack.isEmpty() && stack.peek() <= getNextRemainingMin(charCount)) {
                result.append(stack.pop());
            }
        }

        // Append any remaining characters in the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Return the smallest character that still remains in the unprocessed part
    private char getNextRemainingMin(int[] charCount) {
        for (int i = 0; i < 26; i++) {
            if (charCount[i] > 0) {
                return (char) (i + 'a');
            }
        }
        return '{'; // Return a char greater than 'z' to ensure stack is popped when no chars remain
    }
}