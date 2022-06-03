package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        int n=3;
        System.out.println(generateParenthesis(n));
    }



    //using recursion
//    public List<String> generateParenthesis(int n) {
//        List<String> result = new ArrayList<>();
//
//        solve(n,0,0,"",result);
//        return result;
//    }
//
//    public void solve(int n,int starting,int ending,String str, List<String> result)
//    {
//        //base case
//        if(starting == n && ending == n)
//        {
//            result.add(str);
//            return;
//        }
//
//        //if opening braces are less than given n
//        if(starting<n)
//            solve(n,starting+1,ending,str+"(",result);
//
//        //if closing braces are less than opening braces
//        if(ending < starting)
//            solve(n,starting,ending+1,str+")",result);
//    }


    // using backtracking leetcode

//    public static List<String> generateParenthesis(int n) {
//        int open=n,close=n;
//
//        ArrayList<String>ans=new ArrayList<>();
//        recursion(open,close,new StringBuilder(),ans);
//        return ans;
//    }
//
//    public static void recursion(int open, int close, StringBuilder sb,ArrayList<String>ans)
//    {
//        if(open==0 && close==0)
//        {
//            ans.add(sb.toString());
//            return;
//        }
//
//        if(open==close)
//        {   sb.append('(');
//            recursion(open-1,close,sb,ans);
//            sb.deleteCharAt(sb.length()-1);
//        }
//        else if(open==0)
//        {
//            sb.append(')');
//            recursion(open,close-1,sb,ans);
//            sb.deleteCharAt(sb.length()-1);
//        }
//        else if(open<close)
//        {
//            sb.append('(');
//            recursion(open-1,close,sb,ans);
//            sb.deleteCharAt(sb.length()-1);
//
//            sb.append(')');
//            recursion(open,close-1,sb,ans);
//            sb.deleteCharAt(sb.length()-1);
//        }
//    }


    // love babbar backtracking approach

    public static List<String> generateParenthesis(int n) {
        StringBuilder output = new StringBuilder("(");
        int curOpen=1;
        int curClose=0;
        int remOpen=n-1;
        int remClose = n;
        List<String> ans = new ArrayList<>();

        solve(curOpen,curClose,remOpen,remClose,output,ans);
        return ans;
    }

    public static void solve(int curOpen,int curClose,int remOpen,int remClose,StringBuilder output,List<String> ans)
    {
        //base case
        if(remOpen == 0 && remClose == 0)
        {
            ans.add(output.toString());
            return;
        }

        // open bracket('(') call
        if(remOpen>0)
        {
            output.append("(");
            solve(curOpen+1,curClose,remOpen-1,remClose,output,ans);
            //backtrack
            output.deleteCharAt(output.length()-1);
        }

        // close bracket(')') call
        if(remClose>0 && curOpen>curClose)
        {
            output.append(")");
            solve(curOpen,curClose+1,remOpen,remClose-1,output,ans);
            //backtrack
            output.deleteCharAt(output.length()-1);
        }

    }
}
