class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char sArray[] = s.toCharArray();
        Arrays.sort(sArray);
        char tArray[] = t.toCharArray();
        Arrays.sort(tArray);
        for(int i = 0; i < s.length(); i++){
            if(sArray[i] == tArray[i])
                continue;
            else
                return false;
        }
        return true;
    }
}