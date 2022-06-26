package com.company;

import java.util.Stack;

public class ReverseAStack {

    //to insert element at bottom
    public static void insertAtBottom(Stack<Integer> stack,int item) {
        if(stack.empty()){
            stack.push(item);
            return;
        }

        //step1;
        int topElement = stack.peek();
        stack.pop();

        //step2
        insertAtBottom(stack,item);

        //step 3
        stack.push(topElement);

    }


    //to reverse stack
    public static void reverse(Stack<Integer> stack){
        //base case
        if(stack.empty())
            return ;

        int topElement = stack.peek();
        stack.pop();

        reverse(stack);

        insertAtBottom(stack,topElement);
    }



    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(6);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.size());

        insertAtBottom(stack,99);


        System.out.println(stack.size());

        reverse(stack);
        while (!stack.empty()){
            System.out.println(stack.peek());
            stack.pop();
        }






    }
}
