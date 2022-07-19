package Problems;

import java.util.Stack;

//https://leetcode.com/problems/simplify-path/
public class SimplifyPath {

    /**
     Approach:
     Transform the path into an array with only the directory names, hence split by "/"
     Then, if the array contains "." or it is empty we dont do anything.
     If we get an actual directory, we push it in the stack
     However, if we get ". .", we need to go one directory up, so if there is a directory we can go up to, we will pop, else if the stack is empty i.e. there is no parent directory, we are already in root, so again we dont do anything.

     Finally, we will store the directories remaining in stack in a stringbuilder by appending it with "/" and if the stack is empty, we simply return "/".

     eg-
     /home/etc/../tmp ----> stack=[home, tmp] as etc will be pushed in and then popped out when ".." is encountered ---------> /home/tmp
     */


    public static String simplifyPath(String path) {
        //make array that contains only paths or directories or .,..
        String[] paths = path.split("/");
        Stack<String> st=new Stack<>();
        for(String dir:paths){
            if(dir.equals(".") || dir.length()==0) continue;
            else{
                if(!st.isEmpty() && dir.equals(".."))
                    st.pop();
                else if(st.isEmpty() && dir.equals(".."))
                    continue;
                else st.push(dir);
            }
        }
        StringBuilder sb=new StringBuilder();
        if(st.isEmpty()) return "/";
        for(String s:st){
            sb.append("/"); sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
       /**
        "/home/"
        "/../"
        "/home//foo/"
        */
       String s =  "/home//foo/";
        System.out.println(simplifyPath(s));
    }
}
