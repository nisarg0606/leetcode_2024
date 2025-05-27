class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // Check if the token is an operator using just the first character
            if (token.length() == 1) {
                char c = token.charAt(0);
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    int b = stack.pop();
                    int a = stack.pop();

                    switch (c) {
                        case '+':
                            stack.push(a + b);
                            break;
                        case '-':
                            stack.push(a - b);
                            break;
                        case '*':
                            stack.push(a * b);
                            break;
                        case '/':
                            stack.push(a / b);
                            break;
                    }
                    continue;
                }
            }

            // If not an operator, parse and push the number
            stack.push(Integer.parseInt(token));
        }

        return stack.pop();
    }
}