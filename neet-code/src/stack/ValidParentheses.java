package stack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "]]";
        System.out.println(isValid(s));
    }

//    public static boolean isValid(String s) {
//        // TC = O(n)  SC = O(n)
//        if (s.length() % 2 != 0 || s.isEmpty()) return false;
//
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (ch == '}') {
//                if (!stack.isEmpty() && stack.peek() == '{') {
//                    stack.pop();
//                    continue;
//                }
//            } else if (ch == ']') {
//                if (!stack.isEmpty() && stack.peek() == '[') {
//                    stack.pop();
//                    continue;
//                }
//            } else if (ch == ')') {
//                if (!stack.isEmpty() && stack.peek() == '(') {
//                    stack.pop();
//                    continue;
//                }
//            }
//            stack.push(ch);
//        }
//        return stack.isEmpty();
//    }

    public static boolean isValid(String s) {
        // TC = O(n)  SC = O(n)
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() && (ch == '}' || ch == ')' || ch == ']')) {
                return false;
            } else if (ch == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (ch == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (ch == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.add(ch);
            }
        }
        return stack.isEmpty();
    }
}
