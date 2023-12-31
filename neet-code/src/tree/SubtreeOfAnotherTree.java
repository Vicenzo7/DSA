package tree;

import tree.implementation.Tree;
import tree.implementation.TreeNode;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode root = tree.buildTree();
        TreeNode subRoot = tree.buildTree();

        System.out.println(isSubtree(root, subRoot));
    }

    /*
        To check if subRoot is a part of root

        1. subRoot could start from root itself so check is root and subRoot are same or
        2. if root and subRoot are not same then root.left and subRoot may be or
        3. root.right and subRoot may be

        isSubtree(s, t):

            The base case is:
                If s == null && t == null, then return true.
                If s == null || t == null, then return false.
            If isSame(s, t) is true, then return true.
            If isSubtree(s.left, t) or isSubtree(s.right, t) is true, then return true.

    */


    // TC = (m * n)
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }

        return isSameTree(root, subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }


    // tc = O(n)
    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        boolean isLeftTreeSame = isSameTree(p.left, q.left);
        boolean isRightTreeSame = isSameTree(p.right, q.right);

        return p.val == q.val && isLeftTreeSame && isRightTreeSame;
    }

    private static TreeNode findNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }
        // Recur on the left and right subtrees
        TreeNode leftResult = findNode(root.left, val);
        TreeNode rightResult = findNode(root.right, val);

        // Return the result from either subtree
        return (leftResult != null) ? leftResult : rightResult;
    }
}
