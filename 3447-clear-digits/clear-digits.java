class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (!stack.isEmpty()) { // Ensure stack is not empty before popping
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        // Convert stack contents to a string
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}