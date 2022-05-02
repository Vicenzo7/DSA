package com.company;

import java.util.Scanner;

public class Questions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n=in.nextInt();
//        System.out.println(isPrime(n));
//          System.out.println(isArmstrong(n));

        for(int i=100;i<1000;i++){
            if(isArmstrong(i))
                System.out.print(i +" ");
        }
    }

    static boolean isArmstrong(int n) {
        int temp =n,rev;
        int sum=0;
         while(temp>0){
             rev=temp%10;
             sum=sum+rev*rev*rev;
             temp=temp/10;
         }
         return n==sum;
    }

    static boolean isPrime(int n) {

        if(n<=1)
            return false;
        int c=2;
        while(c*c<=n){
            if(n%c==0)
                return false;
            c++;
        }
         return c * c > n;

     }
}
