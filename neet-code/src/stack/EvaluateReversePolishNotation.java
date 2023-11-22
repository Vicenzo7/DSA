package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")) {
                int calculateResult = calculate(stack.pop(), stack.pop(), token);
                stack.push(calculateResult);
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    private static int calculate(Integer b, Integer a, String operand) {
        return switch (operand) {
            case "*" -> a * b;
            case "/" -> a / b;
            case "+" -> a + b;
            case "-" -> a - b;
            default -> 0;
        };

    }
}
