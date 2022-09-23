package com.math;
//https://leetcode.com/problems/number-of-1-bits/
public class NumberOf1Bits {
    public static void main(String[] args) {
        int n = 787;
        System.out.println(Integer.toBinaryString(n));

        System.out.println(setBits(n));
    }

    static int setBits(int n) {

        int count = 0;
        // one way
//        while(n>0){
//            int lastDigit = n  & 1;
//            if(lastDigit == 1){
//                count++;
//            }
//
//            n = n >> 1;
//        }
//        return count;


        /**
         * Note that in some languages, such as Java, there is no unsigned integer type.
         * In this case, the input will be given as a signed integer type.
         * It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
         * In Java, the compiler represents the signed integers using 2's complement notation.
         */

        // second way
//        while(n>0){
//            count++;
//            n -= (n & -n);
//        }
//        return count;


        // third way
        while(n>0){
            count++;
            n = (n & (n-1));
        }
        return count;
    }


}
