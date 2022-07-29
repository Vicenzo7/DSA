package Problems;

import java.util.HashMap;
import java.util.Scanner;

public class KthAncestorInATree {
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


    public void storeParents(Node root, HashMap<Integer, Integer> map) {
        if (root == null)
            return;

        if (root.left != null)
            map.put(root.left.value, root.value);

        if (root.right != null)
            map.put(root.right.value, root.value);

        storeParents(root.left, map);
        storeParents(root.right, map);
    }

    public int kthAncestor(Node root, int k, int node) {
        //Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(root.value, -1);

        storeParents(root, map);
        int x = node;
        while (x != -1 && k != 0) {
            x = map.get(x);
            k--;
        }

        return x;
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
        KthAncestorInATree tree = new KthAncestorInATree();
        Node root = tree.buildTree();

        System.out.println(tree.kthAncestorOptimised(root, 2, 8));
        //1 2 4 -1 -1 5 -1 8 -1 -1 3 6 -1 -1 7 -1 -1
    }


    int rem;

    public int kthAncestorOptimised(Node root, int k, int node) {
        rem = k;
        Node ans = solve(root, node);
        if (ans == null || ans.value == node)
            return -1;
        else return ans.value;
    }

    Node solve(Node root, int target) {
        if (root == null)
            return null;
        if (root.value == target)
            return root;

        Node left = solve(root.left, target);
        Node right = solve(root.right, target);

        if (left != null && right == null) {
            rem = rem - 1;

            if (rem == 0) {
                rem = Integer.MAX_VALUE;
                return root;
            }

            return left;
        } else if (left == null && right != null) {
            rem = rem - 1;

            if (rem == 0) {
                rem = Integer.MAX_VALUE;
                return root;
            }

            return right;
        } else {
            return null;
        }
    }
}
