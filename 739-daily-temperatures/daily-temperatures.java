// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         int n = temperatures.length;
//         int[] answer = new int[n];
//         for (int i = 0; i < n; i++) {
//             int count = 1, flag = 0;
//             for (int j = i + 1; j < n; j++) {
//                 if (temperatures[i] < temperatures[j]) {
//                     answer[i] = count;
//                     flag = 1;
//                     break;
//                 } else {
//                     count++;
//                 }
//             }
//             if (flag == 0) {
//                 answer[i] = 0;
//             }
//         }

//         return answer;
//     }
// }

// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         int n = temperatures.length;
//         int[] answer = new int[n];

//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (temperatures[i] < temperatures[j]) {
//                     answer[i] = j - i;
//                     break;
//                 }
//             }
//         }
//         return answer;
//     }
// }

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                answer[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return answer;
    }
}