package com.math;

public class Prime {
    public static void main(String[] args) {
        int n = 20;
        for (int i = 0; i <= n; i++) {
            System.out.println(i + " " + isPrime(i));
        }

    }


    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
