package com.company;

import java.util.*;

public class Dijkstra_sAlgorithm {
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

    public void shortestPath(int src, ArrayList<ArrayList<Node>> adj,int N){

        int[] distance = new int[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                if(node1.getWeight() > node2.getWeight())
                    return 1;
                else if (node1.getWeight() < node2.getWeight())
                    return -1;
                return 0;
            }
        });

        // step1: add the source and distance from source to source into priority que
        minHeap.add(new Node(src,0));

        // step2: traverse the Priority Queue till its empty
        while(!minHeap.isEmpty()){
            Node node = minHeap.remove();
            for(Node it :adj.get(node.getV())){
                if(distance[node.getV()]+it.getWeight() < distance[it.getV()]){
                    distance[it.getV()] = distance[node.getV()]+it.getWeight();
                    minHeap.add(new Node(it.getV(),distance[it.getV()]));
                }
            }
        }

        for (int i = 1; i <=N; i++) {
            if(distance[i] == Integer.MAX_VALUE){
                System.out.println("from src to "+i+" distance is Infinity");
            }else{
                System.out.println("from src to "+i+" distance is "+distance[i]);
            }
        }
    }


    void addEdge(ArrayList<ArrayList<Node>> adj, int u, int v, int w){
        adj.get(u).add(new Node(v, w));
        adj.get(v).add(new Node(u, w));

    }

    public static void main(String[] args) {
        Dijkstra_sAlgorithm obj = new Dijkstra_sAlgorithm();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertices/node");
        int n = sc.nextInt();

        ArrayList<ArrayList<Node>> adj = new ArrayList<>();

        for (int i = 0; i <=n ; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the number of edges for undirected graph");
        int m = sc.nextInt();

        System.out.println("give the inputs ");

        for (int i = 0; i < m ; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            obj.addEdge(adj,u,v,w);
        }

        System.out.println("enter the source");
        int src = sc.nextInt();
        obj.shortestPath(src,adj,n);
    }
}
