public class RemoveDigitFromNumbertoMaximizeResult {
    public String removeDigit(String number, char digit) {
        StringBuilder sb = new StringBuilder(number);
        int last = number.indexOf(digit);
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                last = i;
                if (i != number.length() - 1) {
                    if (Character.getNumericValue(number.charAt(i + 1)) > Character.getNumericValue(number.charAt(i))) {
                        sb.deleteCharAt(i);
                        return sb.toString();
                    }
                }
            }
        }
        return sb.deleteCharAt(last).toString();
    }

    public static void main(String[] args) {
        RemoveDigitFromNumbertoMaximizeResult removeDigitFromNumbertoMaximizeResult = new RemoveDigitFromNumbertoMaximizeResult();
        System.out.println(removeDigitFromNumbertoMaximizeResult.removeDigit("123", '3'));
        System.out.println(removeDigitFromNumbertoMaximizeResult.removeDigit("1231", '1'));
        System.out.println(removeDigitFromNumbertoMaximizeResult.removeDigit("551", '5'));
        System.out.println(removeDigitFromNumbertoMaximizeResult.removeDigit("73197", '7'));
    }
}

/*
 * Elegant Solution 0 ms
 */


// class Solution {
//     public String removeDigit(String number, char digit) {
//         int n = number.length(), last = -1;
//         for(int i=0; i<n; i++) {
//             if(number.charAt(i) == digit) {
//                 last = i;
//                 if(i+1< n && number.charAt(i+1) > digit)
//                     return number.substring(0,i)+number.substring(i+1,n);
//         }
//         }
        
//         return number.substring(0,last)+number.substring(last+1,n);
//     }
// }