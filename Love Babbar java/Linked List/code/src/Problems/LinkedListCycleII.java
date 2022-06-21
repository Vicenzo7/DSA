package Problems;

public class LinkedListCycleII {
    public Node head;
    public Node tail;
    public int size;

    public LinkedListCycleII() {
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

    //display function to display single node
    public void display3(Node head) {
        Node temp = head;
        System.out.println(temp.value);
    }


    public Node detectCycle(Node head) {
        return detectandDelete(head);
    }

    public Node detect(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow== fast)
                return slow;
        }

        return null;
    }


    public Node detectandDelete(Node head){

        if(head == null)
            return null;
        Node slow = detect(head);
        if(slow == null)
            return null;
        Node fast = head;

        while(slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }


        return slow;

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
        LinkedListCycleII list = new LinkedListCycleII();

        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        Node temp =list.tail;
        list.insertLast(6);
        list.insertLast(7);
        list.insertLast(8);
        list.insertLast(9);
        list.insertLast(10);
        list.tail.next = temp;

        list.display3(list.detectCycle(list.head));
    }
}
