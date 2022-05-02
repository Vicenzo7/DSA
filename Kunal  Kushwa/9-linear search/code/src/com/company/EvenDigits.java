package com.company;

// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class EvenDigits {
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
//        System.out.println(findNumbers(nums));

        System.out.println(digits2(-345678));
    }

    public static int findNumbers(int[] nums) {
        int count = 0;

        for (int number : nums) {
            if (even(number)) {
                count++;
            }
        }
        return count;
    }

    static boolean even(int number) {
        int numberOfDigits = digits(number);
        /*
        if(numberOfDigits % 2 == 0)
        {
            return true;
        }

         */
        return numberOfDigits % 2 == 0;
    }


    static int digits2(int nums) {
        if (nums < 0) {
            nums = nums * -1;
        }
        return (int)(Math.log10(nums)) +1;
    }

    //count number of digits in a number
    static int digits(int nums) {
        if (nums < 0) {
            nums = nums * -1;
        }
        if (nums == 0) {
            return 1;
        }
        int count = 0;
        while (nums > 0) {
            count++;
            nums /= 10;
        }
        return count;
    }
}
