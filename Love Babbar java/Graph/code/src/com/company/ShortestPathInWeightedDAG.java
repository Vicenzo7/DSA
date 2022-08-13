package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ShortestPathInWeightedDAG {
    static class Pair{
        private int v;
        private int weight;

        public Pair(int v, int weight) {
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
    private void toposort(int node, ArrayList<ArrayList<Pair>> adj, boolean[] vis, Stack<Integer> s) {
        vis[node] = true;

        for(Pair it :adj.get(node)){
            if(!vis[it.getV()]){
                toposort(it.getV(),adj,vis,s);
            }
        }
        s.add(node);
    }

    public void shortestPath(int src,ArrayList<ArrayList<Pair>> adj, int N){
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[N];
        int[] distance = new int[N];

        for (int i = 0; i < N ; i++) {
            if(!vis[i]){
                toposort(i,adj,vis,s);
            }
        }

        for (int i = 0; i < N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] =0;
        while(!s.isEmpty()){
            int node = s.pop();
            if(distance[node]!=Integer.MAX_VALUE){
                for (Pair it:adj.get(node)){
                    if(distance[node] + it.getWeight() < distance[it.getV()]){
                        distance[it.getV()] =distance[node]+it.getWeight();
                    }
                }
            }
        }


        for (int i = 0; i < N; i++) {
            if(distance[i] == Integer.MAX_VALUE){
                System.out.println("from src to "+i+" distance is Infinity");
            }else{
                System.out.println("from src to "+i+" distance is "+distance[i]);
            }
        }


    }



    void addEdge(ArrayList<ArrayList<Pair>> adj, int u, int v, int w){
        adj.get(u).add(new Pair(v, w));

    }

    public static void main(String[] args) {
        ShortestPathInWeightedDAG obj = new ShortestPathInWeightedDAG();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertices/node");
        int n = sc.nextInt();

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <n ; i++) {
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
