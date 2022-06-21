package Problems;

public class KthNodeFromEndOfLL {
    public Node head;
    public Node tail;
    public int size;
    public KthNodeFromEndOfLL() {
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

    // with slow fast pointer
    // slow and fast with a gap of K
    public void kthElementFromEnd(Node head,int k)
    {
        if(head == null)
        {
            System.out.println("Empty list");
        }
        Node slow = head;
        Node fast = head;

        //moving fast pointer to a point where gap between slow and fast is k

        while(k!=0)
        {
            fast = fast.next;
            k--;
        }

        while(fast != null )
        {
            slow = slow.next;
            fast = fast.next;
        }
        // after while the slow will reach the kth element from last
        System.out.println(slow.value);
    }


    // same using recursion
    public int  kthElementFromEnd2(Node head,int k){

        //base case
        if(head == null)
        {
            return 0;
        }

        int count = kthElementFromEnd2(head.next,k) + 1;

        if(count == k)
        {
            return head.value;
        }else{
            return 0;
        }


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

        KthNodeFromEndOfLL list = new KthNodeFromEndOfLL();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(6);
        list.insertLast(7);
        list.insertLast(8);
        list.insertLast(9);
        list.insertLast(10);
        int k=3;
        list.kthElementFromEnd(list.head,k);

        System.out.println(list.kthElementFromEnd2(list.head, k));
    }
}
