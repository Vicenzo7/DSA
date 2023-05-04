package array.hard;

import java.util.*;

public class MergeOverLappingSubIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}};

        System.out.println(Arrays.deepToString(merge(intervals)));
        System.out.println(Arrays.deepToString(mergeOptimal(intervals)));
    }

    /*
        First we will sort the array as we need to merge the overlapping intervals
        In this approach we need a stack that contains the interval [1,3], [2,6]
        Initially we will insert the first interval in the stack
        Now we iterate from the 1 row
        lets say intervals = [[1,7],[2,6],[8,10],[15,18]]

        now our startPoint2 = 2, and endPoint2 = 6
        We pop out the interval inserted
        and startPoint1 = 1 and endPoint2 = 7
        step1 :now we check if endPoint1 >= startPoint2, if this satisfies we merge the intervals
        new merged interval [1,6] this is wrong, the correct is [1,7],
        so we need to take max of both end point, maxEnd = Math.max(endPoint1,endPoint2);
        and the new merged interval will be [startPoint1,maxEnd]

        if step1 doesn't satisfy we simply add the popped interval and the current interval

        TC = O(nlog(n) + O(n)
        Reason : We are sorting the 2D array and, also traversing the 2D array but only the row part

        SC = O(n) + O(n*m) where n = no 0f rows
        Reason: We are storing the result in a new 2D array, and we are also storing the row in the set

    */

    public static int[][] merge(int[][] intervals) {
        // sort the 2D array
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> stack = new Stack<>();
        // initially add the first row of intervals into the stack, so we can later consider it as previousInterval or row
        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currentRow = intervals[i];
            int startPoint2 = currentRow[0];
            int endPoint2 = currentRow[1];

            int[] previousRow = stack.pop();
            int startPoint1 = previousRow[0];
            int endPoint1 = previousRow[1];

            int maxEndPoint = Math.max(endPoint1, endPoint2);

            if (endPoint1 >= startPoint2) { // this means a merging interval exist
                int[] mergedInterval = new int[]{startPoint1, maxEndPoint};
                stack.push(mergedInterval);
            } else {
                stack.push(previousRow);
                stack.push(currentRow);
            }
        }

        int[][] result = new int[stack.size()][2];

        // inserting element from backwards, as stack will pop intervals from descending order
        for (int i = result.length - 1; i >= 0; i--) {
            int[] row = stack.pop();
            result[i][0] = row[0];
            result[i][1] = row[1];
        }

        return result;
    }

    /*
        Optimal Approach here we will reduce the space complexity,we will eliminate the stack that is being used
        1.First Sort the array
        2.We need a List to store row(int[])
        3.Declare two variables
            startPoint = intervals[0][0]
            endPoint = intervals[0][1]
        4. Iterate the intervals 2D array and fetch a row at each iteration and check
            if(endPoint >= row[0] -> this means merging interval exits so update the endPoint by taking the max of endPoint
            and row[1].
            If merging point doesn't exist store the interval [startPoint,endPoint] in results and update the startPoint
            and the endPoint

        5. After the iteration again add the interval to the result [startPoint,endPoint]
        6. Return the result;

        TC = O(nlog(n)) +O(n)
        Reason: O(nlog(n)) to sort the array , O(n) to traverse the array

        SC = O(n) -> to store the answer
    */


    public static int[][] mergeOptimal(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        // sort the 2D array
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int startPoint = intervals[0][0];
        int endPoint = intervals[0][1];

        for (int[] row : intervals) {
            if (endPoint >= row[0]) { // this check if a merging interval exist.
                // update the endPoint
                endPoint = Math.max(endPoint, row[1]);
            } else {
                result.add(new int[]{startPoint, endPoint});
                startPoint = row[0];
                endPoint = row[1];
            }
        }
        // adding the last interval
        result.add(new int[]{startPoint, endPoint});
        return result.toArray(new int[0][]);
    }
}
