package linkedList;

import linkedList.implementation.ListNode;
import linkedList.implementation.SinglyLinkedList;

import java.util.*;

public class MergeKSortedList {
    public static void main(String[] args) {
        SinglyLinkedList l1 = new SinglyLinkedList();
        l1.insertEnd(1);
        l1.insertEnd(4);
        l1.insertEnd(5);
        SinglyLinkedList l2 = new SinglyLinkedList();
        l2.insertEnd(1);
        l2.insertEnd(3);
        l2.insertEnd(4);
        SinglyLinkedList l3 = new SinglyLinkedList();
        l3.insertEnd(2);
        l3.insertEnd(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = l1.head.next;
        lists[1] = l2.head.next;
        lists[2] = l3.head.next;

        ListNode listNode = mergeKLists_BruteForce(lists);
        printFromNode(listNode);

        ListNode listNode1 = mergeKLists(lists);
        printFromNode(listNode1);

        ListNode listNode2 = mergeKListsOptimised(lists);
        printFromNode(listNode2);
    }

    private static void printFromNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static ListNode mergeKLists_BruteForce(ListNode[] lists) {
        List<Integer> arrayList = new ArrayList<>();
        for (ListNode list : lists) {
            while (list != null) {
                arrayList.add(list.val);
                list = list.next;
            }
        }

        Collections.sort(arrayList);

        ListNode head = new ListNode(-1);
        ListNode dummyHead = head;

        for (Integer i : arrayList) {
            dummyHead.next = new ListNode(i);
            dummyHead = dummyHead.next;
        }
        return head.next;
    }


    //  Solution using Iterative Merge Sort
    //  Time Complexity:         O(n*log(k))
    //  Extra Space Complexity:  O(1)

    /*
        	The code snippet uses a bottom-up merge sort approach to merge the k sorted lists.
        	The while loop runs log n times, where n is the number of lists. In each iteration of the while loop,
        	the for loop merges two lists, which takes O(n) time. Therefore, the overall time complexity is O(n log n).
    */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int size = lists.length;
        int interval = 1;

        while (interval < size) {
            for (int i = 0; i < size - interval; i += interval * 2) {
                lists[i] = mergeTwoList(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }

    private static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode dummyHead = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                dummyHead.next = l1;
                l1 = l1.next;
            } else {
                dummyHead.next = l2;
                l2 = l2.next;
            }
            dummyHead = dummyHead.next;
        }

        dummyHead.next = l1 != null ? l1 : l2;
        return head.next;
    }


    /*
        The code uses a priority queue to merge k sorted lists.
        The priority queue is initialized with a comparator that compares the values of the nodes.
	    The time complexity of adding an element to the priority queue is O(logk), where k is the number of elements in the queue.
        In the worst case, there can be a total of n elements across all the lists, so the overall time complexity is O(nlogk).
    */

    public static ListNode mergeKListsOptimised(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode mergedList = new ListNode();
        ListNode curr = mergedList;
        while (!queue.isEmpty()) {
            ListNode temp = queue.remove();
            curr.next = temp;
            curr = curr.next;

            if (temp.next != null) {
                queue.add(temp.next);
                temp.next = null;
            }
        }
        return mergedList.next;
    }
}
