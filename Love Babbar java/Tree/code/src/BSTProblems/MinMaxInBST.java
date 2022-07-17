package BSTProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MinMaxInBST {
    Scanner sc = new Scanner(System.in);
    Node root;
    public Node buildBST(Node root, int data) {
        if (root == null) {
            Node temp = new Node(data);
            return temp;
        }

        if (data > root.value) {
            root.right = buildBST(root.right, data);
        } else {
            root.left = buildBST(root.left, data);
        }
        return root;
    }

    public void createBST() {
        System.out.println("Enter data for root node");
        int data = sc.nextInt();

        while (data != -1) {
            root = buildBST(root, data);
            System.out.println("Enter data for node");
            data = sc.nextInt();
        }
    }

    public void levelOrder(Node root) {
        Queue<Node> que = new LinkedList<>();
        que.add(root);

        //
        que.add(null);

        while (!que.isEmpty()) {

            Node front = que.remove();
            if (front == null) {
                System.out.println();
                //catch here
                if (!que.isEmpty()) {
                    que.add(null);
                }
            } else {
                System.out.print(front.value + " ");

                if (front.left != null)
                    que.add(front.left);

                if (front.right != null)
                    que.add(front.right);
            }

        }
    }

    //Minimum in BST
    public int minInBST(Node root)
    {
        int min = root.value;
        while(root.left!=null)
        {
            root = root.left;
            min = root.value;
        }

        return min;
    }

    //Maximun in BST
    public int maxInBST(Node root)
    {
        int max = root.value;
        while(root.right!=null)
        {
            root = root.right;
            max = root.value;
        }

        return max;
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
        MinMaxInBST tree = new MinMaxInBST();
        tree.createBST();
        tree.levelOrder(tree.root);

        System.out.println("Maximum in BST: "+tree.maxInBST(tree.root));
        System.out.println("Minimum in BST: "+tree.minInBST(tree.root));
    }
}
