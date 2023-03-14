package basic.math;

public class PalindromeNumber {
    public static void main(String[] args) {
        int n = 2442;
        System.out.println(isPalindrome(n));
    }

    public static boolean isPalindrome(int x) {
        // String value = String.valueOf(x);
        // int start = 0, end = value.length()-1;
        // while (start < end) {
        //     if(value.charAt(start++) != value.charAt(end--)) {
        //         return false;
        //     }
        // }
        // return true;

        // Another approach is to reverse the number and check with the original number

        int reversedNumber = 0;
        int temp = x;
        while (temp != 0) {
            int lastDigit = temp % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
            temp = temp / 10;
        }
        reversedNumber = x > 0 ? reversedNumber : -reversedNumber;
        return reversedNumber == x;

    }
}
