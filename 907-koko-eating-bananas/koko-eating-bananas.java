class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = getMax(piles);

        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = totalHours(piles, mid);

            if (hours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        return max;
    }

    private int totalHours(int[] piles, int k) {
        int total = 0;
        for (int pile : piles) {
            total += Math.ceil((double) pile / k);
        }
        return total;
    }
}