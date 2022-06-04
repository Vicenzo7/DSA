package RecursionYT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsAfAPhoneNumber {
    public static void main(String[] args) {

    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = Arrays.asList("","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
        String str="";
        List<String> ans = new ArrayList<>();
        solve(digits,0,0,list,str,ans);

        return ans;
    }

    public static void solve(String digits,int index1,int index2,List<String> list,String str,List<String> ans)
    {
            
    }
}
