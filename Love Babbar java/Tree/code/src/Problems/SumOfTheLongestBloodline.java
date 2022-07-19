package Problems;

import java.util.Scanner;

public class SumOfTheLongestBloodline {

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



    int maxSum=Integer.MIN_VALUE;
    int maxLen = 0;
    public int sumOfLongRootToLeafPath(Node root)
    {
        //code here

        if(root == null)
            return 0;

        solve(root,0,0);
        return maxSum;
    }


    public void solve(Node root,int sum,int len)
    {
        //when it reaches null checking if theres change in maxLen and maxSum
        if(root==null)
        {
            if(maxLen < len){
                maxLen=len;
                maxSum = sum;
            }
            else if (maxLen == len && maxSum<sum){
                maxSum=sum;
            }
            return;
        }

        solve(root.left,sum+root.value,len+1);
        solve(root.right,sum+root.value,len+1);
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

    public static void main(String[] args) {
        SumOfTheLongestBloodline tree = new SumOfTheLongestBloodline();
        Node root = tree.buildTree();

        int ans =tree.sumOfLongRootToLeafPath(root);
        System.out.println(ans);
        //4 2 1 -1 -1 3 -1 -1 8 5 -1 -1 10 -1 -1
    }
}
