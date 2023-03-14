package basic.math;

public class DivisorOfNumber {
    public static void main(String[] args) {
        int n = 36;
//        printDivisor(n);
        printDivisor2(n);
    }

    public static void printDivisor(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // Optimised
    // Divisor of 36 = 1 2 3 4 6 9 12 18 36
    /*  1 *36
        2*18
        3*12
        4*9
        6*6

        So its better only to traverse up to square root
     */

    public static void printDivisor2(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if (n / i != i) {
                    System.out.print(n / i + " ");
                }
            }
        }
    }
}
