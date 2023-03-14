package basic.recursion;

public class BasicRecursion {
    public static void main(String[] args) {
        int n = 10;
//        printNames(n);
//        print1toN(1, n);
//        printNto1(1, n);
        System.out.println(sumOfFirstNNumbers(n,0));
    }


    private static void print1toN(int start, int n) {
        if (start > n) {
            return;
        }
        System.out.println(start);
        print1toN(start + 1, n);
    }

    private static void printNto1(int start, int n) {
        if (start > n) {
            return;
        }
        printNto1(start + 1, n);
        System.out.println(start);
    }

    private static void printNames(int n) {
        if (n == 0) {
            return;
        }
        System.out.println("Vicenzo");
        printNames(n - 1);
    }

    private static int sumOfFirstNNumbers(int n, int sum) {
        if (n < 1) {
            return sum;
        }
        return sumOfFirstNNumbers( n-1, sum + n);
    }
}
