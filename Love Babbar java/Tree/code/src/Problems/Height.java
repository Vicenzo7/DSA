package Problems;
//https://leetcode.com/problems/maximum-depth-of-binary-tree/
import java.util.Scanner;

public class Height {
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
        Height tree = new Height();
        Height.Node root = tree.buildTree();

        System.out.println("Height of the tree is "+tree.height(root));
        //10 5 3 -1 -1 7 6 -1 -1 -1 11 -1 -1
    }
}
