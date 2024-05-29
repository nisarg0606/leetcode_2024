/*
 * Write a program, using any language with which you are comfortable, that takes a number N, then accepts some text and outputs lines of text, where the output lines have as many words as possible but are never longer than N characters. Words may not be split, but you may assume that no single word is too long for a line. If a line would begin with a blank space, you may ignore that space. 


For example: ./Telegram 15 "The quick brown fox jumped over the lazy dog"

will output:


The quick brown
fox jumped over
the lazy dog


Requirements
  * If you choose a language where the code dictates the name of output (for example, Java classes), you must name your objects such that the resulting binary / machine code will be named "Telegram"
  * The provided answer must run / compile as is, with no modifications. This means that all external libraries that may need to be added / included / used should be present.
  * All parameters must be passed in as command line arguments, as shown in the example above.
  * The provided solution must not rely on user input.
  * All code must begin with a comment indicating the language.
 */
package bloom;

public class Telegram {
    public static void main(String[] args){
        // we take the args first as N and text
        int n = Integer.parseInt(args[0]);
        String text = args[1];
        // here we will split words by space
        String[] words = text.split(" ");
        // we create a StringBuilder to store the words
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            // If the length of the StringBuilder + length of word is greater then we print the current line and then reset the StringBuilder
            if(sb.length() + words[i].length() > n){
                System.out.println(sb.toString().trim());
                sb = new StringBuilder();
            }
            sb.append(words[i]).append(" "); // here we add the current word
        }
        // Finally we will print the last line
        System.out.println(sb.toString().trim());
    }
}
