package strings;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationPhoneNumber {
    public static void main(String[] args) {
//        pad("", "12");
//        System.out.println(padRet("", "12"));
//        System.out.println(padCount("", "12"));
        System.out.println(letterCombinations("23"));
    }


    static void pad(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = (up.charAt(0) - '0'); // will covert '2' to 2

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char charToAdd = (char) ('a' + i);
            pad(p + charToAdd, up.substring(1));
        }

    }


    static ArrayList<String> padRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = (up.charAt(0) - '0'); // will covert '2' to 2

        ArrayList<String> ans = new ArrayList<>();

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char charToAdd = (char) ('a' + i);
            ans.addAll(padRet(p + charToAdd, up.substring(1)));
        }
        return ans;
    }


    static int padCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }

        int digit = (up.charAt(0) - '0'); // will covert '2' to 2


        int count = 0;
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char charToAdd = (char) ('a' + i);
            count = count + padCount(p + charToAdd, up.substring(1));
        }
        return count;
    }


    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0)
            return ans;

        String[] list = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


        solve("",digits, list, ans);

        return ans;
    }

    public static void solve(String p,String up,  String[] list, List<String> ans) {
        //base case
        if (up.isEmpty()) {
            ans.add(p);
            return;
        }

        int num = up.charAt(0) - '0';
        String value = list[num];


        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            solve(p+ch,up.substring(1),list,ans);
        }
    }
}
