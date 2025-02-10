class Solution {
    public String clearDigits(String s) {
        // Stack<Character> stack = new Stack<>();

        // for (char c : s.toCharArray()) {
        // if (Character.isDigit(c)) {
        // if (!stack.isEmpty()) {
        // stack.pop();
        // }
        // } else {
        // stack.push(c);
        // }
        // }
        // StringBuilder result = new StringBuilder();
        // for (char c : stack) {
        // result.append(c);
        // }

        // return result.toString();

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) && answer.length() != 0) {
                answer.setLength(answer.length() - 1);
            } else {
                answer.append(s.charAt(i));
            }
        }

        return answer.toString();
    }
}