package com.math;

public class BinarySearchSQRT {
    public static void main(String[] args) {
        int n = 109;
        int precision = 3;
        System.out.printf("%.3f" ,sqrt(n, precision));
    }

    private static double sqrt(int n, int precision) {

        int s = 0;
        int e = n;
        double root = 0.0;

        while (s <= e) {
            int m = s + (e - s) / 2;
            long sqaure = m*m;
            // perfect square
            if (sqaure == n)
                return m;
            if (sqaure < n){
                root = m;
                s = m +1;
            }
            else{
                e = m- 1;
            }
        }

        double incr = 0.1;
        // precision loop
        for (int i = 0; i <precision ; i++) {
            while(root * root <=n) {
                root += incr;
            }

            root -= incr;
            incr /=10;
        }

        return root;

    }
}
