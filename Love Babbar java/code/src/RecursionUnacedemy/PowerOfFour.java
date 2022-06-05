package RecursionUnacedemy;

public class PowerOfFour {
    public static void main(String[] args) {
        int n = 24;
        System.out.println(isPowerOfFour(n));
    }

    public static boolean isPowerOfFour(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;

        if (n % 4 == 0)
            return isPowerOfFour(n / 4);
        else
            return false;
    }


}
