package Problems;

import com.company.Main;

public class MergeTwoSortedLists {
    public Node head;
    public Node tail;
    public int size;
    public MergeTwoSortedLists() {
        this.size =0;
    }

    //insert at head
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail= node;
        }

        size += 1;
    }


    //insert at tail
    public void insertLast(int val){
        // if tail is empty means no nodes
        if(tail == null){
            insertFirst(val);
            return;//we are returning because the below part should not execute or put it in else condition
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }


    //display function
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " ->  ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    //display function
    public void display2(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " ->  ");
            temp = temp.next;
        }
        System.out.println("END");
    }


    //Function to merge two sorted LL
    public Node mergeTwoLists(Node list1, Node list2) {

        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        //create a reference
        Node first = list1;
        Node second = list2;

        //create a dummy pointer;
        Node Dummy = new Node(-1);
        Node tempDummy = Dummy;

        while(first != null && second != null)
        {
            if(first.value <= second.value)
            {
                tempDummy.next = first;
                tempDummy = first;
                first = first.next;
            }else{
                tempDummy.next = second;
                tempDummy = second;
                second = second.next;
            }
        }


        //if any of the list exhausted first than add the remaining list
        while(first != null )
        {
            tempDummy.next = first;
            tempDummy = first;
            first = first.next;
        }

        while(second != null)
        {
            tempDummy.next = second;
            tempDummy = second;
            second = second.next;
        }

        Node head = Dummy.next;

        return  head;


    }





    public class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        MergeTwoSortedLists list1 = new MergeTwoSortedLists();
        list1.insertLast(1);
        list1.insertLast(3);
        list1.insertLast(5);
        list1.insertLast(7);
        list1.display();

        MergeTwoSortedLists list2 = new MergeTwoSortedLists();
        list2.insertLast(2);
        list2.insertLast(4);
        list2.insertLast(6);
        list2.insertLast(8);
        list2.display();

        list1.display2(list1.mergeTwoLists(list1.head,list2.head));
    }
}
