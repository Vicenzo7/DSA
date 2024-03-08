package graph.advance_problems;

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}};
        int n = 4, k = 2;

        System.out.println(networkDelayTime(times, n, k));
    }


    // TC = O(E.log(E)) or O(E.log(V)) where e is the edge and v is vertices

    public  static int networkDelayTime(int[][] times, int n, int k) {
        // Apply Dijkstra's Algorithm

        // Create Adjacency List
        // (source, (destination,weight))
        Map<Integer, List<int[]>> adjacencyList = new HashMap<>();
        for (int[] time : times) {
            int source = time[0];
            int destination = time[1];
            int weight = time[2];

            adjacencyList.computeIfAbsent(source, p -> new ArrayList<>()).add(new int[] { destination, weight });
        }

        Set<Integer> visit = new HashSet<>();
        // (weight, destination)
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        minHeap.add(new int[] { 0, k }); // add kth node as we have to start from k

        int minimumTime = 0;

        while (!minHeap.isEmpty()) {
            int[] nodeInfo = minHeap.poll();
            int weight = nodeInfo[0];
            int destination = nodeInfo[1];

            if (visit.contains(destination)) { // already traveled this path through shortest distance
                continue;
            }

            visit.add(destination);
            minimumTime = Math.max(minimumTime, weight);

            // now travel the neighbours
            List<int[]> neighbours = adjacencyList.get(destination);
            if (neighbours == null) { // no neighbours
                continue;
            }

            for (int[] neighbourInfo : neighbours) {
                int neighbour = neighbourInfo[0];
                int neighbourWeight = neighbourInfo[1];
                if (!visit.contains(neighbour)) {
                    minHeap.offer(new int[] { weight + neighbourWeight, neighbour });
                }
            }
        }

        // if we are not able to reach all nodes return -1
        return visit.size() != n ? -1 : minimumTime;
    }
}
