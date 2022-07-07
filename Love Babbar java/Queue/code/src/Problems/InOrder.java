package Problems;




import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InOrder {

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
        InOrder tree = new InOrder();
        InOrder.Node root = tree.buildTree();

        System.out.println("Printing In Order");
        tree.inOrder(root);
        System.out.println();



        //10 5 3 -1 -1 7 6 -1 -1 -1 11 -1 -1
    }
}
