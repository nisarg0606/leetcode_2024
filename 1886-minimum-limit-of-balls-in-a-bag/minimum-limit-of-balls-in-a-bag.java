class Solution {

    private boolean canAssign(List<Integer> num, int maxVal, int operations){
        int count = 0;
        for (int element : num) {
            if(element > maxVal){
                count += (int) Math.ceil((double) (element - maxVal) / maxVal);
            }
        }
        return count <= operations;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = Arrays.stream(nums).max().orElse(0);
        int result = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canAssign(Arrays.stream(nums).boxed().collect(Collectors.toList()), mid, maxOperations)){
                result = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }
}