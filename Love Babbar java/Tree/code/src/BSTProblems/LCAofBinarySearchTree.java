package BSTProblems;

public class LCAofBinarySearchTree {

    Node root;

    // creating a BST
    public void insertKey(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if(key < root.value){
            root.left = insertRec(root.left,key);
        }else{
            root.right = insertRec(root.right,key);
        }
        return root;
    }

    public Node lowestCommonAncestor(Node root, Node p, Node q) {

        if(root == null)
            return null;
        if(p.value < root.value && q.value < root.value)
            return lowestCommonAncestor(root.left,p,q);
        else if(p.value > root.value && q.value > root.value)
            return lowestCommonAncestor(root.right,p,q);
        else{
            return root;
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

    Node p = new Node(2);
    Node q = new Node(8);
    public static void main(String[] args) {
        LCAofBinarySearchTree tree = new LCAofBinarySearchTree();
        tree.insertKey(6);
        tree.insertKey(2);
        tree.insertKey(8);
        tree.insertKey(0);
        tree.insertKey(4);
        tree.insertKey(7);
        tree.insertKey(9);
        tree.insertKey(3);
        tree.insertKey(5);


        Node ans =tree.lowestCommonAncestor(tree.root, tree.p, tree.q);
        System.out.println(ans.value);


    }
}
