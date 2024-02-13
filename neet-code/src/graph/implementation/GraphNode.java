package graph.implementation;

import java.util.ArrayList;
import java.util.List;

    public class GraphNode {
        public int val;
        public List<GraphNode> neighbors;

    public GraphNode() {
        neighbors = new ArrayList<>();
    }

    public GraphNode(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public GraphNode(int val, List<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
//
//    @Override
//    public String toString() {
//        return "GraphNode{" +
//                "val=" + val +
//                ", neighbors=" + neighbors +
//                '}';
//    }
}
