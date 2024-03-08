package tree;

import tree.implementation.Tree;
import tree.implementation.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BSTLevelOrderTraversal {
    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode treeNode = tree.buildTree();
        System.out.println(levelOrder(treeNode));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();

        if (root != null) {
            deque.add(root);
        }

        List<List<Integer>> result = new ArrayList<>();

        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode first = deque.removeFirst();
                level.add(first.val);
                if (first.left != null) {
                    deque.add(first.left);
                }

                if (first.right != null) {
                    deque.add(first.right);
                }
            }
            result.add(level);
        }

        return result;
    }
}
