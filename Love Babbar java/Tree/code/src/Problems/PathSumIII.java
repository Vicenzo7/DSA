package Problems;

import java.util.Scanner;

public class PathSumIII {
    Scanner sc = new Scanner(System.in);


    public Node buildTree() {
        System.out.println("Enter the data");
        int data = sc.nextInt();

        if (data == -1)
            return null;

        Node newNode = new Node(data);

        System.out.println("Enter the data for left child of " + data);
        newNode.left = buildTree();

        System.out.println("Enter the data for right child of " + data);
        newNode.right = buildTree();

        return newNode;
    }
    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


    int count=0;
    public int pathSum(Node root, int targetSum) {
        if(root == null)
            return 0;

        // check if path exist from root
        solve(root,targetSum);

        //check if path from left and right
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);

        return count;
    }

    private void solve(Node root, int targetSum) {
        if(root == null)
            return;
        if(root.value == targetSum)
            count++;

        solve(root.left,targetSum-root.value);
        solve(root.right,targetSum-root.value);
    }

    public static void main(String[] args) {
        PathSumIII tree = new PathSumIII();
        Node root = tree.buildTree();
        // 10 5 3 3 -1 -1 -2 -1 -1 2 -1 1 -1 -1 -3 -1 11 -1 -1
        System.out.println(tree.pathSum(root,8));
    }
}
