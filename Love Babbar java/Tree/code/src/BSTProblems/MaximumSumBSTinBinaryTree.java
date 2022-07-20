package BSTProblems;

import java.util.Scanner;

public class MaximumSumBSTinBinaryTree {
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


    int max = 0;
    class NodeValue {
        int minNode;
        int maxNode;
        int maxSum;

        public NodeValue(int minNode, int maxNode,int maxSum){
            this.minNode=minNode;
            this.maxNode = maxNode;

            this.maxSum =maxSum;
        }
    }

    public  NodeValue solve(Node root){
        if(root == null){
            return new NodeValue (Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }

        NodeValue left = solve(root.left);
        NodeValue right = solve(root.right);

        if(left.maxNode < root.value && root.value < right.minNode){
            max = Math.max(max,root.value + left.maxSum+right.maxSum);
            return new NodeValue(Math.min(root.value,left.minNode) ,Math.max(root.value,right.maxNode),root.value + left.maxSum+right.maxSum);

        }

        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxSum,right.maxSum));

    }


    public int maxSumBST(Node root) {
        solve(root);
        return max;
    }


    public static void main(String[] args) {
        MaximumSumBSTinBinaryTree tree = new MaximumSumBSTinBinaryTree();
        Node root = tree.buildTree();

        System.out.println(tree.maxSumBST(root));
        // 1 4 2 -1 -1 4 -1 -1 3 2 -1 -1 5 4 -1 -1 6 -1 -1 --> output 20

        /**
         *               1
         *           /       \
         *          4          3
         *       /    \      /   \
         *     2       4   2      5
         *                       /  \
         *                      4    6
         *
         */
    }
}
