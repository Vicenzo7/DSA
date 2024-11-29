package graph.algo;

import util.CustomPair;

import java.util.*;

public class DijkstrasAlgorithm {
    public static void main(String[] args) {
        Edge[] edges = new Edge[7];
        edges[0] = new Edge("A", "B", 10);
        edges[1] = new Edge("A", "C", 3);
        edges[2] = new Edge("C", "B", 4);
        edges[3] = new Edge("C", "D", 8);
        edges[4] = new Edge("C", "E", 2);
        edges[5] = new Edge("D", "E", 5);
        edges[6] = new Edge("B", "D", 2);

        System.out.println(shortestPath(edges, "A"));
    }


    /*
        Given a connected graph represented by list of edges, where
        edge[0] = src, edge[1] = dest, edge[2] = weight.
        Find the shortest path from source to every other node in the graph

        Now let's analyse the Time Complexity
        Number of edges = E <= V^2
        Pushing and popping from the minHeap is going to cost log(E) where E is the number of edges
        So out TC = O( E.Log(E)) -> We will be doing push and pop for E edges and push pop take log(E) TC
        or also can be written as O(E.log(V^2)) = O(E.2.log(V)) == O(E.log(V))

        SC = O(E) -> number of edges
    */

    public static class Edge {
        String source;
        String destination;
        int weight;

        public Edge(String source, String destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static Map<String, Integer> shortestPath(Edge[] edges, String source) {
        // source to (destination,weight)
        Map<String, List<CustomPair<String, Integer>>> adjacencyList = new HashMap<>();

        // create adjacencyList
        for (Edge edge : edges) {
            adjacencyList.computeIfAbsent(edge.source, k -> new ArrayList<>())
                    .add(new CustomPair<>(edge.destination, edge.weight));
        }

        Map<String, Integer> nodeToShortestPath = new HashMap<>();
        // stores [weight,Node] in ascending order
        Queue<CustomPair<Integer, String>> minHeap = new PriorityQueue<>(Comparator.comparingInt(CustomPair::getKey));
        // Initially add cost and source in minHeap
        minHeap.add(new CustomPair<>(0, source));

        while (!minHeap.isEmpty()) {
            CustomPair<Integer, String> nodeInfo = minHeap.poll();
            Integer cost = nodeInfo.getKey();
            String node = nodeInfo.getValue();
            if (nodeToShortestPath.containsKey(node)) {
                continue;
            }

            nodeToShortestPath.put(node, cost);
            List<CustomPair<String, Integer>> neighbors = adjacencyList.get(node);
            if (neighbors == null) {
                continue;
            }

            // now iterate the nodes neighbours and add them int the minHeap only if their shortest path is not computed
            // also if they are being added in minHeap add the total cost
            for (CustomPair<String, Integer> neighbor : neighbors) {
                String neighborNode = neighbor.getKey();
                if (!nodeToShortestPath.containsKey(neighborNode)) {
                    Integer neighborCost = neighbor.getValue();
                    minHeap.add(new CustomPair<>(cost + neighborCost, neighborNode));
                }
            }
        }
        return nodeToShortestPath;
    }
}
