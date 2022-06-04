package RecursionYT;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsAfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if(digits.length() == 0)
            return ans;

        String[] list = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder output= new StringBuilder("");

        solve(digits,0,list,output,ans);

        return ans;
    }

    public static void solve(String digits,int index,String[] list,StringBuilder output,List<String> ans)
    {
        //base case
        if(index == digits.length())
        {
            ans.add(String.valueOf(output));
            return;
        }

        int num = digits.charAt(index) - '0';
        String value = list[num];


        for (int i = 0; i < value.length() ; i++) {
            output.append(value.charAt(i));
            solve(digits,index+1,list,output,ans);
            output.deleteCharAt(output.length()-1);

        }
    }
}
