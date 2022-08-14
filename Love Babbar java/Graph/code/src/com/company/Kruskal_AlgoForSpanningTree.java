package com.company;

import java.util.*;

public class Kruskal_AlgoForSpanningTree {
    static class Node {
        private int u;
        private int v;
        private int weight;

        public Node(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public int getU() {
            return u;
        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }
    }

    void addEdge(ArrayList<Node> adj, int u, int v, int w) {
        adj.add(new Node(u,v,w));
        adj.add(new Node(v,u,w));
    }


    private void kruskalAlgo(ArrayList<Node> adj, int n) {

        //sorting the adj list according to weight
        Collections.sort(adj, new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                if (node1.getWeight() > node2.getWeight())
                    return 1;
                else if(node1.getWeight() < node2.getWeight())
                    return -1;
                return 0;
            }
        });

        //disjoint set
        int[] parent = new int[n];
        int[] rank = new int[n];


        for (int i = 0; i <n ; i++) {
            parent[i]=i;
            rank[i]=0;
        }

        int cost=0;
        ArrayList<Node> mst = new ArrayList<>();
        for(Node it : adj){
            if (findPar(it.getU(),parent) != findPar(it.getV(),parent)){
                cost +=it.getWeight();
                mst.add(it);
                union(it.getU(), it.getV(),parent,rank);
            }
        }

        System.out.println("Cost of spanning tree is Minimum "+cost);
        for (Node it : mst){
            System.out.println("u = "+it.getU() + " v = "+it.getV()+" w = "+it.getWeight());
        }
    }

    int findPar(int u,int[] parent){
        if(u==parent[u]){
            return u;
        }
        return parent[u] = findPar(parent[u],parent);
    }

    public void union(int u,int v,int[] parent, int[] rank ){
        // find parent of u and v
        u = findPar(u,parent);
        v = findPar(v,parent);

        // join the node whose rank is lower to a node whose rank is higher;
        if(rank[u] < rank[v]){
            parent[u] = v;
        }else if (rank[u] > rank[v]) {
            parent[v] = u;
        }else {
            // if rank equal can join to any one
            // after joining increase the rank of the joined one;
            parent[v] = u;
            rank[u]++;
        }
    }

    public static void main(String[] args) {
        Kruskal_AlgoForSpanningTree obj = new Kruskal_AlgoForSpanningTree();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertices/node");
        int n = sc.nextInt();

        ArrayList<Node> adj = new ArrayList<>();
        System.out.println("Enter the number of edges for undirected graph");
        int m = sc.nextInt();

        System.out.println("give the inputs ");

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            obj.addEdge(adj, u, v, w);
        }
        obj.kruskalAlgo(adj, n);

//        Enter the no of vertices/node
//        7
//        Enter the number of edges for undirected graph
//        9
//        give the inputs
//        1 4 1
//        1 2 2
//        1 5 4
//        2 4 3
//        2 3 3
//        2 6 7
//        3 4 5
//        3 6 8
//        4 5 9
//        Cost of spanning tree is Minimum 17
//        u = 1 v = 4 w = 1
//        u = 1 v = 2 w = 2
//        u = 2 v = 3 w = 3
//        u = 1 v = 5 w = 4
//        u = 2 v = 6 w = 7
    }





}
