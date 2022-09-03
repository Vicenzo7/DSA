package com.company.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Inorder {

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


    public void inorder(Node root, ArrayList<Integer> arr){
        // baseCase
        if(root == null){
            return ;
        }

        // left
        inorder(root.left,arr);

        // node
        arr.add(root.value);

        // right
        inorder(root.right,arr);
    }

    public static void main(String[] args) {
        Inorder tree = new Inorder();
        Node root = tree.buildTree();

        tree.levelOrder(root);
        ArrayList<Integer> arr = new ArrayList<>();
        tree.inorder(root,arr);
        System.out.println(arr);
        //5 7 10 -1 -1 1 -1 -1 9 15 -1 -1 16 -1 -1
    }
}
