package Problems;

import java.util.Scanner;

public class PathSum {

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
    public boolean hasPathSum(Node root, int targetSum) {
        if(root == null)
            return false;

        if(root.value == targetSum && root.left == null && root.right == null)
            return true;

        boolean leftAns = hasPathSum(root.left, targetSum - root.value);
        boolean rightAns = hasPathSum(root.right, targetSum - root.value);

        return leftAns || rightAns;

    }

    public static void main(String[] args) {
        PathSum tree = new PathSum();
        Node root = tree.buildTree();
        // 5 4 11 7 -1 -1 2 -1 -1 -1 8 13 -1 -1 4 -1 1 -1 -1
        System.out.println(tree.hasPathSum(root,22));
    }
}
