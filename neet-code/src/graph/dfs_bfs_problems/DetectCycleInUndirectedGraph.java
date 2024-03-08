package graph.dfs_bfs_problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        int V = 5;
//        int[][] adj = {
//                {1}, // 0th adjacent
//                {0, 2, 4}, // 1 adjacent
//                {1, 3}, // 2 adjacent
//                {2, 4}, // 3 adjacent
//                {1, 3}  // 4 adjacent
//        };

        List<List<Integer>> adj = new ArrayList<>() {{
            add(List.of(1));
            add(List.of(0, 2, 4));
            add(List.of(1, 3));
            add(List.of(2, 4));
            add(List.of(1, 3));
        }};
        System.out.println(isCycle(V, adj));
        System.out.println(hasCycle(V, adj));
    }



    /*
    For every visited vertex v, if there is an adjacent u such that u is already visited and u is not parent of v, then there is a cycle in graph.
    If we don’t find such an adjacent for any vertex, we say that there is no cycle.


     */
    public static boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visit = new boolean[V];
        for (int node = 0; node < V; node++) {
            if (!visit[node] && hasCycle(node, -1, adj, visit)) {
                return true;
            }
        }


        return false;
    }

    private static boolean hasCycle(int u, int parent, List<List<Integer>> adj, boolean[] visit) {
        visit[u] = true;// marking the current vertex visited

        for (Integer v : adj.get(u)) { // iterating on all adjacent vertex
            if (v == parent) {
                continue;
            }

            if (visit[v]) {
                return true;
            }

            if (hasCycle(v, u, adj, visit)) {
                return true;
            }
        }
        return false;
    }



    // two set method
    public static boolean hasCycle(int V, List<List<Integer>> adj) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recursionStack = new HashSet<>();

        for (int node = 0; node < V; node++) {
            if (hasCycleDFS(node, adj, visited, recursionStack)) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasCycleDFS(int u, List<List<Integer>> adj, Set<Integer> visited, Set<Integer> recursionStack) {
        if (recursionStack.contains(u)) {
            return true; // Cycle detected
        }

        if (visited.contains(u)) {
            return false;
        }

        visited.add(u);
        recursionStack.add(u);

        for (Integer v : adj.get(u)) {
            if (hasCycleDFS(v, adj, visited, recursionStack)) {
                return true;
            }
        }

        recursionStack.remove(u);
        return false;
    }

}
