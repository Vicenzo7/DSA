package Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsOfQueue {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        System.out.println(q);
        int k = 3;
        System.out.println(modifyQueue(q,k));
    }


    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        Stack<Integer> stack = new Stack<>();
        int n = q.size();
        for (int i = 0; i < k ; i++) {
            stack.add(q.remove());
        }

        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
        for (int i = 0; i < n-k; i++) {
            int element = q.remove();
            q.add(element);
        }

        return q;
    }
}
