package Problems;

import java.util.LinkedList;
import java.util.Queue;

//we can also do this using a dequeue.


// using two stacks
//class MyStack {
//    Queue<Integer> q1;
//    Queue<Integer> q2;
//
//    public MyStack() {
//        q1 = new LinkedList<>();
//        q2 = new LinkedList<>();
//    }
//
//    public void push(int x) {
//        if (q1.isEmpty()) {
//            q1.add(x);
//        } else {
//            while (!q1.isEmpty()) {
//                q2.add(q1.remove());
//            }
//            q1.add(x);
//
//            while (!q2.isEmpty()) {
//                q1.add(q2.remove());
//            }
//        }
//    }
//
//    public int pop() {
//        return q1.remove();
//    }
//
//    public int top() {
//        return q1.peek();
//    }
//
//    public boolean empty() {
//        return q1.isEmpty();
//    }
//
//    public static void main(String[] args) {
//        MyStack s = new MyStack();
//
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        s.push(4);
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//    }
//}

// using a single stack

/**
 * Method 3 (Using only 1 queue):
 *
 * In this method, we will be using only one queue and make the queue act as a stack.
 * The idea behind this approach is to make one queue and push the first element in it.
 * After the first element, we push the next element and then push the first element again and finally pop the
 * first element.
 * So, according to the FIFO rule of queue, second element that was inserted will be at the front and then the
 * first element as it was pushed again later and its first copy was popped out. So, this acts as a stack, and
 * we do this at every step i.e. from the initial element to the second last element and the last element will be
 * the one which we are inserting and since we will be pushing the initial elements after pushing the last element,
 * our last element becomes the first element.
 */

class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        if(q.isEmpty()){
            q.add(x);
        }else{
            int size = q.size();
            q.add(x);
            for(int i=0;i<size;i++){
                int element = q.remove();
                q.add(element);
            }
        }
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}



