package graph.algo;

import java.util.*;

public class PrimsAlgorithm {

    /*
        Minimum Spanning Tree
        What is a minimum spanning tree.
        If a graph is not a tree it is also not a minimum spanning tree.

        Given a graph find minimum spanning tree, means find a subset of that graph with satisfies
        the tree property and the cost of making that subset is minimum.

        If there are multiple solution return anyone.

        Time Complexity And Space Complexity

        The TC is similar to Dijkstra's Algo which is TC = O(E.log(E)) or O(E.log(V))
        SC = O(n) + O(E)  where n is number of nodes in set and E is the number of edges in minHeap
     */

    public static void main(String[] args) {

        int nodes = 5;
        int[][] edges = new int[7][3];
        edges[0] = new int[]{1, 2, 10};
        edges[1] = new int[]{1, 3, 3};
        edges[2] = new int[]{3, 2, 4};
        edges[3] = new int[]{3, 4, 4};
        edges[4] = new int[]{3, 5, 4};
        edges[5] = new int[]{4, 5, 2};
        edges[6] = new int[]{4, 2, 1};

        List<int[]> mst = minimumSpanningTree(edges, nodes);
        System.out.println(Arrays.deepToString(mst.toArray(new int[0][])));
    }

    // Given a list of edges of a connected undirected graph,
    // with nodes numbered from 1 to n,
    // return a list edges making up the minimum spanning tree.

    private static List<int[]> minimumSpanningTree(int[][] edges, int nodes) {

        // the graph which is given is undirected and start with node 1
        // source to (destination,weight)
        Map<Integer, List<int[]>> adjacencyList = new HashMap<>();

        // create adjacencyList
        for (int[] edge : edges) {
            adjacencyList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            adjacencyList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }

        List<int[]> mst = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        // (weight, source,destination)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        // since the nodes are starting from 1 to n, we will initially add all neighbours of 1 in minHeap and add 1 in visit
        // Initialize the heap by choosing a single node
        // (in this case 1) and pushing all its neighbors.
        for (int[] neighbour : adjacencyList.get(1)) {
            int destination = neighbour[0];
            int weight = neighbour[1];
            minHeap.add(new int[]{weight, 1, destination});
        }

        visit.add(1); // since we added neighbours of 1 in minHeap, 1 is marked visited
        int min = 0;

        while (!minHeap.isEmpty()) {
            int[] nodeInfo = minHeap.poll();
            int cost = nodeInfo[0];
            int source = nodeInfo[1];
            int destination = nodeInfo[2];
            if (visit.contains(destination)) {
                continue;
            }

            visit.add(destination); // add destination to visit
            mst.add(new int[]{source, destination}); // add the edge to mst
            min += cost;

            // iterate its neighbours and add them to minHeap if they are not visited
            for (int[] pair : adjacencyList.get(destination)) {
                int neighbour = pair[0];
                int weight = pair[1];
                if (!visit.contains(neighbour)) {
                    // now here destination is source and destination is the neighbour
                    minHeap.add(new int[]{weight, destination, neighbour});
                }
            }
        }
        System.out.println(min);
        return mst;
    }
}
