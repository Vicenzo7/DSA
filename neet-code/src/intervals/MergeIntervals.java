package intervals;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {

        int[][] intervals = {{1, 3},
                {2, 6},
                {8, 10},
                {15, 18}};
        System.out.println(Arrays.deepToString(mergeOptimised(intervals)));
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] mergeOptimised(int[][] intervals) {

        List<int[]> result = new ArrayList<>();

        // sort the array
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int previousStart = intervals[0][0];
        int previousEnd = intervals[0][1];

        for (int[] row : intervals) {
            int currentStart = row[0];
            int currentEnd = row[1];
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

    public static int[][] merge(int[][] intervals) {

        Stack<int[]> stack = new Stack<>();

        // sort the array
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] previousInterval = stack.pop();
            int previousStart = previousInterval[0];
            int previousEnd = previousInterval[1];

            int[] currentInterval = intervals[i];
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];

            int maxEndPoint = Math.max(previousEnd, currentEnd);

            if (previousEnd >= currentStart) {
                stack.push(new int[]{previousStart, maxEndPoint});
            } else {
                stack.push(previousInterval);
                stack.push(currentInterval);
            }
        }

        int[][] result = new int[stack.size()][];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
