public class Winner_Test {
    public static String winner(String erica, String bob){
        int ericaScore = 0;
        int bobScore = 0;
        for(int i = 0; i < erica.length(); i++){
            if(erica.charAt(i) == 'E'){
                ericaScore += 1;
            } else if(erica.charAt(i) == 'M'){
                ericaScore += 3;
            } else if(erica.charAt(i) == 'H'){
                ericaScore += 5;
            }
        }
        for(int i = 0; i < bob.length(); i++){
            if(bob.charAt(i) == 'E'){
                bobScore += 1;
            } else if(bob.charAt(i) == 'M'){
                bobScore += 3;
            } else if(bob.charAt(i) == 'H'){
                bobScore += 5;
            }
        }
        if(ericaScore > bobScore){
            return "Erica";
        } else if(bobScore > ericaScore){
            return "Bob";
        } else {
            return "Tie";
        }
    }
}
