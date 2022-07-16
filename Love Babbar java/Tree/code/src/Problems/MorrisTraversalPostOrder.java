package Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MorrisTraversalPostOrder {
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

    public static ArrayList<Integer> getPostorder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Node cur = root;
        while (cur != null) {
            if (cur.right == null) {
                result.add(cur.value);
                cur = cur.left;
            } else {
                // for link creation finding the left most node of right subtree
                Node prev = cur.right;
                while (prev.left != null && prev.left != cur) {
                    prev = prev.left;
                }
                //link creation
                if (prev.left == null) {
                    prev.left = cur;
                    result.add(cur.value);
                    cur = cur.right;
                } else {
                    //link already present we de-link it
                    prev.left = null;
                    cur = cur.left;
                }
            }
        }
        Collections.reverse(result);
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
        MorrisTraversalPostOrder tree = new MorrisTraversalPostOrder();
        Node root = tree.buildTree();
        ArrayList<Integer> ans = tree.getPostorder(root);

        System.out.println(ans);
    }
}
