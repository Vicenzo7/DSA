package Problems;

import java.util.*;

public class TreeFromInorderPostOrder {
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
//    static int postOrderIndex;
//    Node buildFromInorderPostorder(int[] inorder,int[] postorder,int inStart,int inEnd)
//    {
//        //Base Case
//        if(postOrderIndex <0 || inStart > inEnd)
//            return null;
//
//        int element = postorder[postOrderIndex--];
//        Node root = new Node(element);
//
//        //search element in inorder array
//        int pos = position(inorder,element,inStart,inEnd);
//        root.right = buildFromInorderPostorder(inorder,postorder,pos+1,inEnd);
//        root.left = buildFromInorderPostorder(inorder,postorder,inStart,pos-1);
//
//        return root;
//
//    }


    int postorderIndex;
    Map<Integer, Integer> inorderIndexMap;

    public Node buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(postorder, 0, postorder.length - 1);
    }


    public Node arrayToTree(int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;

        int element = postorder[postorderIndex--];
        Node root = new Node(element);

        // build first right subtree and then left subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        int pos = inorderIndexMap.get(element);

        root.right = arrayToTree(postorder, pos + 1, inEnd);
        root.left = arrayToTree(postorder, inStart, pos - 1);

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

        TreeFromInorderPostOrder obj = new TreeFromInorderPostOrder();
        int[] inorder = {9, 3, 15, 20, 7}, postorder = {9, 15, 7, 20, 3};


        Node root = obj.buildTree(inorder, postorder);
        obj.levelOrder(root);

    }
}
