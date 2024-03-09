class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Byte, Byte> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            map.put((byte) nums[i], (byte) (map.getOrDefault((byte) nums[i], (byte) 0) + 1));
        }
        byte max = 0, count = 0;
        for(byte value: map.values()){
            if(value > max){
                max = value;
            }
        }
        for(byte value: map.values()){
            if(max == value)
                count+=max;
        }
        return count;
    }
}