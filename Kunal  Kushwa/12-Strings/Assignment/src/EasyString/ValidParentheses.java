package EasyString;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));
    }

    public static  boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        char[] a = s.toCharArray();

        for(char ch : a)
        {
            if(ch == ')')
            {
                if(!stack.empty()  && stack.peek() == '(')    //peek is to view the topmost element
                {
                    stack.pop();    // eliminate or remove the peek element
                    continue;         // break the loop and start with next iteration
                }
            }
            else if(ch == ']')
            {
                if(!stack.empty()  && stack.peek() == '[')
                {
                    stack.pop();
                    continue;
                }
            }
            else if(ch == '}')
            {
                if(!stack.empty()  && stack.peek() == '{')
                {
                    stack.pop();
                    continue;
                }
            }

            stack.push(ch); // push the element
        }
        return stack.empty(); // returns true if stack is empty
    }
}
