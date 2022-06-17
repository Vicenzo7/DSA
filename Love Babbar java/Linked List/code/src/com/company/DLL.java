package com.company;

public class DLL {

    private Node head;
    public int size =0;

    public DLL() {
        this.size = 0;
    }

    //insert first
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null)
            head.prev = node;

        head = node;
        size++;
    }

    //insert at last
    public void insertLast(int val) {
        Node node = new Node(val);
        Node last = head;

        node.next = null;

        // if linked list is empty
        if (head == null) {
            node.prev = null;
            head = node;
            size++;
            return;
        }

        while (last.next != null)
            last = last.next;

        last.next = node;
        node.prev = last;

        size++;

    }

    //insert after a particular value
    public void insert(int after, int val) {
        Node p = find(after);

        if (p == null) {
            System.out.println("does not exist");
            return;
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;

        if (node.next != null) {
            node.next.prev = node;
        }
        size++;

    }


    //delete at start
    public int deleteFirst() {
        if(head == null){
            System.out.println("List empty");
            return -1;
        }
        int val = head.value;

        head = head.next;
        head.prev = null;



        size--;
        return val;

    }


    //delete at last
    public int deleteLast() {
        if(size <= 1)
        {
            return deleteFirst();
        }
        Node last = head;
        while(last.next != null){
            last=last.next;
        }
        int val = last.value;
        last.prev.next = null;
        size--;
        return val;

    }

    //to delete at a particular index
    public int delete(int index){

        if(index >= size)
        {
            System.out.println("List is smaller than the index provided ");
            return -1;
        }

        if(index == 0)
            return deleteFirst();
        if(index == size-1)
            return deleteLast();

        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next.next.prev = prev;
        prev.next = prev.next.next;


        size--;
        return val;

    }


    //function that gets us Node that has a particular value
    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value)
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


    //to display
    public void display() {
        Node temp = head;
        Node last = null;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("END");

//        System.out.println("Print in reverse");
//        while (last != null) {
//            System.out.print(last.value + " -> ");
//            last = last.prev;
//        }
//        System.out.println("START");
    }

    private class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
