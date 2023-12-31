package tree;

import tree.implementation.BinaryTree;
import tree.implementation.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementInBST {
    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(6);
        bst.insert(2);
        bst.insert(4);
        bst.insert(1);

        int k = 3;

        System.out.println(kthSmallest(bst.root, k));
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);

        System.out.println(list.get(k - 1));
        System.out.println(dfs(root, k));
        return inorder_Iterative(root, k);
    }


    /*
        Solution 1:
             Perform inorder travel and store its values
             extract k-1 from the stored arraylist

             TC = O(n), SC= O(n) -> for arraylist and also recursion so auxiliary space
    */


    private static void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }


    /*
        Solution 2:
        TC = O(n)  SC = O(1) only auxiliary  space
    */

    public static int count = 0;

    private static int dfs(TreeNode root, int k) {

        if (root == null) {
            return -1; // this indicates that we reached null
        }

        int left = dfs(root.left, k);
        // check if the returned value is an answer
        if (left != -1) {
            return left;
        }

        count++;
        if (count == k) {
            return root.val;
        }

        int right = dfs(root.right, k);
        if (right != -1) {
            return right;
        }

        return -1;
    }

    /*
        Both solutions aim to find the kth smallest element in a Binary Search Tree (BST), but they use different approaches. Let's compare them in terms of space and time complexity:

        DFS Solution:
            Time Complexity: The time complexity is O(k), where k is the desired rank of the element in the sorted order. In the worst case, it may traverse the entire tree.
            Space Complexity: The space complexity is O(h), where h is the height of the tree. This is because of the recursive call stack. In the worst case, it could be O(n) for a skewed tree.

        Iterative In-order Traversal Solution:
            Time Complexity: The time complexity is O(k), similar to the DFS solution, as it traverses only the elements needed to find the kth smallest.
            Space Complexity: The space complexity is O(h), where h is the height of the tree. This is due to the stack used for iterative traversal. In the worst case, it could be O(n) for a skewed tree.

        Both have similar time complexities.
        Both have similar space complexities, depending on the height of the tree.
    */

    public static int inorder_Iterative(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int n = 0;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                // finding kth smallest element
                n += 1;
                if (n == k) {
                    return curr.val;
                }
                curr = curr.right;
            }
        }

        return -1;
    }
}
