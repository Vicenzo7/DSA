package basic.math;

public class ArmstrongNumbers {
    public static void main(String[] args) {
        int n = 153;
        System.out.println(armstrongNumber(n));
    }

    public static String armstrongNumber(int n) {
        // code here
        int length = (int) Math.floor(Math.log10(n) + 1);
        int temp = n;
        int ans = 0;
        while (temp != 0) {
            int lastDigit = temp % 10;
            ans += Math.pow(lastDigit, length);
            temp = temp / 10;
        }

        return ans == n ? "Yes" : "No";

    }
}
