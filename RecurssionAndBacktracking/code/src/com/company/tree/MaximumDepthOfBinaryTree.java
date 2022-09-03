package com.company.tree;

import java.util.Scanner;

public class MaximumDepthOfBinaryTree {

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


    public int maxDepth(Node root) {
        // if empty tree height = 0
        if(root == null)
            return 0;

        return height(root);
    }

    public int height(Node root){

        // base case
        if(root == null)
            return 0;

        int leftAns = height(root.left);
        int rightAns = height(root.right);

        return Math.max(leftAns,rightAns) + 1;

    }


    public static void main(String[] args) {
        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();

        Node root = tree.buildTree();
        // 3 9 -1 -1 20 15 -1 -1 7 -1 -1
        System.out.println("Max Height of given tree is : " +tree.maxDepth(root));
    }
}
