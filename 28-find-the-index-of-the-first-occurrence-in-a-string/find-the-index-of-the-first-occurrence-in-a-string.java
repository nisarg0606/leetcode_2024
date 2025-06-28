class Solution {
    public int strStr(String haystack, String needle) {
        int j = 0;
        //9 - 3 = 6 
        //aadbutsaa sad
        //sadbutsad sad
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            String temp = haystack.substring(i, i + needle.length());
            if(temp.equals(needle)){
                return i;
            }
        }
        return -1;
    }
}