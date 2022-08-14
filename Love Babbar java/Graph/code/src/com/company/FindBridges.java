package com.company;

//https://leetcode.com/problems/critical-connections-in-a-network/
// this above question is same as find-bridges in graph


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindBridges {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
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

        System.out.println(Arrays.toString(tin));
        System.out.println(Arrays.toString(low));
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
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(it);
                    temp.add(node);
                    list.add(temp);
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

        for (int i = 0; i <n ; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the number of edges for undirected graph");
        int m = sc.nextInt();

        System.out.println("give the inputs ");

        for (int i = 0; i < m ; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            addEdge(adj,u,v);
        }

        printBridges(adj,n);
        System.out.println(list);

        //Enter the no of vertices/node
        //13
        //Enter the number of edges for undirected graph
        //15
        //give the inputs
//        0 1
//        1 2
//        1 4
//        2 3
//        3 4
//        4 5
//        5 6
//        6 7
//        6 9
//        7 8
//        9 8
//        8 10
//        10 11
//        10 12
//        11 12

    }
}



// In Leetcode adjacency list is given as List<List<Integer>>
// convet into ArrayList<ArrayList<Integer>> than perform operation
//List<List<Integer>> list = new ArrayList<>();
//    private void addEdge(int u,int v){
//        graph.get(u).add(v);
//        graph.get(v).add(u);
//    }
//
//    private ArrayList<ArrayList<Integer>> graph;
//
//    private void BuildGraph(List<List<Integer>> Connections){
//        for(List<Integer> pair:Connections){
//            int u=pair.get(0);
//            int v=pair.get(1);
//            addEdge(u,v);
//        }
//    }