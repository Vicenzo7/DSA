package graph.dfs_bfs_problems;

import graph.implementation.GraphNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphCycleChecker {
    public static boolean hasCycle(GraphNode node) {
        Set<GraphNode> visited = new HashSet<>();
        Set<GraphNode> recursionStack = new HashSet<>();

        return hasCycleDFS(node, visited, recursionStack);
    }

    private static boolean hasCycleDFS(GraphNode node, Set<GraphNode> visited, Set<GraphNode> recursionStack) {
        if (node == null) {
            return false;
        }
        if (recursionStack.contains(node)) {
            return true; //cycle detected
        }

        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        recursionStack.add(node);

        for (GraphNode neighbor : node.neighbors) {
            if (hasCycleDFS(neighbor, visited, recursionStack)) {
                return true;
            }
        }

        recursionStack.remove(node);
        return false;
    }

    public static void main(String[] args) {
        // Create your graph and test for cycles
        GraphNode node1 = new GraphNode();
        GraphNode node2 = new GraphNode();
        GraphNode node3 = new GraphNode();
        GraphNode node4 = new GraphNode();

        node1.neighbors = List.of(node2);
        node2.neighbors = List.of(node3);
//        node3.neighbors = List.of(node1);
        node3.neighbors = List.of(node4);

        System.out.println("Has cycle: " + hasCycle(node1)); // Output: true
    }
}