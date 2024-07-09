class Solution {
    public double averageWaitingTime(int[][] customers) {
        double average = 0;
        int n = customers.length;
        int time = 0;
        for (int i = 0; i < n; i++) {
            int arrival = customers[i][0];
            int duration = customers[i][1];
            if (time < arrival) {
                time = arrival;
            }
            time += duration;
            average += time - arrival;
        }
        return average / n;
    }
}