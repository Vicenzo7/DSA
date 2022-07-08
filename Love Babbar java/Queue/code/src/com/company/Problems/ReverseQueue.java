package com.company.Problems;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void main(String[] args) {

        Queue<Integer> que = new LinkedList<>();
        que.add(2);
        que.add(4);
        que.add(6);
        que.add(8);

        System.out.println(que);
//        reverse(que);
        reverseRecursion(que);
        System.out.println(que);
    }

    public static void reverse(Queue<Integer> que){
        Stack<Integer> stack = new Stack<>();

        //step1: Add in stack
        while(!que.isEmpty()){
            stack.add(que.peek());
            que.remove();
        }

        //step2 Add back from stack to queue
        while(!stack.isEmpty()){
            que.add(stack.pop());
        }
    }

    public static void reverseRecursion(Queue<Integer> que){
        if(que.isEmpty())
            return;

        //remove element
        int element = que.remove();

        // recursion to reverse que
        reverseRecursion(que);

        //after the que is reverse add the first element to back
        que.add(element);
    }



}
