package com.bitwise;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }

    public static boolean isPowerOfTwo(int n) {

        if (n<=0)
            return false;

        return (n & (n-1) )== 0;
    }

    public static boolean withLoop(int n) {

        if (n<=0)
            return false;

        // with loop
        int count =0;
        while(n>0){
            int lastDigit = n & 1;
            if(lastDigit == 1)
                count++;
            n = n >> 1;
        }


        if(count >1)
            return false;
        return true;
    }
}
