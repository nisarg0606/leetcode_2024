class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length <= 2) {
            return Integer.valueOf(tokens[0]);
        }
        Stack<String> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                if (tokens[i].equals("+"))
                    result = a + b;
                if (tokens[i].equals("-"))
                    result = b - a;
                if (tokens[i].equals("*"))
                    result = a * b;
                if (tokens[i].equals("/"))
                    result = b / a;
                stack.push(String.valueOf(result));
            } else {
                stack.push(tokens[i]);
            }
        }

        return result;
    }
}