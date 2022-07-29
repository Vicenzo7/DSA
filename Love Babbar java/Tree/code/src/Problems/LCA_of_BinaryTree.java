package Problems;

import java.util.Scanner;

public class LCA_of_BinaryTree {
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

    public Node lowestCommonAncestor(Node root, int p, int q) {
        if(root == null)
            return null;
        if(root.value == p || root.value == q){
            return root;
        }else{
            Node left = lowestCommonAncestor(root.left,p,q);
            Node right = lowestCommonAncestor(root.right,p,q);

            if(left != null && right!=null)
                return root;
            else if(left == null  && right!= null)
                return right;
            else
                return left;
        }
    }

    public static void main(String[] args) {
        LCA_of_BinaryTree tree = new LCA_of_BinaryTree();
        Node root = tree.buildTree();
         //3 5 6 -1 -1 2 7 -1 -1 4 -1 -1 1 0 -1 -1 8 -1 -1
        System.out.println(tree.lowestCommonAncestor(root,6,7).value);
    }
}
