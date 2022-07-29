package Problems;

import java.util.Scanner;

public class SumTree {

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

    int sum(Node root){
        if(root == null)
            return 0;

        int left = sum(root.left);
        int right = sum(root.right);

        return left+right+root.value;
    }
    boolean isSumTree(Node root)
    {
        if(root == null || (root.left==null && root.right ==null))
            return true;


        int left = sum(root.left);
        int right = sum(root.right);

        if(left+right == root.value && isSumTree(root.left) && isSumTree(root.right)){
            return true;
        }
        else{
            return false;
        }

    }


    public static void main(String[] args) {
        SumTree tree = new SumTree();
        Node root = tree.buildTree();
        // 26 10 4 -1 -1 6 -1 -1 3 -1 3 -1 -1
        System.out.println(tree.isSumTree(root));
    }
}
