package com.company.array;

public class FibonacciSeries {

    public static void main(String[] args) {
        int n = 9;
        System.out.println(getFib(n));
        solve(n);
    }

    private static int getFib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return getFib(n -1 ) + getFib(n - 2);
    }

    private static void solve(int n) {
        if (n == 0) {
            return ;
        }

        System.out.print(n+" ");
        solve(n -1 ) ;
        System.out.print(n+" ");
    }
}
