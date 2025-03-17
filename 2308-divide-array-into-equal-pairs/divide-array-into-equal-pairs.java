class Solution {
    public boolean divideArray(int[] nums) {
        // Arrays.sort(nums);
        // for(int i = 0; i < nums.length; i+=2){
        // if(nums[i] != nums[i+1]) return false;
        // }
        // return true;

        int[] freq = new int[501];
        for (int i : nums)
            freq[i]++;

        for (int count : freq)
            if (count % 2 != 0)
                return false;

        return true;
    }
}