class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int currentBottles = numBottles;
        int emptyBottles = 0;
        int totalBottles = 0;

        while (currentBottles > 0) {
            totalBottles += currentBottles;
            emptyBottles += currentBottles;
            currentBottles = emptyBottles / numExchange;
            emptyBottles = emptyBottles % numExchange;
        }

        return totalBottles;
    }
}