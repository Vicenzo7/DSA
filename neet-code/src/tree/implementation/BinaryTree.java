package tree.implementation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BinaryTree {

    public TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }


    // Insert a new node and return the root of the BST.
    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            root.right = insert(root.right, val);
        } else if (val < root.val) {
            root.left = insert(root.left, val);
        }
        return root;
    }

    // Return the minimum value node of the BST.
    public TreeNode minValueNode(TreeNode root) {
        TreeNode curr = root;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }


    public void remove(int val) {
        root = remove(root, val);
    }

    // Remove a node and return the root of the BST.
    private TreeNode remove(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val > root.val) {
            root.right = remove(root.right, val);
        } else if (val < root.val) {
            root.left = remove(root.left, val);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = minValueNode(root.right);
                root.val = minNode.val;
                root.right = remove(root.right, minNode.val);
            }
        }
        return root;
    }

    // Inorder traversal of the tree
    public void inorderTraversal() {
        inorder(root);
        System.out.println();
    }


    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public void preorderTraversal() {
        preorder(root);
        System.out.println();
    }


    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorderTraversal() {
        postorder(root);
        System.out.println();
    }

    private void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public void bfsTraversal() {
        bfsTraversal(root);
        System.out.println();
    }

    public void bfsTraversal(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();

        if (root != null) {
            queue.add(root);
        }

        int level = 0;
        while (!queue.isEmpty()) {
            System.out.print("level " + level + ": ");
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode curr = queue.removeFirst();
                System.out.print(curr.val + " ");
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            level++;
            System.out.println();
        }
    }

    // Iterative DFS

    public void inorder_Iterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                System.out.print(curr.val + " ");
                curr = curr.right;
            }
        }
    }

    // Time and space: O(n)
    public void preorder_Iterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                System.out.print(curr.val + " ");
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                curr = curr.left;
            } else {
                curr = stack.pop();
            }
        }
    }


    // Time and space: O(n)
    public void postorder_Iterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        Stack<Boolean> visit = new Stack<>();
        visit.push(false);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            boolean visited = visit.pop();
            if (curr != null) {
                if (visited) {
                    System.out.print(curr.val + " ");
                } else {
                    stack.push(curr);
                    visit.push(true);
                    stack.push(curr.right);
                    visit.push(false);
                    stack.push(curr.left);
                    visit.push(false);
                }
            }
        }
    }
}
