package BasicMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

//https://leetcode.com/problems/count-primes/
public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n=10;

        System.out.println(" count is "+ sieveOfEratosthenes(n));
        System.out.println(countPrime2(n));
    }

    private static int sieveOfEratosthenes(int n) {
        int count =0;
        Vector<Boolean>  prime = new Vector<>(n+1);

        //mapping all numbers to true at start

        //saare number ko initially prime number maanlo
        for (int i = 0; i <=n ; i++) {
            prime.add(i,true);
        }
        System.out.println(prime);

        //set 0 and 1 as false because they are not prime number;
        //0 and 1 ko non-prime mark kardo
        prime.set(0,false);
        prime.set(1,false);

        //table wise non prime mark kardo
        for (int i = 2;  i<n ; i++) {
            if(prime.get(i))
            {
                count++;
            }

            //table wise marking
            for (int j = 2*i; j <n ; j=j+i) {
                prime.set(j,false);
            }
        }
        System.out.println();

        System.out.println();

        System.out.println(prime);

        return count;
    }

    //more optimised
    public static int countPrime2(int n)
    {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}
