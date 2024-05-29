public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf poaes = new ProductOfArrayExceptSelf();
        int[] nums = { 1, 2, 3, 4, 5 };
        int[] res = poaes.productExceptSelf(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
        nums = new int[] { -1, 1, 0, -3, 3 };
        res = poaes.productExceptSelf(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
