public class MinLengthSubArray {
    public int minLengthSubArray(int arr[], int x){
        int minLength = Integer.MAX_VALUE;
        int start = 0, end = 0, current_sum = 0;
        while(end < arr.length){
            current_sum = current_sum + arr[end];
            end = end + 1;

            while(start < end && current_sum >= x){
                current_sum = current_sum - arr[start];
                start += 1;
                minLength = Math.min(minLength, end-start+1);
            }
        }
        return minLength;
    }
}
