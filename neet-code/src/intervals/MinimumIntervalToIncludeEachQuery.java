package intervals;

import java.util.*;

public class MinimumIntervalToIncludeEachQuery {
    public static void main(String[] args) {
        int[][] intervals = {{1, 4},
                {2, 4},
                {3, 6},
                {4, 4}};
        int[] queries = {2, 3, 4, 5};

        System.out.println(Arrays.toString(minInterval(intervals, queries)));
    }


    /*
        You are given a 2D integer array intervals, where intervals[i] = [lefti, righti] describes the ith interval starting at lefti and ending at righti (inclusive).
        The size of an interval is defined as the number of integers it contains, or more formally righti - lefti + 1.

        You are also given an integer array queries. The answer to the jth query is the size of the smallest interval i such that lefti <= queries[j] <= righti.
        If no such interval exists, the answer is -1.

        Return an array containing the answers to the queries.


    */

    public static int[] minInterval(int[][] intervals, int[] queries) {

        // Sort intervals by start
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        // we also need to sort the queries, before sorting keep a track of the query order, because answer should be in query order
        List<Integer> sortedQueryIndex = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            sortedQueryIndex.add(i);
        }

        // index of sorted queries
        sortedQueryIndex.sort(Comparator.comparingInt(o -> queries[o]));

        // A Priority Queue that stores (interval) sorted by size in ascending order, if size is equal then  sorted by end of interval
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            int size = getIntervalSize(o1);
            int size1 = getIntervalSize(o2);
            if (size != size1) {
                return Integer.compare(size, size1);
            }
            return Integer.compare(o1[1], o2[1]);
        });


        int[] result = new int[queries.length];

        int idx = 0;
        // iterate the sorted queries
        for (Integer queryIndex : sortedQueryIndex) {
            // extract the query
            int query = queries[queryIndex];
            // now add all the possible interval where interval[left] <= query
            while (idx < intervals.length && intervals[idx][0] <= query) {
                queue.add(intervals[idx]);
                idx++;
            }

            // now remove all the intervals from the queue, where the query cannot be in that interval
            while (!queue.isEmpty() && queue.peek()[1] < query) {
                queue.poll();
            }

            // now fetch the result;
            result[queryIndex] = queue.isEmpty() ? -1 : getIntervalSize(queue.peek());
        }

        return result;

    }

    public static int getIntervalSize(int[] interval) {
        return interval[1] - interval[0] + 1;
    }
}
