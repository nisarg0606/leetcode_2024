class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = Integer.MIN_VALUE, count = 0;
        for(int value: map.values()){
            if(value > max){
                max = value;
            }
        }
        for(int value: map.values()){
            if(max == value)
                count+=max;
        }
        return count;
    }
}