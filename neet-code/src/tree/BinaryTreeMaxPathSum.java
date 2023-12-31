package tree;

import tree.implementation.Tree;
import tree.implementation.TreeNode;

import java.util.Map;

public class BinaryTreeMaxPathSum {
    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode treeNode = tree.buildTree();

        System.out.println(maxPathSum(treeNode));
    }


    /*
        eg              1
                       /  \
                      2    3
                          /  \
                         4    5

        TC = O(n)

    */

    public static int maxPathSum(TreeNode root) {
        int[] maxArray = new int[1];
        maxArray[0] = root.val;
        maxPathSum(root, maxArray);
        return maxArray[0];
    }

    // return max path sum without split

    private static int maxPathSum(TreeNode root, int[] maxArray) {
        if (root == null) {
            return 0;
        }

        int leftMax = maxPathSum(root.left, maxArray);
        int rightMax = maxPathSum(root.right, maxArray);

        // update left and right max to avoid adding negative
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        // compute max path sum with split
        maxArray[0] = Math.max(maxArray[0], root.val + leftMax + rightMax);

        return root.val + Math.max(leftMax, rightMax);
    }
}
