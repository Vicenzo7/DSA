package company.blackBuck;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    public static void main(String[] args) {
        int n = 5;
        long[] arr = {4, 3, 2, 6};

        System.out.println(minCost(arr, n));
    }

    public static long minCost(long[] arr, int n) {
        long cost = 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        for (long a : arr) {
            minHeap.add(a);
        }

        while (minHeap.size() != 1) {
            Long a = minHeap.remove();
            Long b = minHeap.remove();
            cost += a + b;

            minHeap.add(a + b);
        }

        return cost;

    }


}
