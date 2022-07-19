package Problems;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String str : tokens)
        {
            if(str.equals("+")){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first + second);
            }else if (str.equals("-")){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            }
            else if (str.equals("*")){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first * second);
            }
            else if (str.equals("/")){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            }
            else{
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        //["2","1","+","3","*"]
        //["4","13","5","/","+"]
        System.out.println(evalRPN(tokens));
    }
}
