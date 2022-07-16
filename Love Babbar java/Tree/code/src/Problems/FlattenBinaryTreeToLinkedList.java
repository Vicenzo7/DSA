package Problems;

import java.util.Scanner;

public class FlattenBinaryTreeToLinkedList {

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


    public void flatten(Node root) {
        Node cur = root;
        while(cur != null)
        {
            if(cur.left != null)
            {
                Node pred = cur.left;
                while(pred.right !=null)
                {
                    pred = pred.right;
                }
                pred.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

    public void display(Node root)
    {
        Node cur = root;
        while(cur != null)
        {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
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
        FlattenBinaryTreeToLinkedList tree = new FlattenBinaryTreeToLinkedList();
        Node root = tree.buildTree();
        tree.flatten(root);
        tree.display(root);

        //1 2 3 -1 -1 4 -1 -1 5 -1 6 -1 -1
    }
}
