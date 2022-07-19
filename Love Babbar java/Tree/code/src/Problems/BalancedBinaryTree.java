package Problems;

import java.util.Scanner;

public class BalancedBinaryTree {
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

    boolean isBal = true;
    public boolean isBalanced(Node root) {
        if(root == null)
            return true;

        int g= height(root);
        return isBal;
    }

    public int height(Node root)
    {
        if(root == null)
            return 0;

        int leftHeight= height(root.left);
        int rightHeight= height(root.right);

        //repeatedly checking if each node is balanced or not
        if(Math.abs(leftHeight - rightHeight) >1)
            isBal = false;

        return 1+Math.max(leftHeight,rightHeight);
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
        BalancedBinaryTree tree = new BalancedBinaryTree();
        Node root = tree.buildTree();
        System.out.println(tree.isBalanced(root));

        //3 9 -1 -1 20 15 -1 -1 7 -1 -1  balanced

        //1 2 3 4 -1 -1 4 -1 -1 3 -1 -1 2 -1 -1  not balanced
    }
}
