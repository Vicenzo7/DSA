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

    public int height(Node root){
        if(root == null)
            return 0;

        int leftAns =  height(root.left);
        int rightAns =  height(root.right);

        return 1+Math.max(leftAns,rightAns);
    }

    public int diameter(Node root){
        if(root == null ){
            return 0;
        }
        int option1 = diameter(root.left);
        int option2 = diameter(root.right);
        int option3 = 1 + height(root.left) + height(root.right);

        return Math.max(option1,Math.max(option2,option3));
    }

    public int diameterOfBinaryTree(Node root) {
        if(root == null)
            return 0;

        return diameter(root)-1;
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
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
        Node  root = tree.buildTree();

        System.out.println("Diameter of Binary tree is " + tree.diameterOfBinaryTree(root));
        //10 5 3 -1 -1 7 6 -1 -1 -1 11 -1 -1
    }
}
