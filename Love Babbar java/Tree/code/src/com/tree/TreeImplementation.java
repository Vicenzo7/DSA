package com.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeImplementation {
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

    // preorder
    public void preOrder(Node root) {
        //base case
        if (root == null)
            return;

        //Node
        System.out.print(root.value + " ");
        //left
        preOrder(root.left);
        //right
        preOrder(root.right);
    }

    //inorder
    public void inOrder(Node root) {
        //base case
        if (root == null)
            return;

        //left
        inOrder(root.left);

        //Node
        System.out.print(root.value + " ");

        //right
        inOrder(root.right);
    }


    // post order
    public void postOrder(Node root) {
        //base case
        if (root == null)
            return;

        //left
        postOrder(root.left);

        //right
        postOrder(root.right);

        //Node
        System.out.print(root.value + " ");
    }


    public void levelOrder(Node root) {
        Queue<Node> que = new LinkedList<>();
        que.add(root);

        //
        que.add(null);

        while (!que.isEmpty()) {

            Node front = que.remove();
            if (front == null) {
                System.out.println();
                //catch here
                if (!que.isEmpty()) {
                    que.add(null);
                }
            } else {
                System.out.print(front.value + " ");

                if (front.left != null)
                    que.add(front.left);

                if (front.right != null)
                    que.add(front.right);
            }

        }
    }

    public int height(Node root){
        if(root == null)
            return 0;

        int leftAns =  height(root.left);
        int rightAns =  height(root.right);

        return 1+Math.max(leftAns,rightAns);
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


    public static void main(String[] args) {
        // write your code here
        TreeImplementation tree = new TreeImplementation();
        Node root = tree.buildTree();

        System.out.println("Printing Pre Order");
        tree.preOrder(root);
        System.out.println();
        System.out.println("Printing In Order");
        tree.inOrder(root);
        System.out.println();
        System.out.println("Printing Post Order");
        tree.postOrder(root);
        System.out.println();
        System.out.println("Printing Level Order");
        tree.levelOrder(root);

        System.out.println("Height of the tree is " + tree.height(root));


        //10 5 3 -1 -1 7 6 -1 -1 -1 11 -1 -1
    }
}
