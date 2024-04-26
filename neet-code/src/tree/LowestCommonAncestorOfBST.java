package tree;

import tree.implementation.BinarySearchTree;
import tree.implementation.TreeNode;

public class LowestCommonAncestorOfBST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(6);
        bst.insert(2);
        bst.insert(8);
        bst.insert(0);
        bst.insert(4);
        bst.insert(7);
        bst.insert(9);
        bst.insert(3);
        bst.insert(5);

        bst.bfsTraversal();

        BinarySearchTree p = new BinarySearchTree();
        p.insert(2);

        BinarySearchTree q = new BinarySearchTree();
        q.insert(8);

        TreeNode treeNode = lowestCommonAncestor(bst.root, p.root, q.root);
        TreeNode treeNode2 = lowestCommonAncestor_Recursive(bst.root, p.root, q.root);

        if (treeNode != null) {
            System.out.println(treeNode.val);
        } else {
            System.out.println("null");
        }

        if (treeNode2 != null) {
            System.out.println(treeNode2.val);
        } else {
            System.out.println("null");
        }
    }

    // TC = O(log(n))
    /*
        Since its a binary tree
        1. Check where the p and q lies
        2. if they lie in the left subtree move left, if they lie in right move to the right.
        3. this can be checked by BST property
        check if both p and q value are less than root then move left
        check if both p and q value are greater than root then move right
        else root is the answer


    */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while (curr != null) {
            // check whether ancestor can be in the left
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } // check whether ancestor can be in the right
            else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }

        return null;
    }


    // TC = O(log(n))  SC = O(n) -> Auxiliary space
    private static TreeNode lowestCommonAncestor_Recursive(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor_Recursive(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor_Recursive(root.right, p, q);
        } else {
            return root;
        }
    }
}
