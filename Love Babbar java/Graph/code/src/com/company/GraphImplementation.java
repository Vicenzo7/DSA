package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphImplementation {

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

//        addEdge(adj,1,2);
//        addEdge(adj,1,3);
//        addEdge(adj,1,5);
//        addEdge(adj,2,3);
//        addEdge(adj,2,4);
//        addEdge(adj,3,4);
//        addEdge(adj,5,3);

        //Enter the no of vertices/node
        //5
        //Enter the number of edges for undirected graph
        //7
        //give the inputs
        //1 2
        //1 3
        //1 5
        //2 3 2 4
        //3 4
        //5 3

        printGraph(adj);



    }
}
