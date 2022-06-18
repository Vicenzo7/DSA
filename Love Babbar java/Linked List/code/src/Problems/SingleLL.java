package Problems;

public class SingleLL {

    public Node head;
    public Node tail;
    public int size;
    public SingleLL() {
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

    // reverse a linked list
    public Node reverseList(Node head) {

        if(head == null)
        {
            return head;
        }
        Node curr = head;
        Node prev = null;


        while(curr != null)
        {
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }


        return prev;

    }

    // to get middle element
    public Node middleNode(Node head) {
        // using hair tortoise method

        if(head == null)
        {
            return head;
        }
        Node slow = head;
        Node fast = head;

        // till we reach last  and also checking if its possible to move forward
        while(fast != null && fast.next != null)
        {
            //moving fast by 2
            fast = fast.next.next;
            //moving slow by 2
            slow = slow.next;
        }

        return slow;
    }


    // to check is linked list is Circular
    public boolean hasCycle(Node head) {


        Node slow = head;
        Node fast = head;

        // till we reach last  and also checking if its possible to move forward
        while(fast != null && fast.next != null)
        {
            //moving fast by 2
            fast = fast.next.next;
            //moving slow by 2
            slow = slow.next;
            if(slow == fast)
                return true;
        }

        return false;

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





}
