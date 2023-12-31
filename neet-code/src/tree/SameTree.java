package tree;

import tree.implementation.Tree;
import tree.implementation.TreeNode;

public class SameTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode p = tree.buildTree();
        TreeNode q = tree.buildTree();

        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        boolean isLeftTreeSame = isSameTree(p.left, q.left);
        boolean isRightTreeSame = isSameTree(p.right, q.right);
        return p.val == q.val && isLeftTreeSame && isRightTreeSame;
    }
}
