package Problems;

import java.util.ArrayList;
import java.util.Scanner;

public class KSumPaths {
    Scanner sc = new Scanner(System.in);


    public Node buildTree() {
        System.out.println("Enter the data");
        String data = sc.next();

        if (data.equals("x"))
            return null;

        Node newNode = new Node(Integer.parseInt(data));

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

    int count =0;
    public int sumK(Node root,int k)
    {
        ArrayList<Integer> path = new ArrayList<>();
        solve(root,k,path);
        return count;
    }

    private void solve(Node root, int k, ArrayList<Integer> path) {
        if(root == null)
            return;

        path.add(root.value);
        //left
        solve(root.left,k,path);
        //right
        solve(root.right,k,path);


        int size = path.size();
        int sum =0;
        //check if sum == k
        for (int i = size-1; i >=0 ; i--) {
            sum += path.get(i);
            if(sum == k)
                count++;
        }
        //backtrack;
        path.remove(size-1);
    }


    public static void main(String[] args) {
        KSumPaths tree = new KSumPaths();
        Node root = tree.buildTree();
        // 1 3 2 x x 1 1 x x x -1 4 1 x x 2 x x 5 x 6 x x
        tree.sumK(root,5);
        System.out.println(tree.count);


    }
}
