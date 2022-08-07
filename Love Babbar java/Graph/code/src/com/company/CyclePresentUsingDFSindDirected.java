package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class CyclePresentUsingDFSindDirected {
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

    static class Node {
        int first;
        int second;

        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V+1];
        boolean[] dfsVis = new boolean[V+1];

        for(int i=1;i<=V;i++){
            if(!vis[i]){
                if(checkForCycle(i,vis,dfsVis,adj)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean checkForCycle(int node,boolean[] vis,boolean[] dfsVis,ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        dfsVis[node]=true;

        for(int it :adj.get(node)){
            if(!vis[it]){
                if(checkForCycle(it,vis,dfsVis,adj))
                    return true;
            }
            //if it is visited in vis and also visited in dfsVis tha cycle present
            else if(dfsVis[it]) {
                return true;
            }
        }

        // cycle not present back track for dfsVis for that node
        dfsVis[node] = false;
        return false;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertices/node");
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <=n ; i++) {
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

        System.out.println(isCyclic(n,adj));


//        Enter the no of vertices/node
//        9
//        Enter the number of edges for undirected graph
//        10
//        give the inputs
//        1 2
//        2 3
//        3 4
//        4 5
//        3 6
//        6 5
//        7 2
//        7 8
//        8 9
//        9 7


    }


}
