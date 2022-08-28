package com.company.linkedlist;

public class ReverseLLInKGroups {

    public Node head;
    public Node tail;
    public int size;
    public ReverseLLInKGroups() {
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


    public Node reverseInKGroup(Node head,int k){
        Node temp = head;

        return reverseInKGroupRec(temp,k);
    }

    public Node reverseInKGroupRec(Node node ,int k){
        // if list empty return the same list

        if(node == null){
            return node;
        }

        // check if there are K nodes to be reversed
        int count =0;
        Node temp = node;

        // checking if there are k elements to reverse
        while(temp!=null && count<k) {
            temp = temp.next;
            count++;
        }
        // if there aren't k node return the node back
        if (count < k)
            return node;


        Node cur = node;
        Node prev = null;
        Node next = null;
        count = 0;

        while(cur != null & count<k){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }


        if(next != null){
            Node rem = reverseInKGroupRec(next,k);
            node.next = rem;
        }

        return prev;
    }


    public static void main(String[] args) {
        ReverseLLInKGroups list = new ReverseLLInKGroups();

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

        int k= 2;

        Node ans = list.reverseInKGroup(list.head,k);

        list.display2(ans);

    }
}
