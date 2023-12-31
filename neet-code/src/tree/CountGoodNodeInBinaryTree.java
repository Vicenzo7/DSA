package tree;

import tree.implementation.Tree;
import tree.implementation.TreeNode;

// Microsoft most asked question in 2021
public class CountGoodNodeInBinaryTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode treeNode = tree.buildTree();
        System.out.println(goodNodes(treeNode));
    }


    /*
       Explanation:
        Record the maximum value along the path from the root to the node.

        Time O(N)
        Space O(height)

    */
    public static int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    // preorder technique
    public static int dfs(TreeNode root, int maxValue) {
        if (root == null) {
            return 0;
        }

        // check if the root is a good node
        int result = root.val >= maxValue ? 1 : 0;
        // update maxValue
        maxValue = Math.max(root.val, maxValue);
        // get good nodes count from left subtree
        result += dfs(root.left, maxValue);
        // get good nodes count from right subtree
        result += dfs(root.right, maxValue);

        return result;
    }
}
