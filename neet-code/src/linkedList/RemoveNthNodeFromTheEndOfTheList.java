package linkedList;

public class RemoveNthNodeFromTheEndOfTheList {
    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();
        ll.insertEnd(1);
        ll.insertEnd(2);
        ll.insertEnd(3);
        ll.insertEnd(4);
        ll.insertEnd(5);
//        ll.insertEnd(6);
//        ll.insertEnd(7);
//        ll.insertEnd(8);
//        ll.insertEnd(9);
//        ll.insertEnd(10);

        ListNode listNode = removeNthFromEnd(ll.head.next, 2);
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Maintain two pointers and update on by delay of n steps

        // add a dummy node, so we can arrive at a node which is prev to the one we want to delete
        ListNode dummyNode = new ListNode(0, head);

        // Creating a delay
        ListNode right = head;
        while (n > 0 && right != null) {
            right = right.next;
            n -= 1;
        }

        // find a node prev to node to be deleted
        ListNode left = dummyNode;
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummyNode.next;

    }
}

// Intution
// Maintain two pointers and update one by delay of n steps

// Creating a delay on n-steps
//    int counter = 0;
//    ListNode second = head;
//        while(counter <= n && second != null) {
//                counter++;
//                second = second.next;
//                }
//
//                if(second == null) {
//                return second;
//                }
//
//                ListNode first = head;
//                while(second != null) {
//                first = first.next;
//                second = second.next;
//                }
//
//                first.next = first.next.next;
//                return head;
