package tree;

import tree.implementation.BinarySearchTree;
import tree.implementation.TreeNode;

public class ConvertSortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode x = sortedArrayToBST(nums);
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.bfsTraversal(x);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return constructTree(nums, 0, nums.length - 1);
    }

    private static TreeNode constructTree(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTree(nums, start, mid - 1);
        root.right = constructTree(nums, mid + 1, end);
        return root;
    }
}
