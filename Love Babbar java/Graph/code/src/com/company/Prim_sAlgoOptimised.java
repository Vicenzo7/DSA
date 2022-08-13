package com.company;

import java.util.*;

public class Prim_sAlgoOptimised {
    class Node {
        private int v;
        private int weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }
    }


    private void primsAlgo(ArrayList<ArrayList<Node>> adj, int N) {
        int[] key = new int[N];
        int[] parent = new int[N];
        boolean[] mstSet = new boolean[N];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        Arrays.fill(parent, -1);

        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                if (node1.getWeight() > node2.getWeight())
                    return 1;
                else if (node1.getWeight() < node2.getWeight())
                    return  -1;
                return 0;
            }
        });


        minHeap.add(new Node(0,key[0]));
        // traversing till n-1 because spanning tree will have N-1 edges for N graph

        for (int i = 0; i < N - 1; i++) {
            int u = minHeap.remove().getV();

            mstSet[u] = true;
            for (Node it : adj.get(u)) {
                if (!mstSet[it.getV()] && it.getWeight() < key[it.getV()]) {
                    key[it.getV()] = it.getWeight();
                    parent[it.getV()] = u;
                    minHeap.add(new Node(it.getV(),key[it.getV()]));
                }
            }
        }
        for (int i = 1; i < N; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }

    void addEdge(ArrayList<ArrayList<Node>> adj, int u, int v, int w) {
        adj.get(u).add(new Node(v, w));
        adj.get(v).add(new Node(u, w));

    }


    public static void main(String[] args) {
        Prim_sAlgoOptimised obj = new Prim_sAlgoOptimised();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertices/node");
        int n = sc.nextInt();

        ArrayList<ArrayList<Node>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the number of edges for undirected graph");
        int m = sc.nextInt();

        System.out.println("give the inputs ");

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            obj.addEdge(adj, u, v, w);
        }

        obj.primsAlgo(adj, n);


//        Enter the no of vertices/node
//        5
//        Enter the number of edges for undirected graph
//        6
//        give the inputs
//        0 1 2
//        0 3 6
//        1 2 3
//        1 4 5
//        3 1 8
//        4 2 7
    }


}
