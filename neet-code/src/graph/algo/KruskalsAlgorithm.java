package graph.algo;

import java.util.*;

public class KruskalsAlgorithm {

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

    /*
        Given a list of edges of a connected undirected graph, with nodes
        numbered from 1 to n, return the list of edges making up the Minimum Spanning Tree
     */

    static int[] parent;
    static int[] rank;

    private static List<int[]> minimumSpanningTree(int[][] edges, int nodes) {
        parent = new int[nodes + 1];
        rank = new int[nodes + 1];

        for (int i = 1; i < nodes + 1; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // Store (weight,source,destination) -> sorted by weight
        // using minHeap, so we get edge of minimum weight
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            int weight = edge[2];
            minHeap.add(new int[]{weight, source, destination});
        }

        List<int[]> mst = new ArrayList<>();
        while (mst.size() < nodes - 1) {// this condition, because for n nodes there must be n-1 edges to form a graph without cycle
            int[] nodeInfo = minHeap.poll();
            int source = nodeInfo[1];
            int destination = nodeInfo[2];
            if (!union(source, destination)) { // if cannot union the edge, skip the edge
                continue;
            }
            mst.add(new int[]{source, destination});
        }

        return mst;
    }

    public static int find(int x) {
        if (parent[x] != x) { // finding the super root
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false; // cannot form a union because they have same parent which means path from x to y exist
        }

        if (rootX > rootY) {
            parent[rootY] = rootX;
            rank[rootX] += rank[rootY];
        } else {
            parent[rootX] = rootY;
            rank[rootY] += rank[rootX];
        }

        return true; // union done
    }
}
