package com.company;

import java.util.Stack;

//https://www.codingninjas.com/codestudio/problems/redundant-brackets_975473?leftPanelTab=0
public class RedundantBrackets {
    public static void main(String[] args) {
//        String s ="(a+c*b)+(c))";
        String s ="((a+c*b)+(c*d))";
        System.out.println(findRedundantBrackets(s));

    }

    public static boolean findRedundantBrackets(String s)
    {
        // Write your code here.
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);

            //if anything comes except closing bracket just push it
            if(ch == '(' || ch == '+'|| ch == '-' || ch == '*' || ch == '/')
            {
                stack.push(ch);
            }else if(ch == ')'){
                boolean isReduntant = true;

                while(stack.peek() != '('){
                    char top = stack.peek();
                    if(top == '+'|| top == '-' || top == '*' || top == '/'){
                        isReduntant = false;
                    }
                    stack.pop();
                }

                if(isReduntant)
                    return true;
                stack.pop();
            }
        }
        return false;
    }
}
