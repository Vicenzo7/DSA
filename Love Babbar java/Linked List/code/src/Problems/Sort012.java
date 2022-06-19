package Problems;

public class Sort012 {
    public Node head;
    public Node tail;
    public int size;

    public Sort012() {
        this.size = 0;
    }

    //insert at head
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = node;
        }

        size += 1;
    }


    //insert at tail
    public void insertLast(int val) {
        // if tail is empty means no nodes
        if (tail == null) {
            insertFirst(val);
            return;//we are returning because the below part should not execute or put it in else condition
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    //display function
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ->  ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    //display function
    public void display2(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ->  ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    //Function to sort a linked list of 0s, 1s and 2s.
    Node segregate(Node head)
    {


        Node h0 = new Node(-1);
        Node zero = h0;

        Node h1 = new Node(-1);
        Node one = h1;

        Node h2 = new Node(-1);
        Node two = h2;

        Node cur = head;

        while(cur != null){
            if(cur.value == 0){
                zero.next = cur;
                zero = zero.next;
            }
            else if(cur.value == 1){
                one.next = cur;
                one = one.next;
            }else{

                two.next = cur;
                two = two.next;
            }

            cur = cur.next;
        }

        if(h0.next == null)
        {
            if(h1.next == null)
                head = h2.next;
            else
                head = h1.next;
        }else{
            head= h0.next;
        }




        zero.next = h1.next == null ? h2.next : h1.next;
        one.next = h2.next;
        two.next = null;

        return head;


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
        Sort012 list = new Sort012();

        list.insertLast(0);
        list.insertLast(1);
        list.insertLast(0);
        list.insertLast(2);
        list.insertLast(0);
        list.insertLast(1);
        list.insertLast(2);

        list.display();

        list.display2(list.segregate(list.head));
    }
}
