package com.company.linkedlist;

public class LL {

    private Node head;
    private Node tail;
    public int size;
    public LL() {
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

    //insert at any position
    public void insert(int val,int index)
    {
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
        }

        Node temp = head;
        for (int i = 1; i < index ; i++) {
            temp = temp.next;
        }

        Node node = new Node(val,temp.next);
        temp.next = node;

        size++;
    }


    //delete first element
    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail=null;
        }

        size--;
        return val;
    }

    //to delete last element
    public int deleteLast()
    {
        if(size <= 1)
        {
            return deleteFirst();
        }

        Node secondLast = get(size-2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;

        size--;

        return val;
    }

    // delete at a particular index
    public int delete(int index){
        if(index == 0)
            return deleteFirst();
        if(index == size-1)
            return deleteLast();

        Node prev = get(index-1);
        int val = prev.next.value;

        prev.next = prev.next.next;

        size--;
        return val;

    }

    //function that gets us Node that has a particular value
    public Node find(int value){
        Node node = head;
        while(node != null)
        {
            if(node.value == value)
                return node;
            node = node.next;
        }


        // if not found return null
        return null;
    }


    //function that gets us a node reference
    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index ; i++) {
            node = node.next;
        }

        return node;
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


    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}