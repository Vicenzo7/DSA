package linkedList;

import linkedList.implementation.ListNode;
import linkedList.implementation.SinglyLinkedList;

public class ReverseNodeInKGroup {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertEnd(1);
        list.insertEnd(2);
        list.insertEnd(3);
        list.insertEnd(4);
        list.insertEnd(5);

        ListNode listNode = reverseKGroup(list.head.next, 2);
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        // recursive solution
        if (head == null) {
            return null;
        }

        // check if there are k nodes that can be reversed
        ListNode current = head;
        int count = 0;

        while (current != null && count < k) {
            count++;
            current = current.next;
        }

        // if no k nodes return the remaining list
        if (count < k) {
            return head;
        }

        // reverse the k nodes
        current = head;
        ListNode prev = null;
        ListNode next = null;
        count = 0;
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // check if there are more node which can be sent for reversal
        if (current != null) {
            // connect the reversed last node to the remainingList
            head.next = reverseKGroup(current, k);
        }

        return prev;
    }
}
