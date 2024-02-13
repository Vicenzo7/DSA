package graph;

public class NumberOfConnectedComponentInUndirectedGraph {

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {4, 5}};
        System.out.println(countComponents(n, edges));
    }

    /*
        Intuition:
        Using union Find we can find which edge is redundant,

        So my initial approach was to do a union find and
        after that iterate the parent array and count how many elements are parent of itself

        This count indicates total number of connected component


        But we still need to iterate the parent array again.

        So what improvement we can do
        Initially we treat each node as a single component so our totalConnectedComponent = no of nodes
        We do a union on each edge and check if it can be union, if yes we reduce the totalConnectedComponent count
        after all union is done we return totalConnectedComponent;


    */


    static int[] parent;
    static int[] rank;

    public static int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];


        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int totalConnectedComponent = n;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                totalConnectedComponent--;
            }
        }

        return totalConnectedComponent;
    }

    private static boolean union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false; // belong to different graph component
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
        if (parent[x] != x) { // if not a parent root
            parent[x] = find(parent[x]); // also doing path compression
        }

        return parent[x];
    }

}
