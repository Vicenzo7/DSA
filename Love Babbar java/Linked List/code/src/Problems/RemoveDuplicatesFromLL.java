package Problems;

import java.util.HashSet;
import java.util.LinkedList;

public class RemoveDuplicatesFromLL {
    public Node head;
    public Node tail;
    public int size;
    public RemoveDuplicatesFromLL() {
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


    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head)
    {
        // Your code here
        Node cur = head;
        Node prev = null;
        HashSet<Integer> set = new HashSet<Integer>();


        while(cur != null){
            int val = cur.value;
            if(set.contains(val)){
                prev.next=cur.next;
            }else{
                set.add(val);
                prev=cur;
            }

            cur = cur.next;
        }

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
        RemoveDuplicatesFromLL list = new RemoveDuplicatesFromLL();

        list.insertLast(5);
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(4);
        list.insertLast(4);



        //middle element of LL02
        list.display2(list.removeDuplicates(list.head));
    }
}
