package BSTProblems;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckIfTreeIsBST {
    Scanner sc = new Scanner(System.in);

    // creating a BST
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


    //inorder
    ArrayList<Integer> ans = new ArrayList<>();
    public ArrayList<Integer> getInorde(Node root)
    {
        inOrder(root);
        return ans;
    }
    public void inOrder(Node root) {
        //base case
        if (root == null)
            return;

        //left
        inOrder(root.left);

        //Node
        ans.add(root.value);

        //right
        inOrder(root.right);
    }

    public boolean isBST2(Node root){
        ArrayList<Integer> inorder = getInorde(root);
        for (int i = 0; i < inorder.size()-1; i++) {
            if(inorder.get(i) >= inorder.get(i+1))
                return false;
        }
        return true;
    }

    public boolean isBST(Node root,int min,int max){
        if(root == null)
            return true;

        if(min< root.value && root.value<max){
            boolean left=isBST(root.left,min, root.value);
            boolean right=isBST(root.right,root.value,max);
            return left && right;
        }
        return false;

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
        CheckIfTreeIsBST tree = new CheckIfTreeIsBST();
        Node root = tree.buildTree();

        //inorder approach
        System.out.println(tree.isBST2(root));


        System.out.println(tree.isBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE));

        //100 50 20 -1 -1 70 -1 -1 110 -1 200 -1 -1  is a BST
        //50 40 30 -1 -1 45 41 -1 -1 47  -1 -1 60 65 -1 -1 70 -1 -1  is not  a BST
    }
}
