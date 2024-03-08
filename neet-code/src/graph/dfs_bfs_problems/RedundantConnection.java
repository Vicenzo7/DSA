package graph.dfs_bfs_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedundantConnection {
    public static void main(String[] args) {
        int[][] edges = {
//                {1, 2},
//                {1, 3},
//                {2, 3}

                {1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}
        };
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
        System.out.println(Arrays.toString(findRedundantConnectionUnionFind(edges)));
    }


    // using Union Find Method
    /*
        Redundant Connection Check:

        To check for redundant connections in an undirected graph, you can iterate through the edges. For each edge, perform the following steps:

            Apply the Find operation to find the representatives of the sets to which the two endpoints of the edge belong.
            If the representatives are the same, then adding this edge would create a cycle, making it redundant.
            If the representatives are different, perform the Union operation to merge the two sets.

        If at any point you encounter an edge whose endpoints already belong to the same set (have the same representative), then adding this edge would create a cycle,
        and it is considered a redundant connection.

        TC = O(n)
    */

    static int[] parent; // store root node
    static int[] rank; // size of the tree

    public static int[] findRedundantConnectionUnionFind(int[][] edges) {
        parent = new int[edges.length + 1];
        rank = new int[edges.length + 1];

        for (int i = 0; i < edges.length; i++) {
            parent[i] = i; // every node is parent of itself initially
            rank[i] = 1; // size of each node is 1 initially
        }

        for (int[] edge : edges) {
            // if union of this edge is not possible that mean this is the redundant edge
            if (!union(edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[2];
    }

    // finds the root node of X
    public static int find(int x) {
        if (parent[x] != x) { // until it's not the root node, root node is a parent of itself
            parent[x] = find(parent[x]); // path compression
        }

        return parent[x];
    }

    // return false if already union
    public static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false; // has same parent mean there is already a path
        }

        // to do union, attach smaller tree to root of larger tree
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
            rank[rootX] += rank[rootY];
        } else {
            parent[rootX] = rootY;
            rank[rootY] += rank[rootX];
        }

        return true;
    }



    /*
        Cycle in undirected graph
        For every visited vertex v,there is an adjacent vertex u such that u is visited and is not a parent of v,there is a cycle in a graph

        Create the graph edge by edge and check when an edge is added, a cycle is formed or not,
        if cycle formed return that edge


    */

    //Time Complexity : O(n^2), In worst case, we may need n dfs calls with each taking O(n) time complexity.
    //Space Complexity : O(n), to maintain graph
    public static int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < edges.length + 1; i++) {
            graph.add(new ArrayList<>());
        }
        boolean[] visit = new boolean[edges.length + 1];

        for (int[] edge : edges) {
            Arrays.fill(visit, false);
            // add the edge and then check if this edge causes a cycle
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            if (dfs(edge[0], -1, graph, visit)) {
                return edge;
            }
        }

        return new int[2];
    }

    private static boolean dfs(int u, int parent, List<List<Integer>> graph, boolean[] visit) {
        // mark u as visited
        visit[u] = true;

        for (Integer v : graph.get(u)) {
            if (v == parent) { // if adjacent is parent skip
                continue;
            }

            if (visit[v]) { // if adjacent is not a parent and is visited means cycle exist
                return true;
            }
            if (dfs(v, u, graph, visit)) { // check for adjacent is there is a cycle
                return true;
            }
        }

        return false;
    }

}
