package graph.implementation;

import java.util.*;

public class AdjacencyList {

    public static void main(String[] args) {
        String[][] edges = {{"A", "B"}, {"B", "C"}, {"B", "E"}, {"C", "E"}, {"E", "D"}};
        Map<String, List<String>> adjList = buildAdjList(edges);
        System.out.println(adjList);
        System.out.println("Number of paths = " + dfs("A", "E", adjList, new HashSet<>()));
        System.out.println("Shortest Path length= " + bfs(adjList, "A", "E"));
    }


    public static Map<String, List<String>> buildAdjList(String[][] edges) {
        Map<String, List<String>> adjList = new HashMap<>();

        for (String[] edge : edges) {
            String src = edge[0];
            String dest = edge[1];

            if (!adjList.containsKey(src)) {
                adjList.put(src, new ArrayList<>());
            }
            if (!adjList.containsKey(dest)) {
                adjList.put(dest, new ArrayList<>());
            }
            adjList.get(src).add(dest);
        }

        return adjList;
    }

    // count paths
    /*
        TC = O(N^V)  V = no of vertices or height of decision tree and N = average no of edges each vertex has
    */
    public static int dfs(String src, String dest, Map<String, List<String>> adjList, Set<String> visit) {
        // check if source already visited
        if (visit.contains(src)) {
            return 0;
        }

        // check if we reached the destination
        if (src.equals(dest)) {
            return 1;
        }

        int count = 0;
        visit.add(src);
        for (String s : adjList.get(src)) {
            count += dfs(s, dest, adjList, visit);
        }
        visit.remove(src);
        return count;
    }

    // shortest path length
    /*
        TC = O(size of graph)
        Tc = O(V+E) no of vertices + no of edges
    */
    public static int bfs(Map<String, List<String>> adjList, String src, String dest) {
        Deque<String> deque = new ArrayDeque<>();
        deque.add(src);

        Set<String> visit = new HashSet<>();
        visit.add(src);

        int length = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String s = deque.poll();
                if (s.equals(dest)) {
                    return length;
                }

                for (String neighbor : adjList.get(s)) {
                    if (!visit.contains(neighbor)) {
                        visit.add(neighbor);
                        deque.add(neighbor);
                    }
                }
            }
            length += 1;
        }

        return length;
    }
}
