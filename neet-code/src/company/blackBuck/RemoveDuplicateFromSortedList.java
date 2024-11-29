package company.blackBuck;

import linkedList.implementation.ListNode;
import linkedList.implementation.SinglyLinkedList;

public class RemoveDuplicateFromSortedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertEnd(1);
        list.insertEnd(1);
        list.insertEnd(2);
        list.insertEnd(3);
        list.insertEnd(3);

        ListNode listNode = deleteDuplicates(list.head.next);
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            // means we reached the last node
            if (curr.next == null) {
                break;
            }

            // check if the cur value == next node value
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
