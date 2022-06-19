package Problems;

public class IsLLCircular {

    public Node head;
    public Node tail;
    public int size;
    public IsLLCircular() {
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
        //circular or not
        IsLLCircular list = new IsLLCircular();

        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(6);
        list.insertLast(7);
        list.display();

        list.tail.next = list.head;
        System.out.println(list.hasCycle(list.head));
    }
}
