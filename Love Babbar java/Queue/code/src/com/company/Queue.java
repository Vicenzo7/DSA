package com.company;

public class Queue {

    private int[] arr;      // array to store queue elements
    private int front;      // front points to the front element in the queue
    private int rear;       // rear points to the last element in the queue
    private int capacity;   // maximum capacity of the queue
    private int count;      // current size of the queue

    // Constructor to initialize a queue
    Queue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = 0;
        count = 0;
    }

    // function to dequeue the front element
    public void dequeue() {
        // check for queue underflow
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        } else {
            int x = arr[front];

            System.out.println("Removing " + x);
            arr[front] = -1;
            front++;
            count--;
            if (front == rear) {
                front = rear = 0;
            }
        }
    }

    // function to add an item to the queue
    public void enqueue(int element) {
        // check for queue overflow
        if (isFull()) {
            System.out.println("Overflow");
            System.exit(-1);
        } else {
            System.out.println("Inserting " + element);
            arr[rear] = element;
            rear++;
            count++;
        }
    }

    // function to return the front element of the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        return arr[front];
    }


    //  function to return the size of the queue
    public int size() {
        return count;
    }

    // function to check if the queue is empty or not
    public boolean isEmpty() {
        return (size() == 0);
    }

    // function to check if the queue is full or not
    public boolean isFull() {
        return (size() == capacity);
    }


    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.enqueue(3);
        q.enqueue(5);
        q.enqueue(7);
        q.enqueue(9);


        System.out.println("Front element is "+q.peek());

        q.dequeue();

        System.out.println("Front element is "+q.peek());

        System.out.println("size of queue  "+q.size());

        System.out.println("printing all elements inside Queue");
        while(!q.isEmpty()) {
            System.out.println(q.peek() + " ");
            q.dequeue();
        }

    }
}
