package com.company.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Preorder {

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

    public void preorder(Node root, ArrayList<Integer> arr){
        // baseCase
        if(root == null){
            return ;
        }

        // node
        arr.add(root.value);
        // left
        preorder(root.left,arr);
        // right
        preorder(root.right,arr);
    }

    public static void main(String[] args) {
        Preorder tree = new Preorder();
        Node root = tree.buildTree();

        ArrayList<Integer> arr = new ArrayList<>();
        tree.preorder(root,arr);
        System.out.println(arr);
        //5 7 10 -1 -1 1 -1 -1 9 15 -1 -1 16 -1 -1
    }
}
