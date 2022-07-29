package Problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathSumII {
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

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(Node root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        solve(root,targetSum,path);
        return ans;
    }


    void solve(Node root,int targetSum,List<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.value);
        if(root.left == null && root.right == null){
            if(root.value == targetSum){
                ans.add(new ArrayList<>(path));
            }

        }

        solve(root.left,targetSum-root.value,path);
        solve(root.right,targetSum-root.value,path);
        path.remove(path.size()-1);

    }


    public static void main(String[] args) {
        PathSumII tree = new PathSumII();
        Node root = tree.buildTree();
        // 5 4 11 7 -1 -1 2 -1 -1 -1 8 13 -1 -1 4 5 -1 -1 1 -1 -1
        System.out.println(tree.pathSum(root,22));
    }
}
