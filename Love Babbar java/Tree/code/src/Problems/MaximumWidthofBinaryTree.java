package Problems;

import java.util.*;


public class MaximumWidthofBinaryTree {
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
    public int widthOfBinaryTree(Node root) {
        if(root==null)
            return 0;
        Queue<Pair> que = new LinkedList<>();
        int maxWidth=0;
        que.add(new Pair(root,0));
        while(!que.isEmpty())
        {
            int size = que.size();
            int min = que.peek().num; //to make id start from zero
            int first =0,last=0;
            for(int i=0;i<size;i++){
                int cur_id = que.peek().num-min;
                Node node = que.peek().node;
                que.remove();
                if(i==0)
                    first = cur_id;
                if(i==size-1)
                    last = cur_id;

                if(node.left!=null)
                    que.add(new Pair(node.left , cur_id*2+1));

                if(node.right!=null)
                    que.add(new Pair(node.right , cur_id*2+2));
            }
            maxWidth=Math.max(maxWidth,last-first +1);

        }

        return maxWidth;
    }

    class Pair {
        Node node;
        int num;
        public Pair(Node node,int num){
            this.node = node;
            this.num=num;
        }
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
        MaximumWidthofBinaryTree tree = new MaximumWidthofBinaryTree();
        Node root = tree.buildTree();
        System.out.println(tree.widthOfBinaryTree(root));

        //1 3 5 -1 -1 3 -1 -1 2 -1 9 -1 -1
    }
}
