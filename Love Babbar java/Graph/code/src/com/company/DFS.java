package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS {

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

    static void dfs(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storeDfs){
        storeDfs.add(node);
        vis[node]=true;
        for(int it:adj.get(node)){
            if(!vis[it]){
                dfs(it,vis,adj,storeDfs);
            }
        }
    }

    static ArrayList<Integer> dfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> storeDfs = new ArrayList<>();
        boolean[] vis = new boolean[V+1];

        //apply dfs for each node
        for (int i = 1; i <=V ; i++) {
            // check if that node is visited
            if(!vis[i]){
                dfs(i,vis,adj,storeDfs);
            }
        }
        return storeDfs;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertices/node");
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the number of edges for undirected graph");
        int m = sc.nextInt();

        System.out.println("give the inputs ");

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            addEdge(adj, u, v);
        }
        printGraph(adj);

        System.out.println(dfsOfGraph(n,adj));
//        1 2
//        2 4
//        2 7
//        7 6
//        4 6
//        3 5


    }
}




