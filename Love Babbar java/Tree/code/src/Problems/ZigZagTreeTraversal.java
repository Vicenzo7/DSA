package Problems;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ZigZagTreeTraversal {
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


    //Function to store the zig zag order traversal of tree in a list.
    public ArrayList<Integer> zigZagTraversal(Node root)
    {
        //Add your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        boolean flag = false;

        deque.addLast(root);

        while(!deque.isEmpty()){
            int size = deque.size();//2 3

            if(flag){
                //right
                for(int i =0;i<size;i++){
                    Node temp = deque.getLast(); //2
                    deque.removeLast();
                    ans.add(temp.value);
                    if(temp.right != null)
                        deque.addFirst(temp.right);
                    if(temp.left != null)
                        deque.addFirst(temp.left);
                }
                flag = false;
            }
            else{
                //left
                for(int i =0;i<size;i++){
                    Node temp = deque.getFirst();
                    deque.removeFirst();
                    ans.add(temp.value);
                    if(temp.left != null)
                        deque.addLast(temp.left);
                    if(temp.right != null)
                        deque.addLast(temp.right);
                }
                flag = true;
            }
        }

        return ans;
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
        ZigZagTreeTraversal tree = new ZigZagTreeTraversal();
        Node root = tree.buildTree();
        ArrayList<Integer> ans = tree.zigZagTraversal(root);
        System.out.println(ans);

        //1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1

    }
}
