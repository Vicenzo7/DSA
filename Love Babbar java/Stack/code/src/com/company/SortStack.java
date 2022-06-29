package com.company;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.add(5);
        s.add(4);
        s.add(7);
        s.add(6);
        s.add(1);
        s.add(3);

        System.out.println(s);
        sortStack(s);
        System.out.println(s);

    }

    public static void sortStack(Stack<Integer> s)
    {
        //if stack empty
        if(s.empty())
            return ;

        int topElement = s.peek();
        s.pop();

        //Recursive call
        sortStack(s);

        sortedInsert(s,topElement);

    }


    public static void sortedInsert(Stack<Integer> s, int data)
    {
        //if stack empty
        if(s.empty() || s.peek() < data)
        {
            s.push(data);
            return ;
        }


        int topElement = s.peek();
        s.pop();

        //Recursive cal
        sortedInsert(s,data);

        s.push(topElement);

    }
}
