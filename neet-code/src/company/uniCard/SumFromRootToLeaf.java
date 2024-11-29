package company.uniCard;

import tree.implementation.Tree;
import tree.implementation.TreeNode;

public class SumFromRootToLeaf {
    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode treeNode = tree.buildTree();
        helper(treeNode, 0);
        System.out.println(sum);
    }

    static int sum = 0;

    private static void helper(TreeNode treeNode, int currSum) {
        if (treeNode == null) {
            return;
        }
        currSum = currSum * 10 + treeNode.val;
        if (treeNode.left == null && treeNode.right == null) {
            sum += currSum;
            return;
        }

        helper(treeNode.left, currSum);
        helper(treeNode.right, currSum);

    }
}
