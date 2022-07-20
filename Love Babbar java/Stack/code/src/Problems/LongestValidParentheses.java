package Problems;

import java.util.Stack;

public class LongestValidParentheses {
    //TC : O(n) SC: O(n)
    public  static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                else{
                    ans = Math.max(ans,i-stack.peek());
                }
            }
        }
        return ans;
    }


    //TC : O(n) SC: O(1)
    public static int longestValidParenthesesoptimised(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    public static void main(String[] args) {
        String s = "())((())";
        System.out.println(longestValidParenthesesoptimised(s));
        System.out.println(longestValidParentheses(s));
    }
}
