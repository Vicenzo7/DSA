package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CyclePresentUsingDFSinUndirected {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
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

    static class Node {
        int first;
        int second;

        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V+1];
        for (int i = 1; i <=V ; i++) {
            if (!vis[i]){
                if(checkForCycle(i,-1,adj,vis)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkForCycle(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node]=true;
        for(int it :adj.get(node)){
            //check if not visited
            if(!vis[it]){
                //check if there is cycle present beneath
                if(checkForCycle(it,node,adj,vis)) return true;
            }
            //if (it) is visited than check if nt parent than cycle exist
            else if(parent !=it)
                return true;
        }

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

        System.out.println(isCycle(n,adj));


    }


}
