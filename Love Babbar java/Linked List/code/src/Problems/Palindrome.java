package Problems;

public class Palindrome {


    public Node head;
    public Node tail;
    public int size;
    public Palindrome() {
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
    public void display2(ReverseLLInKGroups.Node head){
        ReverseLLInKGroups.Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " ->  ");
            temp = temp.next;
        }
        System.out.println("END");
    }




    public boolean isPalindrome(Node head) {


        Node mid = getMiddle(head);

        Node left = head;

        Node right = mid.next;

        //disconnecting one half
        mid.next = null;
        //reverse the right
        right = reverse(right);



        //checking if Linked list palindrome or not
        Node temp1 = left;
        Node temp2 = right; // prev will be the head of reversed linked list


        while(temp1 != null && temp2 != null){
            if(temp1.value != temp2.value)
                return false;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;
    }


    public Node getMiddle(Node head) {
        Node slow = head;
        //to get mid for odd and even
        Node fast=head.next;

        //finding middle
        while(fast != null  && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node reverse(Node head) {
        Node cur = head;
        Node prev = null;

        while(cur != null){
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
        Palindrome list2 = new Palindrome();

        list2.insertLast(1);
        list2.insertLast(2);
        list2.insertLast(3);
        list2.insertLast(2);
        list2.insertLast(1);
        list2.display();

        System.out.println(list2.isPalindrome(list2.head));
    }
}
