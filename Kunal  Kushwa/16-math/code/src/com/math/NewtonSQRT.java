package com.math;

public class NewtonSQRT {
    public static void main(String[] args) {
        int n = 109;
        System.out.println(sqrt(n));
    }

    public static double sqrt(int n) {
        double x = n;
        double root = 0.0;


        while (true) {
            root = 0.5 * (x + n / x);

            if (Math.abs(root - x) < 0.5) {
                break;
            }

            x = root;
        }

        return root;
    }
}
