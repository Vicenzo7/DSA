package com.backtracking.hard;

import java.util.*;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        String s = "()())()";
        List<String> ans = removeInvalidParentheses(s);
        System.out.println(ans);
    }


    public static List<String> removeInvalidParentheses(String s) {
        int removalCount = getRemovalCount(s);
        ArrayList<String> ans = new ArrayList<>();
        Map<String,Boolean> map = new HashMap<>();
        solve(s, removalCount, ans, map );
        return ans;
    }

    static void solve(String s, int removalCount,ArrayList<String> ans, Map<String,Boolean> map){
        if(map.containsKey(s)){
            return;
        }else{
            map.put(s,true);
        }


        if(removalCount == 0){
            // check again for validity
            int numRemoval = getRemovalCount(s);
            if(numRemoval == 0){
                ans.add(s);
            }
            return;
        }


        for(int i =0; i< s.length(); i++){
            // removing one bracket at a time and
            // checking if the removed bracket gets us a valid thing;
            String leftStr = s.substring(0,i);
            String rightStr= s.substring(i+1);
            String temp = leftStr + rightStr;
            solve(temp,removalCount-1,ans,map);
        }
    }



    static int getRemovalCount(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch =='('){
                stack.push(ch);
            }else if (ch == ')') {
                if(!stack.isEmpty() && stack.peek()=='(' ){
                    stack.pop();
                }else{
                    stack.push(')');
                }
            }
        }

        return stack.size();
    }
}
