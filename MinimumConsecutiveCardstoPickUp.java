import java.util.HashMap;
import java.util.Map;

public class MinimumConsecutiveCardstoPickUp {
    /* Initial Solution
     * class Solution {
     * public int minimumCardPickup(int[] cards) {
     * Set<Integer> mySet =
     * Arrays.stream(cards).boxed().collect(Collectors.toSet());
     * if (mySet.size() == cards.length) {
     * return -1;
     * }
     * int minimum = Integer.MAX_VALUE;
     * int start = 0, end = 0;
     * while (end < cards.length) {
     * if (mySet.contains(cards[end])) {
     * mySet.remove(cards[end]);
     * end += 1;
     * } else {
     * minimum = Math.min(minimum, end - start + 1);
     * mySet.add(cards[start]);
     * start += 1;
     * }
     * }
     * return minimum;
     * }
     * }
     */
    // GOT TLE
    // public int minimumCardPickup(int[] cards) {
    // int min = Integer.MAX_VALUE;
    // for (int i = 0; i < cards.length; i++) {
    // for (int j = i + 1; j < cards.length; j++) {
    // if (cards[i] == cards[j]) {
    // min = Math.min(min, j - i + 1);
    // }
    // }
    // }
    // return min == Integer.MAX_VALUE ? -1 : min;
    // }

    public int minimumCardPickup(int[] cards) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])) {
                min = Math.min(min, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i], i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        MinimumConsecutiveCardstoPickUp minimumConsecutiveCardstoPickUp = new MinimumConsecutiveCardstoPickUp();
        System.out.println(minimumConsecutiveCardstoPickUp.minimumCardPickup(new int[] { 1, 2, 4, 4, 2, 3, 1 }));
        System.out.println(minimumConsecutiveCardstoPickUp.minimumCardPickup(new int[] { 3, 4, 2, 3, 4, 7 }));
        System.out.println(minimumConsecutiveCardstoPickUp.minimumCardPickup(new int[] { 1, 0, 5, 3 }));
    }
}
