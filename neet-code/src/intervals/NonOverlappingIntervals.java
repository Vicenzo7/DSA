package intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };

        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int previousEnd = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];

            // check if the interval overlap and if they overlap, we will remove the one which ends last
            // as this creates fewer chances of intervals to overlap further after merging
            if (previousEnd > currentStart) {
                // overlapping so we will remove the interval which ends first
                count++;
                previousEnd = Math.min(previousEnd, currentEnd);
            } else { // not overlapping
                previousEnd = currentEnd;
            }
        }
        return count;
    }
}
