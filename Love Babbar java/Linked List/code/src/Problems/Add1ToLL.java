package Problems;
//https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1
public class Add1ToLL {
    public Node head;
    public Node tail;
    public int size;
    public Add1ToLL() {
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

    public  Node addOne(Node head)
    {
        Node temp = head;

        temp = reverse(temp);

        temp = addOneUpto(temp);

        return reverse(temp);
    }

    public   Node addOneUpto(Node head){
        Node temp = head;
        Node prev = null;

        int sum =0,carry =1;

        while(temp != null){

            sum = carry + temp.value;

            carry = sum>=10 ? 1:0;

            sum = sum%10;

            temp.value = sum;

            prev = temp;
            temp = temp.next;
        }

        if(carry > 0){
            prev.next = new Node(carry);
        }

        return head;
    }


    public  Node reverse(Node head){
        Node cur = head;
        Node prev = null;

        while(cur!=null){
            Node next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
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
        Add1ToLL list = new Add1ToLL();

        list.insertLast(1);
        list.insertLast(9);
        list.insertLast(9);
        list.insertLast(9);

        //middle element of LL02
        list.display2(list.addOne(list.head));
    }
}
