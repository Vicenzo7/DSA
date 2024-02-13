
## Union Find Algorithm 

- **_Union-Find_ is NOT applicable on _DIRECTED Graphs_. It is only applicable to _Undirected Graphs_**.  
    
- **Most problems that can be solved by _Union-Find_, can also be solved by _DFS Connected Components_ approach.**

### Applications:

1) As explained above, Union-Find is used to determine the connected components in a graph. We can determine whether 2 nodes are in the same connected component or not in the graph. 
2) We can also determine that by adding an edge between 2 nodes whether it leads to cycle in the graph or not. We learned that we can reduce its complexity to a very optimum level, so in case of very large and dense graph we can use this data structure. 
3) It is used to determine the cycles in the graph. In the Kruskal’s Algorithm, Union Find Data Structure is used as a subroutine to find the cycles in the graph, which helps in finding the minimum spanning tree. This is explained in great details in [4 Ways to Finding Cycles](https://www.thealgorists.com/Algo/FindingCycles). and [Redundant Connection](https://www.thealgorists.com/Algo/UnionFind/RedundantConnection) .


Algorithm 
Union-Find, also known as Disjoint Set Union (DSU) or Merge-Find, is a data structure and algorithm used to efficiently perform two main operations on a collection of disjoint sets:

Union: Merge two sets into one set.
Find: Determine which set a particular element belongs to.

The Union-Find algorithm is often used in graph theory and can be employed to check for redundant connections or cycles in a graph.

Here's a brief explanation of how the Union-Find algorithm works:
Data Structure:

Parent Array: Each element in the set is initially its own parent. It is represented using an array where the index corresponds to the element, 
and the value at that index is the parent of the element.

Rank (or Size) Array: To optimize the Union operation, a rank array is maintained to keep track of the depth of each tree. 

This helps in making the Union operation more efficient by always attaching the smaller tree to the root of the larger tree.

Operations:
Initialization:
    Initialize each element as its own set, i.e., the parent of each element is itself.
    Initially, set the rank of each element to 1.

Find Operation:
Given an element, follow the chain of parent pointers until you reach the root of the set (representative element).
This operation is used to determine the set to which an element belongs.

Union Operation:
Find the representatives (roots) of the sets to which the two elements belong.
If the roots are different, merge the two sets by making one root the parent of the other.
Update the rank array to maintain balance in the trees (attach the smaller tree to the root of the larger tree).

Redundant Connection Check:

To check for redundant connections in an undirected graph, you can iterate through the edges. For each edge, perform the following steps:

Apply the Find operation to find the representatives of the sets to which the two endpoints of the edge belong.
If the representatives are the same, then adding this edge would create a cycle, making it redundant.
If the representatives are different, perform the Union operation to merge the two sets.

If at any point you encounter an edge whose endpoints already belong to the same set (have the same representative), then adding this edge would create a cycle, and it is considered a redundant connection.

The Union-Find algorithm efficiently handles these operations and is particularly useful for detecting cycles in graphs.

```
static int[] parent; // store root node  
static int[] rank; // size of the tree  
  
public static int[] findRedundantConnectionUnionFind(int[][] edges) {  
    parent = new int[edges.length + 1];  
    rank = new int[edges.length + 1];  
  
    for (int i = 0; i < edges.length; i++) {  
        parent[i] = i; // every node is parent of itself initially  
        rank[i] = 1; // size of each node is 1 initially  
    }  
  
    for (int[] edge : edges) {  
        // if union of this edge is not possible that mean this is the redundant edge  
        if (!union(edge[0], edge[1])) {  
            return edge;  
        }  
    }  
  
    return new int[2];  
}  
  
// finds the root node of X  
public static int find(int x) {  
    if (parent[x] != x) { // until its not the root node, root node is a parent of itself  
        parent[x] = find(parent[x]); // path compression  
    }  
  
    return parent[x];  
}  
  
// return false if already union  
public static boolean union(int x, int y) {  
    int rootX = find(x);  
    int rootY = find(y);  
  
    if (rootX == rootY) {  
        return false; // has same parent mean there is already a path  
    }  
  
    // to do union, attach smaller tree to root of larger tree  
    if (rank[rootX] > rank[rootY]) {  
        parent[rootY] = rootX;  
        rank[rootX] += rank[rootY];  
    } else {  
        parent[rootX] = rootY;  
        rank[rootY] += rank[rootX];  
    }  
  
    return true;  
}
```