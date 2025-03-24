import java.util.*;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0])); // Sort by start day

        int occupiedDays = 0;
        int prevEnd = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            // If there's a gap between previous meeting and current meeting, count free days
            if (start > prevEnd + 1) {
                occupiedDays += (end - start + 1);
            } else { // Merge overlapping meetings
                end = Math.max(prevEnd, end);
                occupiedDays += (end - prevEnd);
            }

            prevEnd = end; // Update last meeting end
        }

        return days - occupiedDays;
    }
}

