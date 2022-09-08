package Backtracking;

import java.util.HashSet;

// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/

public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {

    public static void main(String[] args) {

        //String s = "ababccc";
        String s ="wwwzfvedwfvhsww";
        System.out.println(maxUniqueSplit(s));
    }

//    public static int maxUniqueSplit(String s) {
//        HashSet<String> set = new HashSet<>();
//        return solve(set,0,s);
//    }
//
//    private static int solve(HashSet<String> set,int index, String s) {
//
//        if(index >= s.length())
//            return 0;
//
//        int ans = -1;// did not find method to split;
//
//        for (int i = index+1; i <= s.length(); i++) {
//
//            String sub = s.substring(index,i);
//            if(!set.add(sub))
//                continue; //already contains sub
//
//            int next = solve(set,i,s);
//            if(next >=0)
//                ans =Math.max(ans,next+1);
//            set.remove(sub);
//        }
//
//        return ans;
//    }



    public static int maxUniqueSplit(String s) {
        solve(s,new HashSet());
        return ans;
    }

    public static int ans =0;

    public static void solve(String s , HashSet<String> set){
        if(s.length() == 0)
        {
            ans = Math.max(ans,set.size());
            return ;
        }


        for(int i=0;i<s.length();i++){
            String sub = s.substring(0,i+1);
            if(!set.contains(sub)){
                set.add(sub);
                solve(s.substring(i+1,s.length()),set);
                set.remove(sub);
            }
        }
    }
}
