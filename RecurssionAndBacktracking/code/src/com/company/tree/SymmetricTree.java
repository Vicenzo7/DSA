package com.company.tree;

import java.util.Scanner;

//https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
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


    public boolean isSymmetric(Node root) {
        if(root == null){
            return true;
        }
        return checkMirror(root.left,root.right);
    }


    public boolean checkMirror(Node a , Node b){

        if(a== null && b== null)
            return true;

        if(a != null && b == null)
            return false;

        if(a == null && b != null)
            return false;

        if(a.value != b.value)
            return false;

        boolean option1 = checkMirror(a.left,b.right);
        boolean option2 = checkMirror(a.right,b.left);
        boolean finalAns = option1 && option2;
        return finalAns;

    }

    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();
        Node root = tree.buildTree();
        // 1 2 3 -1 -1 4 -1 -1 2 4 -1 -1 3 -1 -1

        System.out.println("Tree Symmetric ?\n"+tree.isSymmetric(root));
    }
}
