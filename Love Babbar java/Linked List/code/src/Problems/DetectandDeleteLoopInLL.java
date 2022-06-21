package Problems;

public class DetectandDeleteLoopInLL {

    public Node head;
    public Node tail;
    public int size;

    public DetectandDeleteLoopInLL() {
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

    //to detect loop
    public Node detect(Node head) {
        if (head == null)
            return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast= fast.next.next;

            if(slow == fast)
                return slow;
        }

        return null;
    }


    // to detect and delete loop
    public void detectAndDeleteLoop(Node head)
    {
        if(head == null)
        {
            System.out.println("List empty");

        }

        Node slow = detect(head);
        if(slow == null)
        {
            System.out.println("No loop present");

        }else{
            System.out.println("loop present");
        }

        Node fast = head;
        while(slow != fast)
        {
            slow = slow.next;
            fast= fast.next;
        }

        // now slow and fast are at our beginning node
        Node beginningNode = slow;

        while(beginningNode.next != slow)
        {
            beginningNode=beginningNode.next;
        }
        beginningNode.next = null;
        
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
        DetectandDeleteLoopInLL list = new DetectandDeleteLoopInLL();

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

//        list.display();

        list.detectAndDeleteLoop(list.head);
        list.display();
    }
}
