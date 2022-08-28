package com.company.linkedlist;

public class TraverseLL {

    public Node head;
    public Node tail;
    public int size;
    public TraverseLL() {
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

    class Node{
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

    void printLL(Node head){
        Node temp = head;

        printLLRecursion(temp);
    }

    void printLLRecursion(Node node){

        // base case
        if(node == null)
            return;

        System.out.print(node.value+" ");

        printLLRecursion(node.next);
    }

    public static void main(String[] args) {
        TraverseLL list = new TraverseLL();

        list.insertLast(5);
        list.insertLast(4);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(1);

        list.printLL(list.head);

    }

}
