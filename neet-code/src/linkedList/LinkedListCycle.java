package linkedList;

import linkedList.implementation.ListNode;
import linkedList.implementation.SinglyLinkedList;

public class LinkedListCycle {
    public static void main(String[] args) {
        SinglyLinkedList myList = new SinglyLinkedList();
        myList.insertEnd(3);
        myList.insertEnd(2);
        myList.insertEnd(0);
        myList.insertEnd(-4);

        // Creating a cycle (4 points to 2)
        ListNode node4 = myList.head.next.next.next.next;
        ListNode node2 = myList.head.next.next;
        node4.next = node2;

        // Print the cyclic linked list
//        myList.print();
        System.out.println(hasCycle(myList.head));
    }


    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        // Determining cycle start node

//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//
//            if (slow == fast) {
//                break;
//            }
//        }



//        ListNode slow2 = head;
//        while (slow2 != slow) {
//            slow2 = slow2.next;
//            slow = slow.next;
//        }

//        System.out.println(slow2.val);
        return false;
    }
}
