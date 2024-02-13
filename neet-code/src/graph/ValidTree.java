package graph;

import java.util.ArrayList;
import java.util.List;

public class ValidTree {
    public static void main(String[] args) {
        int n = 5;
//        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}; // cycle in thr graph

//        int[][] edges = {{0, 1}, {1, 2}, {3, 4}}; // 2 connected component graph
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}}; // valid tree


        System.out.println(validTree(n, edges));
        System.out.println(validTree2(n, edges));
    }


    /*
        An undirected graph can be said as a tree, if there are no cycles and there exist only one connected component in the graph

        Approach: use topological sort we can find if a cycle exist or not, but there must be a pattern like this
        edge from 0 -> 1 and 1 - 0, in the input

        Here, there is no such pattern, so we apply unionFind Algo to check if the edge can be union or not
        if it cannot be we return false, if it can we reduce the connectedComponent count.

        finally we check if the connectedComponentCount == 1 we return true;

    */


    static int[] parent;
    static int[] rank;

    public static boolean validTree(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int totalConnectedComponent = n;
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return false;
            } else { // union possible so reduce count to connected component
                totalConnectedComponent--;
            }
        }

        return totalConnectedComponent == 1;
    }

    private static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) { // has same parent means there is already a path and
            // doing union of this will cause cycle
            return false;
        }
        if (rootX > rootY) {
            parent[rootY] = rootX;
            rank[rootX] += rank[rootY];
        } else {
            parent[rootX] = rootY;
            rank[rootY] += rank[rootX];
        }

        return true;
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }


    /*
        Cycle in undirected graph
        For every visited vertex v,there is an adjacent vertex u such that u is visited and is not a parent of v,there is a cycle in a graph

        Create a graph and check if a cycle exist or not

    */


    public static boolean validTree2(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (dfs(i, -1, graph, visit)) {
                return false;
            }
        }
        return true;

    }

    private static boolean dfs(int u, int parent, List<List<Integer>> graph, boolean[] visit) {
        visit[u] = true;

        for (Integer v : graph.get(u)) {
            if (v == parent) {
                continue;
            }

            if (visit[v]) {
                return false;
            }
            if (dfs(v, u, graph, visit)) {
                return false;
            }
        }

        return true;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int index = -1;
        for (int i = 0; i < wordList.size(); i++) {
            if (beginWord.equals(wordList.get(i))) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return 0;
        }

        return 5;
    }
}
