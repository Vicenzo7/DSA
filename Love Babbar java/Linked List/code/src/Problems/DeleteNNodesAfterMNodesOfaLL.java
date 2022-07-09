package Problems;

public class DeleteNNodesAfterMNodesOfaLL {
    public Node head;
    public Node tail;
    public int size;

    public DeleteNNodesAfterMNodesOfaLL() {
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

    //deleting N nodes after skipping M nodes
    public void linkdelete(Node head, int M, int N) {
        // your code here

        Node prev = null;
        Node cur = head;


        while (cur != null) {
            int p = M;
            while (cur != null && p != 1) {
                cur = cur.next;
                p--;
            }
            if (cur == null) {
                break;
            }
            int q = N;
            prev = cur;
            cur = cur.next;

            while (cur != null && q != 0) {
                cur = cur.next;
                q--;
            }

            prev.next = cur;
        }


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
        DeleteNNodesAfterMNodesOfaLL list = new DeleteNNodesAfterMNodesOfaLL();

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
        list.insertLast(11);
        list.insertLast(12);


        int M=2,N=2;
        list.display();
        list.linkdelete(list.head,M,N);
        list.display();
    }
}
