
**Diameter can be calculated in three types**
1. It can be a part of left subtree  
2. It can be a part of right subtree  
3. It can be combo of left and right subtree

```
public static int diameterOfBinaryTree(TreeNode root) {  
    return diameter(root);  
}  
  
private static int diameter(TreeNode root) {  
    if (root == null) {  
        return 0;  
    }  
  
    int option1 = diameter(root.left);  
    int option2 = diameter(root.right);  
    int option3 = height(root.left) + 1 + height(root.right);  
  
    return Math.max(option1, Math.max(option2, option3));  
}  
  
private static int height(TreeNode root) {  
    if (root == null) {  
        return 0;  
    }  
    return 1 + Math.max(height(root.left), height(root.right));  
}
```

`TC = O(n^2)`

Time Complexity could be `O(n)` but since we are calling height function it's `TC = O(n^2)`

Since we are calling height function, is it possible to calculate the diameter 

```
public static int diameterOfBinaryTree(TreeNode root) {  
    int[] diameter = new int[1];  
	diameterHeight(root, diameter);  
	return diameter[0];
}

private static int diameterHeight(TreeNode root, int[] diameter) {  
    if (root == null) {  
        return 0;  
    }  
  
    int leftHeight = diameterHeight(root.left, diameter);  
    int rightHeight = diameterHeight(root.right, diameter);  
    diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);  
  
    return 1 + Math.max(leftHeight, rightHeight);  
}
```

`TC = O(n)`