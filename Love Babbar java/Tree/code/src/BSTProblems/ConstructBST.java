package BSTProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConstructBST {
    Scanner sc = new Scanner(System.in);

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

    Node root;

//    public ConstructBST() {
//        this.root = null;
//    }

    public Node buildBST(Node root, int data) {
        if (root == null) {
            Node temp = new Node(data);
            return temp;
        }

        if (data > root.value) {
            root.right = buildBST(root.right, data);
        } else {
            root.left = buildBST(root.left, data);
        }
        return root;
    }

    public void createBST() {
        System.out.println("Enter data for root node");
        int data = sc.nextInt();

        while (data != -1) {
            root = buildBST(root, data);
            System.out.println("Enter data for node");
            data = sc.nextInt();
        }
    }

    //delete
    public void deleteKey(int key)
    {
        root = deleteRec(root,key);
    }

    private Node deleteRec(Node root, int key) {
        if(root == null)
            return root;

        if(key < root.value)
            root.left = deleteRec(root.left,key);
        else if(key > root.value)
            root.right = deleteRec(root.right,key);

        else{
            //leaf node or a single child node
            if(root.left==null)
                return root.right;
            else if (root.right==null)
                return root.left;

            //node with two child:get inorder successor(smallest in right subtree)
            root.value = minValue(root.right);

            root.right = deleteRec(root.right, root.value);
        }
        return root;
    }

    private int minValue(Node root) {
        int minVal = root.value;
        while(root.left!=null){
            root = root.left;
            minVal= root.value;

        }
        return minVal;
    }

    //searching
    public boolean searchKey(int key) {
        Node ans = searchRec(root,key);
        if (ans != null)
            return true;
        else
            return false;
    }

    public Node searchRec(Node root,int key)
    {
        if(root == null || root.value==key)
            return root;

        if(root.value < key)
           return  searchRec(root.right,key);
        else
            return searchRec(root.left,key);
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
       Scanner sc = new Scanner(System.in);
        ConstructBST tree = new ConstructBST();
        tree.createBST();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */

        tree.levelOrder(tree.root);
//        System.out.println("Printing Inorder");
//        tree.inOrder(tree.root);
//        System.out.println();
//
//        System.out.println("Printing preorder");
//        tree.preOrder(tree.root);
//        System.out.println();
//
//        System.out.println("Printing Postorder");
//
//        tree.postOrder(tree.root);
//        System.out.println();

//        System.out.println("Enter the element to find");
//        int toFind=sc.nextInt();
//
//
//        boolean ans = tree.searchKey(toFind);

//        System.out.println(ans);

        tree.deleteKey(20);
        tree.levelOrder(tree.root);

        tree.deleteKey(30);
        tree.levelOrder(tree.root);

        tree.deleteKey(50);
        tree.levelOrder(tree.root);
    }
}
