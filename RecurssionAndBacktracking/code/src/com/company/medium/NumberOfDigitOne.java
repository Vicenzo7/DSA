package com.company.medium;
//https://leetcode.com/problems/number-of-digit-one/
public class NumberOfDigitOne {


    public static void main(String[] args) {
        int n = 5461;
        System.out.println(countDigitOne(n));
    }
    public static int countDigitOne(int n) {
        return solve(n);
    }


    public static int solve(int n){
        // base case
        if(n<=0)
            return 0;

        if(n<10)
            return 1;

        String nV= String.valueOf(n);


        int length = (int) (Math.log(n)/ Math.log(10)) +1;
        //int length = nV.length();

        int base =(int) Math.pow(10,length-1);

        int firstDigit= n/base;

        int remainder = n%base;

        int oneInBase=0;
        if(firstDigit ==1){
            oneInBase = n-base +1;
        }else{
            oneInBase = base;
        }


        return solve(remainder) + oneInBase + firstDigit * solve(base-1);
    }
}
