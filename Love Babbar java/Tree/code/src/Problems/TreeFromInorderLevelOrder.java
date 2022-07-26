package Problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class TreeFromInorderLevelOrder {


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

    //inorder
    public void inOrder(Node root) {
        //base case
        if (root == null)
            return;

        //left
        inOrder(root.left);

        //Node
        System.out.print(root.value + " ");

        //right
        inOrder(root.right);
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


    HashMap<Integer,Integer> map;
    Node buildTree(int inord[], int level[])
    {
        map = new HashMap<>();
        int n= inord.length;
        for(int i=0;i<n;i++){
            map.put(inord[i],i);
        }

        return buildTree(inord,0,n-1,level);
    }


    Node buildTree(int[] inord,int start, int end,int[] level){

        //if out of range
        if(start>end) return null;

        Node root = new Node(level[0]);

        int pos = map.get(level[0]);

        HashSet<Integer> set = new HashSet<>();
        //insert into hashset the inorder of left subtree
        for(int i=start;i<pos;i++){
            set.add(inord[i]);
        }

        // now we will contruct level order for left subtree and right subtree
        int[] lofls = new int[pos-start];  // level order for left subtree
        int[] lofrs = new int[end -pos];   // level order for right subtree
        int ls=0,rs=0;

        //traversing the level order from 1 since 0 index is already used
        for(int i=1;i<level.length;i++){
            int ele = level[i];
            if(set.size() !=0 && set.contains(ele)){
                lofls[ls++] = ele;
                //after finding deleting that element to optimise the search
                set.remove(ele);
            }else{
                lofrs[rs++] = ele;
            }
        }


        // now we have level order for left and right subtree and we can consruct the tree;
        root.left = buildTree(inord,start,pos-1,lofls);
        root.right = buildTree(inord,pos+1,end,lofrs);

        return root;
    }

    public static void main(String[] args) {
        TreeFromInorderLevelOrder tree = new TreeFromInorderLevelOrder();

        int[] inord = {3,7,5,6,11,2,15,4,9};
        int[] level = {2,7,15,3,6,9,5,11,4};

        Node root = tree.buildTree(inord,level);
        tree.inOrder(root);
    }

}
