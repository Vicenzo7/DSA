package com.company;
//https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BellmanFordAlgo {
    static class Node {
        private int u;
        private int v;
        private int weight;

        public Node(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public int getU() {
            return u;
        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }
    }

    void addEdge(ArrayList<Node> adj, int u, int v, int w) {
        adj.add(new Node(u, v, w));
    }

    public void bellmanFordAlgo(ArrayList<Node> adj, int src, int N) {
        int[] distance = new int[N];
        Arrays.fill(distance, 100000);
        distance[src] = 0;

        // relaxing each edges N-1 times
        for (int i = 1; i <= N - 1; i++) {
            for (Node it : adj) {
                if (distance[it.getU()] + it.getWeight() < distance[it.getV()]) {
                    distance[it.getV()] = distance[it.getU()] + it.getWeight();
                }
            }
        }

        // checking if negative cycle present or not by relaxing one more time
        boolean isNegativeCyclePresent = false;
        for (Node it : adj) {
            if (distance[it.getU()] + it.getWeight() < distance[it.getV()]) {
                distance[it.getV()] = distance[it.getU()] + it.getWeight();
                isNegativeCyclePresent = true;

                break;
            }
        }

        if (isNegativeCyclePresent) {
            System.out.println("Negative cycle present");
        } else {
            for (int i = 0; i < N; i++) {
                System.out.println("From " + src + " to " + i + " distance is " + distance[i]);
            }
        }
    }

    public static void main(String[] args) {
        BellmanFordAlgo obj = new BellmanFordAlgo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertices/node");
        int n = sc.nextInt();

        ArrayList<Node> adj = new ArrayList<>();
        System.out.println("Enter the number of edges for Directed graph");
        int m = sc.nextInt();

        System.out.println("give the inputs ");

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            obj.addEdge(adj, u, v, w);
        }
        System.out.println("Enter the source");
        int src = sc.nextInt();

        obj.bellmanFordAlgo(adj, src, n);
    }
}
