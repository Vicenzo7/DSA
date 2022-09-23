package com.math;
//https://practice.geeksforgeeks.org/problems/magic-number4431/1
public class MagicNumber {
    public static void main(String[] args) {
        int n = 6;
        int ans = 0;
        int base = 5;

        while (n > 0) {
            // will give last number
            int lastDigit = n & 1;
            // will skip the last number and will make the second last number the last number
            n = n >> 1;
            ans += lastDigit * base;
            // moving the base
            base = base * 5;
        }


        System.out.println(ans);
    }



    static long nthMagicNo(int n){

        long ans = 0;
        long base = 5;

        while(n>0){
            // will give last number
            long lastDigit = n & 1;
            // will skip the last number and will make the second last number the last number
            n = n>>1;
            ans += lastDigit * base;
            ans = ans %100000000_7;
            base = base * 5;
        }

        return ans;
    }
}
