class Solution {
    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        char[] arr = s.toCharArray();
        while (left < right) {
            if (isVowel(arr[left]) && isVowel(arr[right])) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } else if (isVowel(arr[left])) {
                right--;
            } else {
                left++;
            }
        }
        return new String(arr);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}