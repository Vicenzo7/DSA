package tree;

import tree.implementation.BinaryTree;
import tree.implementation.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(3);
        tree.insert(9);
        tree.insert(20);
        tree.insert(15);
        tree.insert(7);
        tree.bfsTraversal();

        System.out.println(maxDepth_BFSAlgo(tree.root));
        System.out.println(maxDepth(tree.root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }


        return height(root);
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /*
           Plus 1 because we need to count the current node too.
           Math.max(height(root.left), height(root.right)) because we don't know which side there is maximum depth.
        */
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // using bfs algorithm
    public static int maxDepth_BFSAlgo(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();

        if (root != null) {
            deque.add(root);
        }

        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.removeFirst();
                if (treeNode.left != null) {
                    deque.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    deque.add(treeNode.right);
                }
            }
            level++;
        }
        return level;
    }
}
