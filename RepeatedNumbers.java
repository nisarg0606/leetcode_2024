public class RepeatedNumbers {
    public int[] repeatedNumber(final int[] A) {
        // int[] result = new int[2];
        // int[] count = new int[A.length + 1];
        // for (int i = 0; i < A.length; i++) {
        //     count[A[i]]++;
        // }
        // for (int i = 1; i < count.length; i++) {
        //     if (count[i] == 2) {
        //         result[0] = i;
        //     } else if (count[i] == 0) {
        //         result[1] = i;
        //     }
        // }
        // return result;
        //implement mergesort
        int[] result = new int[2];
        mergeSort(A, 0, A.length - 1);
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                result[0] = A[i];
                break;
            }
        }
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        int n = A.length;
        int total = (n * (n + 1)) / 2;
        result[1] = total - (sum - result[0]);
        return result;
    }

    public void mergeSort(int[] A, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(A, start, mid);
            mergeSort(A, mid + 1, end);
            merge(A, start, mid, end);
        }
    }

    public void merge(int[] A, int start, int mid, int end) {
        int[] temp = new int[A.length];
        int i = start, j = mid + 1, k = start;
        while (i <= mid && j <= end) {
            if (A[i] < A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = A[i++];
        }
        while (j <= end) {
            temp[k++] = A[j++];
        }
        for (int l = start; l <= end; l++) {
            A[l] = temp[l];
        }
    }
}
