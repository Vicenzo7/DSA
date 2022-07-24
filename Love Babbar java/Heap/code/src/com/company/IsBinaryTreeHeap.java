package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IsBinaryTreeHeap {

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



     boolean isHeap(Node root) {


        if(isCompleteBT(root)){
            return checkHeap(root);
        }else{
            return false;
        }

    }


     boolean checkHeap(Node root){


        if(root.left == null && root.right == null){
            return true;
        }

        if(root.right == null){
            return root.value > root.left.value;
        }
        else if (root.value > root.left.value && root.value > root.right.value){
            boolean left = isHeap(root.left);
            boolean right = isHeap(root.right);

            return left && right;
        }

        return false;
    }


     boolean isCompleteBT(Node root)
    {
        boolean end = false;
        Queue<Node> que = new LinkedList<>();

        que.offer(root);
        while(!que.isEmpty()){
            Node cur = que.poll();
            if(cur == null){
                end = true;
            }else{
                if(end) return false;
                que.offer(cur.left);
                que.offer(cur.right);
            }
        }

        return true;
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
        IsBinaryTreeHeap tree = new IsBinaryTreeHeap();
        Node  root = tree.buildTree();

        System.out.println(tree.isHeap(root));

        //50 40 30 -1 -1 31 -1 -1 41 35 -1 -1 -1
    }
}
