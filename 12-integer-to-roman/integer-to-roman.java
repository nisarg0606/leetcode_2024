class Solution {
    public String intToRoman(int num) {
        /*
            1 - I, 4 - IV, 5 - V, 9 - IX, 10 - X, 40 - XL, 50 - L, 
            90 - XC, 100 - C, 400 - CD, 500 - D, 900 - CM, 1000 - M
        */
        String[] romanNumerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
                "IX", "V", "IV", "I" };
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        StringBuilder romanString = new StringBuilder();

        for (int i = 0; i < romanNumerals.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                romanString.append(romanNumerals[i]);
            }
        }
        return romanString.toString();
    }
}