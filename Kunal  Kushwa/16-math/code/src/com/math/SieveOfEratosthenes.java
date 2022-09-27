package com.math;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 40;
        boolean[] primes = new boolean[n + 1];
        sieveOfEratosthenes(n, primes);
    }


    public static void sieveOfEratosthenes(int n, boolean[] primes) {
        // running till sqrt root of n, because after that point things get repeated
        for (int i = 2; i*i<=n ; i++) {

            if(!primes[i]){
                // cancelling ut the factors of i as they aren't going to be prime so
                // when later encountered no need to check them.
                for (int j = i*2; j <=n ; j+= i) {
                    primes[j]=true;
                }
            }
        }

        for (int i = 2; i <=n ; i++) {
            if(!primes[i]){
                System.out.print(i+" ");
            }
        }
    }
}
