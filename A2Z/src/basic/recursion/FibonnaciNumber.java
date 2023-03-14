package basic.recursion;

public class FibonnaciNumber {
    public static void main(String[] args) {
        System.out.println(fibRecursive(18));
        fib(18);
    }

    public static int fibRecursive(int n) {
        if (n == 0 || n == 1) return n;

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }


    public static void fib(int n) {
        if (n == 0 || n == 1) {
            System.out.println(n);
        }

        int first = 0;
        int second = 1;
        int next = 0;
        for (int i = 2; i <= n; i++) {
            next = first + second;
            first = second;
            second = next;
        }
        System.out.println(next);
    }

}
