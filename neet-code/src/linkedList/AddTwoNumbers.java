package linkedList;

import linkedList.implementation.ListNode;
import linkedList.implementation.SinglyLinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        SinglyLinkedList l1 = new SinglyLinkedList();
        l1.insertEnd(9);
        l1.insertEnd(9);
        l1.insertEnd(9);
        l1.insertEnd(9);
        l1.insertEnd(9);
        l1.insertEnd(9);
        l1.insertEnd(9);

        SinglyLinkedList l2 = new SinglyLinkedList();
        l2.insertEnd(9);
        l2.insertEnd(9);
        l2.insertEnd(9);
        l2.insertEnd(9);

        ListNode listNode = addTwoNumbers(l1.head.next, l2.head.next);
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = 0;
        int carry = 0;
        ListNode newHead = new ListNode();
        ListNode dummyHead = newHead;

        while (l1 != null || l2 != null || carry != 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            sum = x + y + carry;
            carry = sum > 9 ? 1 : 0;

            sum = sum % 10;

            dummyHead.next = new ListNode(sum);
            dummyHead = dummyHead.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return newHead.next;
    }
}

