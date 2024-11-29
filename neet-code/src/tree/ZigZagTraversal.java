package tree;

import tree.implementation.Tree;
import tree.implementation.TreeNode;

import java.util.*;

public class ZigZagTraversal {
    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode treeNode = tree.buildTree();
        System.out.println(zigzagLevelOrder(treeNode));
    }


    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return result;
        zigZagTraversal(root);
        return result;
    }

    static
    public void zigZagTraversal(TreeNode root) {
        // Add your code here.
        Deque<TreeNode> deque = new LinkedList<>();
        boolean rightToLeft = false;
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (rightToLeft) {
                    // right
                    TreeNode temp = deque.removeLast();
                    ans.add(temp.val);
                    if (temp.right != null)
                        deque.addFirst(temp.right);
                    if (temp.left != null)
                        deque.addFirst(temp.left);
                } else {
                    // left
                    TreeNode temp = deque.removeFirst();
                    ans.add(temp.val);
                    if (temp.left != null)
                        deque.addLast(temp.left);
                    if (temp.right != null)
                        deque.addLast(temp.right);
                }
            }
            result.add(ans);
            rightToLeft = !rightToLeft;
        }
    }
}
