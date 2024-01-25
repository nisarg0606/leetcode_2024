public class SumOfDistances {
    public long[] distance(int[] nums) {
        int sum = 0;
        long arr[] = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                } else if (nums[i] == nums[j]) {
                    sum = sum + Math.abs(i - j);
                }
            }
            arr[i] = sum;
            sum = 0;
        }
        return arr;
    }

    public static void main(String[] args) {
        SumOfDistances sod = new SumOfDistances();
        int[] nums = { 1, 3, 1, 1, 2 };
        long[] result = sod.distance(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
