package RecursionYT;

import java.util.ArrayList;

public class SubsequencesOfString {
    public static void main(String[] args) {
        String str ="abc";
        System.out.println(subsequences(str));
    }

    public static ArrayList<String> subsequences(String str) {
        ArrayList<String> ans =  new ArrayList<>();
        String output ="";
        solve(str,0,ans,output);
        return ans;
    }

    public static void solve(String str, int index, ArrayList<String> ans, String output)
    {
        //base case
        if(index == str.length())
        {
            if(output.length()>0)
                ans.add(output);
            return;
        }

        //exclude
        solve(str,index+1,ans,output);

        //include
        char ch = str.charAt(index);
        output = output+ch;
        solve(str,index+1,ans,output);
    }
}
