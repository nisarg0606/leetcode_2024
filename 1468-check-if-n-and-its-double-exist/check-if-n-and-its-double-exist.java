class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            for(int j = 1; j < arr.length; j++){
                if(arr[i] == 2*arr[j] && i != j){
                    return true;
                }
            }
        }
        return false;
    }
}