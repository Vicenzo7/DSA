package Problems;

import java.util.ArrayList;
import java.util.Scanner;

public class MorrisTraversalPreorder {
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

    public static ArrayList<Integer> getPreorder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Node cur = root;
        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.value);
                cur = cur.right;
            } else {
                // for link creation finding the right most node of left subtree
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                //link creation
                if (prev.right == null) {
                    prev.right = cur;
                    result.add(cur.value);
                    cur = cur.left;
                } else {
                    //link already present we de-link it
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return result;
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
        MorrisTraversalPreorder tree = new MorrisTraversalPreorder();
        Node root = tree.buildTree();
        ArrayList<Integer> ans = tree.getPreorder(root);

        System.out.println(ans);
    }
}
