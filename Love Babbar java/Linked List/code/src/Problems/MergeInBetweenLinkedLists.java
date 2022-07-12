package Problems;
//https://leetcode.com/problems/merge-in-between-linked-lists/
public class MergeInBetweenLinkedLists {
    public Node head;
    public Node tail;
    public int size;
    public MergeInBetweenLinkedLists() {
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

    public Node mergeInBetween(Node list1, int a, int b, Node list2) {

        Node list2End = list2;
        while(list2End.next !=null)
        {
            list2End = list2End.next;
        }

        Node prevOfA = null;
        Node nodeB = null;

        Node temp = list1;
        int count = 0;

        while(temp!=null)
        {
            if(count+1 == a)
                prevOfA = temp; //points to previous of node A
            if(count == b)
                nodeB = temp; //points to Bth node

            count++;
            temp = temp.next;
        }

        prevOfA.next = list2;
        list2End.next = nodeB.next;
        nodeB.next = null;
        return list1;

    }



    public class Node{
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
        MergeInBetweenLinkedLists list = new MergeInBetweenLinkedLists();
        list.insertLast(0);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(6);

        MergeInBetweenLinkedLists list2 = new MergeInBetweenLinkedLists();
        list2.insertLast(100);
        list2.insertLast(101);
        list2.insertLast(102);
        list2.insertLast(103);
        list2.insertLast(104);
        int a=2,b=5;
        list.display();
        list2.display();
        list.display2(list.mergeInBetween(list.head,a,b,list2.head));
    }
}
