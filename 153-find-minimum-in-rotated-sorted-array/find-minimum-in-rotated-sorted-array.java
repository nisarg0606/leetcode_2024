// class Solution {
//     public int findMin(int[] nums) {
//         if (nums.length == 1)
//             return nums[0];

//         int left = 0, right = nums.length - 1;

//         if (nums[right] > nums[0])
//             return nums[0];

//         while (right >= left) {
//             int mid = left + (right - left) / 2;

//             if (nums[mid] > nums[mid + 1])
//                 return nums[mid + 1];

//             if (nums[mid - 1] > nums[mid])
//                 return nums[mid];

//             if (nums[mid] > nums[0])
//                 left = mid + 1;

//             else
//                 right = mid - 1;
//         }

//         return Integer.MAX_VALUE;
//     }
// }

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;

        // This means array is already sorted
        if (nums[right] > nums[0]) {
            return nums[0];
        }

        while (right >= left) {
            int middle = left + (right - left) / 2;

            if (nums[middle] > nums[middle + 1]) {
                return nums[middle + 1];
            }

            if (nums[middle - 1] > nums[middle])
                return nums[middle];

            if (nums[middle] > nums[0]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }

        }
        return Integer.MAX_VALUE;
    }
}