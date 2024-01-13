package backtracking.treemaze;

import tree.implementation.Tree;
import tree.implementation.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeMaze {
    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode treeNode = tree.buildTree();

        // check if there exist a path from root to leaf that does not contain zero
        //4 0 -1 -1 1 2 -1 -1 0 -1 -1
        System.out.println(canReachLeaf(treeNode));
        List<Integer> result = new ArrayList<>();
        canReachLeafPath(treeNode, result);
        System.out.println(result);
    }

    private static boolean canReachLeaf(TreeNode root) {

        if (root == null || root.val == 0) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }

        if (canReachLeaf(root.left)) {
            return true;
        }
        if (canReachLeaf(root.right)) {
            return true;
        }

        return false;
    }

    private static boolean canReachLeafPath(TreeNode root, List<Integer> result) {

        if (root == null || root.val == 0) {
            return false;
        }
        result.add(root.val);
        if (root.left == null && root.right == null) {
            return true;
        }

        if (canReachLeafPath(root.left, result)) {
            return true;
        }
        if (canReachLeafPath(root.right, result)) {
            return true;
        }
        result.remove(result.size() - 1);
        return false;
    }
}
