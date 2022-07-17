package Problems;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(min.isEmpty())
            min.push(val);
        else{
            min.push(Math.min(stack.peek(),min.peek()));
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(3);
        obj.pop();
        obj.push(4);
        obj.push(-1);
        System.out.println(obj.top());
        obj.push(6);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}
