package tree;

import tree.implementation.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryNodesOfBinaryTree {


    /*
        Create a list
        1. Add root node value
        2. Add left boundary nodes (excluding leaf nodes)
        3. Add leaf nodes
        4. Add right boundary nodes (excluding leaf nodes)
    */
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundaryNodes = new ArrayList<>();
        
        if (root == null) {
            return boundaryNodes;
        }
        
        // Add root to boundary nodes
        boundaryNodes.add(root.val);
        
        // Add left boundary (excluding leaf nodes)
        addLeftBoundary(root.left, boundaryNodes);
        
        // Add leaf nodes
        addLeafNodes(root, boundaryNodes);
        
        // Add right boundary (excluding leaf nodes and root if already added as left boundary)
        addRightBoundary(root.right, boundaryNodes);
        
        return boundaryNodes;
    }
    
    private void addLeftBoundary(TreeNode node, List<Integer> boundaryNodes) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        boundaryNodes.add(node.val);
        if (node.left != null) {
            addLeftBoundary(node.left, boundaryNodes);
        } else {
            addLeftBoundary(node.right, boundaryNodes);
        }
    }
    
    private void addLeafNodes(TreeNode node, List<Integer> boundaryNodes) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            boundaryNodes.add(node.val);
            return;
        }
        addLeafNodes(node.left, boundaryNodes);
        addLeafNodes(node.right, boundaryNodes);
    }
    
    private void addRightBoundary(TreeNode node, List<Integer> boundaryNodes) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        if (node.right != null) {
            addRightBoundary(node.right, boundaryNodes);
        } else {
            addRightBoundary(node.left, boundaryNodes);
        }
        boundaryNodes.add(node.val); // Add after child recursion to ensure correct order
    }
    
    public static void main(String[] args) {
        /*
         * Example tree:
         *        1
         *       / \
         *      2   3
         *     / \
         *    4   5
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        BoundaryNodesOfBinaryTree solution = new BoundaryNodesOfBinaryTree();
        List<Integer> boundaryNodes = solution.boundaryOfBinaryTree(root);
        
        System.out.println("Boundary nodes of the binary tree:");
        for (int node : boundaryNodes) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}