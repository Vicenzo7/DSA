package tree;

import tree.implementation.Tree;
import tree.implementation.TreeNode;
import util.CustomPair;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode root = tree.buildTree();
        System.out.println(isBalanced_BruteForce(root));
        System.out.println(isBalanced_WithOnlyHeightFunction(root));
        System.out.println(isBalanced(root));
    }

    private static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalancedFast(root).getKey();
    }

    // Pair <isBalanced,height>
    private static CustomPair<Boolean, Integer> isBalancedFast(TreeNode root) {
        if (root == null) {
            return new CustomPair<>(true, 0);
        }

        CustomPair<Boolean, Integer> left = isBalancedFast(root.left);
        CustomPair<Boolean, Integer> right = isBalancedFast(root.right);
        boolean difference = Math.abs(left.getValue() - right.getValue()) <= 1;

        CustomPair<Boolean, Integer> ans = new CustomPair<>();
        ans.setValue(1 + Math.max(left.getValue(), right.getValue()));
        ans.setKey(left.getKey() && right.getKey() && difference);

        return ans;
    }


    public static boolean isBalanced = true;

    // TC = O(n)
    private static boolean isBalanced_WithOnlyHeightFunction(TreeNode root) {
        if (root == null) {
            return true;
        }

        isBalancedHeight(root);
        return isBalanced;
    }

    private static int isBalancedHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = isBalancedHeight(root.left);
        int rightHeight = isBalancedHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced = false;
        }

        return 1 + Math.max(leftHeight, rightHeight);

    }


    // TC = O(n^2) because on each node height function is also called
    public static boolean isBalanced_BruteForce(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        boolean isLeftBalanced = isBalanced_BruteForce(root.left);
        boolean isRightBalanced = isBalanced_BruteForce(root.right);


        return Math.abs(leftHeight - rightHeight) <= 1 && isLeftBalanced && isRightBalanced;
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
