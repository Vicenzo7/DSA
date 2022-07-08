package Problems;




import java.util.Scanner;

public class PreOrder {

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
        PreOrder tree = new PreOrder();
        PreOrder.Node root = tree.buildTree();


        System.out.println("Printing Pre Order");
        tree.preOrder(root);
        System.out.println();



        //10 5 3 -1 -1 7 6 -1 -1 -1 11 -1 -1
    }
}
