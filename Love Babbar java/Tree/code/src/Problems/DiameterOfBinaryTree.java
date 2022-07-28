package Problems;

import java.util.Scanner;

public class DiameterOfBinaryTree {
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

//    public int height(Node root){
//        if(root == null)
//            return 0;
//
//        int leftAns =  height(root.left);
//        int rightAns =  height(root.right);
//
//        return 1+Math.max(leftAns,rightAns);
//    }
//
//    public int diameter(Node root){
//        if(root == null ){
//            return 0;
//        }
//        int option1 = diameter(root.left);
//        int option2 = diameter(root.right);
//        int option3 = 1 + height(root.left) + height(root.right);
//
//        return Math.max(option1,Math.max(option2,option3));
//    }
//
//    public int diameterOfBinaryTree(Node root) {
//        if(root == null)
//            return 0;
//
//        return diameter(root)-1;
//    }

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
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
        Node  root = tree.buildTree();

        System.out.println("Diameter of Binary tree is " + tree.diameter(root));
        //10 5 3 -1 -1 7 6 -1 -1 -1 11 -1 -1
    }


    class Pair {
        int diameter;
        int height;
    }
    // Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        return diameterFast(root).diameter;
    }


    Pair diameterFast(Node root){
        if(root == null){
            Pair p = new Pair();
            p.diameter = 0;
            p.height = 0;
            return p;
        }


        Pair left = diameterFast(root.left);
        Pair right = diameterFast(root.right);

        int op1 = left.diameter;
        int op2 = right.diameter;
        int op3 = left.height + right.height +1;

        Pair ans = new Pair();
        ans.diameter = Math.max(op1,Math.max(op2,op3));
        ans.height = Math.max(left.height ,right.height)+1;

        return ans;
    }
}
