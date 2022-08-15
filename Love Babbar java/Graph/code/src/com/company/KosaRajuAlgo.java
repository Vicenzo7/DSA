package com.company;
//https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class KosaRajuAlgo {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }


    static int count=0;
    private  static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> s) {
        vis[node] = true;
        for (int it : adj.get(node)){
            if(!vis[it]){
                dfs(it,adj,vis,s);
            }
        }
        s.push(node);
    }

    private  static void revDfs(int node, ArrayList<ArrayList<Integer>> transpose, boolean[] vis) {
        vis[node] = true;
        System.out.print(node +" ");
        for (int it : transpose.get(node)){
            if(!vis[it]){
                revDfs(it,transpose,vis);
            }
        }

    }
    public static void kosaRaju(ArrayList<ArrayList<Integer>> adj, int N) {
        boolean[] vis = new boolean[N+1];
        Stack<Integer> s = new Stack<>();

        // step1: find the topo sort
        for (int i = 1; i <= N; i++) {
            if(!vis[i]){
                dfs(i,adj,vis,s);
            }
        }

        // step 2:to store the transpose of graph
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();

        for (int i = 0; i <=N; i++) {
            transpose.add(new ArrayList<>());
        }
        // step2: transpose the graph and also reinitializing visited array
        for (int i = 0; i <=N ; i++) {
            vis[i] = false;
            for (int it:adj.get(i)){
                transpose.get(it).add(i);
            }
        }

        // step3: perform dfs on transpose graph in order of toposort

        while(!s.isEmpty()){
            int node = s.pop();
            if(!vis[node]){
                revDfs(node,transpose,vis);
                System.out.println();
                count++;
            }

        }
    }




    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertices/node");
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <=n; i++) {
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

        kosaRaju(adj,n);
        System.out.println("Total number of SCC: "+count);

        //Enter the no of vertices/node
        //5
        //Enter the number of edges for undirected graph
        //5
        //give the inputs
        //1 2
        //2 3
        //3 1
        //2 4
        //4 5
        //1 3 2
        //4
        //5
        //Total number of SCC: 3
    }
}
