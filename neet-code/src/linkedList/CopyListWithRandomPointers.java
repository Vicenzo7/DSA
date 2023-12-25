package linkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointers {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.val + ",");
            if (current.random != null) {
                System.out.print(current.random.val);
            } else {
                System.out.print("null");
            }
            System.out.print("] -> ");
            current = current.next;
        }
        System.out.println("null");
    }


    // TC = O(n)  SC = O(n)
    public static Node copyRandomList(Node head) {
        // Create a Map and map old nodes to new nodes
        Map<Node, Node> oldToCopy = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            Node copyNode = new Node(curr.val);
            oldToCopy.put(curr, copyNode);
            curr = curr.next;
        }

        // Map new nodes next and random pointer
        curr = head;
        while (curr != null) {
            Node copy = oldToCopy.get(curr);
            copy.next = oldToCopy.getOrDefault(curr.next, null);
            copy.random = oldToCopy.getOrDefault(curr.random, null);
            curr = curr.next;
        }

        return oldToCopy.get(head);
    }

    //  TC = O(n)  SC=O(1)
    public static Node copyRandomListOptimised(Node head) {
        // Step 1: Create a new node for each original node and insert it next to the original node
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        // Step 2: Assign random pointers for the new nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the original list and the copied list
        Node newHead = head.next;
        current = head;
        Node newCurrent = newHead;

        while (current != null) {
            current.next = current.next.next;
            current = current.next;

            if (newCurrent.next != null) {
                newCurrent.next = newCurrent.next.next;
                newCurrent = newCurrent.next;
            }
        }

        return newHead;
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[5];
        nodes[0] = new Node(7);
        nodes[1] = new Node(13);
        nodes[2] = new Node(11);
        nodes[3] = new Node(10);
        nodes[4] = new Node(1);

        nodes[0].next = nodes[1];
        nodes[1].next = nodes[2];
        nodes[2].next = nodes[3];
        nodes[3].next = nodes[4];

        nodes[1].random = nodes[0];
        nodes[2].random = nodes[4];
        nodes[3].random = nodes[2];
        nodes[4].random = nodes[0];
        printLinkedList(nodes[0]);
        Node node = copyRandomList(nodes[0]);
        printLinkedList(node);
        Node node1 = copyRandomListOptimised(nodes[0]);
        printLinkedList(node1);

    }
}


