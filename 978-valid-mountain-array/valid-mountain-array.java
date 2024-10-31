class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        for (int i = maxIndex; i > 0; i--) {
            if (maxIndex == arr.length - 1 || maxIndex == 0) {
                return false;
            }
            if (arr[i] > arr[i - 1]) {
                continue;
            } else {
                return false;
            }
        }

        for (int i = maxIndex; i < arr.length - 1; i++) {
            if (maxIndex == arr.length - 1 || maxIndex == 0) {
                return false;
            }
            if (arr[i] > arr[i + 1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}