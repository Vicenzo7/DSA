
**Binary Search Tree (BST)**

They have a sorted property
1. Every single node on the left of the root must have value less than the root value
2. Every single node on the right of the root must have value greater than the root value
3. BST do not contain duplicate value

**Searching in BST**
```
// Definiton of TreeNode in Java
/*
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val; 
        left = null;
        right = null; 
    }
}
*/

public class Search {
    
    public boolean search(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (target > root.val) {
            return search(root.right, target);
        } else if (target < root.val) {
            return search(root.left, target);
        } else {
            return true;
        }
    }
}


TC = O(log(n)) -> if tree is balanced, else O(h) where h is the height
```

**Why use BST instead of sorted array ?**
The main benefit of BST over sorted array is, we can insert and remove in log(n) time.

```
public class InsertAndRemove {

    // Insert a new node and return the root of the BST.
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            root.right = insert(root.right, val);
        } else  if (val < root.val) {
            root.left = insert(root.left, val);
        }
        return root;
    }

    // Return the minimum value node of the BST.
    public TreeNode minValueNode(TreeNode root) {
        TreeNode curr = root;
        while(curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    // Remove a node and return the root of the BST.
    public TreeNode remove(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val > root.val) {
            root.right = remove(root.right, val);
        } else if (val < root.val) {
            root.left = remove(root.left, val) ;
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = minValueNode(root.right);
                root.val = minNode.val;;
                root.right = remove(root.right, minNode.val);
            }
        }
        return root;
    }    
}
```

**BST Traversal Technique**
A Tree Data Structure can be traversed in following ways:
1. **Depth First Search or DFS**
	1. Inorder Traversal = (Left->Middle->Right)
	2. Preorder Traversal
	3. Postorder Traversal

```
public class DFS {
    
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(TreeNode root) {
        if (root == null) {
            return;
        }  
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }
    
}
```



2. **Level Order Traversal or Breadth First Search or BFS**
	Print elements level by level
![[bfs.png]]
```
public void bfs(TreeNode root) { 
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        if (root != null) {
            queue.add(root);
        }    
        int level = 0;
        while(!queue.isEmpty()) {
            System.out.print("level " + level + ": ");
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode curr = queue.removeFirst(); 
                System.out.print(curr.val + " ");
                if(curr.left != null) {
                    queue.add(curr.left);  
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }  
            }
            level++;
            System.out.println();
        }
        
    }
```

3. Iterative DFS
```
// Time and space: O(n)

    public static void inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {

            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                System.out.println(curr.val);
                curr = curr.right;
            }
        }
    }

    // Time and space: O(n)
    public static void preorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                System.out.println(curr.val);
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
    public static void postorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        Stack<Boolean> visit = new Stack<>();
        visit.push(false);
        
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            boolean visited = visit.pop();
            if (curr != null) {
                if (visited) {
                    System.out.println(curr.val);
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
```