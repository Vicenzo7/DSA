package Problems;

import java.util.Stack;

public class CheckIfWordsValidAfterSubstitutions {
    public static void main(String[] args) {
        String s = "aabcbc";
        System.out.println(isValid(s));
    }

//    public static boolean isValid(String s) {
//
//        while(!s.equals(""))
//        {
//            int check = s.indexOf("abc");
//            if(check == -1)
//                return false;
//            s = s.substring(0,check)+s.substring(check+3);
//        }
//        return true;
//    }

    //using stack
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);

            if(ch == 'a' || ch =='b')
            {
                stack.push(ch);
            }else{
                //if there are less than two elements to pop than its false;
                if(stack.size() == 0 || stack.size()==1)
                    return false;
                char top1=stack.pop();
                char top2 = stack.pop();

                if(top2 !='a' || top1 !='b')
                    return false;
            }
        }

        return stack.size()==0;
    }
}
