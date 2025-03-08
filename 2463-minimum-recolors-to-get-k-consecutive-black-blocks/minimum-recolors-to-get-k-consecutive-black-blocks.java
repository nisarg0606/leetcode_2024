
import static java.lang.Integer.min;

class Solution {

    public int minimumRecolors(String blocks, int k) {
        // Queue<Character> blockQueue = new LinkedList<>();
        // int numWhites = 0;

        // // Initiate queue with first k values
        // for (int i = 0; i < k; i++) {
        // char currentChar = blocks.charAt(i);
        // if (currentChar == 'W') numWhites++;
        // blockQueue.add(currentChar);
        // }

        // // Set initial minimum
        // int numRecolors = numWhites;

        // for (int i = k; i < blocks.length(); i++) {
        // // Remove front element from queue and update current number of white blocks
        // if (blockQueue.poll() == 'W') numWhites--;

        // // Add current element to queue and update current number of white blocks
        // char currentChar = blocks.charAt(i);
        // if (currentChar == 'W') numWhites++;
        // blockQueue.add(currentChar);

        // // Update minimum
        // numRecolors = Math.min(numRecolors, numWhites);
        // }
        // return numRecolors;
        int n = blocks.length();
        int black = 0, min_recoloring = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            if (blocks.charAt(i) == 'B') {
                black++;
            }
            if (i >= k - 1) {
                min_recoloring = min(k - black, min_recoloring);
                if (blocks.charAt(i - k + 1) == 'B')
                    black--;
            }
        }

        return min_recoloring;
    }
}