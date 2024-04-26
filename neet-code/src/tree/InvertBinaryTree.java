package tree;

import tree.implementation.BinarySearchTree;
import tree.implementation.TreeNode;

public class InvertBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(9);
        tree.bfsTraversal();

        TreeNode treeNode = invertTree(tree.root);
        tree.bfsTraversal(treeNode);
    }

    /*
        1.Change the root's left pointer to point to right child
        2.Change the root's right pointer to point to left child;
        3.Now invert the left child
        4.Now invert the right child
        5.Return the root
     */

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
