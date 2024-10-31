class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        if (maxIndex == n - 1 || maxIndex == 0) {
            return false;
        }
        for (int i = maxIndex; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                continue;
            } else {
                return false;
            }
        }

        for (int i = maxIndex; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}