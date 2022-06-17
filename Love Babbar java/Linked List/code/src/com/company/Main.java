package com.company;

public class Main {
    public static void main(String[] args) {

        // Single Linked List
//        LL list = new LL();
//        list.insertFirst(3);
//        list.insertFirst(1);
//        list.insertFirst(2);
//        list.insertFirst(8);
//        list.insertFirst(17);
//        list.insertLast(99);
//        list.insert(100,3);
//        list.display();
//
//        System.out.println(list.deleteFirst());
//
//        list.display();
//
//        System.out.println(list.deleteLast());
//        list.display();
//        System.out.println(list.size);
//
//        System.out.println(list.delete(2));
//        list.display();
//        System.out.println(list.size);


        //Double Linked List
//        DLL list = new DLL();
//        list.insertFirst(3);
//        list.insertFirst(1);
//        list.insertFirst(2);
//        list.insertFirst(8);
//        list.insertFirst(17);
//
//        list.insertLast(99);
//        list.insert(99,65);
//
//
//        list.display();
//
//        System.out.println(list.deleteFirst());
//        list.display();
//        System.out.println(list.size);
//
//        System.out.println(list.deleteLast());
//        list.display();
//        System.out.println(list.size);
//        list.display();
//        System.out.println(list.delete(6));
//        list.display();
//        System.out.println(list.size);


        //Circular Linked List
        CLL list = new CLL();
        list.insertLast(23);
        list.insertLast(3);
        list.insertLast(19);
        list.insertLast(75);
        list.display();

        list.delete(19);
        list.display();
    }
}

