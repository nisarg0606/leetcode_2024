public class FindtheIndexoftheFirstOccurrenceinaString {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        char c = needle.charAt(0);
        if(haystack.contains(needle)){
            for(int i = 0; i <= haystack.length() - needle.length(); i++){
                if(haystack.charAt(i) == c){
                    System.out.println(haystack.substring(i, i + needle.length()));
                    if(haystack.substring(i, i + needle.length()).equals(needle)){
                        return i;
                    }
                }
            }
        }else{
            return -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindtheIndexoftheFirstOccurrenceinaString fio = new FindtheIndexoftheFirstOccurrenceinaString();
        String haystack = "hello";
        String needle = "ll";
        System.out.println(fio.strStr(haystack, needle));
        haystack = "sadbutsad";
        needle = "sad";
        System.out.println(fio.strStr(haystack, needle));
    }
}
