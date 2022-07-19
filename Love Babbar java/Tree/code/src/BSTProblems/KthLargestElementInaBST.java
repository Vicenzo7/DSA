package BSTProblems;

import java.util.ArrayList;

public class KthLargestElementInaBST {

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

        if(key < root.value){
            root.left = insertRec(root.left,key);
        }else{
            root.right = insertRec(root.right,key);
        }
        return root;
    }

    public int kthLargest(Node root, int k) {
        inorder(root);
        return ans.get(ans.size()-k);
    }
    ArrayList<Integer> ans = new ArrayList<>();
    public void  inorder(Node root){
        if(root == null)
            return;
        //left
        inorder(root.left);
        //add
        ans.add(root.value);
        //right
        inorder(root.right);
    }


    int count =0;
    public int kthLargestOptimised(Node root, int k) {
        if(root == null)
            return -1;

        int right = kthLargestOptimised(root.right,k);
        if(right !=-1)return right;

        count++;
        if(count ==k)
            return root.value;

        int left = kthLargestOptimised(root.left,k);
        if(left !=-1)return left;

        return -1;
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
        KthLargestElementInaBST tree = new KthLargestElementInaBST();
        tree.insertKey(5);
        tree.insertKey(3);
        tree.insertKey(6);
        tree.insertKey(2);
        tree.insertKey(4);
        tree.insertKey(1);

        System.out.println(tree.kthLargestOptimised(tree.root,3));

        System.out.println(tree.kthLargest(tree.root, 3));

    }
}
