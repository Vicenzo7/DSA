package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConvertBSTtoMinHeap {
    Scanner sc = new Scanner(System.in);

    Node root;

    // creating a BST
    public void insertKey(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.value) {
            root.left = insertRec(root.left, key);
        } else {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    int[] arr = new int[500];
    int i = 0;

    public void inorder() {
        inorderRec(root);

    }

    public void inorderRec(Node root) {
        if(root == null)
            return;
        //left
        inorderRec(root.left);
        //Node
        arr[i++] = root.value;
        //right
        inorderRec(root.right);
    }


    public void preorder() {
        preorderRec(root);
    }

    int k = 0;

    private void preorderRec(Node root) {
        if(root == null)
            return;
        //Node
        root.value = arr[k++];
        //left
        preorderRec(root.left);
        //right
        preorderRec(root.right);
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
        ConvertBSTtoMinHeap tree = new ConvertBSTtoMinHeap();

        tree.insertKey(4);
        tree.insertKey(2);
        tree.insertKey(6);
        tree.insertKey(1);
        tree.insertKey(3);
        tree.insertKey(5);
        tree.insertKey(7);

        tree.levelOrder();


        tree.inorder();
        tree.preorder();

        tree.levelOrder();


    }

    private void levelOrder() {
        levelOrderRec(root);
    }

    private void levelOrderRec(Node root) {
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        while (!que.isEmpty()) {
            Node cur = que.remove();
            if (cur == null) {
                System.out.println();
                if (!que.isEmpty()) {
                    que.add(null);
                }
            } else {
                System.out.print(cur.value + " ");
                if (cur.left != null)
                    que.add(cur.left);
                if (cur.right != null) {
                    que.add(cur.right);
                }
            }

        }
    }
}
