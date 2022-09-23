package com.math;

public class NoOfDigits {
    public static void main(String[] args) {
        int a = 263476374;
        int base = 10;

        int noOfDigitsInTheNumberWithRespectToBase = (int) (Math.log(a) / Math.log(10)) +1;

        System.out.println(noOfDigitsInTheNumberWithRespectToBase);
    }
}
