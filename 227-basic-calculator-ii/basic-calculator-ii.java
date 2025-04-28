class Solution {
    public int calculate(String s) {
        s = s.trim();
        int num = 0;
        char lastOperator = '+';
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == n - 1) {
                if (lastOperator == '+') {
                    stack.push(num);
                } else if (lastOperator == '-') {
                    stack.push(-num);
                } else if (lastOperator == '*') {
                    int temp = stack.pop();
                    temp = temp * num;
                    stack.push(temp);
                } else if (lastOperator == '/') {
                    int temp = stack.pop();
                    temp = temp / num;
                    stack.push(temp);
                }
                lastOperator = ch;
                num = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty())
            result += stack.pop();
        return result;
    }
}