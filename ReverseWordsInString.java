public class ReverseWordsInString{
    public String reverseWords(String s){
        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split(" +");
        for(int i = words.length - 1; i >= 0; i--){
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) {
        ReverseWordsInString rws = new ReverseWordsInString();
        System.out.println(rws.reverseWords("a good   example"));
    }
}