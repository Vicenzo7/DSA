package com.company.linkedlist;

public class PrintLastKthNodeInLL {

    public Node head;
    public Node tail;
    public int size;
    public PrintLastKthNodeInLL() {
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

    int count =0;
    void kthLastNode(Node head,int k){
        Node temp = head;

        kthLastNodeRecur(temp,k);
    }

    void kthLastNodeRecur(Node node,int k){

        // base case
        if(node == null)
            return;

       kthLastNodeRecur(node.next,k);

       count = count+1;
       if(count == k)
           System.out.println(node.value);

    }


    public static void main(String[] args) {
        PrintLastKthNodeInLL list = new PrintLastKthNodeInLL();

        list.insertLast(5);
        list.insertLast(4);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(1);
        list.insertLast(7);
        list.insertLast(9);


        list.kthLastNode(list.head,2);
    }
}
