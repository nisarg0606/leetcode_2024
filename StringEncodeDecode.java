import java.util.ArrayList;
import java.util.List;

public class StringEncodeDecode {
    public String encode(List<String> strs) {
        // encode the list of strings into a single string
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('_').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        // decode the single string back into the list of strings
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int underscore = str.indexOf('_', i);
            int size = Integer.parseInt(str.substring(i, underscore));
            res.add(str.substring(underscore + 1, underscore + 1 + size));
            i = underscore + 1 + size;
        }
        return res;
    }
}
