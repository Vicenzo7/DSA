package Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckCompletenessOfABinaryTree {
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


    public boolean isCompleteTree(Node root) {
        boolean end = false;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node current_node = queue.remove();
            // if we encounter null than it should be the last node
            if(current_node == null){
                end = true;
            }else{
                //checking if we get node and the end is true than its not complete
                if(end) return false;
                queue.add(current_node.left);
                queue.add(current_node.right);
            }
        }
        return true;
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
        CheckCompletenessOfABinaryTree tree = new CheckCompletenessOfABinaryTree();
        Node root = tree.buildTree();

        System.out.println(tree.isCompleteTree(root));

        // 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 -1 -- complete

        // 1 2 4 -1 -1 5 -1 -1 3 -1 7 -1 -1 -- not complete
    }
}
