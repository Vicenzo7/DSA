package com.company;

import java.util.*;
import java.util.Queue;

public class ShortestPathInUndirectedGraphsWithUnitWeight {
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

    public static int[] shortestPath(ArrayList<ArrayList<Integer>> adj,int N , int src){

        int[] distance = new int[N];
        for (int i = 0; i <N ; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> q = new LinkedList<>();
        distance[src]=0;
        q.add(src);

        while(!q.isEmpty()){
            int node = q.remove();

            for(int it : adj.get(node)){
                if(distance[node]+1 < distance[it]){
                    distance[it]= distance[node]+1;
                    q.add(it);
                }
            }
        }

        return distance;
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
        int N = adj.size();
        System.out.println(Arrays.toString(shortestPath(adj, N, 0)));

        //output
        //Enter the no of vertices/node
        //8
        //Enter the number of edges for undirected graph
        //11
        //give the inputs
        //0 1
        //0 3
        //1 2
        //1 3
        //2 6
        //3 4
        //4 5
        //5 6
        //6 7
        //6 8
        //7 8
        //[0, 1, 2, 1, 2, 3, 3, 4, 4]
    }
}