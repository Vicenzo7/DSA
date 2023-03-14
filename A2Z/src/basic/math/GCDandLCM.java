package basic.math;

import java.util.Arrays;

public class GCDandLCM {

    public static void main(String[] args) {
//        A = 5 , B = 10
//        Output:
//        10 5
//        Explanation:
//        LCM of 5 and 10 is 10, while their GCD is 5.

        long a = 5, b = 10;
        System.out.println(Arrays.toString(lcmAndGcd(a, b)));
        System.out.println("GCD by brute force " + gcdBruteForce(a,b));
    }

    static Long[] lcmAndGcd(Long A, Long B) {
        // code here
        long gcd = gcd(A, B);
        long lcm = (A * B) / gcd;
        int[] a = new int[5];
        return new Long[]{lcm, gcd};

    }

    public static long gcd(Long a, Long b) {
        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }

    // Brute force
//    Traverse from 1 to min(a,b).
//    And check if i is divisible by both a and b.If yes store it in the answer.
//    Find the maximum value of i which divides both a and b.

    public static long gcdBruteForce(long a, long b) {
        long ans = 0;
        for (long i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                ans = i;
            }
        }

        return ans;
    }
}
