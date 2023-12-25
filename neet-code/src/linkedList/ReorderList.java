package linkedList;

import java.util.Arrays;

public class ReorderList {
    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();
        ll.insertEnd(1);
        ll.insertEnd(2);
        ll.insertEnd(3);
        ll.insertEnd(4);
        ll.insertEnd(5);

        reorderList(ll.head.next);
        ll.print();
    }

    public static void reorderList(ListNode head) {
        // Intuition
        // Find Middle
        // Reverse the second part from middle node
        // Merge the first part and the reversed List

        // find middle
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half
        ListNode second = reverse(slow.next);
        slow.next = null;

        // merge two halfs
        ListNode first = head;
        while(first != null && second != null) {
            ListNode temp = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp;

            first = temp;
            second = temp2;
        }
    }

    public static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
