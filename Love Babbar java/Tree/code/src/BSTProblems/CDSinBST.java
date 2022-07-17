package BSTProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CDSinBST {
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

        if(key < root.data){
            root.left = insertRec(root.left,key);
        }else{
            root.right = insertRec(root.right,key);
        }
        return root;
    }


    //Searching in BST
    public boolean searchKey(int key){
        Node ans = searchRec(root,key);
        if(ans!= null)
            return true;
        else
            return false;
    }

    private Node searchRec(Node root, int key) {
        if(root == null || root.data == key)
            return root;

        if(key < root.data)
            return searchRec(root.left,key);
        else
            return searchRec(root.right,key);
    }


    // to delete in BST
    public void deleteKey(int key)
    {
        root = deleteRec(root,key);
    }

    private Node deleteRec(Node root, int key) {
        if(root == null)
            return root;

        if(key < root.data)
            root.left=deleteRec(root.left,key);
        else if (key > root.data)
            root.right=deleteRec(root.right,key);
        else{
            // node with one or no child
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            //node with two child : get inorder successor (min in the right subtree)

            root.data = minVal(root.right);

            //delete the inorder successor
            root.right = deleteRec(root.right,root.data);
        }
        return root;
    }

    private int minVal(Node root) {
        int min = root.data;
        while(root.left != null){
            root = root.left;
            min = root.data;
        }
        return min;
    }


    public void levelOrder()
    {
        levelOrderRec(root);
    }

    private void levelOrderRec(Node root) {
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        que.add(null);

        while(!que.isEmpty())
        {
            Node front = que.remove();
            if(front == null){
                System.out.println();

                if(!que.isEmpty())
                    que.add(null);
            }else{
                System.out.print(front.data + " ");

                if(front.left != null)
                    que.add(front.left);
                if (front.right != null)
                    que.add(front.right);
            }
        }
    }


    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    public static void main(String[] args) {
        CDSinBST tree = new CDSinBST();
        tree.insertKey(50);
        tree.insertKey(30);
        tree.insertKey(70);
        tree.insertKey(20);
        tree.insertKey(40);
        tree.insertKey(60);
        tree.insertKey(80);

        tree.levelOrder();

//        System.out.println(tree.searchKey(70));
        //leaf node
        tree.deleteKey(20);
        System.out.println("After deleting 20");
        tree.levelOrder();
        System.out.println();

        //node with single child
        tree.deleteKey(30);
        System.out.println("After deleting 30");
        tree.levelOrder();
        System.out.println();


        //node with two child
        tree.deleteKey(50);
        System.out.println("After deleting 50");
        tree.levelOrder();
        System.out.println();
    }
}
