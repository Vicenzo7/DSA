package Problems;

public class Reverse {
    public Node head;
    public Node tail;
    public int size;

    public Reverse() {
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

    // reverse a linked list
    public Node reverseList(Node head) {

        if (head == null) {
            return head;
        }
        Node curr = head;
        Node prev = null;


        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }


        return prev;

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
        Reverse list = new Reverse();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(6);
        list.insertLast(7);


        list.display();
        //reverse a list
        list.display2(list.reverseList(list.head));
    }
}
