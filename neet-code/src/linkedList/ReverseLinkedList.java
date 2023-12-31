package linkedList;

import linkedList.implementation.ListNode;
import linkedList.implementation.SinglyLinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertEnd(1);
        singlyLinkedList.insertEnd(2);
        singlyLinkedList.insertEnd(3);
        singlyLinkedList.insertEnd(4);
        singlyLinkedList.insertEnd(5);

        singlyLinkedList.print();
        ListNode listNode = reverseList(singlyLinkedList.head.next);
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.println();

    }


    public static ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            // Need next so we can move curr to next before breaking the link
            ListNode next = curr.next;
            // break the link
            curr.next = prev;
            // Also need prev
            prev = curr;
            // move curr to next
            curr = next;
        }
        return prev;
    }


}
