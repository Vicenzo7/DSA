package com.company;

import java.util.*;
import java.util.Queue;

/**
 * Linear ordering of vertices such that,
 * if there's a edge from u -> v, u appears before v in  that ordering
 *
 * Note: There may me more than one topo sort for a graph and topo sort is possible for only DAG -directed acyclic graph
 *
 */


public class TopoSortUsingBFS {
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


    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // to store the topo sort
        int[] topo = new int[V];
        //to store indegree
        int[] indegree = new int[V];

        // step1: calculating the indegree
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }


        //step2: add in queue the node who has indegree = 0
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        //step3 :
        int idx=0;
        while(!q.isEmpty())
        {
            int node = q.remove();
            topo[idx++]=node;

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }

        return topo;
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
//        output [4, 5, 0, 2, 3, 1]
    }



}
