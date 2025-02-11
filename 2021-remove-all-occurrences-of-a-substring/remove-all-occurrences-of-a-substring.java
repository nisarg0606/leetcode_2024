class Solution {
    public String removeOccurrences(String s, String part) {
        // Brute - force using inbuild methods

        // while (s.contains(part)) {
        // int partStartIndex = s.indexOf(part);

        // s = s.substring(0, partStartIndex) + s.substring(partStartIndex +
        // part.length());
        // }

        // return s;

        // Optimize it using Stack
        Stack<Character> stack = new Stack<>();
        int strLength = s.length();
        int partLength = part.length();

        for (int i = 0; i < strLength; i++) {
            stack.push(s.charAt(i));

            if (stack.size() >= partLength && checkMatch(stack, part, partLength)) {
                for (int j = 0; j < partLength; j++) {
                    stack.pop();
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse();

        return result.toString();
    }

    private boolean checkMatch(Stack<Character> stack, String part, int partLength) {
        Stack<Character> tempStack = new Stack<>();
        tempStack.addAll(stack);

        for (int i = partLength - 1; i >= 0; i--) {
            if (tempStack.isEmpty() || tempStack.peek() != part.charAt(i)) {
                return false;
            }
            tempStack.pop();
        }
        return true;
    }
}