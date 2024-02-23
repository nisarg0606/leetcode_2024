class Solution {
    public int[][] merge(int[][] intervals) {
        // Custom sorting using lambda expression where a[0] is the start of the
        // interval and b[0] is the start of the next interval
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // List to store the result of type int[] for merged intervals
        List<int[]> result = new ArrayList<>();
        // Add the first interval to the list
        int[] newInterval = intervals[0];
        result.add(newInterval);
        // Iterate through the intervals and merge if necessary
        for (int[] interval : intervals) {
            // If the start of the next interval is less than or equal to the end of the new
            // interval then merge
            if (interval[0] <= newInterval[1]) {
                // Set the end of the new interval to the maximum of the end of the new interval
                // and the end of the current interval
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // If the start of the next interval is greater than the end of the new interval
                // then add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }
        // Convert the list to an array and return the result
        return result.toArray(new int[result.size()][]);
    }
}