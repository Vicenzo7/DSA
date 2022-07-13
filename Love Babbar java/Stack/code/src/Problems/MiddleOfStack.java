package Problems;

import java.util.Stack;

public class MiddleOfStack {


    public static void middleOfStack(Stack<Integer> stack ,int totalSize){
        if((totalSize/2)+1 == stack.size()) {
            System.out.println(stack.peek());
            return;
        }

        int element = stack.peek();
        stack.pop();

        middleOfStack(stack,totalSize);
        stack.push(element);
    }




    public static void main(String[] args) {


        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        middleOfStack(stack,5);









    }
}
