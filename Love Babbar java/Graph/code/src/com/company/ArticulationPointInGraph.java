package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticulationPointInGraph {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void printArticulation(ArrayList<ArrayList<Integer>> adj, int N) {
        boolean[] vis = new boolean[N];
        int[] tin = new int[N];
        int[] low = new int[N];

        int[] isArticulation = new int[N];

        int timer = 0;
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                dfs(i, -1, adj, vis, tin, low, timer, isArticulation);
            }
        }

        for (int i = 0; i < N; i++) {
            if (isArticulation[i] == 1) {
                System.out.print(i + " ");
            }
        }
    }


    private static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] tin, int[] low, int timer, int[] isArticulation) {
        vis[node] = true;
        tin[node] = low[node] = timer++;

        int child = 0;
        for (int it : adj.get(node)) {
            if (it == parent) continue;

            if (!vis[it]) {
                dfs(it, node, adj, vis, tin, low, timer, isArticulation);
                low[node] = Math.min(low[node], low[it]);

                if (low[it] >= tin[node] && parent != -1) {
                    isArticulation[node] = 1;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        // to check if first node can be an articulation point
        if (parent == -1 && child >= 1)
            isArticulation[node] = 1;

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertices/node");
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
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

        printArticulation(adj,n);
    }
}
