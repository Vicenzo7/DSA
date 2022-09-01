package com.company.string;

public class AddTwoString {

    public static void main(String[] args) {

        String num1 = "11", num2 = "123";
        System.out.println(addStrings(num1,num2));
    }

    public static String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        solve(num1,num2,num1.length()-1,num2.length()-1,sb,0);
        return sb.reverse().toString();

    }



    public static void solve(String a ,String b,int i,int j,StringBuilder sb,int carry){

        // base case
        if(i <0 && j<0 && carry ==0){
            return;
        }


        int first = 0;
        int second = 0;

        if(i>=0){
            first = a.charAt(i) -'0';
        }

        if(j>=0){
            second = b.charAt(j) -'0';
        }

        int sum = first + second + carry;

        carry = sum>=10? 1:0;

        sum = sum%10;

        sb.append(sum);


        solve(a,b,i-1,j-1,sb,carry);

    }


}
