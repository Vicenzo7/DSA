package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class FindBridges {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj){
        for (int i = 0; i < adj.size() ; i++) {
            System.out.print(i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print("->"+adj.get(i).get(j));
            }
            System.out.println();
        }
    }





    public static void printBridges(ArrayList<ArrayList<Integer>> adj, int N){
        boolean[] vis = new boolean[N];
        int[] tin = new int[N];
        int[] low = new int[N];

        int timer =0;
        for (int i = 0; i <N; i++) {
            if(!vis[i]){
                dfs(i,-1,adj,vis,tin,low,timer);
            }
        }
    }

    private static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] tin, int[] low, int timer) {
        vis[node]= true;
        tin[node] = low[node] = timer++;

        for(int it:adj.get(node)){
            if(it == parent) continue;
            if(!vis[it]) {
                dfs(it, node, adj, vis, tin, low, timer);
                low[node] = Math.min(low[node], low[it]);

                if (low[it] > tin[node]) {
                    System.out.println(it + " " + node);
                }
            }else{
                low[node]= Math.min(low[node],tin[it]);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertices/node");
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <=n ; i++) {
            adj.add(new ArrayList<>());
        }


//        adj.get(0).add(1);
//        adj.get(1).add(0);
//
//        adj.get(0).add(2);
//        adj.get(2).add(0);
//
//        adj.get(1).add(2);
//        adj.get(2).add(1);
//
//        adj.get(1).add(3);
//        adj.get(3).add(1);
//
//        adj.get(3).add(4);
//        adj.get(4).add(3);
        System.out.println("Enter the number of edges for undirected graph");
        int m = sc.nextInt();

        System.out.println("give the inputs ");

        for (int i = 0; i < m ; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            addEdge(adj,u,v);
        }

        printBridges(adj,5);

    }
}
