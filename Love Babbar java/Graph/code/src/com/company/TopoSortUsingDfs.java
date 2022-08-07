package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Linear ordering of vertices such that,
 * if there's a edge from u -> v, u appears before v in  that ordering
 *
 * Note: There may me more than one topo sort for a graph and topo sort is possible for only DAG -directed acyclic graph
 *
 */


public class TopoSortUsingDfs {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
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

        System.out.println(Arrays.toString(topoSort(n, adj)));


//        Enter the no of vertices/node
//        6
//        Enter the number of edges for undirected graph
//        6
//        give the inputs
//        2 3
//        3 1
//        4 0
//        4 1
//        5 0
//        5 2
// output  [5, 4, 2, 3, 1, 0]
    }


    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[V];

        for(int i=0;i<V;i++){
            if(!vis[i]){
                findTopoSort(i,vis,adj,s);
            }
        }

        int[] topo = new int[s.size()];
        int i=0;
        while(!s.isEmpty()){
            topo[i++] = s.pop();
        }

        return topo;
    }

    static void findTopoSort(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adj,Stack<Integer> s){
        vis[node]=true;
        for(int it:adj.get(node)){
            if(!vis[it]){
                findTopoSort(it,vis,adj,s);
            }
        }
        s.push(node);
    }
}
