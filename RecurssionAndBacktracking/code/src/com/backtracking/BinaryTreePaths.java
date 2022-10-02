package com.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryTreePaths {
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
    public  List<String> binaryTreePaths(Node root) {
        if (root == null)
            return res;

        solve(root,new StringBuilder());
        return res;
    }
     List<String> res = new ArrayList<>();

    public  void solve(Node root, StringBuilder sb)
    {
        if(root==null)
            return;
        int len = sb.length();
        sb.append(root.value);
        if(root.left == null && root.right == null)
        {
            res.add(sb.toString());
        }else{
            sb.append("->");
            solve(root.left,sb);
            solve(root.right,sb);
        }



        sb.setLength(len);
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
        BinaryTreePaths tree = new BinaryTreePaths();
        Node root = tree.buildTree();
        System.out.println(tree.binaryTreePaths(root));

        //1 2 -1 5 -1 -1 3 -1 -1
    }
}
