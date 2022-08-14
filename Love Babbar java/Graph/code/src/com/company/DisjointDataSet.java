package com.company;

import java.util.Scanner;

public class DisjointDataSet {
	static int[] parent = new int[100000]; // 10^5
	static int[] rank = new int[100000];


	static void makeSet(int N){
		for (int i=0;i<N;i++ ) {
			parent[i] = i;
			rank[i]=0;
		}
	}

	// eg 7 -> 6 -> 4 -> 3
	static int findPar(int node){
		if(node == parent[node]){
			return node;
		}
		// to make it path compressed just save what's comes from the recursion into parent[node]
		return parent[node]=findPar(parent[node]);
	}

	static void union(int u, int v){
		// find parent of both nodes
		u = findPar(u);
		v = findPar(v);

		// now see the rank of their parent
		if(rank[u] < rank[v]){
			parent[u] = v;
		}else if(rank[u] > rank[v]){
			parent[v]=u;
		} else { 
			// if equal we can attach anyone to one of the other
			// attaching v to u
			parent[v]=u;

			// and only increase the rank if they are equal,now increase the rank of the node to whom its attached
			rank[u]++;
		}

	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Size");
		int n= sc.nextInt();
		makeSet(n);

		int m = sc.nextInt();
		while(m!=0){
			int u = sc.nextInt();
			int v = sc.nextInt();

			union(u,v);
			m--;
		}

		// eg: too check if 2 and 3 belong to the same component
		if(findPar(2) != findPar(3)){
			System.out.println("Different Component");
		}else{
			System.out.println("Same Component");
		}

	}
}