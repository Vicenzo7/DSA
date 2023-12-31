package tree;

import tree.implementation.Tree;
import tree.implementation.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {

        Tree tree = new Tree();
        TreeNode treeNode = tree.buildTree();
        tree.bfsTraversal(treeNode);
        String serialize = serialize(treeNode);
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        tree.bfsTraversal(deserialize);

    }

    /*
        Intuition
        The tree will be serialized and deserialized  using preorder traversal

        eg              1
                       /  \
                      2    3
                          /  \
                         4    5

        TC = O(n)
         serialized data = 1, 2, N, N, 3, 4, N, N, 5, N, N
         this serialized data will be passed to deserialization function to convert back to tree

         we are adding null as N because we should know that a node has either one of the child or only one child
    */


    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        List<String> serializedTree = new ArrayList<>();
        preorder_Serialization(root, serializedTree);
        StringJoiner stringJoiner = new StringJoiner(",");
        for (String s : serializedTree) {
            stringJoiner.add(s);
        }
        return stringJoiner.toString();

    }

    private static void preorder_Serialization(TreeNode root, List<String> serializedTree) {
        if (root == null) {
            serializedTree.add("N");
            return;
        }

        serializedTree.add(String.valueOf(root.val));
        preorder_Serialization(root.left, serializedTree);
        preorder_Serialization(root.right, serializedTree);
    }

    // Decodes your encoded data to tree.
    public static int counter = 0;

    public static TreeNode deserialize(String data) {
        String[] serializedData = data.split(",");
        return preorder_Deserialization(serializedData);

    }

    private static TreeNode preorder_Deserialization(String[] serializedData) {
        if (serializedData[counter].equals("N")) {
            counter++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(serializedData[counter]));
        counter++;
        root.left = preorder_Deserialization(serializedData);
        root.right = preorder_Deserialization(serializedData);

        return root;
    }


}
