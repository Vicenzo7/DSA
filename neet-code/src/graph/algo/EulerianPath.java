package graph.algo;

import java.util.*;

public class EulerianPath {
    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {1, 3},
                {2, 2},
                {2, 4},
                {2, 4},
                {3, 1},
                {3, 2},
                {3, 5},
                {4, 3},
                {4, 6},
                {5, 6},
                {6, 3},
        };

        int n = 6;
        System.out.println(findEulerianPath(edges, n));
    }

    public static Deque<Integer> findEulerianPath(int[][] edges, int n) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];
        int edgeCount = edges.length;

        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            inDegree[destination] += 1;
            outDegree[source] += 1;
            adjacencyList.get(source).add(destination);
        }

        if (!graphHasEulerianPath(inDegree, outDegree)) {
            return null;
        }

        int startNode = getStartNode(inDegree, outDegree);
        Deque<Integer> result = new ArrayDeque<>();
        dfs(startNode, outDegree, adjacencyList, result);

        // Make sure all edges of the graph were traversed. It could be the
        // case that the graph is disconnected in which case return null.
        if (result.size() != edgeCount + 1) {
            return null;
        }
        return result;
    }

    private static void dfs(int at, int[] outDegree, Map<Integer, List<Integer>> adjacencyList, Deque<Integer> result) {
        // keep iterating until there are no unvisited outgoing edge from startNode
        while (outDegree[at] != 0) {
            // reduce outgoing count when an edge is used
            int nextNode = adjacencyList.get(at).get(--outDegree[at]);
            dfs(nextNode, outDegree, adjacencyList, result);
        }

        result.addFirst(at);
    }


    /*
        This is important because all node will node give you eulerian path
    */
    private static int getStartNode(int[] inDegree, int[] outDegree) {
        int startNode = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if (outDegree[i] - inDegree[i] == 1) { // a node with exactly one extra outgoing edge
                return i;// startNode;
            }

            // in case of an eulerian circuit any node with outgoing edge
            if (outDegree[i] > 0) {
                startNode = i;
            }
        }
        return startNode;
    }

    private static boolean graphHasEulerianPath(int[] inDegree, int[] outDegree) {
        int startNode = 0, endNode = 0;
        for (int i = 0; i < inDegree.length; i++) {
            /*At most one vertex has (outdegree) - (indegree) = 1
            and at most one vertex has (indegree) - (outdegree) = 1
            and all other vertices have equal in and out degrees.
            */

            // no nodes must have to many incoming or outgoing edges, as well ass making sure there are'
            // correct amount of start and end nodes
            if (outDegree[i] - inDegree[i] > 1 || inDegree[i] - outDegree[i] > 1) {
                return false;
            } else if (outDegree[i] - inDegree[i] == 1) {
                startNode++;
            } else if (inDegree[i] - outDegree[i] == 1) {
                endNode++;
            }
        }

        // first one due to eulerian circut, second one is due to eulerian path
        return (startNode == 0 && endNode == 0) || (startNode == 1 && endNode == 1);
    }
}
