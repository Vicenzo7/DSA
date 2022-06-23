package Problems;

public class RotateList {
    public Node head;
    public Node tail;
    public int size;
    public RotateList() {
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

    // to get length of linked list
    public int getLength(Node head)
    {
        int length=0;
        Node temp = head;
        while(temp != null)
        {
            length++;
            temp=temp.next;
        }

        return length;
    }


    public Node rotateRight(Node head, int k) {

        //to get length
        int n = getLength(head);

        // cant rotate list if list empty or only one element or k=0
        if(head == null || head.next == null || k==0 || k%n ==0)
            return head;


        //update k if k> n
        k=k%n;

        Node prev=null;
        Node curr = head;
        int t= n-k;
        while(t!=0)
        {
            prev = curr;
            curr = curr.next;
            t--;
        }
        // making prev of cur to null;
        prev.next=null;

        Node tail = curr;

        //go till end of list
        while(tail.next !=null)
        {
            tail = tail.next;
        }

        //connect the end to head
        tail.next = head;

        //returning cur because its pointing to the node we rotated
        return curr;


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
        RotateList list = new RotateList();

        int k =3;


        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(6);
        list.insertLast(7);

        list.display();
        list.display2(list.rotateRight(list.head,k));




    }
}
