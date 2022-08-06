package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CyclePresentUsingBFSinUndirected {
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
                if(checkForCycle(adj,i,vis)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean[] vis) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(s, -1));
        vis[s]=true;

        while(!que.isEmpty()){
            int node = que.peek().first;
            int par = que.peek().second;
            que.remove();

            for(int it :adj.get(node)){
                if(!vis[it]){
                    vis[it]=true;
                    que.add(new Node(it,node));
                }

                else if(par != it) return true;
            }
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

// Cycle present
//        Enter the no of vertices/node
//        11
//        Enter the number of edges for undirected graph
//        10
//        give the inputs
//        1 2
//        2 4
//        3 5
//        5 6
//        5 10
//        6 7
//        7 8
//        10 9
//        9 8
//        8 11


        // no cycle
//        Enter the no of vertices/node
//        11
//        Enter the number of edges for undirected graph
//        9
//        give the inputs
//        1 2
//        2 4
//        3 5
//        5 6
//        5 10
//        6 7
//        10 9
//        9 8
//        8 11

        printGraph(adj);
    }


}
