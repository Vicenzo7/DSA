package intervals;

import java.util.*;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
        System.out.println(Arrays.deepToString(insertOptimised(intervals, newInterval)));
    }


    public static int[][] insert(int[][] intervals, int[] newInterval) {
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> (o[0])));
        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            minHeap.offer(interval);
        }
        minHeap.offer(newInterval);

        int[] peek = minHeap.peek();
        int previousStart = peek[0];
        int previousEnd = peek[1];

        while (!minHeap.isEmpty()) {
            int[] currentInterval = minHeap.poll();
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];

            if (previousEnd >= currentStart) {
                previousEnd = Math.max(previousEnd, currentEnd);
            } else {
                result.add(new int[]{previousStart, previousEnd});
                previousStart = currentStart;
                previousEnd = currentEnd;
            }
        }

        result.add(new int[]{previousStart, previousEnd});

        return result.toArray(new int[0][]);
    }



    /*
        We know that intervals are sorted according to the start
        Iterate the intervals
        1. Now check if the newInterval lies in the left, right or gets merged
        2. if the newInterval lies in the right, then add the current interval to the result
        3. if the newInterval lies in the left, then add the newInterval to the result then add the current interval,
        and make the new interval now a null, and add the remaining interval
        4. if the newInterval does not lie to the left or right, that means it getting overlapped so merge the newInterval with
        the current interval. Don't add the merged interval,because it might be overlapping with the further intervals

        5. after the iteration add the remaining interval
    */


    public static int[][] insertOptimised(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        for (int[] currentInterval : intervals) {
            // means new interval lies at right
            if (newInterval == null || newInterval[0] > currentInterval[1]) {
                result.add(currentInterval);
            } else if (newInterval[1] < currentInterval[0]) { // means new interval lies at left
                result.add(newInterval);
                result.add(currentInterval);
                newInterval = null;
            } else { // newInterval is overlapping with currentInterval, so we merge it
                newInterval[0] = Math.min(newInterval[0], currentInterval[0]);
                newInterval[1] = Math.max(newInterval[1], currentInterval[1]);
            }
        }
        if (newInterval != null) {
            result.add(newInterval);
        }
        return result.toArray(new int[0][]);
    }
}
