package Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FirstAndMiddle {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        System.out.println(q);

        solve(q);
        System.out.println(q);
    }

    public static void solve(Queue<Integer> q){

        //queue length
        int n = q.size();
        int mid = n/2;

        Stack<Integer> stack = new Stack<>();

        //step1 : put first half into stack
        for (int i = 0; i < mid; i++) {
            stack.add(q.remove());
        }
        System.out.println(q);
        System.out.println(stack);
        //step2: put the stack element back to queue
        while (!stack.isEmpty()){
            q.add(stack.pop());
        }

        System.out.println(q);
        System.out.println(stack);

        //step 3: put first half of queue at back of queue
        for (int i = 0; i < mid; i++) {
            q.add(q.remove());
        }

        System.out.println(q);
        System.out.println(stack);

        //step4 : put first half into stack
        for (int i = 0; i <mid ; i++) {
            stack.add(q.remove());
        }
        //step5: now put in queue one from stack one from queue
        System.out.println(q);
        System.out.println(stack);
        while (!stack.isEmpty()){
            q.add(stack.pop());
            q.add(q.remove());
        }
    }
}
