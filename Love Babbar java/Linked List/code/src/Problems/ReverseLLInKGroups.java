package Problems;

public class ReverseLLInKGroups {

    public Node head;
    public Node tail;
    public int size;
    public ReverseLLInKGroups() {
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


    //Reverse LL in K groups
    public Node reverseKGroup(Node head, int k) {
        // if LL empty
        if(head == null)
            return null;

        int count = 0;
        Node temp = head;
        // checking if there are k elements to reverse
        while(temp!=null && count<k) {
            temp = temp.next;
            count++;
        }

        if(count < k)
            return head;

        // reversing if k elements are there
        Node curr = head;
        Node prev = null;
        Node next = null;
        count =0;
        // reverse the list till first k
        while(curr != null && count < k)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr  = next;
            count++;
        }

        if(next != null)
        {
            Node rem = reverseKGroup(next,k);
            head.next = rem;
        }

        return prev;
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
        ReverseLLInKGroups list = new ReverseLLInKGroups();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.display();

        //Reverse LL in K groups
        list.display2(list.reverseKGroup(list.head,3));
    }





}
