package graph.advance_problems;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}};
        int src = 0, dst = 3, k = 1;

//        int n = 3;
//        int[][] flights = {{0, 1, 100},
//                {1, 2, 100},
//                {0, 2, 500}};
//        int src = 0, dst = 2, k = 1;

        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }


    //    [HINT] Build the priority queue around no of stops


    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Use dijkstra's Algorithm

        // create adjacencyList
        Map<Integer, List<int[]>> adjacencyList = new HashMap<>();
        for (int[] flight : flights) {
            int source = flight[0];
            int destination = flight[1];
            int price = flight[2];

            adjacencyList.computeIfAbsent(source, p -> new ArrayList<>()).add(new int[] { destination, price });
        }

        // an array that keeps track of minimum price required to reach each node
        int[] minimumPriceToEachStop = new int[n];
        Arrays.fill(minimumPriceToEachStop, Integer.MAX_VALUE);

        // A priorityQueue that sorts based on minimum no of stops
        // (cost,destination,noOfStops required to reach that node)
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        // initially add source to the heap
        minHeap.offer(new int[] { 0, src, 0 });
        minimumPriceToEachStop[src] = 0;

        while (!minHeap.isEmpty()) {
            int[] nodeInfo = minHeap.poll();
            int price = nodeInfo[0];
            int node = nodeInfo[1];
            int noOfStops = nodeInfo[2];

            if (noOfStops > k) { // if no of stops exceeds k limit of stops don't consider that route
                continue;
            }

            // if no neighbours then continue
            List<int[]> neighbours = adjacencyList.get(node);
            if (neighbours == null) {
                continue;
            }

            for (int[] neighbourInfo : neighbours) {
                int neighbourNode = neighbourInfo[0];
                int neighbourPrice = neighbourInfo[1];

                // check if the current price to reach neighbour node is less the
                // previousPrice, in that case update the minimumPrice to reach neighbour node
                if (minimumPriceToEachStop[neighbourNode] > price + neighbourPrice) {
                    minimumPriceToEachStop[neighbourNode] = price + neighbourPrice;
                    minHeap.offer(new int[] { price + neighbourPrice, neighbourNode, noOfStops + 1 });
                }
            }

        }

        // check if we were able to reach dst if not return -1 or return the
        // minimumPrice required to reach it
        return minimumPriceToEachStop[dst] == Integer.MAX_VALUE ? -1 : minimumPriceToEachStop[dst];
    }
}
