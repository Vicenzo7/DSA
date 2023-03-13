package basic.math;

public class CountDigits {
    public static void main(String[] args) {
        int n = 323423423;
        countDigit(n);
        countString(n);
        countDigitMoreLogically(n);

    }

    public static void countDigit(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        System.out.println(count);
    }


    // Approach 2 : Using String
    public static void countString(int n) {
        String s = String.valueOf(n);
        System.out.println(s.length());
    }

    // Approach 3 : Use logarithm base 10 to count the number of digits.
    // As The number of digits in an integer = the upper bound of log10(n).
    //n = 12345
    //log10(12345) = 4.091
    //Integral part of 4.091 is 4 and 4 + 1 =  5 which is also the number of digits in 12345

    public static void countDigitMoreLogically(int n) {
        int digits = (int) Math.floor((Math.log10(n) + 1));
        System.out.println(digits);
    }
}
