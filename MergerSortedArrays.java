/**
 * MergerSortedArrays
 */
public class MergerSortedArrays {

    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    // StringBuffer sb = new StringBuffer();
    // int i = 0, j = 0;
    // while (i < m && j < n) {
    // if (nums1[i] < nums2[j]) {
    // sb.append(nums1[i]);
    // i++;
    // }else{
    // sb.append(nums2[j]);
    // j++;
    // }
    // }
    // for(i = 0; i < nums1.length; i++){
    // if (i < sb.length()) {
    // nums1[i] = Integer.parseInt(sb.charAt(i)+"");
    // }else{
    // nums1[i] = 0;
    // }
    // }

    public void merge(int nums1[], int m, int nums2[], int n) {
        int index = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[index] = nums1[m - 1];
                m--;
            } else {
                nums1[index] = nums2[n - 1];
                n--;
            }
            index--;
        }

    }

    public static void main(String[] args) {
        MergerSortedArrays msa = new MergerSortedArrays();
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        msa.merge(nums1, 3, nums2, 3);
    }
}