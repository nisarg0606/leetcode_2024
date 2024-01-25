// import java.util.Arrays;
// import java.util.stream.IntStream;

// public class TwoSumIIInputArrayIsSorted {
//     public int[] twoSum(int[] numbers, int target) {
//         int[] result = new int[2];
//         for (int i = 0; i < numbers.length; i++) {
//             int[] temp = Arrays.copyOfRange(numbers, i + 1, numbers.length);
//             int index = IntStream.range(0, temp.length).filter(j -> temp[j] == target - numbers[i]).findFirst()
//                     .orElse(-1);
//             if (index != -1) {
//                 result[0] = i + 1;
//                 result[1] = index + i + 2;
//                 break;
//             }
//         }
//         return result;
//     }
// }
