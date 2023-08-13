package strings.easy;

import java.math.BigInteger;

public class LargestOddNumberInString {
    public static void main(String[] args) {
        String num = "42076";
        System.out.println(largestOddNumber(num));

    }


    /*
        Intuition
        In a number if the last digit is odd number then that number is an odd number

        So iterate from back and check if the digit is an odd number, if it is
        an odd number then the string from start to that number is "Largest Odd number in that
        String"

        else keep checking.

        TC = O(n)

     */
    public static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }


}
