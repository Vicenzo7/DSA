package Problems;

import java.util.Scanner;

public class PostOrder {

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
        // write your code here
        PostOrder tree = new PostOrder();
        PostOrder.Node root = tree.buildTree();

        System.out.println("Printing Post Order");
        tree.postOrder(root);
        System.out.println();



        //10 5 3 -1 -1 7 6 -1 -1 -1 11 -1 -1
    }
}
