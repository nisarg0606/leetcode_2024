class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int digitCount = 0;
            while(nums[i] > 0){
                int temp = nums[i] % 10;
                digitCount++;
                nums[i] = nums[i] / 10;
            }
            if(digitCount % 2 == 0)
            {
                count++;
            }
        }
        return count;
    }
}