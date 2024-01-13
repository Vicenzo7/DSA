package tree;

import tree.implementation.Tree;
import tree.implementation.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBSTFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode treeNode = buildTree_Optimised(preorder, inorder);
        Tree tree = new Tree();
        tree.bfsTraversal(treeNode);
    }

    /*
        First value in preorder is always going to be the root
    */

    private static int preOrderIndex = 0;

    public static TreeNode buildTree_Optimised(int[] preorder, int[] inorder) {
//        return buildTree(preorder, inorder, 0, preorder.length - 1);
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTree_Optimised(preorder, inorderIndexMap, 0, preorder.length - 1);

    }


    /*
        TC = O(n)
        SC = O(n) -> due to the map;

    */
    private static TreeNode buildTree_Optimised(int[] preorder, Map<Integer, Integer> inorderIndexMap, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preOrderIndex++]);
        int inorderIndex = inorderIndexMap.get(root.val);
        root.left = buildTree_Optimised(preorder, inorderIndexMap, start, inorderIndex - 1);
        root.right = buildTree_Optimised(preorder, inorderIndexMap, inorderIndex + 1, end);
        return root;
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        // construct the root
        TreeNode root = new TreeNode(preorder[preOrderIndex++]);

        int inorderIndex = search(inorder, start, end, root.val);
        root.left = buildTree(preorder, inorder, start, inorderIndex - 1);
        root.right = buildTree(preorder, inorder, inorderIndex + 1, end);

        return root;

    }

    private static int search(int[] nums, int start, int end, int val) {
        int i = 0;
        for (i = start; i < end; i++) {
            if (nums[i] == val) {
                return i;
            }
        }
        return i;
    }
}
