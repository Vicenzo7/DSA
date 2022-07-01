package Problems;
//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
    public Node head;
    public Node tail;
    public int size;
    public AddTwoNumbers() {
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

    //Add tow linked List
    public Node addTwoNumbers(Node l1, Node l2) {

        Node dummyNode = new Node(-1);
        Node dummy = dummyNode;

        Node first = l1;
        Node second = l2;

        int sum = 0, carry = 0;
        while (first != null || second != null || carry != 0) {

            int x = first != null ? first.value : 0;
            int y = second != null ? second.value : 0;
            sum = carry + x + y;

            carry = sum >= 10 ? 1 : 0;

            sum = sum % 10;


            dummy.next = new Node(sum);
            dummy = dummy.next;
            if (first != null)
                first = first.next;
            if (second != null)
                second = second.next;
        }

        return dummyNode.next;
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
        AddTwoNumbers list1 = new AddTwoNumbers();

        list1.insertLast(2);
        list1.insertLast(4);
        list1.insertLast(3);
        list1.insertLast(7);

        AddTwoNumbers list2 = new AddTwoNumbers();

        list2.insertLast(5);
        list2.insertLast(6);
        list2.insertLast(4);

        list1.display2(list1.addTwoNumbers(list1.head,list2.head));


    }
}
