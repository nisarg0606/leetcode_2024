class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int count = 0;
        Integer numArray[] = nums.toArray(new Integer[0]);
        for (int i = 0; i < numArray.length; i++) {
            for (int j = numArray.length - 1; j > i; j--) {
                    if (numArray[i] + numArray[j] < target)
                        count++;
            }
        }
        return count;
    }
}