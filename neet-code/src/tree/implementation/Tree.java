package tree.implementation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Tree {
    Scanner sc = new Scanner(System.in);

    public TreeNode buildTree() {
        System.out.println("Enter the data");
        int data = sc.nextInt();
        if (data == -1)
            return null;

        TreeNode newNode = new TreeNode(data);

        System.out.println("Enter the data for left child of " + data);
        newNode.left = buildTree();

        System.out.println("Enter the data for right child of " + data);
        newNode.right = buildTree();
//        System.out.println("Do you want to add a left child for " + data + "? (y/n)");
//        if (sc.next().equalsIgnoreCase("y")) {
//            newNode.left = buildTree();
//        }
//
//        System.out.println("Do you want to add a right child for " + data + "? (y/n)");
//        if (sc.next().equalsIgnoreCase("y")) {
//            newNode.right = buildTree();
//        }

        return newNode;
    }


    public void bfsTraversal(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();

        if (root != null) {
            queue.add(root);
        }

        int level = 0;
        while (!queue.isEmpty()) {
            System.out.print("level " + level + ": ");
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode curr = queue.removeFirst();
                System.out.print(curr.val + " ");
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            level++;
            System.out.println();
        }
    }
}
