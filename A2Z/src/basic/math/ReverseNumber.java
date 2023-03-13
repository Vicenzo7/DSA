package basic.math;

public class ReverseNumber {
    public static void main(String[] args) {
        int n = 123456;
        reverseNumber(n);
        reverseUsingStringBuilder(n);
        Long x = 1L;
        Long reversedBits = reversedBits(x);
        System.out.println(reversedBits);

        System.out.println(reverseBits(43261596));

    }

    public static void reverseNumber(int n) {
        int reverse = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            reverse = reverse * 10 + lastDigit;
            n = n / 10;
        }

        System.out.println(reverse);
    }

    public static void reverseUsingStringBuilder(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        System.out.println(sb.reverse());
    }

    public int reverse(int n) {
        double reverse = 0;
        while (n != 0) {
            int lastDigit = n % 10;
            reverse = reverse * 10 + lastDigit;
            n = n / 10;
        }

        if (reverse <= (Integer.MIN_VALUE) || reverse >= (Integer.MAX_VALUE)) return 0;
        return (int) reverse;
    }

    //    https://practice.geeksforgeeks.org/problems/reverse-bits3556/1
    static Long reversedBits(Long X) {
        String binaryString = Long.toBinaryString(X);
        String leadingZeros = String.format("%32s",binaryString).replace(' ','0');
        leadingZeros = new StringBuilder(leadingZeros).reverse().toString();
        // radix here is the format 2 = decimal, 8 -> octal, 16-> Hexadecimal
        return Long.parseLong(leadingZeros,2);
    }

    //https://leetcode.com/problems/reverse-bits/description/
    public static int reverseBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        String leadingZeros = String.format("%32s", binaryString).replace(' ', '0');
        leadingZeros = new StringBuilder(leadingZeros).reverse().toString();
        // radix here is the format 2 = binary
        return (int) Long.parseLong(leadingZeros, 2);
    }
}
