package graph.dfs_bfs_problems;

import graph.implementation.GraphNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {
//        [[2,4],[1,3],[2,4],[1,3]]
        // Constructing nodes
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);

        // Connecting neighbors
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        System.out.println(cloneGraph(node1).val);
        System.out.println(cloneGraphDFS(node1).val);
    }


    public static GraphNode cloneGraphDFS(GraphNode node) {
        if (node == null) {
            return null;
        }
        Map<Integer, GraphNode> originalToCloneMap = new HashMap<>();
        return dfs(node, originalToCloneMap);
    }

    private static GraphNode dfs(GraphNode node, Map<Integer, GraphNode> originalToCloneMap) {
        if (originalToCloneMap.containsKey(node.val)) {
            return originalToCloneMap.get(node.val);
        }

        GraphNode copyNode = new GraphNode(node.val);
        originalToCloneMap.put(node.val, copyNode);
        for (GraphNode neighbor : node.neighbors) {
            copyNode.neighbors.add(dfs(neighbor, originalToCloneMap));
        }

        return copyNode;
    }

    public static GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        }

        Map<GraphNode, GraphNode> originalToCloneMap = new HashMap<>();

        Deque<GraphNode> deque = new ArrayDeque<>();
        deque.add(node);
        while (!deque.isEmpty()) {
            GraphNode graphNode = deque.removeFirst();
            GraphNode copyNode = new GraphNode(graphNode.val);
            originalToCloneMap.put(graphNode, copyNode);
            for (GraphNode neighbor : graphNode.neighbors) {
                if (!originalToCloneMap.containsKey(neighbor)) {
                    deque.add(neighbor);
                }
            }
        }


        for (Map.Entry<GraphNode, GraphNode> graphNodeGraphNodeEntry : originalToCloneMap.entrySet()) {
            GraphNode graphNode = graphNodeGraphNodeEntry.getKey();
            GraphNode copy = graphNodeGraphNodeEntry.getValue();
            for (GraphNode neighbor : graphNode.neighbors) {
                GraphNode neighborCopy = originalToCloneMap.get(neighbor);
                copy.neighbors.add(neighborCopy);
            }
        }

        return originalToCloneMap.get(node);
    }
}
