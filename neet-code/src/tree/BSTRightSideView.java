package tree;

import tree.implementation.Tree;
import tree.implementation.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BSTRightSideView {
    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode treeNode = tree.buildTree();
        System.out.println(rightSideView(treeNode));
    }


    // solved using BFS
    // TC = O(n)  SC = O(n)
    public static List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            deque.add(root);
            result.add(root.val);
        }

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode first = deque.removeFirst();
                if (first.left != null) {
                    deque.add(first.left);
                }
                if (first.right != null) {
                    deque.add(first.right);
                }
            }

            // after each level get the right most element from the deque.
            if (!deque.isEmpty()) {
                result.add(deque.getLast().val);
            }
        }

        return result;
    }

}
