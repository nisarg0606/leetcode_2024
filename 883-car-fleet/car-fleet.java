import java.util.Arrays;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            time[i] = (double) (target - cars[i][0]) / cars[i][1];
        }
        int fleet = 0;
        double currentFleetTime = 0;

        for (int i = 0; i < n; i++) {
            if (time[i] > currentFleetTime) {
                fleet++;
                currentFleetTime = time[i];
            }
        }

        return fleet;
    }
}