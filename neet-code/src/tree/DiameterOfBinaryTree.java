package tree;

import tree.implementation.Tree;
import tree.implementation.TreeNode;
import util.CustomPair;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode treeNode = tree.buildTree();
        System.out.println(diameterOfBinaryTree(treeNode));
    }

    /*
        Diameter can be in three type
        1.It can be a part of left subtree
        2.It can be a part of right subtree
        3.It can be combo of left and right subtree

    */
    public static int diameterOfBinaryTree(TreeNode root) {
//        return diameter(root);
        int[] diameter = new int[1];
        diameterHeight(root, diameter);
        System.out.println(diameterFast(root).getKey());
        return diameter[0];
    }

    // Pair<diameter,height>
    // TC = O(n)
    private static CustomPair<Integer, Integer> diameterFast(TreeNode root) {
        if (root == null) {
            return new CustomPair<>(0, 0);
        }

        CustomPair<Integer, Integer> left = diameterFast(root.left);
        CustomPair<Integer, Integer> right = diameterFast(root.right);

        int option1 = left.getKey();
        int option2 = right.getKey();
        int option3 = left.getValue() + right.getValue();

        CustomPair<Integer, Integer> ans = new CustomPair<>();
        ans.setKey(Math.max(option1, Math.max(option2, option3)));
        ans.setValue(1 + Math.max(left.getValue(), right.getValue()));
        return ans;
    }


    // TC = O(n)
    private static int diameterHeight(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }
        int leftHeight = diameterHeight(root.left, diameter);
        int rightHeight = diameterHeight(root.right, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }


   /*
        Solution 3 : TC O(n^2)

   */

    private static int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int option1 = diameter(root.left);
        int option2 = diameter(root.right);
        int option3 = height(root.left) + 1 + height(root.right);

        return Math.max(option1, Math.max(option2, option3));
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }


}
