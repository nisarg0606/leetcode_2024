class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (!isOperator(token)) {
                stack.push(token);
            } else {
                int x = Integer.parseInt(stack.pop());
                int y = Integer.parseInt(stack.pop());
                int result = performOperation(y, x, token);
                stack.push(Integer.toString(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public int performOperation(int x, int y, String operator) {
        switch (operator) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
            default:
                throw new IllegalArgumentException();
        }
    }
}