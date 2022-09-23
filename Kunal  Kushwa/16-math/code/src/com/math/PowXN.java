package com.math;
//https://leetcode.com/problems/powx-n/
public class PowXN {
    public static void main(String[] args) {
        double x = 5;
        int n = -3;
        System.out.println(myPow(x,n));
    }

    public static double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        // if n is negative converting it to positive
        if(n <0){
            nn = -nn;
        }

        while (nn > 0){
            // get the last digit
            long lastDigit = nn & 1;
            if(lastDigit == 1)
                ans = lastDigit * x;

            // updating the power
            x = x*x;
            // shifting second last digit to last digit
            nn = nn>>1;
        }

        if(n<0){
            return 1/ans;
        }
        return ans;
    }

}
