class Solution {
    public String makeFancyString(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < sb.length() - 2; i++){
            if((sb.charAt(i) == sb.charAt(i+1)) && (sb.charAt(i+2) == sb.charAt(i+1))){
                sb.deleteCharAt(i);
                i--;
            }
        }
        return sb.toString();
    }
}