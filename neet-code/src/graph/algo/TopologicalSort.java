package graph.algo;

import java.util.*;

public class  TopologicalSort {

    /*
        Q. Given a Direct Acyclic Graph (DAG) return valid topological ordering of the graph
        Given edges and n where node are from 1 to n
        Post order DFS and reverse the answer


        Common Question Pattern for this Algorithm.
        - If no solution exist return -1 or "", and if multiple solution exist return any one.
    */

    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {1, 3},
                {2, 4},
                {3, 5},
                {4, 6},
                {5, 6},
                {7, 8},
//                {6, 1}  // loop edge
        };
        int n = 8;

        System.out.println(topologicalSort(edges, n));
    }


    /*
        The time complexity of the topological sort algorithm using Depth First Search (DFS) is O(V + E),
        where V is the number of vertices and E is the number of edges in the graph. This is because the
        DFS algorithm visits each vertex and edge once,and the recursive calls are made for each neighbor of a vertex.

    */
    public static List<Integer> topologicalSort(int[][] edges, int n) {
        Map<Integer, List<Integer>> sourceToDestinationMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            sourceToDestinationMap.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];

            sourceToDestinationMap.get(source).add(destination);
        }

        List<Integer> topologicalSort = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        Set<Integer> recursionStack = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            if (dfs(i, sourceToDestinationMap, visit, topologicalSort, recursionStack)) {
                System.out.println("cycle detected");
                break;
            }
        }

        Collections.reverse(topologicalSort);
        return topologicalSort;
    }

    private static boolean dfs(int source, Map<Integer, List<Integer>> sourceToDestinationMap, Set<Integer> visit, List<Integer> topologicalSort, Set<Integer> recursionStack) {
        if (recursionStack.contains(source)) {
            // cycle detected
            return true;
        }

        if (visit.contains(source)) {
            return false;
        }

        visit.add(source);
        recursionStack.add(source);

        for (Integer destination : sourceToDestinationMap.get(source)) {
            if (dfs(destination, sourceToDestinationMap, visit, topologicalSort, recursionStack)) {
                return true;
            }
        }
        // add only after all neighbors are visited
        topologicalSort.add(source);
        recursionStack.remove(source);
        return false;
    }
}
