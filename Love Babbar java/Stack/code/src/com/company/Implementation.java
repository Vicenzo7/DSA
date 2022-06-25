package com.company;

public class Implementation {
    private int arr[];
    private int top;
    private int capacity;

    //Constructor to initialize the stack
    Implementation(int size){
        arr = new int[size];
        capacity = size;
        top =-1;
    }

    //function to add an element
    public void push(int x){
        if(isFull())
        {
            System.out.println("Overflow\nProgram Terminated");
            System.exit(-1);
        }

        top++;
        arr[top] = x;
    }


    // function to pop element
    public int pop()
    {
        //check for stack overflow
        if(isEmpty()){
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }

//        System.out.println(peek());
        return arr[top--];
    }

    // Utility function to return the top element of the stack
    public int peek()
    {
        if (!isEmpty()) {
            return arr[top];
        }
        else {
            System.out.println("Stack empty");
            System.exit(-1);
        }

        return -1;
    }

    // Utility function to return the size of the stack
    public int size() {
        return top + 1;
    }

    // Utility function to check if the stack is empty or not
    public boolean isEmpty() {
        return top == -1;               // or return size() == 0;
    }

    // Utility function to check if the stack is full or not
    public boolean isFull() {
        return top == capacity - 1;     // or return size() == capacity;
    }


    public void printStack()
    {

        while(!isEmpty())
        {
            System.out.println(peek());
            pop();
        }
    }



}

class Tester {
    public static void main(String[] args) {
        Implementation stack = new Implementation(5);

        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        stack.printStack();




    }
}
