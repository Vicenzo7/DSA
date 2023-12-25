package linkedList;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        SinglyLinkedList l1 = new SinglyLinkedList();
        l1.insertEnd(1);
        l1.insertEnd(2);
        l1.insertEnd(4);

        SinglyLinkedList l2 = new SinglyLinkedList();
        l2.insertEnd(1);
        l2.insertEnd(3);
        l2.insertEnd(4);

        ListNode listNode = mergeTwoLists(l1.head.next, l2.head.next);
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode mergedList = new ListNode();
        ListNode dummyNode = mergedList;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                dummyNode.next = list1;
                list1 = list1.next;
            } else {
                dummyNode.next = list2;
                list2 = list2.next;
            }
            dummyNode = dummyNode.next;
        }

        dummyNode.next = list1 != null ? list1 : list2;

//        while (list1 != null) {
//            dummyNode.next = list1;
//            list1 = list1.next;
//            dummyNode = dummyNode.next;
//        }
//        while (list2 != null) {
//            dummyNode.next = list2;
//            list2 = list2.next;
//            dummyNode = dummyNode.next;
//        }

        return mergedList.next;
    }
}
