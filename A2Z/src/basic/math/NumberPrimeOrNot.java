package basic.math;

import java.sql.Time;

public class NumberPrimeOrNot {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isPrime(n));
    }

    // brute force
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // optimised
    public static boolean isPrime2(int n) {
        for (int i = 2; i *i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
