package BSTProblems;

import java.util.Scanner;

public class LargestBSTinBT {
    Scanner sc = new Scanner(System.in);


    public Node buildTree() {
        System.out.println("Enter the data");
        int data = sc.nextInt();

        if (data == -1)
            return null;

        Node newNode = new Node(data);

        System.out.println("Enter the data for left child of " + data);
        newNode.left = buildTree();

        System.out.println("Enter the data for right child of " + data);
        newNode.right = buildTree();

        return newNode;
    }

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


    class NodeValue {
        int minNode;
        int maxNode;
        int maxSize;

        public NodeValue(int minNode, int maxNode, int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }


    public NodeValue solve(Node root) {
        // An empty tree is a BST of size 0.
        if (root == null)
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        // Get values from left and right subtree of current tree.
        NodeValue left = solve(root.left);
        NodeValue right = solve(root.right);

        // Current node is greater than max in left AND smaller than min in right, it is a BST.
        if (left.maxNode < root.value && root.value < right.minNode) {
            /// It is a BST.
            return new NodeValue(Integer.min(root.value, left.minNode),Integer.max(root.value, right.maxNode),left.maxSize+ right.maxSize+1);
        }

        // Otherwise, return [-inf, inf] so that parent can't be valid BST
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxSize, right.maxSize));
    }

    int largestBst(Node root) {
        // Write your code here
        return solve(root).maxSize;
    }


    public static void main(String[] args) {
        LargestBSTinBT tree = new LargestBSTinBT();
        Node root = tree.buildTree();

        System.out.println(tree.largestBst(root));
        // 20 15 14 -1 17 -1 -1 18 16 -1 -1 19 -1 -1 40 30 -1 -1 60 50 -1 -1 -1

        /**
         *               20
         *           /       \
         *          15        40
         *       /    \      /   \
         *     14      18   30    60
         *       \     /  \      /
         *        17  16   19   50
         *
         */
    }
}
