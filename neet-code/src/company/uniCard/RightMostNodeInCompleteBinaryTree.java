package company.uniCard;

import tree.implementation.Tree;
import tree.implementation.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RightMostNodeInCompleteBinaryTree {

    /*
     Expected time complexity is O(log(n) * log(n))
     Problem - Given a binary tree how to find the position of right most node in last level of complete binary tree?
     NOTE : try to solve this in less than O(n) and use minimum possible space.
     */

    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode treeNode = tree.buildTree();
        System.out.println(bfs(treeNode));
        System.out.println(lastNode(treeNode));
        System.out.println(lastNodeOptimised(treeNode));
        //18 15 40 8 -1 -1 7 -1 -1 50 9 -1 -1 -1 30 100 -1 -1 40 -1 -1
    }

    /*
        We are given a complete binary tree means in last level, nodes are lean towards the left.

        Idea here is to compare the depth of the two subtrees.
        If the depth of the subtree on the left is high, move it to the left, otherwise move it to the right.
        The depth of the subtree can be found in O (log N), which is repeated in the O (log N) step.

        Therefore, you can find the answer in O (log N * log N).
    */


    public static int lastNode(TreeNode root) {
        int value = -1;
        TreeNode curr = root;
        while (curr != null) {
            value = curr.val;
            curr = computeDepth(curr.left) > computeDepth(curr.right) ? curr.left : curr.right;
        }

        return value;
    }

    private static int computeDepth(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int depth = 0;
        while (root.left != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }

    public static int lastNodeOptimised(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight > rightHeight) {
            return lastNode(root.left);
        } else {
            return lastNode(root.right);
        }
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // TC = O(n) because we traverse each node
    private static int bfs(TreeNode root) {
        int rightMostNode = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            deque.add(root);
        }


        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.removeFirst();
                if (treeNode.left != null) {
                    deque.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.add(treeNode.right);
                }
            }
            if (!deque.isEmpty()) {
                rightMostNode = deque.getLast().val;
            }
        }

        return rightMostNode;
    }
}
