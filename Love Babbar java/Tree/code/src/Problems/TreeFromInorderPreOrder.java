package Problems;

import java.util.*;

public class TreeFromInorderPreOrder {
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

    public void levelOrder(Node root) {
        Queue<Node> que = new LinkedList<>();
        que.add(root);

        //
        que.add(null);

        while (!que.isEmpty()) {

            Node front = que.remove();
            if (front == null) {
                System.out.println();
                //catch here
                if (!que.isEmpty()) {
                    que.add(null);
                }
            } else {
                System.out.print(front.value + " ");

                if (front.left != null)
                    que.add(front.left);

                if (front.right != null)
                    que.add(front.right);
            }

        }
    }

//    int position(int[] inorder,int key,int s,int e)
//    {
//        for (int i = s; i <=e ; i++) {
//            if (inorder[i]==key)
//                return i;
//        }
//        return -1;
//    }
//    static int preOrderIndex =0;
//    Node buildFromInorderPreorder(int[] inorder,int[] preorder,int inStart,int inEnd)
//    {
//        //Base Case
//        if(preOrderIndex >= preorder.length || inStart > inEnd)
//            return null;
//
//        int element = preorder[preOrderIndex++];
//        Node root = new Node(element);
//
//        //search element in inorder array
//        int pos = position(inorder,element,inStart,inEnd);
//
//        root.left = buildFromInorderPreorder(inorder,preorder,inStart,pos-1);
//        root.right = buildFromInorderPreorder(inorder,preorder,pos+1,inEnd);
//        return root;
//
//    }



    //optimised we used map to store in order index;

    static int preorderIndex = 0;
    static Map<Integer,Integer> inorderIndexMap;
    public Node buildTree(int[] preorder, int[] inorder) {

        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            inorderIndexMap.put(inorder[i],i);
        }

        return arrayToTree(preorder,0,preorder.length-1);
    }


    public Node arrayToTree(int[] preorder, int inStart, int inEnd)
    {
        // if there are no elements to construct the tree
        if(inStart >inEnd)
            return null;

        // select the preorder_index element as the root and increment it
        int element = preorder[preorderIndex++];
        Node root = new Node(element);

        // build first left subtree and then right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        int pos = inorderIndexMap.get(element);

        root.left=arrayToTree(preorder,inStart,pos-1);
        root.right=arrayToTree(preorder,pos+1,inEnd);
        return root;
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

        TreeFromInorderPreOrder obj = new TreeFromInorderPreOrder();
        int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};


        Node root = obj.buildTree(preorder,inorder);
        obj.levelOrder(root);
        //10 5 3 -1 -1 7 6 -1 -1 -1 11 -1 -1
    }
}
