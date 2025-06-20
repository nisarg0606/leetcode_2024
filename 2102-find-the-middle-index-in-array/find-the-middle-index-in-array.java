class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int leftSide = 0;
        for(int i = 0; i < n; i++){
            int rigtSide = sum - nums[i] - leftSide;

            if(leftSide == rigtSide){
                return i;
            }

            leftSide += nums[i];
        }
        return -1;
    }
}