package com.math;

public class GCD_LCM {

    public static void main(String[] args) {

        int a = 2;
        int b = 7;
        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));
    }


    /**
     *  GCD using Euclid's Algorithm
     *  gcd(a,b) = gcd( (remainder(b,a),a)
     *  when a == 0 => b is the ans
     */
    static int gcd(int a, int b) {

        // base case
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }


    static int lcm(int a,int b){
        int d = gcd(a,b);
        return (a*b)/d;
    }

}
