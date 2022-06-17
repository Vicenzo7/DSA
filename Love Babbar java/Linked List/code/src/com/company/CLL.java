package com.company;

public class CLL {


    private Node head;
    private Node tail;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    //insert at tail
    public void insertLast(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    //to delete a particular value
    public void delete(int val){
        Node temp = head;

        if(head == null)
            return;
        if(head.value == val){
            head = head.next;
            tail.next = head;
            return;
        }

        do{
            Node n = temp.next;
            if(n.value == val){
                temp.next=n.next;
                break;
            }
            temp = temp.next;
        } while (temp != head); 
    }

    //to display
    public void display() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            } while (temp != head);
            System.out.println("HEAD");
        }
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
