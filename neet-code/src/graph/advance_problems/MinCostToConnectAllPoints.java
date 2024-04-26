package graph.advance_problems;

import java.util.*;

public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
//        int[][] points = {{0, 0}};
        System.out.println(minCostConnectPoints(points));
        System.out.println(minCostConnectPointsOptimized(points));
    }


    public static int minCostConnectPoints(int[][] points) {
        int minimumCost = 0;
        Map<Integer, List<int[]>> adjacencyList = new HashMap<>();

        for (int source = 0; source < points.length; source++) {
            int[] node1 = points[source];
            for (int destination = 0; destination < points.length; destination++) {
                if (source != destination) {
                    int[] node2 = points[destination];
                    int manhattanDistance = Math.abs(node1[0] - node2[0]) + Math.abs(node1[1] - node2[1]);
                    adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(new int[]{destination, manhattanDistance});
                    adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(new int[]{source, manhattanDistance});
                }
            }
        }

        if (adjacencyList.isEmpty()) {
            return 0;
        }

        // stores (weight,source,destination)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        Set<Integer> visit = new HashSet<>();

        // Initially add in minHeap any node, I choose 0
        for (int[] neighbour : adjacencyList.get(0)) {
            int destination = neighbour[0];
            int cost = neighbour[1];
            minHeap.add(new int[]{cost, 0, destination});
        }
        visit.add(0);

        while (!minHeap.isEmpty()) {
            int[] point = minHeap.poll();
            int cost = point[0];
            int source = point[1];
            int destination = point[2];
            // check if the node is already visited
            if (visit.contains(destination)) {
                continue; // skipping since it's already visited
            }

            visit.add(destination);
            minimumCost += cost;

            List<int[]> neighbours = adjacencyList.get(destination);
            if (neighbours == null || neighbours.isEmpty()) {
                continue;
            }

            for (int[] pair : neighbours) {
                int neighbour = pair[0];
                int neighbourCost = pair[1];
                if (!visit.contains(neighbourCost)) {
                    minHeap.offer(new int[]{neighbourCost, destination, neighbour});
                }
            }
        }

        return minimumCost;
    }

    public static int minCostConnectPointsOptimized(int[][] points) {
        int minimumCost = 0;
        int length = points.length;
        // stores (weight,node)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        Set<Integer> visit = new HashSet<>();

        // initially add in minHeap the {cost,node} == {0,0}
        minHeap.add(new int[]{0, 0});

        while (visit.size() < length) {
            int[] nodeInfo = minHeap.poll();
            int cost = nodeInfo[0];
            int currentNode = nodeInfo[1];

            if (visit.contains(currentNode)) { // already visited,with lesser cost so continue
                continue;
            }

            visit.add(currentNode);
            minimumCost += cost;

            for (int nextNode = 0; nextNode < length; nextNode++) {
                if (!visit.contains(nextNode)) {
                    int nextCost = Math.abs(points[currentNode][0] - points[nextNode][0]) +
                            Math.abs(points[currentNode][1] - points[nextNode][1]);
                    minHeap.add(new int[]{nextCost, nextNode});
                }
            }
        }

        return minimumCost;
    }
}
