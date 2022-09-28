package easy;

public class DigitSum {
    public static void main(String[] args) {
        int n = 1342;
        int ans = sumOfDigit(n);
        System.out.println(ans);
    }

    static int sumOfDigit(int n) {
        if (n == 0) {
            return 0;
        }

        int lastDigit = n%10;
        n = n/10;

        // return (n%10) + sumOfDigit(n/10);
        return lastDigit+sumOfDigit(n);
    }
}
