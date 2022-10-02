package com.company.medium;

//
public class SumOfNodesWithinKDistanceFromTarget {
//    Scanner sc = new Scanner(System.in);
//
//    public Node buildTree() {
//        System.out.println("Enter the data");
//        int data = sc.nextInt();
//
//        if (data == -1)
//            return null;
//
//        Node newNode = new Node(data);
//
//        System.out.println("Enter the data for left child of " + data);
//        newNode.left = buildTree();
//
//        System.out.println("Enter the data for right child of " + data);
//        newNode.right = buildTree();
//
//        return newNode;
//    }
//
//
//    class Node {
//        int value;
//        Node left;
//        Node right;
//
//        public Node(int value) {
//            this.value = value;
//            this.left = null;
//            this.right = null;
//        }
//    }
//
//
//    public Node bfsToMapParent(Node root, Map<Node, Node> map, int start) {
//        Node res = new Node(-1);
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//
//        while (!q.isEmpty()) {
//
//            Node cur = q.remove();
//            if (cur.value == start) {
//                res = cur;
//            }
//            if (cur.left != null) {
//                map.put(cur.left, cur);
//                q.add(cur.left);
//            }
//
//            if (cur.right != null) {
//                map.put(cur.right, cur);
//                q.add(cur.right);
//            }
//
//        }
//
//        return res;
//    }
//
//
//    public int sum_at_distK(Node root, int target,int k) {
//
//        // mapping children with their parent
//        Map<Node, Node> map = new HashMap<>();
//        Node start = bfsToMapParent(root, map, target);
//
//        int sum = calculateSum(map ,start,k);
//        return sum;
//
//
//    }
//
//    private int calculateSum(Map<Node, Node> map, Node start, int k) {
//
//        // base case
//
//
//
//    }


    public static void main(String[] args) {
//        SumOfNodesWithinKDistanceFromTarget tree = new SumOfNodesWithinKDistanceFromTarget();
//
//        Node root = tree.buildTree();
    }
}
