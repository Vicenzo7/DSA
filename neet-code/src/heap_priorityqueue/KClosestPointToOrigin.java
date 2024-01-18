package heap_priorityqueue;

import java.util.*;

public class KClosestPointToOrigin {
    public static void main(String[] args) {
//        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int[][] points = {{0, 1}, {1, 0}};
        int k = 2;
        System.out.println(Arrays.deepToString(kClosest(points, k)));
        System.out.println(Arrays.deepToString(kClosestOptimised(points, k)));
        System.out.println(Arrays.deepToString(kClosestOptimisedUsingMaxHeap(points, k)));
    }


    /*
        TC = O(n.log(n))
        SC = O(n) + O(n) -> map and heap = O(n)

    */

    public static int[][] kClosest(int[][] points, int k) {

        Map<Double, List<int[]>> distanceToPointMap = new HashMap<>();
        PriorityQueue<Double> minHeap = new PriorityQueue<>();

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            double distance = Math.sqrt(x * x + y * y);
            distanceToPointMap.computeIfAbsent(distance, key -> new ArrayList<>()).add(point);
            minHeap.offer(distance);
        }

        int[][] result = new int[k][2];
        int counter = 0;
        while (counter < k) {
            Double distance = minHeap.poll();
            List<int[]> pointsList = distanceToPointMap.get(distance);
            for (int[] point : pointsList) {
                result[counter++] = point;
                if (counter == k) break;
            }
        }

        return result;
    }


    /*
        TC = O(nlog(n))

        First solution Time Complexity is O(NlogN)
        Just take a min heap and add the values using the formula and return the top k values
        We can completely ignore the square root as we are just comparing the values (if a*a>b*b => a>b)
    */

    public static int[][] kClosestOptimised(int[][] points, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0] * o[0] + o[1] * o[1])
        );

        for (int[] point : points) {
            minHeap.offer(point);
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }

    /*
        This approach is a sightly optimized approach here we can use a max heap and maintain its size as k.
        So when we do the removal the time complexity will reduce from logn to logk
        Max heap because we will remove the top elements (the one which are greater)
        Overall Time complexity O(NlogK)

        log(k) -> because in heap push and pop takes log(n) where n is the height of the tree
        and here the height of the tree is k.
    */

    public static int[][] kClosestOptimisedUsingMaxHeap(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) ->
                Integer.compare(o2[0] * o2[0] + o2[1] * o2[1],
                        o1[0] * o1[0] + o1[1] * o1[1])
        );

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
