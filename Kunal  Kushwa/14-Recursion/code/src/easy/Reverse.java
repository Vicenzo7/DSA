package easy;

public class Reverse {
    static int reverse = 0;

    static void rev1(int n) {
        if (n == 0) {
            return;
        }
        int lastDigit = n % 10;
        reverse = reverse * 10 + lastDigit;
        rev1(n / 10);
    }


    static int rev2(int n) {

        // the below formula will give no of digits in number n;
        int digits = (int) Math.log10(n) + 1;
        return helper(n, digits);

    }

    private static int helper(int n, int digits) {
        if (n == 0) {
            return 0;
        }
        int rem = n % 10;

        return rem * (int)(Math.pow(10,digits-1)) +helper(n/10,digits-1);

    }


    public static void main(String[] args) {
        int n = 1234;
        System.out.println(rev2(n));
    }


}
