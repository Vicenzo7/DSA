package Problems;

import java.util.Stack;

//https://leetcode.com/problems/implement-queue-using-stacks/
public class ImplementQueueUsingStacks {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if(!output.isEmpty())
            return output.pop();
        else{
            while(!input.isEmpty())
            {
                output.push(input.pop());


            }
            return output.pop();
        }
    }

    public int peek() {
        if(!output.isEmpty())
            return output.peek();
        else{
            while(!input.isEmpty())
            {
                output.push(input.pop());
            }
            return output.peek();
        }
    }

    public boolean empty() {
        return (input.isEmpty() && output.isEmpty());
    }


    public static void main(String[] args) {
        ImplementQueueUsingStacks obj = new ImplementQueueUsingStacks();
        obj.push(2);
        obj.push(5);
        obj.push(3);

        System.out.println(obj.peek());
        System.out.println(obj.pop());
        obj.push(6);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.peek());

        System.out.println(obj.empty());
    }
}
