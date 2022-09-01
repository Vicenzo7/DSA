package com.company.string;

import java.util.ArrayList;

public class SubsequenceOfString {
    public static void main(String[] args) {
        String s ="abc";
        solveBackTrack(0,s,new StringBuilder());
        System.out.println(ans1);

        ArrayList<String> ans2 = new ArrayList<>();
        String output ="";
        solve(0,s,output,ans2);
        System.out.println(ans2);

    }

    private static void solve(int index, String s, String output, ArrayList<String> ans2) {

        if(index == s.length()){
            ans2.add(output);
            return;
        }

        // exclude
        solve(index+1,s,output,ans2);

        // include
        char ch = s.charAt(index);
        output = output+ch;
        solve(index+1,s,output,ans2);

    }

    static ArrayList<String> ans1 = new ArrayList<>();


    public static void solveBackTrack(int index,String s,StringBuilder sb){

        if(index == s.length()){
            ans1.add(sb.toString());
            return;
        }

        // exclude
        solveBackTrack(index+1,s,sb);

        // include
        sb.append(s.charAt(index));
        solveBackTrack(index+1,s,sb);
        sb.deleteCharAt(sb.length()-1);
    }
}
